/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package coordinacion.sistemas.aulas.controller;

import auxiliar.ManejoStrings;
import coordinacion.sistemas.aulas.entities.CatalogoCarreras;
import coordinacion.sistemas.aulas.entities.CatalogoEspecialidades;
import coordinacion.sistemas.aulas.entities.CatalogoGrupos;
import coordinacion.sistemas.aulas.entities.CatalogoMaterias;
import coordinacion.sistemas.aulas.model.ValidarMateria;
import coordinacion.sistemas.aulas.sessions.CatalogoEspecialidadesFacade;
import coordinacion.sistemas.aulas.sessions.CatalogoGruposFacade;
import coordinacion.sistemas.aulas.sessions.CatalogoMateriasFacade;
import java.math.BigDecimal;
import java.security.Principal;
import java.util.List;
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
public class MateriaController extends AbstractController {

    @EJB(mappedName = "java:global/Aulas/CatalogoMateriasFacade")
    private CatalogoMateriasFacade materiaFacade;
    @EJB(mappedName = "java:global/Aulas/CatalogoEspecialidadesFacade")
    private CatalogoEspecialidadesFacade especialidadFacade;
    @EJB(mappedName = "java:global/Aulas/CatalogoGruposFacade")
    private CatalogoGruposFacade grupoFacade;

