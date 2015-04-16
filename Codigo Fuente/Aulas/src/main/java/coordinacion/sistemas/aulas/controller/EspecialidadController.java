/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package coordinacion.sistemas.aulas.controller;

import auxiliar.ManejoStrings;
import coordinacion.sistemas.aulas.entities.CatalogoCarreras;
import coordinacion.sistemas.aulas.entities.CatalogoEspecialidades;
import coordinacion.sistemas.aulas.entities.CatalogoMaterias;
import coordinacion.sistemas.aulas.model.ValidarEspecialidad;
import coordinacion.sistemas.aulas.sessions.CatalogoCarrerasFacade;
import coordinacion.sistemas.aulas.sessions.CatalogoEspecialidadesFacade;
import coordinacion.sistemas.aulas.sessions.CatalogoMateriasFacade;
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
public class EspecialidadController extends AbstractController{

    @EJB(mappedName = "java:global/Aulas/CatalogoEspecialidadesFacade")
    private CatalogoEspecialidadesFacade especialidadFacade;
    @EJB(mappedName = "java:global/Aulas/CatalogoCarrerasFacade")
    private CatalogoCarrerasFacade carreraFacade;
    @EJB(mappedName = "java:global/Aulas/CatalogoMateriasFacade")
    private CatalogoMateriasFacade materiaFacade;

    @RequestMapping(method = RequestMethod.POST, value = "/NuevaEspecialidad.xx")
    public String insertar(Model modelo, @Valid CatalogoEspecialidades especialidad, BindingResult result, Principal p) {
        addNombreUsuario(modelo, p);
        ValidarEspecialidad validar = new ValidarEspecialidad();
        if (result.hasErrors() || !validar.validateForm(modelo, especialidad) || isDuplicated(especialidad)) {
            modelo.addAttribute("listaCarreras", carreraFacade.findBySpecificField("status", 1, "equal", ord("nombreCarrera", "asc"), null));
            modelo.addAttribute("especialidad", especialidad);
            modelo.addAttribute("mensajeInicial", obtenerMensajeInicial(2));
            if (isDuplicated(especialidad)) {
                modelo.addAttribute("errorNombre", "Esta especialidad ya existe");
            }
            return "/Formularios/FormularioEspecialidad";
        } else {
            especialidad.setStatus((short) 1);
            especialidadFacade.create(especialidad);
            modelo.addAttribute("mensajeInicial", obtenerMensajeInicial(1));
            modelo.addAttribute("listaCarreras", carreraFacade.findBySpecificField("status", 1, "equal", ord("nombreCarrera", "asc"), null));
            modelo.addAttribute("especialidad", new CatalogoEspecialidades());
            return "/Formularios/FormularioEspecialidad";
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/EditarEspecialidad.xx")
    public String editarEspecialidad(Model modelo, BigDecimal idEspecialidad, String nomEsp, BigDecimal idCarrera) {
        CatalogoEspecialidades especialidad = especialidadFacade.find(idEspecialidad);
        especialidad.setNombreEspecialidad(nomEsp);
        especialidad.setIdCarrera(carreraFacade.find(idCarrera));
        especialidadFacade.edit(especialidad);
        return "redirect:Tablas.xx?edT=esp";
    }

     @RequestMapping(method = RequestMethod.GET, value = "/EliminarEspecialidad.xx")
    public @ResponseBody String eliminarCarrera(Model modelo, BigDecimal idEl) {
        CatalogoEspecialidades especialidad = especialidadFacade.find(idEl);
        boolean eliminacionAprobada = true;
        for (CatalogoMaterias m : materiaFacade.findAll()) {
            if (m.getIdEspecialidad().equals(especialidad)) {
                eliminacionAprobada = false;
                break;
            }
        }
        if (eliminacionAprobada) {
            especialidad.setStatus(Short.valueOf(""+0));
//            especialidadFacade.edit(especialidad);
            especialidadFacade.remove(especialidad);
            return "Eliminación de especialidad exitosa";
        }else{
            return "No se puede eliminar porque la especialidad ya está asignada uno o mas grupos";
        }
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/ObtenerFormularioEspecialidad.xx")
    public @ResponseBody
    String formularioEditarEspecialidad(Model modelo, BigDecimal idEd, Principal p) {
        CatalogoEspecialidades especialidad = especialidadFacade.find(idEd);
        String listaCarreras = "";
        for (CatalogoCarreras c : getCarreraAsignadaCoordinador(p)) {
            listaCarreras += "<option value=\""+c.getIdCarrera()+"\" "+((especialidad.getIdCarrera().equals(c)) ? "selected='selected'" : "")+">"+c.getNombreCarrera()+"</option>\n";
        }
        String formulario = ""
                + "<form class=\"form-horizontal\" role=\"form\" action=\"EditarEspecialidad.xx\" method=\"POST\" commandName=\"especialidad\">\n"
                + "<input type='hidden' name='idEspecialidad' value='" + especialidad.getIdEspecialidad() + "'/>"
                + "                            <div class=\"form-group\">\n"
                + "                                <label path=\"\" for=\"nombreEspecialidad\" class=\"col-sm-3 control-label\">Nombre Especialidad</label>\n"
                + "                                <div class=\"col-sm-9\">\n"
                + "                                    <input path=\"nombreEspecialidad\" type=\"text\" class=\"form-control\" id=\"nombreEspecialidad\" placeholder=\"Nombre de la especialidad\" name='nomEsp' value='"+especialidad.getNombreEspecialidad()+"'/>\n"
                + "                                </div>\n"
                + "                            </div>\n"
                + "                            <div class=\"form-group\">\n"
                + "                                <label path=\"\" for=\"usuario\" class=\"col-sm-3 control-label\">Carrera</label>\n"
                + "                                <div class=\"col-sm-9\">\n"
                + "                                    <select path=\"idCarrera.idCarrera\" class=\"form-control \" name='idCarrera'>\n"
                + listaCarreras
                + "                                    </select>\n"
                + "                                </div>\n"
                + "                            </div>\n"
                + "                            <div class=\"form-group\">\n"
                + "                                <div class=\"col-sm-offset-9 col-sm-3\">\n"
                + "                                    <button type=\"submit\" class=\"btn btn-warning\">Actualizar</button>\n"
                + "                                </div>\n"
                + "                            </div>\n"
                + "                        </form>"
                + "";
        return formulario;
    }
    
    public boolean isDuplicated(CatalogoEspecialidades esp) {
        for (CatalogoEspecialidades e : especialidadFacade.findAll()) {
            if (new ManejoStrings().sonIguales(esp.getNombreEspecialidad(), e.getNombreEspecialidad())) {
                for (CatalogoCarreras car : carreraFacade.findAll()) {
                    if (esp.getIdCarrera().equals(car)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
