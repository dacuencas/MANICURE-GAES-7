/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.List;
import javax.ejb.Local;
import modelo.Entrada;

/**
 *
 * @author Frederick Bosa S
 */
@Local
public interface EntradaFacadeLocal {

    void create(Entrada entrada);

    void edit(Entrada entrada);

    void remove(Entrada entrada);

    Entrada find(Object id);

    List<Entrada> findAll();

    List<Entrada> findRange(int[] range);

    int count();
    
}