    @RequestMapping(method = RequestMethod.POST, value = "/NuevaMateria.xx")
    public String insertar(Model modelo, @Valid CatalogoMaterias materia, BindingResult result, Principal p) {
        addNombreUsuario(modelo, p);
        ValidarMateria validar = new ValidarMateria();
        if (result.hasErrors() || !validar.validateForm(modelo, materia) || isDuplicated(materia, p)) {
            validar.validateForm(modelo, materia);
//            modelo.addAttribute("listaEspecialidades", especialidadFacade.findBySpecificField("status", 1, "equal", ord("nombreEspecialidad", "asc"), null));
            modelo.addAttribute("materia", materia);
            modelo.addAttribute("mensajeInicial", obtenerMensajeInicial(2));
            if (isDuplicated(materia, p)) {
                modelo.addAttribute("errorNombre", "Esta materia ya existe en la reticula");
            }
            if (getRole(p).equals("ROLE_ADMINISTRADOR")) {
                modelo.addAttribute("listaEspecialidades", especialidadFacade.findBySpecificField("status", 1, "equal", ord("nombreEspecialidad", "asc"), null));
            } else {
                List<CatalogoCarreras> listaCarreras = getCarreraAsignadaCoordinador(p);
                modelo.addAttribute("listaEspecialidades", especialidadFacade.findBySpecificField("idCarrera", listaCarreras.get(0), "equal", ord("nombreEspecialidad", "asc"), null));
            }
            return "/Formularios/FormularioMateria";
        } else {
            materia.setStatus((short) 1);
            materiaFacade.create(materia);
//            modelo.addAttribute("listaEspecialidades", especialidadFacade.findBySpecificField("status", 1, "equal", ord("nombreEspecialidad", "asc"), null));
            modelo.addAttribute("materia", new CatalogoMaterias());
            modelo.addAttribute("mensajeInicial", obtenerMensajeInicial(1));
            if (getRole(p).equals("ROLE_ADMINISTRADOR")) {
                modelo.addAttribute("listaEspecialidades", especialidadFacade.findBySpecificField("status", 1, "equal", ord("nombreEspecialidad", "asc"), null));
            } else {
                List<CatalogoCarreras> listaCarreras = getCarreraAsignadaCoordinador(p);
                modelo.addAttribute("listaEspecialidades", getEspecialidadesAsignadasCoordinador(p));
            }
            return "/Formularios/FormularioMateria";
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/EditarMateria.xx")
    public String editarMateria(Model modelo, BigDecimal idMateria, String nombre, short hp, short ht, BigDecimal idEsp, short bloque) {
        CatalogoMaterias materia = materiaFacade.find(idMateria);
        materia.setNombreMateria(nombre);
        materia.setHorasPracticas(hp);
        materia.setHorasTeoricas(ht);
        materia.setIdEspecialidad(especialidadFacade.find(idEsp));
        materia.setBloque(bloque);
        materiaFacade.edit(materia);
        return "redirect:Tablas.xx?edT=mat";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/EliminarMateria.xx")
    public @ResponseBody
    String eliminarMateria(Model modelo, BigDecimal idEl) {
        CatalogoMaterias materia = materiaFacade.find(idEl);
        boolean eliminacionAprobada = true;
        for (CatalogoGrupos g : grupoFacade.findAll()) {
            if (g.getIdMateria().equals(materia)) {
                eliminacionAprobada = false;
                break;
            }
        }
        if (eliminacionAprobada) {
            materia.setStatus(Short.valueOf("" + 0));
            materiaFacade.edit(materia);
            materiaFacade.remove(materiaFacade.find(idEl));
            System.out.println(materia.getNombreMateria());
            return "Eliminación exitosa";
        } else {
            return "No se puede eliminar porque la materia ya está asignada a un grupo";
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/ObtenerFormularioMateria.xx")
    public @ResponseBody
    String formularioEditarMateria(Model modelo, BigDecimal idEd, Principal p) {
        CatalogoMaterias materia = materiaFacade.find(idEd);
        String listaEspecialidades = "";
        String listaBotones = "";
        for (CatalogoEspecialidades e : getEspecialidadesAsignadasCoordinador(p)) {
            listaEspecialidades += "<option value=\"" + e.getIdEspecialidad() + "\" " + ((materia.getIdEspecialidad().equals(e)) ? "selected='selected'" : "") + ">" + e.getNombreEspecialidad() + "</option>\n";

        }
        for (int i = 1; i <= 9; i++) {
            listaBotones += "<button id=\"b" + (i) + "\" type=\"button\" class=\"btn btn-" + ((materia.getBloque() == (i)) ? "info" : "default") + "\" value=\"" + i + "\">" + i + "</button>\n";
        }
//        System.out.println(listaBotones);
        String formulario = ""
                + "<form class=\"form-horizontal\" role=\"form\" action=\"EditarMateria.xx\" method=\"POST\" commandName=\"materia\">\n"
                + "<input type='hidden' name='idMateria' value='" + materia.getIdMateria() + "'/>"
                + "                            <div class=\"form-group\">\n"
                + "                                <div class=\"col-sm-offset-1 col-sm-1\">\n"
                + "                                </div>\n"
                + "                            </div>\n"
                + "                            <div class=\"form-group\">\n"
                + "                                <label path=\"\" for=\"nombreMateria\" class=\"col-sm-3 control-label\">Nombre</label>\n"
                + "                                <div class=\"col-sm-9\">\n"
                + "                                    <input path=\"nombreMateria\" type=\"text\" class=\"form-control\" id=\"nombreMateria\" placeholder=\"Nombre Materia\" name='nombre' value='" + materia.getNombreMateria() + "'/>\n"
                + "                                </div>\n"
                + "                            </div>\n"
                + "                            <div class=\"form-group\">\n"
                + "                                <label path=\"\" for=\"hp\" class=\"col-sm-3 control-label\">Horas Pr&aacute;cticas</label>\n"
                + "                                <div class=\"col-sm-3\">\n"
                + "                                    <input path=\"horasPracticas\" type=\"text\" class=\"form-control\" id=\"hp\" placeholder=\"Horas Pr&aacute;cticas\" name='hp' value='" + materia.getHorasPracticas() + "'/>\n"
                + "                                </div>\n"
                + "                                <label path=\"\" for=\"ht\" class=\"col-sm-3 control-label\">Horas Te&oacute;ricas</label>\n"
                + "                                <div class=\"col-sm-3\">\n"
                + "                                    <input path=\"horasTeoricas\" type=\"text\" class=\"form-control\" id=\"ht\" placeholder=\"Horas te&oacute;ricas\" name='ht' value='" + materia.getHorasTeoricas() + "'/>\n"
                + "                                </div>\n"
                + "                            </div>\n"
                + "                            <div class=\"form-group\">\n"
                + "                                <label path=\"\" for=\"carrera\" class=\"col-sm-3 control-label\">Especialidad</label>\n"
                + "                                <div class=\"col-sm-9\">\n"
                + "                                    <select path=\"idEspecialidad.idEspecialidad\" class=\"form-control\" id=\"carrera\" name='idEsp'>\n"
                + listaEspecialidades
                + "                                    </select>\n"
                + "                                </div>\n"
                + "                            </div>\n"
                + "                            <label path=\"\" class=\"col-sm-3 control-label\">Bloque</label>\n"
                + "                            <div class=\"btn-toolbar col-sm-9\">\n"
                + "                                <div class=\"btn-group\">\n"
                + listaBotones
                + "                                </div>\n"
                + "                            </div>\n"
                + "                            <input type=\"hidden\" value=\"3\" id=\"bloqueHidden\" name='bloque'/>\n"
                + "                            <div class=\"form-group\">\n"
                + "                                <div class=\"col-sm-offset-1 col-sm-1\">\n"
                + "                                </div>\n"
                + "                            </div>\n"
                + "                            <div class=\"form-group\">\n"
                + "                                <div class=\"col-sm-offset-9 col-sm-3\">\n"
                + "                                    <button type=\"submit\" class=\"btn btn-warning\">Actualizar</button>\n"
                + "                                </div>\n"
                + "                            </div>\n"
                + "                        </form>"
                + "<script>"
                + "for (var i = 1; i<= 9 ; i++){\n"
                + "    $(\"#b\".concat(i)).click(function(e) {\n"
                + "        var idB = $(this).attr('value');"
                + "         $('#bloqueHidden').attr('value',idB);"
                + "         for (var i = 1; i<= 9 ; i++){"
                + "             $('#b'+i).attr('class','btn btn-default');"
                + "         }"
                + "        $(this).attr('class','btn btn-info');\n"
                + "    });\n"
                + "}</script>";
        return formulario;
    }

    private boolean isDuplicated(CatalogoMaterias materia, Principal p) {
        for (CatalogoMaterias m : getMateriasAsignadasCoordinador(p)) {
            if (new ManejoStrings().sonIguales(materia.getNombreMateria(), m.getNombreMateria())) {
                return true;
            }
        }
        return false;
    }
}
