/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package coordinacion.sistemas.aulas.controller;

import auxiliar.MatrizConNombres;
import coordinacion.sistemas.aulas.beans.InfoGrupo;
import coordinacion.sistemas.aulas.beans.InfoMateria;
import coordinacion.sistemas.aulas.beans.InformacionAula;
import coordinacion.sistemas.aulas.entities.CatalogoAulas;
import coordinacion.sistemas.aulas.entities.CatalogoCarreras;
import coordinacion.sistemas.aulas.entities.CatalogoCicloEscolar;
import coordinacion.sistemas.aulas.entities.CatalogoEspecialidades;
import coordinacion.sistemas.aulas.entities.CatalogoGrupos;
import coordinacion.sistemas.aulas.entities.CatalogoMaterias;
import coordinacion.sistemas.aulas.entities.CatalogoPlanes;
import coordinacion.sistemas.aulas.entities.CatalogoProfesores;
import coordinacion.sistemas.aulas.entities.CatalogoUsuarios;
import coordinacion.sistemas.aulas.entities.HorarioAula;
import coordinacion.sistemas.aulas.sessions.CatalogoAulasFacade;
import coordinacion.sistemas.aulas.sessions.CatalogoCarrerasFacade;
import coordinacion.sistemas.aulas.sessions.CatalogoCicloEscolarFacade;
import coordinacion.sistemas.aulas.sessions.CatalogoEspecialidadesFacade;
import coordinacion.sistemas.aulas.sessions.CatalogoGruposFacade;
import coordinacion.sistemas.aulas.sessions.CatalogoMateriasFacade;
import coordinacion.sistemas.aulas.sessions.CatalogoPlanesFacade;
import coordinacion.sistemas.aulas.sessions.CatalogoProfesoresFacade;
import coordinacion.sistemas.aulas.sessions.CatalogoUsuariosFacade;
import coordinacion.sistemas.aulas.sessions.HorarioAulaFacade;
import coordinacion.sistemas.aulas.sessions.UserRoleFacade;
import java.math.BigDecimal;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.ejb.EJB;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author OIMA
 */
@Controller
public class GlobalController extends AbstractController {

    @EJB(mappedName = "java:global/Aulas/CatalogoUsuariosFacade")
    private CatalogoUsuariosFacade usuarioFacade;
    @EJB(mappedName = "java:global/Aulas/CatalogoCarrerasFacade")
    private CatalogoCarrerasFacade carreraFacade;
    @EJB(mappedName = "java:global/Aulas/CatalogoEspecialidadesFacade")
    private CatalogoEspecialidadesFacade especialidadFacade;
    @EJB(mappedName = "java:global/Aulas/CatalogoMateriasFacade")
    private CatalogoMateriasFacade materiaFacade;
    @EJB(mappedName = "java:global/Aulas/CatalogoAulasFacade")
    private CatalogoAulasFacade aulaFacade;
    @EJB(mappedName = "java:global/Aulas/CatalogoPlanesFacade")
    private CatalogoPlanesFacade planFacade;
    @EJB(mappedName = "java:global/Aulas/CatalogoProfesoresFacade")
    private CatalogoProfesoresFacade profesorFacade;
    @EJB(mappedName = "java:global/Aulas/CatalogoCicloEscolarFacade")
    private CatalogoCicloEscolarFacade cicloEscolarFacade;
    @EJB(mappedName = "java:global/Aulas/CatalogoGruposFacade")
    private CatalogoGruposFacade grupoFacade;
    @EJB(mappedName = "java:global/Aulas/HorarioAulaFacade")
    private HorarioAulaFacade horarioAulaFacade;
    @EJB(mappedName = "java:global/Aulas/UserRoleFacade")
    private UserRoleFacade userRoleFacade;

