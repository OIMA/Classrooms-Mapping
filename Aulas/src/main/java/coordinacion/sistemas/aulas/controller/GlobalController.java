/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package coordinacion.sistemas.aulas.controller;

import auxiliar.MatrizConNombres;
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
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.ejb.EJB;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author OIMA
 */
@Controller
public class GlobalController {

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

    @RequestMapping(method = RequestMethod.GET, value = "/Formularios.xx")
    public String altaFormularios(Model model) {
        model.addAttribute("listaUsuarios", usuarioFacade.findAll());
        model.addAttribute("listaCarreras", carreraFacade.findAll());
        model.addAttribute("listaEspecialidades", especialidadFacade.findAll());
        model.addAttribute("listaMaterias", materiaFacade.findAll());
        model.addAttribute("listaAulas", aulaFacade.findAll());
        model.addAttribute("listaPlanes", planFacade.findAll());
        model.addAttribute("listaProfesores", profesorFacade.findAll());
        model.addAttribute("listaCicloEscolar", cicloEscolarFacade.findAll());
        model.addAttribute("plan", new CatalogoPlanes());
        model.addAttribute("grupo", new CatalogoGrupos());
        model.addAttribute("profesor", new CatalogoProfesores());
        model.addAttribute("cicloEscolar", new CatalogoCicloEscolar());
        model.addAttribute("materia", new CatalogoMaterias());
        model.addAttribute("especialidad", new CatalogoEspecialidades());
        model.addAttribute("carrera", new CatalogoCarreras());
        model.addAttribute("usuario", new CatalogoUsuarios());
        model.addAttribute("aula", new CatalogoAulas());
        return "/AltaFormularios";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/LlenarAula.xx")
    public String llenarAula(Model model, String idAulaString) {
        List<CatalogoAulas> tmpList = aulaFacade.findAll();
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
        model.addAttribute("listaMaterias", obtenerMateriasRestantes());
        return "/ManejoAulas";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/Tablas.xx")
    public String consultarTablas(Model model) {
        model.addAttribute("listaUsuarios", usuarioFacade.findAll());
        model.addAttribute("listaCarreras", carreraFacade.findAll());
        model.addAttribute("listaEspecialidades", especialidadFacade.findAll());
        model.addAttribute("listaMaterias", materiaFacade.findAll());
        model.addAttribute("listaAulas", aulaFacade.findAll());
        model.addAttribute("listaPlanes", planFacade.findAll());
        model.addAttribute("listaProfesores", profesorFacade.findAll());
        model.addAttribute("listaCicloEscolar", cicloEscolarFacade.findAll());
        model.addAttribute("listaGrupos", grupoFacade.findAll());
        return "/tablas";
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

    private String obtenerMateriasRestantes() {
        String listaMaterias = "";
        List<CatalogoMaterias> lista = materiaFacade.findAll();
        List<CatalogoMaterias> nuevaLista = new ArrayList<CatalogoMaterias>();
        for (Iterator<CatalogoMaterias> it = lista.iterator(); it.hasNext();) {
            CatalogoMaterias materia = it.next();
            if (materia.getStatus() == 1) {
                nuevaLista.add(materia);
            }
        }

        String danger = "style=\"background: #DF4444;color: white;\"";
        String warning = "style=\"background: #f0ad4e;color: white;\"";
        String def = "";
        for (Iterator<CatalogoMaterias> it = nuevaLista.iterator(); it.hasNext();) {
            CatalogoMaterias materia = it.next();
            boolean status = false;
            List<CatalogoGrupos> findBySpecificField = grupoFacade.findBySpecificField("idMateria", materia, "equal", null, null);
            for (CatalogoGrupos grupo : findBySpecificField) {
                if (grupo.getHorasPracticasRestantes() > 0 || grupo.getHorasTeoricasRestantes() > 0) {
                    status = true;
                } else {
                    status = false;
                }
            }
            listaMaterias += "<option value='" + materia.getIdMateria() +  "' "+((status) ? warning : danger) +">" + materia.getNombreMateria() + "</option>";
        }
        return listaMaterias;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/Estadisticas.xx")
    public String irAEstadisticas(Model model) {
        String barRender = "";
        String colorClass = "";
        List<CatalogoAulas> listaAulas = aulaFacade.findAll();
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
                    + "                                                    <button type=\"button\" class=\"btn btn-default btn-xs\">Obtener PDF</button>\n"
                    + "                                                </div>\n"
                    + "                                                <div class=\"col-md-2 column\">\n"
                    + "                                                    <button type=\"button\" class=\"btn btn-primary btn-xs btnAula\" idBotonAula=\"" + aula.getIdAula() + "\">Editar Aula</button>\n"
                    + "                                                </div>\n"
                    + "                                            </div>";
        }
        model.addAttribute("listaBarrasPorAula", barRender);
        return "/Estadisticas";
    }
}
