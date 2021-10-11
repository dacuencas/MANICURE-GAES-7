package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Usuario;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-10-10T19:23:56")
@StaticMetamodel(TipoIdentificacion.class)
public class TipoIdentificacion_ { 

    public static volatile SingularAttribute<TipoIdentificacion, Integer> idIdentificación;
    public static volatile SingularAttribute<TipoIdentificacion, String> tipoIdentificacion;
    public static volatile CollectionAttribute<TipoIdentificacion, Usuario> usuarioCollection;

}