/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coordinacion.sistemas.aulas.model;

import coordinacion.sistemas.aulas.entities.CatalogoMaterias;
import org.springframework.ui.Model;

/**
 *
 * @author OIMA
 */
public class ValidarMateria extends AbstractError {

    @Override
    public boolean validateForm(Model m, Object entidad) {
        boolean isValid = true;
        CatalogoMaterias materia = (CatalogoMaterias) entidad;
        if (materia.getBloque() < (short) 1) {
            m.addAttribute("errorBloque", "Debes elegir alguno de los bloques");
            isValid = false;
        }
        if (isNull(materia.getHorasPracticas())) {
            m.addAttribute("errorHP", "Escribe un numero menor a 10");
            isValid = false;
        } else if (isMoreThan(String.valueOf(materia.getHorasPracticas()), 1)) {
            m.addAttribute("errorHP", "Escribe un numero menor a 10");
            isValid = false;
        }
        if (isNull(materia.getHorasTeoricas())) {
            m.addAttribute("errorHT", "Escribe un numero menor a 10");
            isValid = false;
            
        } else if (isMoreThan(String.valueOf(materia.getHorasTeoricas()), 1)) {
            m.addAttribute("errorHP", "Escribe un numero menor a 10");
            isValid = false;
            
        }
        if (isNull(materia.getIdEspecialidad())) {
            m.addAttribute("errorEspecialidad", "No has insertado ninguna especialidad");
            isValid = false;
        }
        if (isNull(materia.getNombreMateria())) {
            m.addAttribute("errorNombre", "El nombre no debe ser vacío");
            isValid = false;
        } else if (isMoreThan(materia.getNombreMateria(), 100)) {
            m.addAttribute("errorNombre", "El nombre debe contener maximo 100 letras");
            isValid = false;
        }
        return isValid;
    }

    @Override
    public boolean isDuplicated(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
