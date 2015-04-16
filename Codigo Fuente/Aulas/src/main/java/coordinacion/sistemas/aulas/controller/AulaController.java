/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package coordinacion.sistemas.aulas.controller;

import auxiliar.ManejoStrings;
import coordinacion.sistemas.aulas.entities.CatalogoAulas;
import coordinacion.sistemas.aulas.entities.CatalogoCarreras;
import coordinacion.sistemas.aulas.entities.HorarioAula;
import coordinacion.sistemas.aulas.model.ValidarAula;
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
import java.security.Principal;
import javax.ejb.EJB;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author OIMA
 */
@Controller
public class AulaController extends AbstractController{

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

    @RequestMapping(method = RequestMethod.POST, value = "/NuevaAula.xx")
    public String insertar(Model model, @Valid CatalogoAulas aula, BindingResult result, Principal p) {
        ValidarAula validaAula = new ValidarAula();
        addNombreUsuario(model, p);
        if (result.hasErrors() || !validaAula.validateForm(model, aula) || isDuplicated(aula)) {
            validaAula.validateForm(model, aula);
            model.addAttribute("listaCarreras", carreraFacade.findBySpecificField("status", 1, "equal", ord("nombreCarrera", "asc"), null));
            model.addAttribute("aula", aula);
            model.addAttribute("mensajeInicial", obtenerMensajeInicial(2));
            if (isDuplicated(aula)) {
                model.addAttribute("errorAula", "Esta aula ya existe en combinación al edificio");
            }
            return "/Formularios/FormularioAula";
        } else {
            aula.setStatus((short) 1);
            aulaFacade.create(aula);
            model.addAttribute("listaCarreras", carreraFacade.findBySpecificField("status", 1, "equal", ord("nombreCarrera", "asc"), null));
            model.addAttribute("aula", new CatalogoAulas());
            model.addAttribute("mensajeInicial", obtenerMensajeInicial(1));
            return "/Formularios/FormularioAula";
        }

    }

    @RequestMapping(method = RequestMethod.POST, value = "/EditarAula.xx")
    public String editarAula(Model modelo, BigDecimal idAula, String ed, String au, short tipo, short cap, BigDecimal idCar) {
        
        CatalogoAulas aula = aulaFacade.find(idAula);
        aula.setEdificio(ed);
        aula.setAula(au);
        aula.setTipoAula(tipo);
        aula.setCapacidadAula(cap);
        aula.setIdCarrera(carreraFacade.find(idCar));
        aulaFacade.edit(aula);
        return "redirect:Tablas.xx?edT=aul";
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/EliminarAula.xx")
    public @ResponseBody String eliminarAula(Model modelo, BigDecimal idEl) {
        CatalogoAulas aula = aulaFacade.find(idEl);
        boolean eliminacionAprobada = true;
        for (HorarioAula h : horarioAulaFacade.findAll()) {
            if (h.getIdAula().equals(aula)) {
                eliminacionAprobada = false;
                break;
            }
        }
        if (eliminacionAprobada) {
            aula.setStatus(Short.valueOf(""+0));
//            aulaFacade.edit(aula);
            aulaFacade.remove(aula);
            return "Eliminación de aula exitosa";
        }else{
            return "No se puede eliminar porque el aula ya contiene uno o mas grupos";
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/ObtenerFormularioAula.xx")
    public @ResponseBody
    String formularioEditarAula(Model modelo, BigDecimal idEd) {
        CatalogoAulas aula = aulaFacade.find(idEd);
        String listaCarreras = "";
        for (CatalogoCarreras c : carreraFacade.findAll()) {
            listaCarreras += "<option value=\"" + c.getIdCarrera() + "\" "+((aula.getIdCarrera().equals(c)) ? "selected='selected'" : "")+">" + c.getNombreCarrera() + "</option>\n";
        }
        String formulario = ""
                + "<form class=\"form-horizontal\" role=\"form\" action=\"EditarAula.xx\" method=\"POST\" commandName=\"aula\">\n"
                + "                            <div class=\"form-group\">\n"
                + "                                <label path=\"\" for=\"edificio\" class=\"col-sm-2 control-label\">Nombre del edificio:</label>\n"
                + "                                <div class=\"col-sm-4\">\n"
                + "<input type='hidden' name='idAula' value='" + aula.getIdAula() + "'/>"
                + "                                    <input path=\"edificio\" type=\"text\" class=\"form-control\" id=\"nombreEdificio\" placeholder=\"Nombre del edificio\" name='ed' value='" + aula.getEdificio() + "'/>\n"
                + "                                </div>\n"
                + "                                <label path=\"\" for=\"aula\" class=\"col-sm-2 control-label\">Nombre del aula</label>\n"
                + "                                <div class=\"col-sm-4\">\n"
                + "                                    <input path=\"aula\" type=\"text\" class=\"form-control\" id=\"aula\" placeholder=\"Nombre del aula\" name='au' value='" + aula.getAula() + "'/>\n"
                + "                                </div>\n"
                + "                            </div>\n"
                + "                            <div class=\"form-group\">\n"
                + "                                <label path=\"\" for=\"tipoAula\" class=\"col-sm-2 control-label\">Tipo de aula</label>\n"
                + "                                <div class=\"col-sm-4\">\n"
                + "                                    <select path=\"tipoAula\" class=\"form-control\" id=\"tipoAula\" name='tipo'>\n"
                + ((aula.getTipoAula() == 0) ? "<option value=\"0\">Practica</option>\n" : "<option value=\"1\">Teorica</option>\n")
                + ((aula.getTipoAula() == 1) ? "<option value=\"0\">Practica</option>\n" : "<option value=\"1\">Teorica</option>\n")
                + "                                        "
                + "                                    </select>\n"
                + "                                </div>\n"
                + "                                <label path=\"\" for=\"capacidad\" class=\"col-sm-2 control-label\">Capacidad del aula</label>\n"
                + "                                <div class=\"col-sm-4\">\n"
                + "                                    <input path=\"capacidadAula\" type=\"text\" class=\"form-control\" id=\"capacidad\" placeholder=\"Capacidad de alumnos\" name='cap' value='" + aula.getCapacidadAula() + "'/>\n"
                + "                                </div>\n"
                + "                            </div>\n"
                + "                            <div class=\"form-group\">\n"
                + "                                <label path=\"\" for=\"idCarrera\" class=\"col-sm-2 control-label\">Carrera</label>\n"
                + "                                <div class=\"col-sm-10\">\n"
                + "                                    <select path=\"idCarrera.idCarrera\" class=\"form-control\" id=\"idCarrera\" name='idCar'>\n"
                + listaCarreras
                + "                                    </select>\n"
                + "                                </div>\n"
                + "                            </div>\n"
                + "                            <div class=\"form-group\">\n"
                + "                                <div class=\"col-sm-offset-9 col-sm-3\">\n"
                + "                                    <button type=\"submit\" class=\"btn btn-warning\">Actualizar</button>\n"
                + "                                </div>  \n"
                + "                            </div>\n"
                + "                        </form>"
                + "";
        return formulario;
    }

    private boolean isDuplicated(CatalogoAulas aula) {
        ManejoStrings m = new ManejoStrings();
        for (CatalogoAulas a : aulaFacade.findAll()) {
            if (m.sonIguales(aula.getEdificio(), a.getEdificio())&& m.sonIguales(aula.getAula(), a.getAula())) {
                return true;
            }
        }
        return false;
    }
}
