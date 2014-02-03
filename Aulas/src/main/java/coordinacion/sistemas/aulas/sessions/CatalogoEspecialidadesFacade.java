/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package coordinacion.sistemas.aulas.sessions;

import coordinacion.sistemas.aulas.entities.CatalogoEspecialidades;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author OIMA
 */
@Stateless
public class CatalogoEspecialidadesFacade extends AbstractFacade<CatalogoEspecialidades> {
    @PersistenceContext(unitName = "servicioPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CatalogoEspecialidadesFacade() {
        super(CatalogoEspecialidades.class);
    }
    
}
