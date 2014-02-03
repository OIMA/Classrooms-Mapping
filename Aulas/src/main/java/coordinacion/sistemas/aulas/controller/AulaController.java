/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package coordinacion.sistemas.aulas.controller;

import coordinacion.sistemas.aulas.entities.CatalogoAulas;
import coordinacion.sistemas.aulas.sessions.CatalogoAulasFacade;
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
public class AulaController {
     @EJB(mappedName = "java:global/Aulas/CatalogoAulasFacade")
    private CatalogoAulasFacade aulaFacade;

    @RequestMapping(method = RequestMethod.POST, value = "/NuevaAula.xx")
    public String insertar(Model modelo, CatalogoAulas aula) {
        modelo.addAttribute("aula", new CatalogoAulas());
        aula.setStatus((short) 1);
        aulaFacade.create(aula);
        return "redirect:Formularios.xx";
    }
}
