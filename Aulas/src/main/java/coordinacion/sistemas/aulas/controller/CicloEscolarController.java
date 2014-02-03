/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package coordinacion.sistemas.aulas.controller;

import coordinacion.sistemas.aulas.entities.CatalogoCicloEscolar;
import coordinacion.sistemas.aulas.sessions.CatalogoCicloEscolarFacade;
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
public class CicloEscolarController {
    @EJB(mappedName = "java:global/Aulas/CatalogoCicloEscolarFacade")
    private CatalogoCicloEscolarFacade cicloEscolarFacade;
    
    @RequestMapping(method= RequestMethod.POST,value = "/NuevoCicloEscolar.xx")
    public String insertar(Model modelo, CatalogoCicloEscolar cicloEscolar){
        modelo.addAttribute("cicloEscolar", new CatalogoCicloEscolar());
        cicloEscolar.setStatus((short)1);
        cicloEscolarFacade.create(cicloEscolar);
        return "redirect:Formularios.xx";
    }
}
