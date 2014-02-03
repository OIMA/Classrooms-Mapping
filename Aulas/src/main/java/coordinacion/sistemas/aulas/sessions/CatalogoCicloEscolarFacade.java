/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package coordinacion.sistemas.aulas.sessions;

import coordinacion.sistemas.aulas.entities.CatalogoCicloEscolar;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author OIMA
 */
@Stateless
public class CatalogoCicloEscolarFacade extends AbstractFacade<CatalogoCicloEscolar> {
    @PersistenceContext(unitName = "servicioPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CatalogoCicloEscolarFacade() {
        super(CatalogoCicloEscolar.class);
    }
    
}
