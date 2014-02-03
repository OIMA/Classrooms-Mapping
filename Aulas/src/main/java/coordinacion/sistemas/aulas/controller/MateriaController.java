/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package coordinacion.sistemas.aulas.controller;

import coordinacion.sistemas.aulas.entities.CatalogoEspecialidades;
import coordinacion.sistemas.aulas.entities.CatalogoMaterias;
import coordinacion.sistemas.aulas.sessions.CatalogoMateriasFacade;
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
public class MateriaController {

    @EJB(mappedName = "java:global/Aulas/CatalogoMateriasFacade")
    private CatalogoMateriasFacade materiaFacade;

    @RequestMapping(method = RequestMethod.POST, value = "/NuevaMateria.xx")
    public String insertar(Model modelo, CatalogoMaterias materia) {
        modelo.addAttribute("materia", new CatalogoMaterias());
        materia.setStatus((short) 1);
        materiaFacade.create(materia);
        return "redirect:Formularios.xx";
    }
}