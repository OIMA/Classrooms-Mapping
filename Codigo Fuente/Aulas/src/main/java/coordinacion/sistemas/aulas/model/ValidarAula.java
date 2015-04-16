/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coordinacion.sistemas.aulas.model;

import coordinacion.sistemas.aulas.entities.CatalogoAulas;
import coordinacion.sistemas.aulas.sessions.CatalogoAulasFacade;
import coordinacion.sistemas.aulas.sessions.CatalogoCarrerasFacade;
import java.util.List;
import javax.ejb.EJB;
import org.springframework.ui.Model;

/**
 *
 * @author OIMA
 */
public class ValidarAula extends AbstractError {

    private boolean valido = true;
//    @EJB(mappedName = "java:global/Aulas/CatalogoCarrerasFacade")
//    private CatalogoCarrerasFacade carreraFacade;
    @EJB(mappedName = "java:global/Aulas/CatalogoAulasFacade")
    private CatalogoAulasFacade aulaFacade;

    @Override
    public boolean validateForm(Model m, Object entidad) {
        CatalogoAulas aula = (CatalogoAulas) entidad;
//        List<CatalogoAulas> listaAulas = aulaFacade.findAll();
//        for (CatalogoAulas a : listaAulas) {
//            if (a.getAula().equals(aula.getAula()) && a.getEdificio().equals(aula.getEdificio())) {
//                m.addAttribute("errorEdificio", "Error de coincidencia de aulas");
//                m.addAttribute("errorAula", "Error de coincidencia de aulas");
//                setValido(false);
//                break;
//            }
//        }
        if (isNull(aula.getEdificio())) {
            m.addAttribute("errorEdificio", "El edificio no puede ser nulo");
            setValido(false);
        } else if (isMoreThan(aula.getEdificio(), 30)) {
            m.addAttribute("errorEdificio", "El edificio debe contener como máximo 30 letras");
            setValido(false);
        }
        if (isNull(aula.getAula())) {
            m.addAttribute("errorAula", "El aula no puede ser vacio");
            setValido(false);
        } else if (isMoreThan(aula.getAula(), 30)) {
            m.addAttribute("errorAula", "El aula debe contener como máximo 30 letras");
            setValido(false);
        }
        if (isNull(aula.getCapacidadAula())) {
            m.addAttribute("errorCapacidad", "Indica la capacidad maxima del aula");
            setValido(false);
        }else if (isMoreThan(String.valueOf(aula.getCapacidadAula()), 2)) {
            m.addAttribute("errorCapacidad", "La capacidad maxima es 99");
            setValido(false);
        }
        if (isNull(aula.getIdCarrera())) {
            m.addAttribute("errorCarrera", "No has insertado ninguna carrera");
            setValido(false);
        } 
//        else {
//            m.addAttribute("listaCarreras", carreraFacade.findAll());
//        }
        return isValido();
    }

    public boolean isValido() {
        return valido;
    }

    public void setValido(boolean valido) {
        this.valido = valido;
    }

    @Override
    public boolean isDuplicated(Object o) {
        return false;
    }

}
