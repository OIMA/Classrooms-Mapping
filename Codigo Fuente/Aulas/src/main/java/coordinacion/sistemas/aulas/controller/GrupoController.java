/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package coordinacion.sistemas.aulas.controller;

import coordinacion.sistemas.aulas.entities.CatalogoCicloEscolar;
import coordinacion.sistemas.aulas.entities.CatalogoGrupos;
import coordinacion.sistemas.aulas.entities.CatalogoMaterias;
import coordinacion.sistemas.aulas.entities.CatalogoPlanes;
import coordinacion.sistemas.aulas.entities.CatalogoProfesores;
import coordinacion.sistemas.aulas.entities.HorarioAula;
import coordinacion.sistemas.aulas.model.ValidarGrupo;
import coordinacion.sistemas.aulas.sessions.CatalogoCicloEscolarFacade;
import coordinacion.sistemas.aulas.sessions.CatalogoGruposFacade;
import coordinacion.sistemas.aulas.sessions.CatalogoMateriasFacade;
import coordinacion.sistemas.aulas.sessions.CatalogoPlanesFacade;
import coordinacion.sistemas.aulas.sessions.CatalogoProfesoresFacade;
import coordinacion.sistemas.aulas.sessions.HorarioAulaFacade;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.Principal;
import javax.ejb.EJB;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author OIMA
 */
@Controller
public class GrupoController extends AbstractController {

    @EJB(mappedName = "java:global/Aulas/CatalogoGruposFacade")
    private CatalogoGruposFacade grupoFacade;
    @EJB(mappedName = "java:global/Aulas/CatalogoMateriasFacade")
    private CatalogoMateriasFacade materiaFacade;
    @EJB(mappedName = "java:global/Aulas/CatalogoPlanesFacade")
    private CatalogoPlanesFacade planFacade;
    @EJB(mappedName = "java:global/Aulas/CatalogoProfesoresFacade")
    private CatalogoProfesoresFacade profesorFacade;
    @EJB(mappedName = "java:global/Aulas/CatalogoCicloEscolarFacade")
    private CatalogoCicloEscolarFacade cicloEscolarFacade;
    @EJB(mappedName = "java:global/Aulas/HorarioAulaFacade")
    private HorarioAulaFacade horarioAulaFacade;

