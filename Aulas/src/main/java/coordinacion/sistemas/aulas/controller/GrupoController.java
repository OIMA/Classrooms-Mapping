/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package coordinacion.sistemas.aulas.controller;

import coordinacion.sistemas.aulas.entities.CatalogoGrupos;
import coordinacion.sistemas.aulas.entities.CatalogoMaterias;
import coordinacion.sistemas.aulas.sessions.CatalogoGruposFacade;
import coordinacion.sistemas.aulas.sessions.CatalogoMateriasFacade;
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
public class GrupoController {
    @EJB(mappedName = "java:global/Aulas/CatalogoGruposFacade")
    private CatalogoGruposFacade grupoFacade;
    @EJB(mappedName = "java:global/Aulas/CatalogoMateriasFacade")
    private CatalogoMateriasFacade materiaFacade;
    
    @RequestMapping(method= RequestMethod.POST,value = "/NuevoGrupo.xx")
    public String insertar(Model modelo, CatalogoGrupos grupo){
        modelo.addAttribute("grupo", new CatalogoGrupos());
        grupo.setStatus((short)1);
        grupoFacade.create(grupo);
        return "redirect:Formularios.xx";
    }
    
   @RequestMapping(method= RequestMethod.GET,value = "/InfoHorasTeoricasMateria.xx")
    public @ResponseBody String infoHorasTeoricas(Model modelo, int idMateria){
       CatalogoMaterias materia = materiaFacade.find(BigDecimal.valueOf((long)idMateria));
        return ""+materia.getHorasTeoricas()+"";
    }
   
    @RequestMapping(method= RequestMethod.GET,value = "/InfoHorasPracticasMateria.xx")
    public @ResponseBody String infoHorasPracticas(Model modelo, int idMateria){
       CatalogoMaterias materia = materiaFacade.find(BigDecimal.valueOf((long)idMateria));
        return ""+materia.getHorasPracticas()+"";
    } 
}
