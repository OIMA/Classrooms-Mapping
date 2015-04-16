/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coordinacion.sistemas.aulas.model;

import coordinacion.sistemas.aulas.entities.CatalogoGrupos;
import coordinacion.sistemas.aulas.sessions.CatalogoGruposFacade;
import javax.ejb.EJB;
import org.springframework.ui.Model;

/**
 *
 * @author OIMA
 */
public class ValidarGrupo extends AbstractError {

    @Override
    public boolean validateForm(Model m, Object entidad) {
        boolean isValid = true;
        CatalogoGrupos grupo = (CatalogoGrupos) entidad;
        if (isNull(grupo.getClaveGrupo())) {
            m.addAttribute("errorClave", "La clave no puede ser nula");
            isValid = false;
        } else if (isIntNumber(grupo.getClaveGrupo())) {
            m.addAttribute("errorClave", "La clave solo debe contener numeros");
            isValid = false;
        } else if (isMoreThan(String.valueOf(grupo.getCapacidadGrupo()), 6)) {
            m.addAttribute("errorClave", "El grupo debe contener 6 numeros");
            isValid = false;
        } else if (isLessThan(String.valueOf(grupo.getClaveGrupo()), 6)) {
            m.addAttribute("errorClave", "El grupo debe contener 6 numeros");
            isValid = false;
        }
        if (isNull(grupo.getIdCicloEscolar())) {
            m.addAttribute("errorCicloEscolar", "No has insertado ningun ciclo escolar");
            isValid = false;
        }
        if (isNull(grupo.getIdMateria())) {
            m.addAttribute("errorMateria", "No has insertado ninguna materia");
            isValid = false;
        }
        if (isNull(grupo.getIdPlan())) {
            m.addAttribute("errorPlan", "No has insertado ningun plan");
            isValid = false;
        }
        if (isNull(grupo.getIdProfesor())) {
            m.addAttribute("errorProfesor", "No has insertado ningun profesor");
            isValid = false;
        }
        if (isNull(grupo.getCapacidadGrupo())) {
            m.addAttribute("errorCapacidad", "Indica la capacidad máxima del grupo");
            isValid = false;
        } else if (isIntNumber(grupo.getCapacidadGrupo())) {
            m.addAttribute("errorCapacidad", "La capacidad debe contener solo numeros");
            isValid = false;
        } else if (isMoreThan(String.valueOf(grupo.getCapacidadGrupo()), 2)) {
            m.addAttribute("errorCapacidad", "La capacidad maxima es 99");
            isValid = false;
        }
        if ("T".equals(grupo.getForzarGrupo()) || "P".equals(grupo.getForzarGrupo())) {
            m.addAttribute("checked", "checked='checked'");
        }
        return isValid;
    }

    @Override
    public boolean isDuplicated(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
