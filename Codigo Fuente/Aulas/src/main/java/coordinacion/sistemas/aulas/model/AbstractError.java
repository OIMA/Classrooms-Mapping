/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coordinacion.sistemas.aulas.model;

import coordinacion.sistemas.aulas.controller.AbstractController;
import coordinacion.sistemas.aulas.sessions.CatalogoAulasFacade;
import coordinacion.sistemas.aulas.sessions.CatalogoCarrerasFacade;
import coordinacion.sistemas.aulas.sessions.CatalogoCicloEscolarFacade;
import coordinacion.sistemas.aulas.sessions.CatalogoEspecialidadesFacade;
import coordinacion.sistemas.aulas.sessions.CatalogoGruposFacade;
import coordinacion.sistemas.aulas.sessions.CatalogoMateriasFacade;
import coordinacion.sistemas.aulas.sessions.CatalogoPlanesFacade;
import coordinacion.sistemas.aulas.sessions.CatalogoProfesoresFacade;
import coordinacion.sistemas.aulas.sessions.CatalogoUsuariosFacade;
import coordinacion.sistemas.aulas.sessions.HorarioAulaFacade;
import coordinacion.sistemas.aulas.sessions.UserRoleFacade;
import javax.ejb.EJB;
import org.springframework.stereotype.Controller;

/**
 *
 * @author OIMA
 */
@Controller
public abstract class AbstractError extends AbstractController implements ErrorInterface {
    @EJB(mappedName = "java:global/Aulas/CatalogoUsuariosFacade")
    public CatalogoUsuariosFacade usuarioFacade;
    @EJB(mappedName = "java:global/Aulas/CatalogoCarrerasFacade")
    public CatalogoCarrerasFacade carreraFacade;
    @EJB(mappedName = "java:global/Aulas/CatalogoEspecialidadesFacade")
    public CatalogoEspecialidadesFacade especialidadFacade;
    @EJB(mappedName = "java:global/Aulas/CatalogoMateriasFacade")
    public CatalogoMateriasFacade materiaFacade;
    @EJB(mappedName = "java:global/Aulas/CatalogoAulasFacade")
    public CatalogoAulasFacade aulaFacade;
    @EJB(mappedName = "java:global/Aulas/CatalogoPlanesFacade")
    public CatalogoPlanesFacade planFacade;
    @EJB(mappedName = "java:global/Aulas/CatalogoProfesoresFacade")
    public CatalogoProfesoresFacade profesorFacade;
    @EJB(mappedName = "java:global/Aulas/CatalogoCicloEscolarFacade")
    public CatalogoCicloEscolarFacade cicloEscolarFacade;
    @EJB(mappedName = "java:global/Aulas/CatalogoGruposFacade")
    public CatalogoGruposFacade grupoFacade;
    @EJB(mappedName = "java:global/Aulas/HorarioAulaFacade")
    public HorarioAulaFacade horarioAulaFacade;
    @EJB(mappedName = "java:global/Aulas/UserRoleFacade")
    public UserRoleFacade userRoleFacade;

    protected boolean isNull(Object o) {
        try {
            String s = (String) o;
            if ("".equals(s) || s == null) {
                return true;
            }
        } catch (Exception e) {
            if (o == null) {
                return true;
            }
        }
        return false;
    }
    protected boolean isZero(Integer num){
        return num == 0;
    };
    protected boolean isMoreThan(String s, int n){
        return s.length() > n;
    }
    protected boolean isLessThan(String s, int n){
        return s.length() < n;
    }
    protected boolean isLessThanZero(int n){
        return n < 0;
    }
    protected boolean isIntNumber(Object s){
        try {
            int n = (Integer) s;
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
