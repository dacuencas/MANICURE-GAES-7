package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Cita;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-10-10T19:23:56")
@StaticMetamodel(Servicio.class)
public class Servicio_ { 

    public static volatile SingularAttribute<Servicio, String> descripcion;
    public static volatile SingularAttribute<Servicio, Integer> codigoServicio;
    public static volatile CollectionAttribute<Servicio, Cita> citaCollection;
    public static volatile SingularAttribute<Servicio, String> nombre;

}