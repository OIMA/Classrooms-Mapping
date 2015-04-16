/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package coordinacion.sistemas.aulas.controller;

import auxiliar.ManejoStrings;
import coordinacion.sistemas.aulas.entities.CatalogoCarreras;
import coordinacion.sistemas.aulas.entities.CatalogoEspecialidades;
import coordinacion.sistemas.aulas.entities.CatalogoUsuarios;
import coordinacion.sistemas.aulas.model.ValidarCarrera;
import coordinacion.sistemas.aulas.sessions.CatalogoCarrerasFacade;
import coordinacion.sistemas.aulas.sessions.CatalogoEspecialidadesFacade;
import coordinacion.sistemas.aulas.sessions.CatalogoUsuariosFacade;
import java.math.BigDecimal;
import java.security.Principal;
import javax.ejb.EJB;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author OIMA
 */
@Controller
public class CarreraController extends AbstractController {

    @EJB(mappedName = "java:global/Aulas/CatalogoCarrerasFacade")
    private CatalogoCarrerasFacade carreraFacade;
    @EJB(mappedName = "java:global/Aulas/CatalogoUsuariosFacade")
    private CatalogoUsuariosFacade usuarioFacade;
    @EJB(mappedName = "java:global/Aulas/CatalogoEspecialidadesFacade")
    private CatalogoEspecialidadesFacade especialidadFacade;

    @RequestMapping(method = RequestMethod.POST, value = "/NuevaCarrera.xx")
    public String insertar(Model modelo, @Valid CatalogoCarreras carrera, BindingResult result, Principal p) {
        addNombreUsuario(modelo, p);
        ValidarCarrera validar = new ValidarCarrera();
        if (result.hasErrors() || !validar.validateForm(modelo, carrera) || isDuplicated(carrera) || alreadyAsigned(carrera)) {
//            validar.validateForm(modelo, carrera);
            modelo.addAttribute("mensajeInicial", obtenerMensajeInicial(2));
            modelo.addAttribute("listaUsuarios", usuarioFacade.findBySpecificField("tipo", 2, "equal", ord("nombre", "asc"), null));
            modelo.addAttribute("carrera", carrera);
            if (isDuplicated(carrera)) {
                modelo.addAttribute("errorNombre", "Esta carrera ya existe");
            }
            if (alreadyAsigned(carrera)) {
                modelo.addAttribute("errorUsuario", "Este usuario ya tiene asignado una carrera");
            }
            return "/Formularios/FormularioCarrera";
        } else {
            carrera.setStatus((short) 1);
            modelo.addAttribute("mensajeInicial", obtenerMensajeInicial(1));
            modelo.addAttribute("listaUsuarios", usuarioFacade.findBySpecificField("tipo", 2, "equal", ord("nombre", "asc"), null));
            modelo.addAttribute("carrera", new CatalogoCarreras());
            carreraFacade.create(carrera);
            return "/Formularios/FormularioCarrera";
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/EditarCarrera.xx")
    public String editarCarrera(Model modelo, BigDecimal idCarrera, String nombre, BigDecimal idUsuario) {
        CatalogoCarreras carrera = carreraFacade.find(idCarrera);
        carrera.setIdUsuario(usuarioFacade.find(idUsuario));
        carrera.setNombreCarrera(nombre);
        carreraFacade.edit(carrera);
        //*********Terminar de acuerdo al formulario
        return "redirect:Tablas.xx?edT=car";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/EliminarCarrera.xx")
    public @ResponseBody
    String eliminarCarrera(Model modelo, BigDecimal idEl) {
        CatalogoCarreras carrera = carreraFacade.find(idEl);
        boolean eliminacionAprobada = true;
        for (CatalogoEspecialidades e : especialidadFacade.findAll()) {
            if (e.getIdCarrera().equals(carrera)) {
                eliminacionAprobada = false;
                break;
            }
        }
        if (eliminacionAprobada) {
                System.out.println("eliminar carrera con id >> "+idEl);
                carreraFacade.remove(carreraFacade.find(idEl));
            return "Eliminación de Carrera exitosa";
        } else {
            return "No se puede eliminar porque la carrera ya está asignada una especialidad";
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/ObtenerFormularioCarrera.xx")
    public @ResponseBody
    String formularioEditarCarrera(Model modelo, BigDecimal idEd) {
        CatalogoCarreras carrera = carreraFacade.find(idEd);
        String listaUsuarios = "";
        for (CatalogoUsuarios u : usuarioFacade.findAll()) {
            System.out.println(u.getNombreUsuario());
            listaUsuarios += "<option value='" + u.getIdUsuario() + "' " + ((carrera.getIdUsuario().equals(u)) ? "selected='selected'" : "") + ">" + u.getNombreUsuario() + "</option>\n";
        }
        System.out.println(listaUsuarios);
        String formulario = ""
                + "<form class=\"form-horizontal\" role=\"form\" action=\"EditarCarrera.xx\" method=\"POST\" commandName=\"carrera\">\n"
                + "<input type='hidden' name='idCarrera' value='" + carrera.getIdCarrera() + "'/>"
                + "                            <div class=\"form-group\">\n"
                + "                                <label path=\"\" for=\"nombreCarrera\" class=\"col-sm-3 control-label\">Nombre carrera</label>\n"
                + "                                <div class=\"col-sm-9\">\n"
                + "                                    <input path=\"nombreCarrera\" type=\"text\" class=\"form-control\" id=\"nombreCarrera\" placeholder=\"Nombre carrera\" name='nombre' value='" + carrera.getNombreCarrera() + "'/>\n"
                + "                                </div>\n"
                + "                            </div>\n"
                + "                            <div class=\"form-group\">\n"
                + "                                <label path=\"\" for=\"usuario\" class=\"col-sm-3 control-label\">Usuario</label>\n"
                + "                                <div class=\"col-sm-9\">\n"
                + "                                    <select path=\"idUsuario.idUsuario\" class=\"form-control\" name=\"idUsuario\">\n"
                /////////////////////////////////////----------FOR-----------\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
                + listaUsuarios
                ///////////////////////////////////----------FOR-----------\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
                + "                                    </select>\n"
                + "                                </div>\n"
                + "                            </div>                            \n"
                + "                            <div class=\"form-group\">\n"
                + "                                <div class=\"col-sm-offset-9 col-sm-3\">\n"
                + "                                    <button type=\"submit\" class=\"btn btn-warning\">Actualizar</button>\n"
                + "                                </div>\n"
                + "                            </div>\n"
                + "                        </form>"
                + "";
        return formulario;
    }

    public boolean isDuplicated(CatalogoCarreras carrera) {
        for (CatalogoCarreras c : carreraFacade.findAll()) {
            if (new ManejoStrings().sonIguales(carrera.getNombreCarrera(), c.getNombreCarrera())) {
                return true;
            }
        }
        return false;
    }

    private boolean alreadyAsigned(CatalogoCarreras carrera) {
        CatalogoUsuarios user = carrera.getIdUsuario();
        for (CatalogoCarreras car : carreraFacade.findAll()) {
            if (car.getIdUsuario().equals(user)) {
                return true;
            }
        }
        return false;
    }
}
