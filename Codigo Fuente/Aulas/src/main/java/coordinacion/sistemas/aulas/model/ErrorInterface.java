/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coordinacion.sistemas.aulas.model;

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
import org.springframework.ui.Model;

/**
 *
 * @author OIMA
 */
public interface ErrorInterface{
    
    public int ID_NO_ECONTRADO = 0;
    public int ELEMENTO_NULO = 1;
    public int SOLO_LETRAS = 2;
    public int SOLO_NUMEROS = 3;
    public int CANTIDAD_CARACTERES_EXEDIDO = 4;
    
    public boolean validateForm(Model m, Object entidad);
    public boolean isDuplicated(Object o);
}
