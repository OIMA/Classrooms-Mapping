/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package coordinacion.sistemas.aulas.controller;

import coordinacion.sistemas.aulas.entities.CatalogoProfesores;
import coordinacion.sistemas.aulas.sessions.CatalogoProfesoresFacade;
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
public class ProfesorController {
    @EJB(mappedName = "java:global/Aulas/CatalogoProfesoresFacade")
    private CatalogoProfesoresFacade profesorFacade;
    
    @RequestMapping(method= RequestMethod.POST,value = "/NuevoProfesor.xx")
    public String insertar(Model modelo, CatalogoProfesores profesor){
        modelo.addAttribute("profesor", new CatalogoProfesores());
        profesor.setStatus((short)1);
        profesorFacade.create(profesor);
        return "redirect:Formularios.xx";
    }
}
