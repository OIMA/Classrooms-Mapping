/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package coordinacion.sistemas.aulas.model;

import coordinacion.sistemas.aulas.entities.CatalogoCarreras;
import org.springframework.ui.Model;

/**
 *
 * @author OIMA
 */
public class ValidarCarrera  extends AbstractError{

    @Override
    public boolean validateForm(Model m, Object entidad) {
        boolean esValido = true;
        CatalogoCarreras carrera = (CatalogoCarreras) entidad;
        if (isNull(carrera.getNombreCarrera())) {
            m.addAttribute("errorNombre","El nombre de la carrerra no debe ser nulo");
            esValido = false;
        }else if (isMoreThan(carrera.getNombreCarrera(), 50)) {
            m.addAttribute("errorNombre","El nombre debe contener maximo 50 letras");
            esValido = false;
        }
        if (isNull(carrera.getIdUsuario())) {
            m.addAttribute("errorUsuario","No has insertado ningun usuario");
            esValido = false;
        }
        return esValido;
    }

    @Override
    public boolean isDuplicated(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
