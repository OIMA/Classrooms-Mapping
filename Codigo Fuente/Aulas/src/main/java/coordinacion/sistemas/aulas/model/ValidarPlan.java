/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package coordinacion.sistemas.aulas.model;

import coordinacion.sistemas.aulas.entities.CatalogoPlanes;
import org.springframework.ui.Model;

/**
 *
 * @author OIMA
 */
public class ValidarPlan  extends AbstractError{

    @Override
    public boolean validateForm(Model m, Object entidad) {
        boolean isValid = true;
        CatalogoPlanes plan = (CatalogoPlanes) entidad;
        if (isNull(plan.getNombrePlan())) {
            m.addAttribute("errorNombre","El nombre del plan no puede ser nulo");
            isValid = false;
        } else if (isMoreThan(plan.getNombrePlan(), 20)) {
            m.addAttribute("errorNombre","El nombre debe contener maximo 20 letras");
            isValid = false;
        }
        return isValid;
    }

    @Override
    public boolean isDuplicated(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
