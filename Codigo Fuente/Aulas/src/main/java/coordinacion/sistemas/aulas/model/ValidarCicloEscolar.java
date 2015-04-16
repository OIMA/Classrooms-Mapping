/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coordinacion.sistemas.aulas.model;

import coordinacion.sistemas.aulas.entities.CatalogoCicloEscolar;
import java.sql.Date;
import org.springframework.ui.Model;

/**
 *
 * @author OIMA
 */
public class ValidarCicloEscolar extends AbstractError {

    @Override
    public boolean validateForm(Model m, Object entidad) {
        boolean isValid = true;
        CatalogoCicloEscolar cicloEscolar = (CatalogoCicloEscolar) entidad;
        if (isNull(cicloEscolar.getNombreCicloEscolar())) {
            m.addAttribute("errorNombre", "El nombre del ciclo escolar no puede ser nulo");
            isValid = false;
        } else if (isMoreThan(cicloEscolar.getNombreCicloEscolar(), 10)) {
            m.addAttribute("errorNombre", "El nombre debe tener maximo 10 letras");
            isValid = false;
        }
        if (isNull(cicloEscolar.getFechaInicio())) {
            m.addAttribute("errorFI", "La fecha inicial no puede ser vacia");
            isValid = false;
        } else if (isMoreThan(cicloEscolar.getFechaInicio(), 10)) {
            m.addAttribute("errorFI", "La fecha debe tener formato DD/MM/AAAA");
            isValid = false;
        } else if (isLessThan(cicloEscolar.getFechaInicio(), 10)) {
            m.addAttribute("errorFI", "La fecha debe tener formato DD/MM/AAAA");
            isValid = false;
        }
        if (isNull(cicloEscolar.getFechaFin())) {
            m.addAttribute("errorFF", "La fecha final no puede ser vacia");
            isValid = false;
        } else if (isMoreThan(cicloEscolar.getFechaFin(), 10)) {
            m.addAttribute("errorFF", "La fecha debe tener formato DD/MM/AAAA");
            isValid = false;
        } else if (isLessThan(cicloEscolar.getFechaFin(), 10)) {
            m.addAttribute("errorFF", "La fecha debe tener formato DD/MM/AAAA");
            isValid = false;
        }
        try {
            System.out.println("shiyuhsuidhnsduigusfg oeaygiu guqg uiqgeiuy");
        } catch (Exception e) {
            System.out.println("error de fecha");
        }
        return isValid;
    }

    @Override
    public boolean isDuplicated(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
