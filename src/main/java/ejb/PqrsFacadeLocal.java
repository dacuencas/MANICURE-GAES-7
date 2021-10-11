/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ejb;

import java.util.List;
import javax.ejb.Local;
import modelo.Pqrs;

/**
 *
 * @author jhoann
 */
@Local
public interface PqrsFacadeLocal {

    void create(Pqrs pqrs);

    void edit(Pqrs pqrs);

    void remove(Pqrs pqrs);

    Pqrs find(Object id);

    List<Pqrs> findAll();

    List<Pqrs> findRange(int[] range);

    int count();
    
}
