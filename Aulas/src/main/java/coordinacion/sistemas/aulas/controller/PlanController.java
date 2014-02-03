/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package coordinacion.sistemas.aulas.controller;

import coordinacion.sistemas.aulas.entities.CatalogoPlanes;
import coordinacion.sistemas.aulas.sessions.CatalogoPlanesFacade;
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
public class PlanController {
    @EJB(mappedName = "java:global/Aulas/CatalogoPlanesFacade")
    private CatalogoPlanesFacade planFacade;
    
    @RequestMapping(method= RequestMethod.POST,value = "/NuevoPlan.xx")
    public String insertar(Model modelo, CatalogoPlanes plan){
        modelo.addAttribute("plan", new CatalogoPlanes());
        plan.setStatus((short)1);
        planFacade.create(plan);
        return "redirect:Formularios.xx";
    }
}
