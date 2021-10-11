/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.Tipopqrs;

/**
 *
 * @author jhoann
 */
@Stateless
public class TipopqrsFacade extends AbstractFacade<Tipopqrs> implements TipopqrsFacadeLocal {

    @PersistenceContext(unitName = "Persistencia")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipopqrsFacade() {
        super(Tipopqrs.class);
    }
    
}
