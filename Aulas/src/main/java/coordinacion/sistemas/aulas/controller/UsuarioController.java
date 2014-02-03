/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package coordinacion.sistemas.aulas.controller;

import coordinacion.sistemas.aulas.entities.CatalogoUsuarios;
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
public class UsuarioController {
    @EJB(mappedName = "java:global/Aulas/CatalogoUsuariosFacade")
    private CatalogoUsuariosFacade usuarioFacade;
    
    @RequestMapping(method= RequestMethod.POST,value = "/NuevoUsuario.xx")
    public String insertar(Model modelo, CatalogoUsuarios usuario){
        modelo.addAttribute("usuario", new CatalogoUsuarios());
        usuario.setStatus((short)1);
        usuarioFacade.create(usuario);
        return "redirect:Formularios.xx";
    }
}
