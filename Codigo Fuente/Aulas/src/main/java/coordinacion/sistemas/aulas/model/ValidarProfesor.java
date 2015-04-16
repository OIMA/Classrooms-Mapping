/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coordinacion.sistemas.aulas.model;

import coordinacion.sistemas.aulas.entities.CatalogoProfesores;
import org.springframework.ui.Model;

/**
 *
 * @author OIMA
 */
public class ValidarProfesor extends AbstractError {

    @Override
    public boolean validateForm(Model m, Object entidad) {
        boolean isValid = true;
        CatalogoProfesores profesor = (CatalogoProfesores) entidad;
        if (isNull(profesor.getNombreProfesor())) {
            m.addAttribute("errorNombre", "El nombre del profesor no puede ser nulo");
            isValid = false;
        } else if (isMoreThan(profesor.getNombreProfesor(), 50)) {
            m.addAttribute("errorNombre", "El nombre debe tener maximo 50 letras");
            isValid = false;
        }
        if (isNull(profesor.getApPatProfesor())) {
            m.addAttribute("errorApPat", "El apellido paterno no puede ser nulo");
            isValid = false;
        } else if (isMoreThan(profesor.getApPatProfesor(), 50)) {
            m.addAttribute("errorApPat", "El apellido paterno debe tener maximo 50 letras");
            isValid = false;
        }
        if (isNull(profesor.getApMatProfesor())) {
            m.addAttribute("errorApMat", "El apellido paterno no puede ser nulo");
            isValid = false;
        } else if (isMoreThan(profesor.getApMatProfesor(), 50)) {
            m.addAttribute("errorApMat", "El apellido materno debe tener maximo 50 letras");
            isValid = false;
        }
        return isValid;
    }

    @Override
    public boolean isDuplicated(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