    @RequestMapping(method = RequestMethod.POST, value = "/NuevoGrupo.xx")
    public String insertar(Model modelo, @Valid CatalogoGrupos grupo, BindingResult result, Principal p) {
        addNombreUsuario(modelo, p);
        BigInteger claveGrupo = grupo.getClaveGrupo();
        System.out.println(claveGrupo);
        ValidarGrupo validar = new ValidarGrupo();
//        System.out.println(result.hasErrors());
//        for (ObjectError e : result.getAllErrors()) {
//            System.out.println(e);
//        }
        if (!validar.validateForm(modelo, grupo) || isDuplicated(grupo)) {
            if (isDuplicated(grupo)) {
                modelo.addAttribute("errorClave", "Ya existe un grupo con esa clave");
            }
            for (CatalogoGrupos g : grupoFacade.findAll()) {
                if (g.getClaveGrupo() == claveGrupo && g.getStatus() == 1) {
                    modelo.addAttribute("errorClave", "Ya existe un grupo con esa clave");
                    break;
                } else if (g.getClaveGrupo() == claveGrupo && g.getStatus() == 0) {
                    grupoFacade.remove(g);
                    break;
                }
            }
            validar.validateForm(modelo, grupo);
            System.out.println("???????????????????????????????---> " + grupo.getForzarGrupo());
            modelo.addAttribute("listaPlanes", planFacade.findBySpecificField("status", 1, "equal", ord("nombrePlan", "asc"), null));
            modelo.addAttribute("listaProfesores", profesorFacade.findBySpecificField("status", 1, "equal", ord("nombreProfesor", "asc"), null));
            modelo.addAttribute("listaCicloEscolar", cicloEscolarFacade.findBySpecificField("status", 1, "equal", ord("nombreCicloEscolar", "asc"), null));
            modelo.addAttribute("listaMaterias", materiaFacade.findBySpecificField("status", 1, "equal", ord("nombreMateria", "asc"), null));
            if (grupo.getForzarGrupo() == null || "null".equals(grupo.getForzarGrupo())) {
                grupo.setForzarGrupo("null");
            }
            modelo.addAttribute("grupo", grupo);
            modelo.addAttribute("mensajeInicial", obtenerMensajeInicial(2));
            return "/Formularios/FormularioGrupo";
        } else {
            grupo.setStatus((short) 1);
            grupoFacade.create(grupo);
            modelo.addAttribute("listaPlanes", planFacade.findBySpecificField("status", 1, "equal", ord("nombrePlan", "asc"), null));
            modelo.addAttribute("listaProfesores", profesorFacade.findBySpecificField("status", 1, "equal", ord("nombreProfesor", "asc"), null));
            modelo.addAttribute("listaCicloEscolar", cicloEscolarFacade.findBySpecificField("status", 1, "equal", ord("nombreCicloEscolar", "asc"), null));
            modelo.addAttribute("listaMaterias", materiaFacade.findBySpecificField("status", 1, "equal", ord("nombreMateria", "asc"), null));
            modelo.addAttribute("grupo", new CatalogoGrupos());
            modelo.addAttribute("mensajeInicial", obtenerMensajeInicial(1));
            return "/Formularios/FormularioGrupo";
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/EditarGrupo.xx")
    public String editarGrupo(Model modelo, BigDecimal idGrupo, BigInteger claveGrupo, short capacidadGrupo, BigDecimal idMateria, BigDecimal idProfesor, BigDecimal idPlan, BigDecimal idCicloEscolar) {
        CatalogoGrupos grupo = grupoFacade.find(idGrupo);
        grupo.setClaveGrupo(claveGrupo);
        grupo.setCapacidadGrupo(capacidadGrupo);
        grupo.setIdMateria(materiaFacade.find(idMateria));
        grupo.setIdProfesor(profesorFacade.find(idProfesor));
        grupo.setIdPlan(planFacade.find(idPlan));
        grupo.setIdCicloEscolar(cicloEscolarFacade.find(idCicloEscolar));
        grupoFacade.edit(grupo);
        return "redirect:Tablas.xx?edT=gpo";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/EliminarGrupo.xx")
    public @ResponseBody
    String eliminarGrupo(Model modelo, BigDecimal idEl) {
        CatalogoGrupos grupo = grupoFacade.find(idEl);
        boolean eliminacionAprobada = true;
        for (HorarioAula h : horarioAulaFacade.findAll()) {
            if (h.getIdGrupo().equals(grupo)) {
                eliminacionAprobada = false;
                break;
            }
        }
        if (eliminacionAprobada) {
//            grupo.setStatus(Short.valueOf("" + 0));
//            grupoFacade.edit(grupo);
            grupoFacade.remove(grupo);
            return "Eliminación exitosa";
        } else {
            return "No se puede eliminar porque el grupo ya está asignado";
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/ObtenerFormularioGrupo.xx")
    public @ResponseBody
    String formularioEditarGrupo(Model modelo, BigDecimal idEd, Principal pr) {
        CatalogoGrupos grupo = grupoFacade.find(idEd);
        String listaMaterias = "";
        String listaPlanes = "";
        String listaProfesores = "";
        String listaCicloEscolar = "";
        for (CatalogoMaterias m : getMateriasAsignadasCoordinador(pr)) {
            listaMaterias += "<option value=\"" + m.getIdMateria() + "\" " + ((grupo.getIdMateria().equals(m)) ? "selected='selected'" : "") + ">" + m.getNombreMateria() + "</option>\n";
        }
        for (CatalogoPlanes p : planFacade.findAll()) {
            listaPlanes += "<option value=\"" + p.getIdPlan() + "\" " + ((grupo.getIdPlan().equals(p)) ? "selected='selected'" : "") + ">" + p.getNombrePlan() + "</option>\n";
        }
        for (CatalogoProfesores p : profesorFacade.findAll()) {
            listaProfesores += "<option value=\"" + p.getIdProfesor() + "\" " + ((grupo.getIdProfesor().equals(p)) ? "selected='selected'" : "") + ">" + p.getNombreProfesor() + " " + p.getApPatProfesor() + " " + p.getApMatProfesor() + "</option>\n";
        }
        for (CatalogoCicloEscolar c : cicloEscolarFacade.findAll()) {
            listaCicloEscolar += "<option value=\"" + c.getIdCicloEscolar() + "\" " + ((grupo.getIdCicloEscolar().equals(c)) ? "selected='selected'" : "") + ">" + c.getNombreCicloEscolar() + "</option>\n";
        }
        String checked = (grupo.getForzarGrupo() == "T" || grupo.getForzarGrupo() == "P") ? "checked" : "";
        String formulario = ""
                + "<form class=\"form-horizontal\" role=\"form\" action=\"EditarGrupo.xx\" method=\"POST\" commandName=\"grupo\">\n"
                + "<input type='hidden' name='idGrupo' value='" + grupo.getIdGrupo() + "'/>"
                + "                            <div class=\"form-group\">\n"
                + "                                <div class=\"col-sm-offset-2 col-sm-10\">\n"
                + "                                </div>\n"
                + "                            </div>\n"
                + "                            <div class=\"form-group\">\n"
                + "                                <label path=\"\" for=\"claveGrupo\" class=\"col-sm-2 control-label\">Clave:</label>\n"
                + "                                <div class=\"col-sm-4\">\n"
                + "                                    <input path=\"claveGrupo\" type=\"text\" class=\"form-control\" id=\"claveGrupo\" placeholder=\"ID o clave del grupo\" name='claveGrupo' value='" + grupo.getClaveGrupo() + "'/>\n"
                + "                                </div>\n"
                + "                                <label path=\"\" for=\"capacidad\" class=\"col-sm-2 control-label\">Capacidad</label>\n"
                + "                                <div class=\"col-sm-4\">\n"
                + "                                    <input path=\"capacidadGrupo\" type=\"text\" class=\"form-control\" id=\"capacidad\" placeholder=\"capacidad del grupo\" name='capacidadGrupo' value='" + grupo.getCapacidadGrupo() + "'/>\n"
                + "                                </div>\n"
                + "                            </div>\n"
                + "                            <div class=\"form-group\">\n"
                + "                                <label path=\"\" for=\"materia\" class=\"col-sm-3 control-label\">Materia</label>\n"
                + "                                <div class=\"col-sm-9\">\n"
                + "                                    <select path=\"idMateria.idMateria\" class=\"form-control \" id=\"selectMaterias\" name='idMateria'>\n"
                + listaMaterias
                + "                                    </select>\n"
                + "                                </div>\n"
                + "                            </div>\n"
                + "                            <div class=\"form-group\">\n"
                + "                                <label path=\"\" for=\"\" class=\"col-sm-3 control-label\">Profesor</label>\n"
                + "                                <div class=\"col-sm-9\">\n"
                + "                                    <select path=\"idProfesor.idProfesor\" class=\"form-control \" name='idProfesor'>\n"
                + listaProfesores
                + "                                    </select>\n"
                + "                                </div>\n"
                + "                            </div>\n"
                + "                            <div class=\"form-group\">\n"
                + "                                <label path=\"\" class=\"col-sm-3 control-label\">Plan:</label>\n"
                + "                                <div class=\"col-sm-9\">\n"
                + "                                    <select path=\"idPlan.idPlan\" class=\"form-control \" name='idPlan'>\n"
                + listaPlanes
                + "                                    </select>\n"
                + "                                </div>\n"
                + "                            </div>\n"
                + "                            <div class=\"form-group\">\n"
                + "                                <label path=\"\" for=\"\" class=\"col-sm-3 control-label\">Ciclo escolar</label>\n"
                + "                                <div class=\"col-sm-9\">\n"
                + "                                    <select path=\"idCicloEscolar.idCicloEscolar\" class=\"form-control \" name='idCicloEscolar'>\n"
                + listaCicloEscolar
                + "                                    </select>\n"
                + "                                </div>\n"
                + "                            </div>\n"
                + "\n"
                + "                            <div class=\"form-group\">\n"
                + "                                <div class=\"col-sm-offset-2 col-sm-10\">\n"
                + "                                </div>\n"
                + "                            </div>\n"
               
                + "<div id=\"divForzar\" class=\"col-sm-offset-1 col-sm-1\">\n"
                + "                                        <div class=\"input-group\">\n"
                + "                                            <span class=\"input-group-addon\">\n"
                + "                                                <label class=\"text-center\">Forzar</label>\n"
                + "                                                <input id=\"checkForzar\" type=\"checkbox\" " + checked + ">\n"
                + "                                        </span>\n"
                + "                                        <select path=\"forzarGrupo\" id=\"selectForzar\" class=\"form-control\">\n"
                + "                                            <option value=\"T\" >Te&oacute;rico</option>\n"
                + "                                            <option value=\"P\" >Pr&aacute;ctico</option>\n"
                + "                                            <option value=\"null\" >No forzar</option>\n"
                + "                                        </select>\n"
                + "                                    </div><!-- /input-group -->\n"
                + "                                    </div>"
                 + "                            <div class=\"form-group\">\n"
                + "                                <div class=\"col-sm-offset-9 col-sm-3\">\n"
                + "                                    <button type=\"submit\" class=\"btn btn-warning\">Actualizar</button>\n"
                + "                                </div>\n"
                + "                            </div>\n"
                + "                        </form>"
                + "<script>"
                + "$(\"#selectForzar\").change(function(){\n"
                + "    if ($(this).val()==='null') {\n"
                + "        $(\"#checkForzar\").prop(\"checked\", '');\n"
                + "        $(\"#selectForzar\").hide(\"slow\");\n"
                + "        $(\"#divForzar\").attr(\"class\", \"col-sm-offset-1 col-sm-1\");\n"
                + "    } \n"
                + "});\n"
                + "if ($(\"#checkForzar\").is(':checked')) {\n"
                + "    $(\"#divForzar\").attr('class', \"col-sm-offset-1 col-sm-4\");\n"
                + "} else {\n"
                + "    $(\"#selectForzar\").hide();\n"
                + "}\n"
                + "$(\"#checkForzar\").change(function() {\n"
                + "    if ($(this).is(':checked')) {\n"
                + "        $(\"#divForzar\").attr('class', \"col-sm-offset-1 col-sm-4\");\n"
                + "        $(\"#selectForzar\").show(\"slow\");\n"
                + "    } else {\n"
                + "        $(\"#selectForzar\").hide(\"slow\");\n"
                + "        $(\"#divForzar\").attr(\"class\", \"col-sm-offset-1 col-sm-1\");\n"
                + "        $(\"#selectForzar\").val('null');\n"
                + "    }\n"
                + "});"
                + "</script>"
                + "";
        return formulario;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/InfoHorasTeoricasMateria.xx")
    public @ResponseBody
    String infoHorasTeoricas(Model modelo, int idMateria) {
        CatalogoMaterias materia = materiaFacade.find(BigDecimal.valueOf((long) idMateria));
        return "" + materia.getHorasTeoricas() + "";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/InfoHorasPracticasMateria.xx")
    public @ResponseBody
    String infoHorasPracticas(Model modelo, int idMateria) {
        CatalogoMaterias materia = materiaFacade.find(BigDecimal.valueOf((long) idMateria));
        return "" + materia.getHorasPracticas() + "";
    }

    private boolean isDuplicated(CatalogoGrupos grupo) {
        for (CatalogoGrupos g : grupoFacade.findAll()) {
            if (g.getClaveGrupo().equals(grupo.getClaveGrupo())) {
                return true;
            }
        }
        return false;
    }
}
