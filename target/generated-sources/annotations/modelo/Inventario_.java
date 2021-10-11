package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Producto;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-10-10T19:23:56")
@StaticMetamodel(Inventario.class)
public class Inventario_ { 

    public static volatile SingularAttribute<Inventario, Integer> invEntradas;
    public static volatile SingularAttribute<Inventario, Integer> invStock;
    public static volatile SingularAttribute<Inventario, Integer> invSalidas;
    public static volatile SingularAttribute<Inventario, Producto> producto;
    public static volatile SingularAttribute<Inventario, String> invProCodigo;

}