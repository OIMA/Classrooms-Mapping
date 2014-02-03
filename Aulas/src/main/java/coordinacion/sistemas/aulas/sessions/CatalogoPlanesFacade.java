/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package coordinacion.sistemas.aulas.sessions;

import coordinacion.sistemas.aulas.entities.CatalogoPlanes;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author OIMA
 */
@Stateless
public class CatalogoPlanesFacade extends AbstractFacade<CatalogoPlanes> {
    @PersistenceContext(unitName = "servicioPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CatalogoPlanesFacade() {
        super(CatalogoPlanes.class);
    }
    
}
