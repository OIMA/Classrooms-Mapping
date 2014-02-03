/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package coordinacion.sistemas.aulas.controller;

import coordinacion.sistemas.aulas.entities.CatalogoCarreras;
import coordinacion.sistemas.aulas.entities.CatalogoEspecialidades;
import coordinacion.sistemas.aulas.sessions.CatalogoCarrerasFacade;
import coordinacion.sistemas.aulas.sessions.CatalogoUsuariosFacade;
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
public class CarreraController {

    @EJB(mappedName = "java:global/Aulas/CatalogoCarrerasFacade")
    private CatalogoCarrerasFacade carreraFacade;

    @RequestMapping(method = RequestMethod.POST, value = "/NuevaCarrera.xx")
    public String insertar(CatalogoCarreras carrera, Model modelo) {
        modelo.addAttribute("carrera", new CatalogoCarreras());
        carrera.setStatus((short)1);
        carreraFacade.create(carrera);
        return "redirect:Formularios.xx";
    }
}
