/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package coordinacion.sistemas.aulas.controller;

import auxiliar.ManejoStrings;
import coordinacion.sistemas.aulas.entities.CatalogoGrupos;
import coordinacion.sistemas.aulas.entities.CatalogoPlanes;
import coordinacion.sistemas.aulas.model.ValidarPlan;
import coordinacion.sistemas.aulas.sessions.CatalogoGruposFacade;
import coordinacion.sistemas.aulas.sessions.CatalogoPlanesFacade;
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
public class PlanController extends AbstractController{

    @EJB(mappedName = "java:global/Aulas/CatalogoPlanesFacade")
    private CatalogoPlanesFacade planFacade;
    @EJB(mappedName = "java:global/Aulas/CatalogoGruposFacade")
    private CatalogoGruposFacade grupoFacade;

    @RequestMapping(method = RequestMethod.POST, value = "/NuevoPlan.xx")
    public String insertar(Model modelo, @Valid CatalogoPlanes plan, BindingResult result, Principal p) {
        addNombreUsuario(modelo, p);
        ValidarPlan validar = new ValidarPlan();
        if (result.hasErrors() || !validar.validateForm(modelo, plan) || isDuplicated(plan)) {
            validar.validateForm(modelo, plan);
            modelo.addAttribute("plan", plan);
            modelo.addAttribute("mensajeInicial", obtenerMensajeInicial(2));
            if (isDuplicated(plan)) {
                modelo.addAttribute("errorNombre", "Este plan ya existe");
            }
            return "/Formularios/FormularioPlan";
        } else {
            plan.setStatus((short) 1);
            planFacade.create(plan);
            modelo.addAttribute("plan", new CatalogoPlanes());
            modelo.addAttribute("mensajeInicial", obtenerMensajeInicial(1));
            return "/Formularios/FormularioPlan";
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/EditarPlan.xx")
    public String editarPlan(Model modelo, BigDecimal idPlan, String nombre_plan) {
        modelo.addAttribute("planEditado", new CatalogoPlanes());
        CatalogoPlanes plan = planFacade.find(idPlan);
        plan.setNombrePlan(nombre_plan);
        planFacade.edit(plan);
        return "redirect:Tablas.xx?edT=pln";
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/EliminarPlan.xx")
    public @ResponseBody String eliminarCarrera(Model modelo, BigDecimal idEl) {
        CatalogoPlanes plan = planFacade.find(idEl);
        boolean eliminacionAprobada = true;
        for (CatalogoGrupos g : grupoFacade.findAll()) {
            if (g.getIdPlan().equals(plan)) {
                eliminacionAprobada = false;
                break;
            }
        }
        if (eliminacionAprobada) {
            plan.setStatus(Short.valueOf(""+0));
//            planFacade.edit(plan);
            planFacade.remove(plan);
            return "Eliminación de plan exitosa";
        }else{
            return "No se puede eliminar porque el plan ya está asignado uno o mas grupos";
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/ObtenerFormularioPlan.xx")
    public @ResponseBody
    String formularioEditarPlan(Model modelo, BigDecimal idEd) {
        CatalogoPlanes plan = planFacade.find(idEd);
        String formulario = ""
                + "<form class=\"form-horizontal\" role=\"form\" action=\"EditarPlan.xx\" method=\"POST\" commandName=\"planEditado\">\n"
                + "    <div class=\"form-group\">\n"
                + "        <input  type='hidden' value= \""+plan.getIdPlan()+" \" name=\"idPlan\"/>"
                + "        <label for=\"nombre_plan\" class=\"col-sm-2 control-label\">Nombre o clave:</label>\n"
                + "        <div class=\"col-sm-10\">\n"
                + "            <input path=\"nombrePlan\" type=\"text\" class=\"form-control\" id=\"nombrePlan\" placeholder=\"Nombre o clave del plan\" name=\"nombre_plan\" value=\"" + plan.getNombrePlan() + "\"/>\n"
                + "        </div>\n"
                + "    </div>\n"
                + "    <div class=\"form-group\">\n"
                + "        <div class=\"col-sm-offset-9 col-sm-3\">\n"
                + "            <button type=\"submit\" class=\"btn btn-warning\">Actualizar</button>\n"
                + "        </div>\n"
                + "    </div>\n"
                + "</form>";
        return formulario;
    }

    private boolean isDuplicated(CatalogoPlanes plan) {
        for (CatalogoPlanes p : planFacade.findAll()) {
            if (new ManejoStrings().sonIguales(plan.getNombrePlan(), p.getNombrePlan())) {
                return true;
            }
        }
        return false;
    }

}
