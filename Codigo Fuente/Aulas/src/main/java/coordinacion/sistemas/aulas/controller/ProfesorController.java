/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package coordinacion.sistemas.aulas.controller;

import auxiliar.ManejoStrings;
import coordinacion.sistemas.aulas.entities.CatalogoGrupos;
import coordinacion.sistemas.aulas.entities.CatalogoProfesores;
import coordinacion.sistemas.aulas.model.ValidarProfesor;
import coordinacion.sistemas.aulas.sessions.CatalogoGruposFacade;
import coordinacion.sistemas.aulas.sessions.CatalogoProfesoresFacade;
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
public class ProfesorController extends AbstractController {

    @EJB(mappedName = "java:global/Aulas/CatalogoProfesoresFacade")
    private CatalogoProfesoresFacade profesorFacade;
    @EJB(mappedName = "java:global/Aulas/CatalogoGruposFacade")
    private CatalogoGruposFacade grupoFacade;

    @RequestMapping(method = RequestMethod.POST, value = "/NuevoProfesor.xx")
    public String insertar(Model modelo, @Valid CatalogoProfesores profesor, BindingResult result, Principal p) {
        addNombreUsuario(modelo, p);
        ValidarProfesor validar = new ValidarProfesor();
        if (result.hasErrors() || !validar.validateForm(modelo, profesor) || isDuplicated(profesor)) {
            if (isDuplicated(profesor)) {
                modelo.addAttribute("errorNombre", "Este profesor ya existe");
            }
            modelo.addAttribute("profesor", profesor);
            modelo.addAttribute("mensajeInicial", obtenerMensajeInicial(2));
            return "/Formularios/FormularioProfesor";
        } else {
            profesor.setStatus((short) 1);
            modelo.addAttribute("profesor", new CatalogoProfesores());
            profesorFacade.create(profesor);
            modelo.addAttribute("mensajeInicial", obtenerMensajeInicial(1));
            return "/Formularios/FormularioProfesor";
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/EditarProfesor.xx")
    public String editarProfesor(Model modelo, BigDecimal idProfesor, String nombre, String apPat, String apMat) {
        CatalogoProfesores profesor = profesorFacade.find(idProfesor);
        profesor.setNombreProfesor(nombre);
        profesor.setApPatProfesor(apPat);
        profesor.setApMatProfesor(apMat);
        profesorFacade.edit(profesor);
        return "redirect:Tablas.xx?edT=pfr";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/EliminarProfesor.xx")
    public @ResponseBody
    String eliminarProfesor(Model modelo, BigDecimal idEl) {
        CatalogoProfesores profesor = profesorFacade.find(idEl);
        boolean eliminacionAprobada = true;
        for (CatalogoGrupos g : grupoFacade.findAll()) {
            if (g.getIdProfesor().equals(profesor)) {
                eliminacionAprobada = false;
                break;
            }
        }
        if (eliminacionAprobada) {
//            profesor.setStatus(Short.valueOf(""+0));
//            profesorFacade.edit(profesor);
            profesorFacade.remove(profesor);
            return "Eliminación de profesor exitosa";
        } else {
            return "No se puede eliminar porque el profesor ya está asignado a un grupo";
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/ObtenerFormularioProfesor.xx")
    public @ResponseBody
    String formularioEditarProfesor(Model modelo, BigDecimal idEd) {
        CatalogoProfesores profesor = profesorFacade.find(idEd);

        String formulario = ""
                + "<form class=\"form-horizontal\" role=\"form\" action=\"EditarProfesor.xx\" method=\"POST\" commandName=\"profesor\">\n"
                + "<input type='hidden' name='idProfesor' value='" + profesor.getIdProfesor() + "'/>"
                + "                            <div class=\"form-group\">\n"
                + "                                <label path=\"nombreProfesor\" for=\"nombre\" class=\"col-sm-3 control-label\">Nombre(s)</label>\n"
                + "                                <div class=\"col-sm-9\">\n"
                + "                                    <input path=\"nombreProfesor\" type=\"text\" class=\"form-control\" id=\"nombre\" placeholder=\"Nombre(s)\" name=\"nombre\" value='" + profesor.getNombreProfesor() + "'/>\n"
                + "                                </div>\n"
                + "                            </div>\n"
                + "                            <div class=\"form-group\">\n"
                + "                                <label path=\"apPatProfesor\" class=\"col-sm-3 control-label\">Apellido Paterno</label>\n"
                + "                                <div class=\"col-sm-9\">\n"
                + "                                    <input path=\"apPatProfesor\" type=\"text\" class=\"form-control\" id=\"apPatProfesor\" placeholder=\"Apellido Paterno\" name=\"apPat\" value='" + profesor.getApPatProfesor() + "'/>\n"
                + "                                </div>\n"
                + "                            </div>\n"
                + "                            <div class=\"form-group\">\n"
                + "                                <label path=\"apMatProfesor\" for=\"apMatProfesor\" class=\"col-sm-3 control-label\">Apellido Materno</label>\n"
                + "                                <div class=\"col-sm-9\">\n"
                + "                                    <input path=\"apMatProfesor\" type=\"text\" class=\"form-control\" id=\"apMatProfesor\" placeholder=\"Apellido Materno\" name=\"apMat\" value='" + profesor.getApMatProfesor() + "'/>\n"
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

    private boolean isDuplicated(CatalogoProfesores pfr) {
        for (CatalogoProfesores p : profesorFacade.findAll()) {
            if (new ManejoStrings().sonIguales(p.getNombreProfesor() + p.getApPatProfesor() + p.getApMatProfesor(),
                    pfr.getNombreProfesor() + pfr.getApPatProfesor() + pfr.getApMatProfesor())) {
                return true;
            }
        }
        return false;
    }
}
