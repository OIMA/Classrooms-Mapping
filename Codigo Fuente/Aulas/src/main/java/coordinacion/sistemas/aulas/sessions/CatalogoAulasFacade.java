/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package coordinacion.sistemas.aulas.sessions;

import coordinacion.sistemas.aulas.entities.CatalogoAulas;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author OIMA
 */
@Stateless
public class CatalogoAulasFacade extends AbstractFacade<CatalogoAulas> {
    @PersistenceContext(unitName = "servicioPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CatalogoAulasFacade() {
        super(CatalogoAulas.class);
    }
    
}
