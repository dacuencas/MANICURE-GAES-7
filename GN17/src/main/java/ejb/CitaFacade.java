package ejb;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import modelo.Cita;

@Stateless
public class CitaFacade extends AbstractFacade<Cita> implements CitaFacadeLocal {

    @PersistenceContext(unitName = "Persistencia")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CitaFacade() {
        super(Cita.class);
    }

    @Override
    public boolean crearCita(Cita citaIn, int fkusu, int fkser) {
        try {
            Query qt = em.createNativeQuery("SELECT nombre, apellido, tipo_rol FROM usuario u LEFT JOIN rol r ON u.nombre=r.tipo_rol WHERE u.rol_id_rol=2;");
            qt.getResultList();
            return true;
        } catch (Exception e) {

        }
        return false;

    }

    @Override
    public List<Cita> mostrarEmpl() {
        try {
            em.getEntityManagerFactory().getCache().evictAll();
            Query qt = em.createNativeQuery("SELECT nombre, apellido, tipo_rol FROM usuario u LEFT JOIN rol r ON u.nombre=r.tipo_rol WHERE u.rol_id_rol=2;");
            qt.getResultList();
            return mostrarEmpl();
        } catch (Exception e) {
            return null;
        }
    }

}
