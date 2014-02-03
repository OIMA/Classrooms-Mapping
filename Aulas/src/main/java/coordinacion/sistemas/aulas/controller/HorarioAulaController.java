/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package coordinacion.sistemas.aulas.controller;

import auxiliar.MatrizConNombres;
import coordinacion.sistemas.aulas.beans.InformacionAula;
import coordinacion.sistemas.aulas.entities.CatalogoAulas;
import coordinacion.sistemas.aulas.entities.CatalogoEspecialidades;
import coordinacion.sistemas.aulas.entities.CatalogoGrupos;
import coordinacion.sistemas.aulas.entities.CatalogoMaterias;
import coordinacion.sistemas.aulas.entities.CatalogoPlanes;
import coordinacion.sistemas.aulas.entities.CatalogoProfesores;
import coordinacion.sistemas.aulas.entities.HorarioAula;
import coordinacion.sistemas.aulas.sessions.CatalogoAulasFacade;
import coordinacion.sistemas.aulas.sessions.CatalogoEspecialidadesFacade;
import coordinacion.sistemas.aulas.sessions.CatalogoGruposFacade;
import coordinacion.sistemas.aulas.sessions.CatalogoMateriasFacade;
import coordinacion.sistemas.aulas.sessions.CatalogoPlanesFacade;
import coordinacion.sistemas.aulas.sessions.CatalogoProfesoresFacade;
import coordinacion.sistemas.aulas.sessions.HorarioAulaFacade;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.ejb.EJB;
import javax.swing.JOptionPane;
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
public class HorarioAulaController {

    @EJB(mappedName = "java:global/Aulas/CatalogoGruposFacade")
    private CatalogoGruposFacade grupoFacade;
    @EJB(mappedName = "java:global/Aulas/HorarioAulaFacade")
    private HorarioAulaFacade horarioAulaFacade;
    @EJB(mappedName = "java:global/Aulas/CatalogoMateriasFacade")
    private CatalogoMateriasFacade materiaFacade;
    @EJB(mappedName = "java:global/Aulas/CatalogoProfesoresFacade")
    private CatalogoProfesoresFacade profesorFacade;
    @EJB(mappedName = "java:global/Aulas/CatalogoPlanesFacade")
    private CatalogoPlanesFacade planFacade;
    @EJB(mappedName = "java:global/Aulas/CatalogoEspecialidadesFacade")
    private CatalogoEspecialidadesFacade especialidadFacade;
    @EJB(mappedName = "java:global/Aulas/CatalogoAulasFacade")
    private CatalogoAulasFacade aulaFacade;

