package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Producto;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-09-28T18:45:52")
@StaticMetamodel(Entrada.class)
public class Entrada_ { 

    public static volatile SingularAttribute<Entrada, String> entFactura;
    public static volatile SingularAttribute<Entrada, String> entFecha;
    public static volatile SingularAttribute<Entrada, Integer> entCantidad;
    public static volatile SingularAttribute<Entrada, Integer> entId;
    public static volatile SingularAttribute<Entrada, Producto> entProCodigo;

}