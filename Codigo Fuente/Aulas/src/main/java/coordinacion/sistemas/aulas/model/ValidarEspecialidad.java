/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package coordinacion.sistemas.aulas.model;

import coordinacion.sistemas.aulas.entities.CatalogoEspecialidades;
import org.springframework.ui.Model;

/**
 *
 * @author OIMA
 */
public class ValidarEspecialidad  extends AbstractError{

    @Override
    public boolean validateForm(Model m, Object entidad) {
        boolean isValid = true;
        CatalogoEspecialidades especialidad = (CatalogoEspecialidades) entidad;
        if (isNull(especialidad.getNombreEspecialidad())) {
            m.addAttribute("errorNombre","El nombre de la especialidad no debe ser nulo");
            isValid = false;
        } else if (isMoreThan(especialidad.getNombreEspecialidad(), 150)) {
            m.addAttribute("errorNombre","El nombre debe contener maximo 150 letras");
            isValid = false;
        }
        if (isNull(especialidad.getIdCarrera())) {
            m.addAttribute("errorCarrera","No has insertado ninguna carrera");
            isValid = false;
        }
        return isValid;
    }

    @Override
    public boolean isDuplicated(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
