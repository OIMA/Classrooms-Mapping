/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package coordinacion.sistemas.aulas.controller;

import auxiliar.ManejoStrings;
import coordinacion.sistemas.aulas.entities.CatalogoCicloEscolar;
import coordinacion.sistemas.aulas.entities.CatalogoGrupos;
import coordinacion.sistemas.aulas.model.ValidarCicloEscolar;
import coordinacion.sistemas.aulas.sessions.CatalogoCicloEscolarFacade;
import coordinacion.sistemas.aulas.sessions.CatalogoGruposFacade;
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
public class CicloEscolarController extends AbstractController {

    @EJB(mappedName = "java:global/Aulas/CatalogoCicloEscolarFacade")
    private CatalogoCicloEscolarFacade cicloEscolarFacade;
    @EJB(mappedName = "java:global/Aulas/CatalogoGruposFacade")
    private CatalogoGruposFacade grupoFacade;

    @RequestMapping(method = RequestMethod.POST, value = "/NuevoCicloEscolar.xx")
    public String insertar(Model modelo, @Valid CatalogoCicloEscolar cicloEscolar, BindingResult result, Principal p) {
        addNombreUsuario(modelo, p);
        ValidarCicloEscolar validar = new ValidarCicloEscolar();
        if (result.hasErrors() || !validar.validateForm(modelo, cicloEscolar) || isDuplicated(cicloEscolar)) {
            validar.validateForm(modelo, cicloEscolar);
            modelo.addAttribute("cicloEscolar", cicloEscolar);
            modelo.addAttribute("mensajeInicial", obtenerMensajeInicial(2));
            if (isDuplicated(cicloEscolar)) {
                modelo.addAttribute("errorNombre", "Este cicloEscolar ya existe");
            }
            return "/Formularios/FormularioCicloEscolar";
        } else {
            cicloEscolar.setStatus((short) 1);
            cicloEscolarFacade.create(cicloEscolar);
            modelo.addAttribute("mensajeInicial", obtenerMensajeInicial(1));
            modelo.addAttribute("cicloEscolar", new CatalogoCicloEscolar());
            return "/Formularios/FormularioCicloEscolar";
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/EditarCicloEscolar.xx")
    public String editarCicloEscolar(Model modelo, BigDecimal idCicloEscolar, String ce, String fi, String ff) {
        CatalogoCicloEscolar cicloEscolar = cicloEscolarFacade.find(idCicloEscolar);
        cicloEscolar.setNombreCicloEscolar(ce);
        cicloEscolar.setFechaInicio(fi);
        cicloEscolar.setFechaFin(ff);
        cicloEscolarFacade.edit(cicloEscolar);
        return "redirect:Tablas.xx?edT=ces";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/EliminarCicloEscolar.xx")
    public @ResponseBody
    String eliminarCicloEscolar(Model modelo, BigDecimal idEl) {
        CatalogoCicloEscolar cicloEscolar = cicloEscolarFacade.find(idEl);
        boolean eliminacionAprobada = true;
        for (CatalogoGrupos g : grupoFacade.findAll()) {
            if (g.getIdCicloEscolar().equals(cicloEscolar)) {
                eliminacionAprobada = false;
                break;
            }
        }
        if (eliminacionAprobada) {
            cicloEscolar.setStatus(Short.valueOf("" + 0));
//            cicloEscolarFacade.edit(cicloEscolar);
            cicloEscolarFacade.remove(cicloEscolar);
            return "Eliminación de cicloEscolar exitosa";
        } else {
            return "No se puede eliminar porque el cicloEscolar ya está asignado uno o mas grupos";
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/ObtenerFormularioCicloEscolar.xx")
    public @ResponseBody
    String formularioEditarCicloEscolar(Model modelo, BigDecimal idEd) {
        CatalogoCicloEscolar cicloEscolar = cicloEscolarFacade.find(idEd);
        String formulario = ""
                + "<form class=\"form-horizontal\" role=\"form\"  commandName=\"cicloEscolar\" action=\"EditarCicloEscolar.xx\" method=\"POST\" >\n"
                + "        <input  type='hidden' value= \"" + cicloEscolar.getIdCicloEscolar() + " \" name=\"idCicloEscolar\"/>"
                + "                            <div class=\"form-group\">\n"
                + "                                <label path=\"\" for=\"nombreCicloEscolar\" class=\"col-sm-3 control-label\">Ciclo Escolar</label>\n"
                + "                                <div class=\"col-sm-9\">\n"
                + "                                    <input path=\"nombreCicloEscolar\" type=\"text\" class=\"form-control\" id=\"nombreCicloEscolar\" name=\"ce\" placeholder=\"Nombre CicloEscolar\" value='" + cicloEscolar.getNombreCicloEscolar() + "'/>\n"
                + "                                </div>\n"
                + "                            </div>\n"
                + "                            <div class=\"form-group\">\n"
                + "                                <label path=\"\" for=\"\" class=\"col-sm-3 control-label\">Fecha inicio</label>\n"
                + "                                <div class=\"col-sm-9\">\n"
                + "                                    <input path=\"fechaInicio\" type=\"text\" class=\"form-control\" id=\"fechaInicioCicloEscolar\" name=\"fi\" placeholder=\"Fecha inicio\" value='" + cicloEscolar.getFechaInicio() + "'/>\n"
                + "                                </div>\n"
                + "                            </div>\n"
                + "                            <div class=\"form-group\">\n"
                + "                                <label path=\"\" for=\"\" class=\"col-sm-3 control-label\">Fecha inicio</label>\n"
                + "                                <div class=\"col-sm-9\">\n"
                + "                                    <input path=\"fechaFin\" type=\"text\" class=\"form-control\" id=\"fechaFinCicloEscolar\" name=\"ff\" placeholder=\"Fecha fin\" value='" + cicloEscolar.getFechaFin() + "'/>\n"
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

    private boolean isDuplicated(CatalogoCicloEscolar cicloEscolar) {
        for (CatalogoCicloEscolar ce : cicloEscolarFacade.findAll()) {
            if (ce != null && cicloEscolar != null) {
                if (new ManejoStrings().sonIguales(ce.getNombreCicloEscolar(), cicloEscolar.getNombreCicloEscolar())) {
                    return true;
                }
            }
        }
        return false;
    }
}