    @RequestMapping(method = RequestMethod.GET, value = "/ConsultarAula.xx")
    public String consultarAula(Model model, int id) {

        List<HorarioAula> findAll = horarioAulaFacade.findAll();
        HorarioAula horarioAula = null;
        for (int i = 0; i < findAll.size(); i++) {
            if (findAll.get(i).getIdHorario() == BigDecimal.valueOf((long) id)) {
                horarioAula = findAll.get(i);
            }
        }
        model.addAttribute("aulaActual", horarioAula);
        model.addAttribute("listaGrupos", grupoFacade.findAll());
        return "LlenarAula";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/ObtenerListaAulas.xx")
    public @ResponseBody
    String obtenerListaAulas(Model modelo, String nombreEdificio) {
        List<CatalogoAulas> listaAulas = aulaFacade.findAll();
        String listaOptions = "";
        for (Iterator<CatalogoAulas> it = listaAulas.iterator(); it.hasNext();) {
            CatalogoAulas aula = it.next();
            if (aula.getEdificio().equals(nombreEdificio)) {
                listaOptions += "<option value='" + aula.getIdAula() + "'>" + aula.getAula() + "</option>";
            }
        }
        return listaOptions;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/ObtenerListaGruposPorMateria.xx")
    public @ResponseBody
    String obtenerListaGruposPorMateria(Model modelo, String tipoHorario, int idMateria) {
        String listaOptions = "";
        CatalogoMaterias materia = null;
        BigDecimal idMat = BigDecimal.valueOf((long) idMateria);
        if (idMateria != -1) {
            materia = materiaFacade.find(idMat);
            System.out.println("Entro y separo materias");
        }else{
            tipoHorario = "All";
        }
        
        List<CatalogoGrupos> listaTeoricos = new ArrayList<CatalogoGrupos>();
        List<CatalogoGrupos> listaPracticos = new ArrayList<CatalogoGrupos>();
        List<CatalogoGrupos> listaTodos = new ArrayList<CatalogoGrupos>();
        List<CatalogoGrupos> listaGrupos = grupoFacade.findAll();
        for (Iterator<CatalogoGrupos> it = listaGrupos.iterator(); it.hasNext();) {
            CatalogoGrupos grupo = it.next();
            if (grupo.getIdMateria().equals(materia)) {
                if (grupo.getHorasPracticasRestantes() > 0) {
                    listaPracticos.add(grupo);
                }
                if (grupo.getHorasTeoricasRestantes() > 0) {
                    listaTeoricos.add(grupo);
                }
            }
            listaTodos.add(grupo);
        }

        if (tipoHorario.equals("P")) {
            for (CatalogoGrupos practico : listaPracticos) {
                listaOptions += "<option value='" + practico.getIdGrupo() + "'>" + practico.getClaveGrupo() + "</option>";
            }
        } else if (tipoHorario.equals("T")) {
            for (CatalogoGrupos teorico : listaTeoricos) {
                listaOptions += "<option value='" + teorico.getIdGrupo() + "'>" + teorico.getClaveGrupo() + "</option>";
            }
        } else if (tipoHorario.equals("All") || idMateria == -1) {
            for (CatalogoGrupos grupo : listaTodos) {
                if (grupo.getIdMateria().equals(materia)) {
                    listaOptions += "<option value='" + grupo.getIdGrupo() + "'>" + grupo.getClaveGrupo() + "</option>";
                }
            }
        }
        return listaOptions;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/ObtenerListaGrupos.xx")
    public @ResponseBody
    String obtenerListaGrupos(Model modelo, String tipoHorario) {
        String listaOptions = "";
        List<CatalogoGrupos> listaTeoricos = new ArrayList<CatalogoGrupos>();
        List<CatalogoGrupos> listaPracticos = new ArrayList<CatalogoGrupos>();
        List<CatalogoGrupos> listaGrupos = grupoFacade.findAll();
        for (CatalogoGrupos grupo : listaGrupos) {
            if (grupo.getHorasPracticasRestantes() > 0) {
                listaPracticos.add(grupo);
            }
            if (grupo.getHorasTeoricasRestantes() > 0) {
                listaTeoricos.add(grupo);
            }
        }

        if (tipoHorario.equals("P")) {
            for (CatalogoGrupos practico : listaPracticos) {
                listaOptions += "<option value='" + practico.getIdGrupo() + "'>" + practico.getClaveGrupo() + "</option>";
            }
        } else if (tipoHorario.equals("T")) {
            for (CatalogoGrupos teorico : listaTeoricos) {
                listaOptions += "<option value='" + teorico.getIdGrupo() + "'>" + teorico.getClaveGrupo() + "</option>";
            }
        } else {
            for (CatalogoGrupos grupo : listaGrupos) {
                listaOptions += "<option value='" + grupo.getIdGrupo() + "'>" + grupo.getClaveGrupo() + "</option>";
            }
        }
        return listaOptions;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/ActualizarGrupo.xx")
    public @ResponseBody
    String actualizarGrupoModal(Model model, int idGrupo, int tipoAula) {
        model.addAttribute("grupo", new CatalogoGrupos());
//        JOptionPane.showMessageDialog(null, idGrupo);
        String render = "";
        try {
            CatalogoGrupos grupo = grupoFacade.find(BigDecimal.valueOf((long) idGrupo));
            CatalogoMaterias materia = grupo.getIdMateria();
            CatalogoProfesores profesor = grupo.getIdProfesor();
            CatalogoPlanes plan = grupo.getIdPlan();
            CatalogoEspecialidades especialidad = materia.getIdEspecialidad();

            render = "<tr>\n"
                    + "                                <td class=\"col-sm-1 active\"><h4>Materia</h4></td>\n"
                    + "                                <td class=\"success\"><h4>" + materia.getNombreMateria() + "</h4></td>\n"
                    + "                            </tr>\n"
                    + "                            <tr>\n"
                    + "                                <td class=\"col-sm-1 active\"><h4>Profesor</h4></td>\n"
                    + "                                <td class=\"success\"><h4>"
                    + profesor.getNombreProfesor() + " " + profesor.getApPatProfesor() + " " + profesor.getApMatProfesor() + "</h4></td>\n"
                    + "                            </tr>\n"
                    + "                            <tr>\n"
                    + "                                <td class=\"col-sm-1 active\"><h4>Plan</h4></td>\n"
                    + "                                <td class=\"success\"><h4>" + plan.getNombrePlan() + "</h4></td>\n"
                    + "                            </tr>\n"
                    + "                            <tr>\n"
                    + "                                <td class=\"col-sm-1 active\"><h4>Especialidad</h4></td>\n"
                    + "                                <td class=\"success\"><h4>" + especialidad.getNombreEspecialidad() + "</h4></td>\n"
                    + "                            </tr>\n"
                    + "                            <tr>\n"
                    + "                                <td class=\"col-sm-1 active\"><h4>Horas restantes</h4></td>\n"
                    + "                                <td class=\"success\"><h4>" + ((tipoAula == 0) ? grupo.getHorasTeoricasRestantes() : grupo.getHorasPracticasRestantes()) + "</h4></td>\n"
                    + "                            </tr>";
        } catch (Exception e) {
            render = e.getMessage();
        }
        return render;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/ActualizarIdAula.xx")
    public @ResponseBody
    String ActualizarIdAula(Model modelo, String edificio, String aula) {
        List<CatalogoAulas> aulas = aulaFacade.findAll();
        String id = "0";
        for (Iterator<CatalogoAulas> it = aulas.iterator(); it.hasNext();) {
            CatalogoAulas a = it.next();
            if (a.getEdificio().equals(edificio) && a.getAula().equals(aula)) {
                id = String.valueOf(a.getIdAula());
            }
        }

        return id;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/NuevoHorario.xx")
    public @ResponseBody
    String insertar(Model model, int idAula, int idGrupo, String dia, String horario, String tipoHorario) {
        CatalogoGrupos g = grupoFacade.find(BigDecimal.valueOf((long) idGrupo));
        if (tipoHorario.equals("P")) {
            int hrs = g.getHorasPracticasRestantes() - 1;
            g.setHorasPracticasRestantes((short) hrs);
            grupoFacade.edit(g);
        } else if (tipoHorario.equals("T")) {
            int hrs = g.getHorasTeoricasRestantes() - 1;
            g.setHorasTeoricasRestantes((short) hrs);
            grupoFacade.edit(g);
        }
        HorarioAula nuevoHorario = new HorarioAula();
        nuevoHorario.setIdAula(aulaFacade.find(BigDecimal.valueOf((long) idAula)));
        nuevoHorario.setIdGrupo(grupoFacade.find(BigDecimal.valueOf((long) idGrupo)));
        nuevoHorario.setDia(dia);
        nuevoHorario.setHorario(horario);
        nuevoHorario.setTipoHorario(tipoHorario);
        nuevoHorario.setStatus((short) 1);
        horarioAulaFacade.create(nuevoHorario);
        return "";
    }

//    @RequestMapping(method = RequestMethod.GET, value = "/ActualizarAula.xx")
//    public @ResponseBody
//    String actualizarAula(Model model, int idAula) {
//        List<CatalogoAulas> tmpList = aulaFacade.findAll();
//        ArrayList<CatalogoAulas> listaAulas = new ArrayList<CatalogoAulas>();
//        for (Iterator<CatalogoAulas> it = tmpList.iterator(); it.hasNext();) {
//            CatalogoAulas aulaTemp = it.next();
//            if (aulaTemp != null) {
//                if (listaAulas.size() < 1) {
//                    listaAulas.add(aulaTemp);
//                } else {
//                    boolean insertar = true;
//                    for (int i = 0; i < listaAulas.size(); i++) {
//                        if (aulaTemp.getEdificio().equals(listaAulas.get(i).getEdificio())) {
//                            insertar = false;
//                            break;
//                        }
//                    }
//                    if (insertar) {
//                        listaAulas.add(aulaTemp);
//                    }
//                }
//            }
//        }
////        model.addAttribute("listaGrupos", grupoFacade.findAll());
////        model.addAttribute("listaAulas", listaAulas);
////        BigDecimal idAula = BigDecimal.ZERO;
////        if (idAulaString.equals(String.valueOf(0))) {
////            for (Iterator<CatalogoAulas> it = tmpList.iterator(); it.hasNext();) {
////                CatalogoAulas next = it.next();
////                if (next.getStatus() == 1) {
////                    idAula = next.getIdAula();
////                    break;
////                }
////            }
////        } else {
////            idAula = BigDecimal.ONE;
////        }
////        System.out.println("id>>>>>>>>>>>>" + idAula);
//        List<HorarioAula> listaHorarios = horarioAulaFacade.findAll();
//        String[] nombreFilas = {"7:00 - 8:00", "8:00 - 9:00", "9:00 - 10:00", "10:00 - 11:00", "11:00 - 12:00", "12:00 - 13:00", "13:00 - 14:00",
//            "14:00 - 15:00", "15:00 - 16:00", "16:00 - 17:00", "17:00 - 18:00", "18:00 - 19:00", "19:00 - 20:00", "20:00 - 21:00"};
//        String[] nombreColumnas = {"Lunes", "Martes", "Miercoles", "Jueves", "Viernes"};
//        HorarioAula matrizHorarios[][] = new HorarioAula[nombreFilas.length][nombreColumnas.length];
//        MatrizConNombres matriz = new MatrizConNombres(nombreFilas, nombreColumnas, matrizHorarios);
//        List<HorarioAula> horariosAula = new ArrayList<HorarioAula>();
//        CatalogoAulas aula = aulaFacade.find(BigDecimal.valueOf((long) idAula));
//        for (int i = 0; i < listaHorarios.size(); i++) {
//            HorarioAula h = listaHorarios.get(i);
////            System.out.println(h.getIdAula().getIdAula() + "<><><><>");
//            if (h.getIdAula().getIdAula().equals(aula.getIdAula())) {
//                horariosAula.add(h);
//            }
//        }
//        if (horariosAula.size() > 0) {
//            for (int i = 0; i < horariosAula.size(); i++) {
//                HorarioAula obj = horariosAula.get(i);
//                matrizHorarios[matriz.index(obj.getHorario(), 'f')][matriz.index(obj.getDia(), 'c')] = obj;
////                System.out.println(obj.getStatus());
//            }
//        }
//
//        String render;
//        render = "<table class=\"table table-responsive table-bordered\" id=\"tablaHorarioAula\">\n"
//                + "                                        <tr id=\"title\">\n"
//                + "                                            <td class=\"nombreFila\" id=\"horas\">Horas</td>\n"
//                + "                                            <td><span >Lunes</span></td>\n"
//                + "                                            <td><span>Martes</span></td>\n"
//                + "                                            <td><span>Mi&eacute;rcoles</span></td>\n"
//                + "                                            <td><span>Jueves</span></td>\n"
//                + "                                            <td><span>Viernes</span></td>\n"
//                + "                                        </tr>\n"
//                + tableRender(nombreColumnas, nombreFilas, matriz)
//                + "                                    </table>";
//        return render;
//    }
//
//    private String tableRender(String[] nombreColumnas, String[] nombreFilas, MatrizConNombres matriz) {
//        String render = "";
//        for (int i = 0; i < nombreFilas.length; i++) {
//            render += "<tr>\n"
//                    + "                                     <td class=\"nombreFila\">" + nombreFilas[i] + "</td>\n";
//            for (int j = 0; j < nombreColumnas.length; j++) {
//                render += "                                            <td class=\"editable\" fil=\"" + nombreFilas[i] + "\" col=\"" + nombreColumnas[j] + "\">" + ((matriz.getValueAt(i, j) != null) ? grupoFacade.find(matriz.getValueAt(i, j).getIdGrupo().getIdGrupo()).getClaveGrupo() + "/" + materiaFacade.find(matriz.getValueAt(i, j).getIdGrupo().getIdMateria().getIdMateria()).getNombreMateria() : "-------------------------") + "</td>\n";
//            }
//            render += "                                        </tr>\n";
//        }
//        return render;
//    }
    @RequestMapping(method = RequestMethod.GET, value = "/EdificioSeleccionado.xx")
    public @ResponseBody
    String obtenerEdificioSeleccionado(Model model, int idAula) {
        CatalogoAulas aula = aulaFacade.find(BigDecimal.valueOf((long) idAula));
        return aula.getEdificio();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/AulaSeleccionada.xx")
    public @ResponseBody
    String obtenerAulaSeleccionada(Model model, int idAula) {
        CatalogoAulas aula = aulaFacade.find(BigDecimal.valueOf((long) idAula));
        return aula.getAula();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/ActualizarInfoAula.xx")
    public @ResponseBody
    InformacionAula actualizarInformacionDeAulas(Model modelo, String idAula) {
        InformacionAula infoAula = new InformacionAula();
        try {
            CatalogoAulas aula = aulaFacade.find(BigDecimal.valueOf(Integer.parseInt(idAula)));
            infoAula.setIdAula(idAula);
            infoAula.setNombreAula(aula.getAula());
            infoAula.setNombreEdificio(aula.getEdificio());
            infoAula.setTipoAula(aula.getTipoAula() + "");
        } catch (Exception e) {
        }
        return infoAula;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/EliminarHorario.xx")
    public @ResponseBody
    String eliminarHorario(Model modelo, String idHorario, String tipoHorario) {

        Integer id = Integer.valueOf(idHorario);
        HorarioAula h = horarioAulaFacade.find(BigDecimal.valueOf((long) id));

        CatalogoGrupos g = grupoFacade.find(h.getIdGrupo().getIdGrupo());
        if (tipoHorario.equals("P")) {
            int hrs = g.getHorasPracticasRestantes() + 1;
            g.setHorasPracticasRestantes((short) hrs);
            grupoFacade.edit(g);
        } else if (tipoHorario.equals("T")) {
            int hrs = g.getHorasTeoricasRestantes() + 1;
            g.setHorasTeoricasRestantes((short) hrs);
            grupoFacade.edit(g);
        }
        horarioAulaFacade.remove(h);
        return "";
    }
}
