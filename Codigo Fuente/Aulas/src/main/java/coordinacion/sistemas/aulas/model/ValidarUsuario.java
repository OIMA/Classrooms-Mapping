/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coordinacion.sistemas.aulas.model;

import coordinacion.sistemas.aulas.entities.CatalogoUsuarios;
import java.util.List;
import org.springframework.ui.Model;

/**
 *
 * @author OIMA
 */
public class ValidarUsuario extends AbstractError {

    @Override
    public boolean validateForm(Model m, Object entidad) {
        boolean valido = true;
        CatalogoUsuarios usuario = (CatalogoUsuarios) entidad;
        if (isNull(usuario.getNombre())) {
            m.addAttribute("errorNombre", "El nombre no puede ser nulo");
            valido = false;
        } else if (isMoreThan(usuario.getNombre(), 45)) {
            m.addAttribute("errorNombre", "El nombre debe contener maximo 45 letras");
            valido = false;
        }
        if (isNull(usuario.getApPat())) {
            m.addAttribute("errorApPat", "El apellido paterno no puede ser nulo");
            valido = false;
        } else if (isMoreThan(usuario.getApPat(), 45)) {
            m.addAttribute("errorApPat", "El apellido paterno debe contener maximo 45 letras");
            valido = false;
        }
        if (isNull(usuario.getApMat())) {
            m.addAttribute("errorApMat", "El apellido materno no puede ser nulo");
            valido = false;
        } else if (isMoreThan(usuario.getApMat(), 45)) {
            m.addAttribute("errorApMat", "El apellido materno debe contener maximo 45 letras");
            valido = false;
        }
        if (isNull(usuario.getNombreUsuario())) {
            m.addAttribute("errorNombreUsuario", "El nombre de usuario no puede ser nulo");
            valido = false;
        } else if (isMoreThan(usuario.getNombreUsuario(), 20)) {
            m.addAttribute("errorNombreUsuario", "El usuario debe contener maximo 20 letras");
            valido = false;
        } 
        if (isNull(usuario.getPasswordUsuario())) {
            m.addAttribute("errorContrasenia", "La contraseña no puede ser nulo");
            valido = false;
        } else if (isLessThan(usuario.getPasswordUsuario(), 6)) {
            m.addAttribute("errorContrasenia", "La contraseña debe tener minimo 6 caracteres");
            valido = false;
        } else if (isMoreThan(usuario.getPasswordUsuario(), 20)) {
            m.addAttribute("errorContrasenia", "La contraseña debe tener maximo 20 caracteres");
            valido = false;
        }
        //encontrar duplicidad de usuarios
        return valido;
    }

    @Override
    public boolean isDuplicated(Object o) {
        
        return false;
    }
}
