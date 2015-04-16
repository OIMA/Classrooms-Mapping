/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package coordinacion.sistemas.aulas.controller;

import auxiliar.ManejoStrings;
import coordinacion.sistemas.aulas.entities.CatalogoCarreras;
import coordinacion.sistemas.aulas.entities.CatalogoUsuarios;
import coordinacion.sistemas.aulas.entities.UserRole;
import coordinacion.sistemas.aulas.model.ValidarUsuario;
import coordinacion.sistemas.aulas.sessions.CatalogoCarrerasFacade;
import coordinacion.sistemas.aulas.sessions.CatalogoUsuariosFacade;
import coordinacion.sistemas.aulas.sessions.UserRoleFacade;
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
public class UsuarioController extends AbstractController {

    @EJB(mappedName = "java:global/Aulas/CatalogoUsuariosFacade")
    private CatalogoUsuariosFacade usuarioFacade;
    @EJB(mappedName = "java:global/Aulas/CatalogoCarrerasFacade")
    private CatalogoCarrerasFacade carreraFacade;
    @EJB(mappedName = "java:global/Aulas/UserRoleFacade")
    private UserRoleFacade userRoleFacade;

    @RequestMapping(method = RequestMethod.POST, value = "/NuevoUsuario.xx")
    public String insertar(Model modelo, @Valid CatalogoUsuarios usuario, BindingResult result, Principal p) {
        addNombreUsuario(modelo, p);
        ValidarUsuario validar = new ValidarUsuario();
        if (result.hasErrors() || !validar.validateForm(modelo, usuario)) {
            validar.validateForm(modelo, usuario);
            for (int i = 0; i < result.getAllErrors().size(); i++) {
                System.out.println(result.getAllErrors().get(i));
            }
            System.out.println(isDuplicated(usuario));
            if (isDuplicated(usuario)) {
                modelo.addAttribute("errorNombreUsuario", "Este nombre de usuario ya existe");
            }
            modelo.addAttribute("usuario", usuario);
            modelo.addAttribute("mensajeInicial", obtenerMensajeInicial(2));
            return "/Formularios/FormularioUsuario";
        } else {
            String userRole = null;
            switch (usuario.getTipo()) {
                case 1:
                    userRole = "ROLE_ADMINISTRADOR";
                    break;
                case 2:
                    userRole = "ROLE_COORDINADOR";
                    break;
                default:
            }
            usuario.setStatus((short) 1);
            UserRole role = new UserRole();
            role.setAuthority(userRole);
            role.setUserId(usuario);
            usuarioFacade.create(usuario);
            userRoleFacade.create(role);
            modelo.addAttribute("usuario", new CatalogoUsuarios());
            modelo.addAttribute("mensajeInicial", obtenerMensajeInicial(1));
            return "/Formularios/FormularioUsuario";
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/EditarUsuario.xx")
    public String editarUsuario(Model modelo, BigDecimal idUsuario, String nombre, String apPat, String apMat, String nombreUsuario, String pwd, short tipo) {
        CatalogoUsuarios usuario = usuarioFacade.find(idUsuario);
        usuario.setNombre(nombre);
        usuario.setApPat(apPat);
        usuario.setApMat(apMat);
        usuario.setNombreUsuario(nombreUsuario);
        usuario.setPasswordUsuario(pwd);
        usuario.setTipo(tipo);
        usuarioFacade.edit(usuario);
        //*********Terminar de acuerdo al formulario
        return "redirect:Tablas.xx?edT=usr";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/EliminarUsuario.xx")
    public @ResponseBody
    String eliminarUsuario(Model modelo, BigDecimal idEl) {
        CatalogoUsuarios usuario = usuarioFacade.find(idEl);
        boolean eliminacionAprobada = true;
        for (CatalogoCarreras c : carreraFacade.findAll()) {
            if (c.getIdUsuario().equals(usuario)) {
                eliminacionAprobada = false;
                break;
            }
        }
        if (eliminacionAprobada) {
//            usuario.setStatus(Short.valueOf("" + 0));
            for (UserRole role : userRoleFacade.findAll()) {
                if (role.getUserId().equals(usuario)) {
                    userRoleFacade.remove(role);
                    break;
                }
            }
            usuarioFacade.remove(usuario);
            return "Eliminación de usuario exitosa";
        } else {
            return "No se puede eliminar porque el usuario ya está asignado una carrera";
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/ObtenerFormularioUsuario.xx")
    public @ResponseBody
    String formularioEditarUsuario(Model modelo, BigDecimal idEd) {
        CatalogoUsuarios usuario = usuarioFacade.find(idEd);
        System.out.println("tipo usuario" + usuario.getTipo());
        String formulario = ""
                + "<form class=\"form-horizontal\" role=\"form\" action=\"EditarUsuario.xx\" method=\"POST\" commandName=\"usuario\">\n"
                + "<input type='hidden' name='idUsuario' value='" + usuario.getIdUsuario() + "'/>"
                + "                            <div class=\"form-group\">\n"
                + "                                <label path=\"\" for=\"nombre\" class=\"col-sm-3 control-label\">Nombre(s)</label>\n"
                + "                                <div class=\"col-sm-9\">\n"
                + "                                    <input path=\"nombre\" type=\"text\" class=\"form-control\" id=\"nombre\" placeholder=\"Nombre(s)\" name='nombre' value='" + usuario.getNombre() + "'/>\n"
                + "                                </div>\n"
                + "                            </div>\n"
                + "                            <div class=\"form-group\">\n"
                + "                                <label path=\"\" for=\"ap_pat\" class=\"col-sm-3 control-label\">Apellido Paterno</label>\n"
                + "                                <div class=\"col-sm-9\">\n"
                + "                                    <input path=\"apPat\" type=\"text\" class=\"form-control\" id=\"ap_pat\" placeholder=\"Apellido Paterno\" name='apPat' value='" + usuario.getApPat() + "'/>\n"
                + "                                </div>\n"
                + "                            </div>\n"
                + "                            <div class=\"form-group\">\n"
                + "                                <label path=\"\" for=\"ap_mat\" class=\"col-sm-3 control-label\">Apellido Materno</label>\n"
                + "                                <div class=\"col-sm-9\">\n"
                + "                                    <input path=\"apMat\" type=\"text\" class=\"form-control\" id=\"ap_mat\" placeholder=\"Apellido Materno\" name='apMat' value='" + usuario.getApMat() + "'/>\n"
                + "                                </div>\n"
                + "                            </div>\n"
                + "                            <div class=\"form-group\">\n"
                + "                                <label path=\"\" for=\"nombreUsuario\" class=\"col-sm-2 control-label\">Usuario</label>\n"
                + "                                <div class=\"col-sm-4\">\n"
                + "                                    <input path=\"nombreUsuario\" type=\"text\" class=\"form-control\" id=\"nombreUsuario\" placeholder=\"Nombre usuario\" name='nombreUsuario' value='" + usuario.getNombreUsuario() + "'/>\n"
                + "                                </div>\n"
                + "                                <label path=\"\" for=\"passwordUsuario\" class=\"col-sm-2 control-label\">Contrase&ntilde;a</label>\n"
                + "                                <div class=\"col-sm-4\">\n"
                + "                                    <input path=\"passwordUsuario\" type=\"password\" class=\"form-control\" id=\"passwordUsuario\" placeholder=\"Contrase&ntilde;a\" name='pwd' value='" + usuario.getPasswordUsuario() + "'/>\n"
                + "                                </div>\n"
                + "                            </div>\n"
                + "                            <div class=\"form-group\">\n"
                + "                                <label path=\"\" class=\"col-sm-1 control-label\">Tipo</label>\n"
                + "                                <div class=\"col-sm-11\">\n"
                + "                                    <select path=\"tipo\" class=\"form-control \" name='tipo'>\n"
                + "                                        <option value=\"1\" " + ((usuario.getTipo() == 1) ? "selected='selected'" : "") + ">Administrador</option>\n"
                + "                                        <option value=\"2\" " + ((usuario.getTipo() == 2) ? "selected='selected'" : "") + ">Coordinador</option>\n"
                + "                                        <option value=\"3\" " + ((usuario.getTipo() == 3) ? "selected='selected'" : "") + ">Visitante</option>\n"
                + "                                    </select>\n"
                + "                                </div>\n"
                + "                            </div>\n"
                + "                            <div class=\"form-group\">\n"
                + "                                <div class=\"col-sm-offset-9 col-sm-1\">\n"
                + "                                    <button type=\"submit\" class=\"btn btn-warning\">Actualizar</button>\n"
                + "                                </div>\n"
                + "                            </div>\n"
                + "                        </form>"
                + "";
        return formulario;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/EditarPerfil.xx")
    public String editarPerfil(Model modelo, CatalogoUsuarios usuario, Principal p) {
        addNombreUsuario(modelo, p);
            if ("ROLE_ADMINISTRADOR".equals(getRole(p))) {
                usuario.setTipo((short) 1);
            } else {
                usuario.setTipo((short) 2);
            }
//            CatalogoUsuarios u = usuarioFacade.find(usuario.getIdUsuario());
            usuario.setStatus((short)1);
            usuarioFacade.edit(usuario);
            return "redirect:j_spring_security_logout";
    }

    public boolean isDuplicated(CatalogoUsuarios usuario) {
        
        for (CatalogoUsuarios usr : usuarioFacade.findAll()) {
            if (new ManejoStrings().sonIguales(usr.getNombreUsuario(), usuario.getNombreUsuario())) {
                return true;
            }
        }
        return false;
    }
}
