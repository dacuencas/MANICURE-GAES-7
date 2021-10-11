package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Entrada;
import modelo.Inventario;
import modelo.Salida;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-10-10T19:23:56")
@StaticMetamodel(Producto.class)
public class Producto_ { 

    public static volatile CollectionAttribute<Producto, Salida> salidaCollection;
    public static volatile SingularAttribute<Producto, String> proCodigo;
    public static volatile SingularAttribute<Producto, Inventario> inventario;
    public static volatile CollectionAttribute<Producto, Entrada> entradaCollection;
    public static volatile SingularAttribute<Producto, String> proDescripcion;

}