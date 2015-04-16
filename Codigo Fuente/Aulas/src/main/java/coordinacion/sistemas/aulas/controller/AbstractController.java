/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coordinacion.sistemas.aulas.controller;

import coordinacion.sistemas.aulas.entities.CatalogoAulas;
import coordinacion.sistemas.aulas.entities.CatalogoCarreras;
import coordinacion.sistemas.aulas.entities.CatalogoEspecialidades;
import coordinacion.sistemas.aulas.entities.CatalogoGrupos;
import coordinacion.sistemas.aulas.entities.CatalogoMaterias;
import coordinacion.sistemas.aulas.entities.CatalogoPlanes;
import coordinacion.sistemas.aulas.entities.CatalogoUsuarios;
import coordinacion.sistemas.aulas.sessions.CatalogoAulasFacade;
import coordinacion.sistemas.aulas.sessions.CatalogoCarrerasFacade;
import coordinacion.sistemas.aulas.sessions.CatalogoEspecialidadesFacade;
import coordinacion.sistemas.aulas.sessions.CatalogoGruposFacade;
import coordinacion.sistemas.aulas.sessions.CatalogoMateriasFacade;
import coordinacion.sistemas.aulas.sessions.CatalogoUsuariosFacade;
import java.math.BigDecimal;
import java.security.Principal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import javax.ejb.EJB;
import org.springframework.ui.Model;

/**
 *
 * @author OIMA
 */
public class AbstractController {

    @EJB(mappedName = "java:global/Aulas/CatalogoUsuariosFacade")
    private CatalogoUsuariosFacade usuarioFacade;
    @EJB(mappedName = "java:global/Aulas/CatalogoCarrerasFacade")
    private CatalogoCarrerasFacade carreraFacade;
    @EJB(mappedName = "java:global/Aulas/CatalogoEspecialidadesFacade")
    private CatalogoEspecialidadesFacade especialidadFacade;
    @EJB(mappedName = "java:global/Aulas/CatalogoMateriasFacade")
    private CatalogoMateriasFacade materiaFacade;
    @EJB(mappedName = "java:global/Aulas/CatalogoGruposFacade")
    private CatalogoGruposFacade grupoFacade;
    @EJB(mappedName = "java:global/Aulas/CatalogoAulasFacade")
    private CatalogoAulasFacade aulaFacade;

    public LinkedHashMap<String, String> ord(String nombreCampo, String tipoOrden) {
        LinkedHashMap<String, String> ordering = new LinkedHashMap<String, String>();
        ordering.put(nombreCampo, tipoOrden);
        return ordering;
    }

