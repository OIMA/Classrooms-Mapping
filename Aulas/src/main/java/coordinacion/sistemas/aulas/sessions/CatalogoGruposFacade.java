/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package coordinacion.sistemas.aulas.sessions;

import coordinacion.sistemas.aulas.entities.CatalogoGrupos;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author OIMA
 */
@Stateless
public class CatalogoGruposFacade extends AbstractFacade<CatalogoGrupos> {
    @PersistenceContext(unitName = "servicioPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CatalogoGruposFacade() {
        super(CatalogoGrupos.class);
    }
    
}
