/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ejb;

import java.util.List;
import javax.ejb.Local;
import modelo.Tipopqrs;

/**
 *
 * @author jhoann
 */
@Local
public interface TipopqrsFacadeLocal {

    void create(Tipopqrs tipopqrs);

    void edit(Tipopqrs tipopqrs);

    void remove(Tipopqrs tipopqrs);

    Tipopqrs find(Object id);

    List<Tipopqrs> findAll();

    List<Tipopqrs> findRange(int[] range);

    int count();
    
}