    public String getRole(Principal p) {
        String r = "SIN_PERMISOS";
        try {
            if (usuarioFacade.findAll().size() > 0) {
                CatalogoUsuarios usuario = usuarioFacade.findBySpecificField("nombreUsuario", p.getName(), "equal", null, null).get(0);
                if (usuario.getTipo() == 1) {
                    r = "ROLE_ADMINISTRADOR";
                } else if (usuario.getTipo() == 2) {
                    r = "ROLE_COORDINADOR";
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error al consultar usuario en abstract controller");
        }

        return r;
    }

    public List<CatalogoCarreras> getCarreraAsignadaCoordinador(Principal p) {
        List<CatalogoCarreras> list = new ArrayList<CatalogoCarreras>();
        if (usuarioFacade.findAll().size() > 0) {
            CatalogoUsuarios usuario = usuarioFacade.findBySpecificField("nombreUsuario", p.getName(), "equal", null, null).get(0);
            for (CatalogoCarreras carrera : carreraFacade.findAll()) {
                if (carrera.getIdUsuario().equals(usuario)) {
                    if ("ROLE_COORDINADOR".equals(getRole(p))) {
                        list.add(carrera);
                        return list;
                    }
                }
                if ("ROLE_ADMINISTRADOR".equals(getRole(p))) {
                    list.add(carrera);
                }
            }
        }
        return list;
    }

//    public List<CatalogoEspecialidades> getCarreraAsignada(CatalogoCarreras carrera) {
//        return carrera.getCatalogoEspecialidadesList();
//    }
    public List<CatalogoEspecialidades> getEspecialidadesAsignadasCoordinador(Principal p) {
        List<CatalogoEspecialidades> list = new ArrayList<CatalogoEspecialidades>();
        if (getCarreraAsignadaCoordinador(p).size() > 0) {
            CatalogoCarreras carrera = getCarreraAsignadaCoordinador(p).get(0);
            for (CatalogoEspecialidades e : especialidadFacade.findBySpecificField("status", 1, "equal", ord("nombreEspecialidad", "asc"), null)) {
                if (e.getIdCarrera().equals(carrera)) {
                    list.add(e);
                }
            }
        }
        return list;
    }

    public List<CatalogoMaterias> getMateriasAsignadasCoordinador(Principal p) {
        List<CatalogoMaterias> list = new ArrayList<CatalogoMaterias>();
        for (CatalogoMaterias m : materiaFacade.findBySpecificField("status", 1, "equal", ord("nombreMateria", "asc"), null)) {
            for (CatalogoEspecialidades e : getEspecialidadesAsignadasCoordinador(p)) {
                if (m.getIdEspecialidad().equals(e)) {
                    list.add(m);
                }
            }
        }
        if (getRole(p).equals("ROLE_ADMINISTRADOR")) {
            list = materiaFacade.findBySpecificField("status", 1, "equal", ord("nombreMateria", "asc"), null);
        }
        return list;
    }

    public List<CatalogoGrupos> getGruposAsignadosCoordinador(Principal p) {
        List<CatalogoGrupos> list = new ArrayList<CatalogoGrupos>();
        for (CatalogoGrupos g : grupoFacade.findBySpecificField("status", 1, "equal", ord("claveGrupo", "asc"), null)) {
            for (CatalogoMaterias m : getMateriasAsignadasCoordinador(p)) {
                if (m.equals(g.getIdMateria())) {
                    list.add(g);
                }
            }
        }
        if (getRole(p).equals("ROLE_ADMINISTRADOR")) {
            list = grupoFacade.findBySpecificField("status", 1, "equal", ord("claveGrupo", "asc"), null);
        }
        return list;
    }

    public List<CatalogoPlanes> getPlanesAsignadosCoordinador(Principal p) {
        List<CatalogoPlanes> list = new ArrayList<CatalogoPlanes>();
        return list;
    }

    public List<CatalogoAulas> getAulasAsignadasCoordinador(Principal p) {
        List<CatalogoAulas> list = new ArrayList<CatalogoAulas>();
        List<CatalogoCarreras> carreras = getCarreraAsignadaCoordinador(p);
        for (CatalogoAulas a : aulaFacade.findBySpecificField("status", 1, "equal", ord("edificio", "asc"), null)) {
            if (carreras.size() > 0) {
                if (a.getIdCarrera().equals(carreras.get(0))) {
                    list.add(a);
                }
            }
        }
        if ("ROLE_ADMINISTRADOR".equals(getRole(p))) {
            return aulaFacade.findBySpecificField("status", 1, "equal", ord("edificio", "asc"), null);
        } else {
            return list;
        }
    }

    public String obtenerMensajeInicial(int tipoMensaje) {
        String mensaje = "";
        switch (tipoMensaje) {
            case 0:
                mensaje = "<div class=\"alert alert-info alert-dismissable\">\n"
                        + "                    <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-hidden=\"true\">&times;</button>\n"
                        + "                    <strong>¡Seleccione un tipo de elemento a insertar!</strong> Despu&eacute;s ingrese los datos que se le piden y de click en aceptar.\n"
                        + "                </div>";
                break;
            case 1:
                mensaje = "<div class=\"alert alert-success alert-dismissable\">\n"
                        + "                    <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-hidden=\"true\">&times;</button>\n"
                        + "                    <strong>¡Elemento insertado correctamente!</strong> Para consultarlo ingrese al modulo de tablas.\n"
                        + "                </div>";
                break;
            case 2:
                mensaje = " <div class=\"alert alert-danger alert-dismissable\">\n"
                        + "                    <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-hidden=\"true\">&times;</button>\n"
                        + "                    <strong>¡Error al insertar!</strong> Asegurese de seguir las reglas de validaci&oacute;n del manual o consulte a un administrador.\n"
                        + "                </div>";
                break;
            default:
                throw new AssertionError();
        }
        return mensaje;
    }

    public void addNombreUsuario(Model m, Principal p) {
        if (p != null) {
            m.addAttribute("nombreUsuario", p.getName());
        }
    }

    public BigDecimal obtenerPrimerAulaPermitida(Principal p) {
        if (getRole(p).equals("ROLE_ADMINISTRADOR")) {
            return aulaFacade.findAll().get(0).getIdAula();
        } else {
            return getAulasAsignadasCoordinador(p).get(0).getIdAula();
        }
    }
}
