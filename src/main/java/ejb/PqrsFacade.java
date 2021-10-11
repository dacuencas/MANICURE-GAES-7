/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.Pqrs;

/**
 *
 * @author jhoann
 */
@Stateless
public class PqrsFacade extends AbstractFacade<Pqrs> implements PqrsFacadeLocal {

    @PersistenceContext(unitName = "Persistencia")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PqrsFacade() {
        super(Pqrs.class);
    }
    
}