    @RequestMapping(method = RequestMethod.GET, value = "/index.xx")
    public String index(Model model) {
        model.addAttribute("error", "true");
        return "/index";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/Perfil.xx")
    public String perfil(Model model, Principal p) {
        if (p == null) {
            return "/index";
        } else {
            CatalogoUsuarios usuario = usuarioFacade.findBySpecificField("nombreUsuario", p.getName(), "equal", null, null).get(0);
            model.addAttribute("usuario", usuario);
            addNombreUsuario(model, p);
        }
        return "/VistaPerfil";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/InicioFallido.xx")
    public String inicioFallido(Model model) {
        model.addAttribute("error", "true");
        return "/index";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/Formularios.xx")
    public String altaFormularios(Model model, Principal p) {
        if (p == null) {
            return "/index";
        }
        System.out.println(p.getName());
        addNombreUsuario(model, p);
        model.addAttribute("listaUsuarios", usuarioFacade.findBySpecificField("tipo", 2, "equal", ord("nombreUsuario", "asc"), null));
        model.addAttribute("listaAulas", aulaFacade.findBySpecificField("status", 1, "equal", ord("aula", "asc"), null));
        model.addAttribute("listaPlanes", planFacade.findBySpecificField("status", 1, "equal", ord("nombrePlan", "asc"), null));
        model.addAttribute("listaProfesores", profesorFacade.findBySpecificField("status", 1, "equal", ord("nombreProfesor", "asc"), null));
        model.addAttribute("listaCicloEscolar", cicloEscolarFacade.findBySpecificField("status", 1, "equal", ord("nombreCicloEscolar", "asc"), null));
        model.addAttribute("plan", new CatalogoPlanes());
        model.addAttribute("grupo", new CatalogoGrupos());
        model.addAttribute("profesor", new CatalogoProfesores());
        model.addAttribute("cicloEscolar", new CatalogoCicloEscolar());
        model.addAttribute("materia", new CatalogoMaterias());
        model.addAttribute("especialidad", new CatalogoEspecialidades());
        model.addAttribute("carrera", new CatalogoCarreras());
        model.addAttribute("usuario", new CatalogoUsuarios());
        model.addAttribute("aula", new CatalogoAulas());

        if (getRole(p).equals("ROLE_ADMINISTRADOR")) {
            model.addAttribute("listaCarreras", carreraFacade.findBySpecificField("status", 1, "equal", ord("nombreCarrera", "asc"), null));
            model.addAttribute("listaEspecialidades", especialidadFacade.findBySpecificField("status", 1, "equal", ord("nombreEspecialidad", "asc"), null));
            model.addAttribute("listaMaterias", materiaFacade.findBySpecificField("status", 1, "equal", ord("nombreMateria", "asc"), null));
            return "/AltaFormularios";
        } else {
            List<CatalogoCarreras> listaCarreras = null;
            listaCarreras = getCarreraAsignadaCoordinador(p);
            if (listaCarreras.size() <= 0) {
                return "/SinCarrera";
            }
            model.addAttribute("listaEspecialidades", getEspecialidadesAsignadasCoordinador(p));
            model.addAttribute("listaCarreras", listaCarreras);
            model.addAttribute("listaMaterias", getMateriasAsignadasCoordinador(p));
            return "/FormulariosCoord";
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/LlenarAula.xx")
    public String llenarAula(Model model, String idAulaString, Principal p) {
        List<CatalogoAulas> lAulas = aulaFacade.findAll();
        addNombreUsuario(model, p);
        if (lAulas.size() <= 0) {
            return "/SinAulas";
        }
        if (p == null) {
            return "/index";
        }
        List<CatalogoAulas> tmpList;
        String role = getRole(p);
        if ("ROLE_ADMINISTRADOR".equals(role)) {
            tmpList = lAulas;
        } else {
            List<CatalogoCarreras> listaCarreras = getCarreraAsignadaCoordinador(p);
            if (listaCarreras.size() <= 0) {
                return "/SinCarrera";
            }
            tmpList = getAulasAsignadasCoordinador(p);
        }
        if (idAulaString == null) {
            return "redirect:LlenarAula.xx?idAulaString=" + obtenerPrimerAulaPermitida(p);
        }
        ArrayList<CatalogoAulas> listaAulas = new ArrayList<CatalogoAulas>();
        for (Iterator<CatalogoAulas> it = tmpList.iterator(); it.hasNext();) {
            CatalogoAulas aulaTemp = it.next();
            if (aulaTemp != null) {
                if (listaAulas.size() < 1) {
                    listaAulas.add(aulaTemp);
                } else {
                    boolean insertar = true;
                    for (int i = 0; i < listaAulas.size(); i++) {
                        if (aulaTemp.getEdificio().equals(listaAulas.get(i).getEdificio())) {
                            insertar = false;
                            break;
                        }
                    }
                    if (insertar) {
                        listaAulas.add(aulaTemp);
                    }
                }
            }
        }
//        model.addAttribute("listaGrupos", grupoFacade.findAll());
        model.addAttribute("listaAulas", listaAulas);
        BigDecimal idAula = BigDecimal.ZERO;
        if (idAulaString.equals(String.valueOf(0))) {//Arreglar cuando en la url se meten valores inv[alidos
            System.out.println("id es cero o superior a la cantidad de aulas");
            for (Iterator<CatalogoAulas> it = tmpList.iterator(); it.hasNext();) {
                CatalogoAulas next = it.next();
                if (next.getStatus() == 1) {
                    idAula = next.getIdAula();
                    break;
                }
            }
        } else {
            idAula = BigDecimal.valueOf((long) Integer.valueOf(idAulaString));
        }
//        System.out.println("id>>>>>>>>>>>>" + idAula);
        List<HorarioAula> listaHorarios = horarioAulaFacade.findAll();
        String[] nombreFilas = {"7:00 - 8:00", "8:00 - 9:00", "9:00 - 10:00", "10:00 - 11:00", "11:00 - 12:00", "12:00 - 13:00", "13:00 - 14:00",
            "14:00 - 15:00", "15:00 - 16:00", "16:00 - 17:00", "17:00 - 18:00", "18:00 - 19:00", "19:00 - 20:00", "20:00 - 21:00"};
        String[] nombreColumnas = {"Lunes", "Martes", "Miercoles", "Jueves", "Viernes"};
        HorarioAula matrizHorarios[][] = new HorarioAula[nombreFilas.length][nombreColumnas.length];
        MatrizConNombres matriz = new MatrizConNombres(nombreFilas, nombreColumnas, matrizHorarios);
        List<HorarioAula> horariosAula = new ArrayList<HorarioAula>();
        CatalogoAulas aula = aulaFacade.find(idAula);
        for (int i = 0; i < listaHorarios.size(); i++) {
            HorarioAula h = listaHorarios.get(i);
//            System.out.println(h.getIdAula().getIdAula() + "<><><><>");
            if (h.getIdAula().getIdAula().equals(aula.getIdAula())) {
                horariosAula.add(h);
            }
        }
        if (horariosAula.size() > 0) {
            for (int i = 0; i < horariosAula.size(); i++) {
                HorarioAula obj = horariosAula.get(i);
                matrizHorarios[matriz.index(obj.getHorario(), 'f')][matriz.index(obj.getDia(), 'c')] = obj;
//                System.out.println(obj.getStatus());
            }
        }

        String render;
        render = "<table class=\"table table-responsive table-bordered\" id=\"tablaHorarioAula\">\n"
                + "                                        <tr id=\"title\">\n"
                + "                                            <td class=\"nombreFila\" id=\"horas\">Horas</td>\n"
                + "                                            <td><span >Lunes</span></td>\n"
                + "                                            <td><span>Martes</span></td>\n"
                + "                                            <td><span>Mi&eacute;rcoles</span></td>\n"
                + "                                            <td><span>Jueves</span></td>\n"
                + "                                            <td><span>Viernes</span></td>\n"
                + "                                        </tr>\n"
                + tableRender(nombreColumnas, nombreFilas, matriz)
                + "                                    </table>";
        model.addAttribute("render", render);
        model.addAttribute("listaMaterias", obtenerMateriasRestantes(aula.getTipoAula(), p));
        return "/ManejoAulas";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/Tablas.xx")
    public String consultarTablas(Model model, Principal p) {
        if (p == null) {
            return "/index";
        }
        addNombreUsuario(model, p);
        model.addAttribute("listaPlanes", planFacade.findBySpecificField("status", 1, "equal", ord("nombrePlan", "asc"), null));
        model.addAttribute("listaProfesores", profesorFacade.findBySpecificField("status", 1, "equal", ord("nombreProfesor", "asc"), null));
        model.addAttribute("listaCicloEscolar", cicloEscolarFacade.findBySpecificField("status", 1, "equal", ord("nombreCicloEscolar", "asc"), null));
        if (getRole(p).equals("ROLE_ADMINISTRADOR")) {
            model.addAttribute("listaEspecialidades", especialidadFacade.findAll());
            model.addAttribute("listaUsuarios", usuarioFacade.findBySpecificField("status", 1, "equal", ord("nombre", "asc"), null));
            model.addAttribute("listaCarreras", carreraFacade.findBySpecificField("status", 1, "equal", ord("nombreCarrera", "asc"), null));
            model.addAttribute("listaMaterias", materiaFacade.findBySpecificField("status", 1, "equal", ord("nombreMateria", "asc"), null));
            model.addAttribute("listaAulas", aulaFacade.findBySpecificField("status", 1, "equal", ord("aula", "asc"), null));
            model.addAttribute("listaGrupos", grupoFacade.findBySpecificField("status", 1, "equal", ord("claveGrupo", "asc"), null));
            return "/tablas";
        } else {
            List<CatalogoCarreras> listaCarreras = getCarreraAsignadaCoordinador(p);
            if (listaCarreras.size() <= 0) {
                return "/SinCarrera";
            }
            model.addAttribute("listaGrupos", getGruposAsignadosCoordinador(p));
//            model.addAttribute("listaEspecialidades", especialidadFacade.findBySpecificField("idCarrera", listaCarreras.get(0), "equal", ord("nombreEspecialidad", "asc"), null));
            model.addAttribute("listaEspecialidades", getEspecialidadesAsignadasCoordinador(p));
            model.addAttribute("listaMaterias", getMateriasAsignadasCoordinador(p));
            return "/tablasCoord";
        }
    }

    private String tableRender(String[] nombreColumnas, String[] nombreFilas, MatrizConNombres matriz) {
        String render = "";
        for (int i = 0; i < nombreFilas.length; i++) {
            render += "<tr>\n"
                    + "                                     <td class=\"nombreFila\">" + nombreFilas[i] + "</td>\n";
            for (int j = 0; j < nombreColumnas.length; j++) {
                render += "                                            <td "
                        + "class=\"editable\" "
                        + "fil=\"" + nombreFilas[i] + "\" "
                        + "col=\"" + nombreColumnas[j] + "\" "
                        + "ocupado=\"" + ((matriz.getValueAt(i, j) != null) ? "true" : "false") + "\" "
                        + "id=\"" + ((matriz.getValueAt(i, j) != null) ? (matriz.getValueAt(i, j).getIdHorario()) : "noId") + "\""
                        + "tipoHorario=\"" + ((matriz.getValueAt(i, j) != null) ? (matriz.getValueAt(i, j).getTipoHorario()) : "null") + "\""
                        + "idGrupo=\"" + ((matriz.getValueAt(i, j) != null) ? (grupoFacade.find(matriz.getValueAt(i, j).getIdGrupo().getIdGrupo()).getClaveGrupo()) : "noIdGrupo") + "\"" + ">"
                        + ((matriz.getValueAt(i, j) != null) ? grupoFacade.find(matriz.getValueAt(i, j).getIdGrupo().getIdGrupo()).getClaveGrupo() + "/"
                        + materiaFacade.find(matriz.getValueAt(i, j).getIdGrupo().getIdMateria().getIdMateria()).getNombreMateria() : "")
                        + "</td>\n";
            }
            render += "                                        </tr>\n";
        }
        return render;
    }

    private String obtenerMateriasRestantes(short tAula, Principal p) {
        String listaMaterias = "";
        List<CatalogoMaterias> lista;
        if ("ROLE_ADMINISTRADOR".equals(getRole(p))) {
            lista = materiaFacade.findBySpecificField("status", 1, "equal", ord("nombreMateria", "asc"), null);
        } else {
            lista = getMateriasAsignadasCoordinador(p);
        }
        String tipoAula = (tAula == 0) ? "P" : "T";
        List<CatalogoMaterias> nuevaLista = new ArrayList<CatalogoMaterias>();
        for (Iterator<CatalogoMaterias> it = lista.iterator(); it.hasNext();) {
            CatalogoMaterias materia = it.next();
            if (materia.getStatus() == 1) {
                nuevaLista.add(materia);
            }
        }

        String danger = "style=\"background: #DF4444;color: white;\"";
        String warning = "style=\"background: #f0ad4e;color: white;\"";
        List<CatalogoGrupos> listaGrupos = getGruposAsignadosCoordinador(p);
        for (Iterator<CatalogoMaterias> it = nuevaLista.iterator(); it.hasNext();) {
            CatalogoMaterias materia = it.next();
            boolean status = false;//Asume que aun hay horas por acomodar
            for (CatalogoGrupos grupo : listaGrupos) {
                if (grupo.getIdMateria().equals(materia) && (tipoAula.equals(grupo.getForzarGrupo()) || "null".equals(grupo.getForzarGrupo()))) {
                    if (grupo.getHorasPracticasRestantes() > 0 || grupo.getHorasTeoricasRestantes() > 0) {
                        status = true;
                        listaMaterias += "<option value='" + materia.getIdMateria() + "' " + ((status) ? warning : danger) + ">" + materia.getNombreMateria() + "</option>";
                        break;
                    } else {
                        status = false;
                        listaMaterias += "<option value='" + materia.getIdMateria() + "' " + ((status) ? warning : danger) + ">" + materia.getNombreMateria() + "</option>";
                        break;
                    }
                }

            }

        }
        return listaMaterias;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/Estadisticas.xx")
    public String irAEstadisticas(Model model, Principal p) {
        addNombreUsuario(model, p);
        if (p == null) {
            return "/index";
        }
        String role = getRole(p);
        String barRender = "";
        String colorClass = "";
//        List<CatalogoAulas> listaAulas = aulaFacade.findBySpecificField("status", 1, "equal", ord("aula", "asc"), null);
        List<CatalogoAulas> listaAulas = new ArrayList<CatalogoAulas>();
//        if (role.equals("ROLE_ADMINISTRADOR")) {
        listaAulas = getAulasAsignadasCoordinador(p);
//        }else{
//            return "";
//        }

        int numAulasLlenas = 0;
        for (CatalogoAulas aula : listaAulas) {
            int numeroDeHorarios = 0;
            List<HorarioAula> oima = horarioAulaFacade.findBySpecificField("idAula", aula.getIdAula(), "equal", null, null);
            numeroDeHorarios = oima.size() * 100 / 70;
            if (numeroDeHorarios > 0 && numeroDeHorarios < 25) {
                colorClass = "info";
            } else if (numeroDeHorarios >= 25 && numeroDeHorarios < 50) {
                colorClass = "success";
            } else if (numeroDeHorarios >= 50 && numeroDeHorarios < 75) {
                colorClass = "warning";
            } else if (numeroDeHorarios >= 75) {
                colorClass = "danger";
            } else if (numeroDeHorarios >= 100) {
                ++numAulasLlenas;
            }
            barRender += ""
                    + "                                            <div class=\"row clearfix\">\n"
                    + "                                                <div class=\"col-md-2 column\">\n"
                    + "                                                    <span class=\"nombreAula text-center\">" + aula.getEdificio() + " - " + aula.getAula() + "</span>\n"
                    + "                                                </div>\n"
                    + "                                                <div class=\"col-md-6 column\">\n"
                    + "                                                    <div class=\"progress\">\n"
                    + "                                                        <div class=\"progress-bar progress-bar-" + colorClass + "\" style=\"width: " + numeroDeHorarios + "%\">\n"
                    + "                                                        </div>\n"
                    + "                                                    </div>\n"
                    + "                                                </div>\n"
                    + "                                                <div class=\"col-md-2 column\">\n"
                    + "                                                    <button type=\"button\" class=\"btn btn-default btn-xs botonGenerarReporte\" idAula='" + aula.getIdAula() + "'>Obtener PDF</button>\n"
                    + "                                                </div>\n"
                    + "                                                <div class=\"col-md-2 column\">\n"
                    + "                                                    <button type=\"button\" class=\"btn btn-primary btn-xs btnAula\" idBotonAula=\"" + aula.getIdAula() + "\">Editar Aula</button>\n"
                    + "                                                </div>\n"
                    + "                                            </div>";
        }

//        List<CatalogoGrupos> grupos = grupoFacade.findBySpecificField("status", 1, "equal", ord("claveGrupo", "asc"), null);
        List<CatalogoGrupos> grupos = getGruposAsignadosCoordinador(p);
        List<CatalogoMaterias> lMat = getMateriasAsignadasCoordinador(p);
        int numMaterias = lMat.size();
        int numProfesores = profesorFacade.count();
        int gruposAcomodados = 0;
        int gruposSinAula = 0;
        for (CatalogoGrupos g : grupos) {
            if (g.getHorasPracticasRestantes() > 0 || g.getHorasTeoricasRestantes() > 0) {
                ++gruposSinAula;
            } else {
                if (g.getHorasPracticasRestantes() <= 0 && g.getHorasTeoricasRestantes() <= 0) {
                    ++gruposAcomodados;
                }
            }
        }
        List<InfoMateria> infoM = new ArrayList<InfoMateria>();
        for (CatalogoMaterias m : lMat) {
            InfoMateria info = new InfoMateria();
            int pc = porcentajeMaterias(grupos);
            int ng = noGruposPorMateria(grupos, m);
            String color = getColorClass(pc);
            if (ng == 0) {
                pc = 100;
                color = "danger";
            }
            info.setId(m.getIdMateria().toString());
            info.setColor(color);
            info.setNoGrupos(String.valueOf(ng));
            info.setNombre(m.getNombreMateria());
            info.setPorcentaje(String.valueOf(pc));
            infoM.add(info);
            System.out.println(pc);
        }
        model.addAttribute("numeroGruposSinAula", gruposSinAula);
        model.addAttribute("numeroMaterias", numMaterias);
        model.addAttribute("numeroGrupos", grupos.size());
        model.addAttribute("numeroProfesores", numProfesores);
        model.addAttribute("listaBarrasPorAula", barRender);
        model.addAttribute("numeroAulasLlenas", numAulasLlenas);
        model.addAttribute("numeroGruposAcomodados", gruposAcomodados);
        model.addAttribute("listaMaterias", infoM);
        List<InfoGrupo> obG = obtenerGrupos(grupos);
        System.out.println(obG.size()+"   ndljndjk");
        model.addAttribute("todoGrupos", obG);
        if (role.equals("ROLE_ADMINISTRADOR")) {
            return "/Estadisticas";
        } else {
            List<CatalogoCarreras> listaCarreras = getCarreraAsignadaCoordinador(p);
            if (listaCarreras.size() <= 0) {
                return "/SinCarrera";
            }
            return "/EstadisticasCoord";
        }
    }

    private int porcentajeMaterias(List<CatalogoGrupos> lista) {
        int porcentaje = 0;
        int g = 0;
        int mat = 0;
        for (CatalogoGrupos grp : lista) {
                g += grp.getHorasPracticasRestantes() + grp.getHorasTeoricasRestantes();
                mat += (grp.getIdMateria().getHorasPracticas() + grp.getIdMateria().getHorasTeoricas());
        }
        if (mat > 0) {
            porcentaje = (mat - g) * 100 / mat;
        }
        System.out.println("mat "+mat+" g "+g);
        return porcentaje;
    }
    
    private int porcentajeGrupo(CatalogoGrupos grp) {
        int porcentaje = 0;
        int g = 0;
        int mat = 0;
                g += grp.getHorasPracticasRestantes() + grp.getHorasTeoricasRestantes();
                mat += (grp.getIdMateria().getHorasPracticas() + grp.getIdMateria().getHorasTeoricas());
        if (mat > 0) {
            porcentaje = (mat - g) * 100 / mat;
        }
        return porcentaje;
    }
    
    private List<InfoGrupo> obtenerGrupos(List<CatalogoGrupos> lista) {
        List<InfoGrupo> listaGrupos = new ArrayList<InfoGrupo>();
        for (CatalogoGrupos g : lista) {
            InfoGrupo grupo = new InfoGrupo();
            String fg = g.getForzarGrupo();
            if (fg.equals("null")) {
                fg = "- - - -";
            }else{
                fg = (fg.equals("P"))?"Práctico":"Teórico";
            }
            int ha = getHorasAcomodadas(g);
            int pc = porcentajeGrupo(g);
            int th = g.getIdMateria().getHorasTeoricas()+g.getIdMateria().getHorasPracticas();
            CatalogoProfesores p = g.getIdProfesor();
            grupo.setForzado(fg);
            grupo.setAulas(obtenerAulasGrupo(g));
            grupo.setClave(String.valueOf(g.getClaveGrupo()));
            grupo.setHorasAcomodadas(String.valueOf(ha));
            grupo.setMateria(g.getIdMateria().getNombreMateria());
            grupo.setPorciento(String.valueOf(pc));
            grupo.setProfesor(p.getNombreProfesor()+" "+p.getApPatProfesor()+" "+p.getApMatProfesor());
            grupo.setTotalHoras(String.valueOf(th));
            grupo.setHorasPorAcomodar(String.valueOf(th-ha));
            grupo.setColor(getColorGrupo(pc));
            listaGrupos.add(grupo);
        }
        return listaGrupos;
    }
    
    private String obtenerAulasGrupo(CatalogoGrupos g){
        String aulas = "";
//        for (HorarioAula h : horarioAulaFacade.findBySpecificField("idGrupo", g, "equal", null, null)) {
//            aulas += h.getIdAula().getAula() + "-" + h.getIdAula().getEdificio() + ",";
//        }
        for (CatalogoAulas a : aulaFacade.findAll()) {
            List<HorarioAula> h = horarioAulaFacade.findBySpecificField("idGrupo", g, "equal", null, null);
            if (h.size()>0) {
                if (h.get(0).getIdGrupo().equals(g) && h.get(0).getIdAula().equals(a)) {
                    aulas += a.getEdificio() + "-" +  a.getAula()+ ",";
                }
            }
        }
        return aulas;
    }

    private int getHorasAcomodadas(CatalogoGrupos g){
        return horarioAulaFacade.findBySpecificField("idGrupo", g, "equal", null, null).size();
    }
    
    private int noGruposPorMateria(List<CatalogoGrupos> lista, CatalogoMaterias m) {
        int n = 0;
        for (CatalogoGrupos grp : lista) {
            if (grp.getIdMateria().equals(m)) {
                ++n;
            }
        }
        return n;
    }

    private String getColorClass(int porcentaje) {
        String clase;
        if (porcentaje < 34) {
            clase = "danger";
        } else if (porcentaje < 71) {
            clase = "warning";
        } else if (porcentaje <= 100) {
            clase = "success";
        } else {
            clase = "default";
        }
        return clase;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/ReporteAula.xx")
    public String pagina(Model model) {
        return "/Reportes/VisualizarAula";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/ObtenerReporteAula.xx")
    public @ResponseBody
    InformacionAula generarReporte(Model model, BigDecimal idAula) {
        List<HorarioAula> listaHorarios = horarioAulaFacade.findAll();
        String[] nombreFilas = {"7:00 - 8:00", "8:00 - 9:00", "9:00 - 10:00", "10:00 - 11:00", "11:00 - 12:00", "12:00 - 13:00", "13:00 - 14:00",
            "14:00 - 15:00", "15:00 - 16:00", "16:00 - 17:00", "17:00 - 18:00", "18:00 - 19:00", "19:00 - 20:00", "20:00 - 21:00"};
        String[] nombreColumnas = {"Lunes", "Martes", "Miercoles", "Jueves", "Viernes"};
        HorarioAula matrizHorarios[][] = new HorarioAula[nombreFilas.length][nombreColumnas.length];
        MatrizConNombres matriz = new MatrizConNombres(nombreFilas, nombreColumnas, matrizHorarios);
        List<HorarioAula> horariosAula = new ArrayList<HorarioAula>();
        CatalogoAulas aula = aulaFacade.find(idAula);
        for (int i = 0; i < listaHorarios.size(); i++) {
            HorarioAula h = listaHorarios.get(i);
            if (h.getIdAula().equals(aula)) {
                horariosAula.add(h);
            }
        }
        if (horariosAula.size() > 0) {
            for (int i = 0; i < horariosAula.size(); i++) {
                HorarioAula obj = horariosAula.get(i);
                matrizHorarios[matriz.index(obj.getHorario(), 'f')][matriz.index(obj.getDia(), 'c')] = obj;
            }
        }

        String render;
        render = "<table class=\"table table-responsive table-bordered\" id=\"tablaHorarioAula\">\n"
                + "<thead>"
                + "                                        <tr id=\"title\">\n"
                + "                                            <th class=\"nombreFila\" id=\"horas\">Horas</th>\n"
                + "                                            <th>Lunes</th>\n"
                + "                                            <th>Martes</th>\n"
                + "                                            <th>Mi&eacute;rcoles</th>\n"
                + "                                            <th>Jueves</th>\n"
                + "                                            <th>Viernes</th>\n"
                + "                                        </tr>\n"
                + "</thead>"
                + "<tbody>"
                + tableRender2(nombreColumnas, nombreFilas, matriz)
                + "</tbody>"
                + "                                    </table>";
        InformacionAula objAula = new InformacionAula();
        objAula.setTabla(render);
        System.out.println(render);
        objAula.setNombreAula(aula.getAula());
        objAula.setNombreEdificio(aula.getEdificio());
        objAula.setTipoAula((aula.getTipoAula() == (short) 0) ? "Práctica" : "Teórica");
        objAula.setNombreCarrera(aula.getIdCarrera().getNombreCarrera());
        return objAula;
    }

    private String tableRender2(String[] nombreColumnas, String[] nombreFilas, MatrizConNombres matriz) {
        String render = "";
        for (int i = 0; i < nombreFilas.length; i++) {
            render += "<tr>\n"
                    + "                                     <td class=\"nombreFila\">" + nombreFilas[i] + "</td>\n";
            for (int j = 0; j < nombreColumnas.length; j++) {
                render += "                                            <td >"
                        + ((matriz.getValueAt(i, j) != null)
                        ? trim(materiaFacade.find(matriz.getValueAt(i, j).getIdGrupo().getIdMateria().getIdMateria()).getNombreMateria(), 25)
                        : "")
                        + "</td>\n";
            }
            render += "                                        </tr>\n";
        }
        return render;
    }

    private String trim(String s, int n) {
        String trim = "";
        if (s != null && !"".equals(s)) {
            for (int i = 0; i < n; i++) {
                if (s.length() >= n) {
                    trim += s.charAt(i);
                } else {
                    return s;
                }
            }
        }
        return trim += "\n";
    }

    String pruebas() {
        return "<table summary=\"Análisis de ventas anuales\">\n"
                + "  <caption>Análisis de ventas anuales</caption>\n"
                + " \n"
                + "  <col style=\"width:10%;\" />\n"
                + "  <col style=\"width:30%;\" />\n"
                + " \n"
                + "  <thead>\n"
                + "    <tr>\n"
                + "      <th scope=\"col\">AÑO</th>\n"
                + "      <th scope=\"col\">Producto A</th>\n"
                + "      <th scope=\"col\">Producto B</th>\n"
                + "      <th scope=\"col\">Producto C</th>\n"
                + "      <th scope=\"col\">Producto D</th>\n"
                + "    </tr>\n"
                + "  </thead>\n"
                + " \n"
                + "  <tbody>\n"
                + "    <tr>\n"
                + "      <th scope=\"row\">N-3</th><td>-</td><td>-</td><td>-</td><td>-</td>\n"
                + "    </tr>\n"
                + "    <tr>\n"
                + "      <th scope=\"row\">N-2</th><td>3</td><td>5</td><td>8</td><td>4</td>\n"
                + "    </tr>\n"
                + "    <tr>\n"
                + "      <th scope=\"row\">N-1</th><td>4</td><td>4</td><td>7</td><td>3</td>\n"
                + "    </tr>\n"
                + "    <tr>\n"
                + "      <th scope=\"row\">N</th><td>5</td><td>7</td><td>6</td><td>2</td>\n"
                + "    </tr>\n"
                + "  </tbody>\n"
                + "</table>";
    }

    private String getColorGrupo(int pc) {
        String color = "info";
        if (pc < 35) {
            color = "danger";
        }else if (pc<71) {
            color = "warning";
        }else if (pc < 100) {
            color= "primary";
        }else if (pc == 100) {
            color = "success";
        }
        return color;
    }
}
