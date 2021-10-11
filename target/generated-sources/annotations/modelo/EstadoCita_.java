package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Cita;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-10-10T19:23:56")
@StaticMetamodel(EstadoCita.class)
public class EstadoCita_ { 

    public static volatile SingularAttribute<EstadoCita, String> descripcion;
    public static volatile CollectionAttribute<EstadoCita, Cita> citaCollection;
    public static volatile SingularAttribute<EstadoCita, Integer> idEstadoCita;

}