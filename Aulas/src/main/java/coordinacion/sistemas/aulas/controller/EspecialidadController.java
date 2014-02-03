/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package coordinacion.sistemas.aulas.controller;

import coordinacion.sistemas.aulas.entities.CatalogoEspecialidades;
import coordinacion.sistemas.aulas.sessions.CatalogoEspecialidadesFacade;
import java.math.BigDecimal;
import javax.ejb.EJB;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author OIMA
 */
@Controller
public class EspecialidadController {
    @EJB(mappedName = "java:global/Aulas/CatalogoEspecialidadesFacade")
    private CatalogoEspecialidadesFacade especialidadFacade;
    
     @RequestMapping(method = RequestMethod.POST, value = "/NuevaEspecialidad.xx")
    public String insertar(Model modelo, CatalogoEspecialidades especialidad) {
        modelo.addAttribute("especialidad", new CatalogoEspecialidades());
        especialidad.setStatus((short)0);
        especialidadFacade.create(especialidad);
        return "redirect:Formularios.xx";
    }
    
//    
//    @RequestMapping(method = RequestMethod.GET,value = "/AltaEspecialidades.xx")
//    public String nombreRuta(Model modelo){
//        modelo.addAttribute("especialidad", new CatalogoEspecialidades());
//        return "/Especialidades/AltaEspecialidades";
//    }
//    
//    @RequestMapping(method = RequestMethod.POST, value = "/guardarEspecialidad.xx")
//    public String insertar(Model modelo, CatalogoEspecialidades especialidad){
//        especialidadFacade.create(especialidad);
//        modelo.addAttribute("especialidad", new CatalogoEspecialidades());
//        System.out.println(especialidad.getNombreEspecialidad());
//        return "/Especialidades/AltaEspecialidades";
//    }
//    
//    @RequestMapping(method = RequestMethod.GET, value = "/TablaEspecialidades.xx")
//    public String tablaEspecialidad(Model modelo){
//        modelo.addAttribute("tabla", especialidadFacade.findAll());
//        return "/Especialidades/TablaEspecialidades";
//    }
//    
//    @RequestMapping(method = RequestMethod.POST, value = "/EliminarEspecialidad.xx")
//    public @ResponseBody String eliminarEspecialidad(Model modelo, int id){
//        CatalogoEspecialidades e = especialidadFacade.find(BigDecimal.valueOf(id));
//        e.setStatus((short)0);
//        especialidadFacade.edit(e);
//        System.out.println("Especialidad "+id+" eliminada");
//        return "ok";
//    }
}

