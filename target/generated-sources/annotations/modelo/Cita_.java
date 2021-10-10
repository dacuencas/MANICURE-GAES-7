package modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.EstadoCita;
import modelo.Servicio;
import modelo.Usuario;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-09-28T18:45:52")
@StaticMetamodel(Cita.class)
public class Cita_ { 

    public static volatile SingularAttribute<Cita, Integer> idCita;
    public static volatile SingularAttribute<Cita, Usuario> usuarioIdUsuario;
    public static volatile SingularAttribute<Cita, Date> fecha;
    public static volatile SingularAttribute<Cita, Servicio> servicioCódigoServicio;
    public static volatile SingularAttribute<Cita, EstadoCita> estadoCitaIdEstadoCita;
    public static volatile SingularAttribute<Cita, Date> hora;

}