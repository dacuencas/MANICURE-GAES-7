package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Cita;
import modelo.Rol;
import modelo.TipoDireccion;
import modelo.TipoIdentificacion;
import modelo.TipoTelefono;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-09-28T18:45:52")
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile CollectionAttribute<Usuario, Cita> citaCollection;
    public static volatile SingularAttribute<Usuario, Short> estado;
    public static volatile SingularAttribute<Usuario, Integer> idUsuario;
    public static volatile SingularAttribute<Usuario, TipoTelefono> tipoTelefonoIdTelefono;
    public static volatile SingularAttribute<Usuario, String> nombre;
    public static volatile SingularAttribute<Usuario, TipoDireccion> tipoDireccionIdDireccion;
    public static volatile SingularAttribute<Usuario, String> apellido;
    public static volatile SingularAttribute<Usuario, String> correo;
    public static volatile SingularAttribute<Usuario, String> detalleDireccion;
    public static volatile SingularAttribute<Usuario, String> contrasena;
    public static volatile SingularAttribute<Usuario, String> numeroDocumento;
    public static volatile SingularAttribute<Usuario, Rol> rolIdRol;
    public static volatile SingularAttribute<Usuario, TipoIdentificacion> tipoIdentificacionIdIdentificación;
    public static volatile SingularAttribute<Usuario, String> numeroTelefono;

}