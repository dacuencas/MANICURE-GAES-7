package controlador;

import ejb.CitaFacadeLocal;
import ejb.EstadoCitaFacadeLocal;
import ejb.RolFacadeLocal;
import ejb.ServicioFacadeLocal;
import ejb.UsuarioFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.DataSource;
import modelo.Cita;
import modelo.EstadoCita;
import modelo.Rol;
import modelo.Servicio;
import modelo.Usuario;

@Named(value = "agendarCitas")
@SessionScoped
public class AgendarCitas implements Serializable {

    @Resource(lookup = "jdbc/GlossNailG")
    DataSource dataSource;

    //Conexion con facades local
    //Punto de conexion a bd
    @EJB
    private CitaFacadeLocal citaFacadeLocal;

    //Estructuras para llaves foraneas Usuario
    @EJB
    private UsuarioFacadeLocal usuarioFacadeLocal;
    @EJB
    private EstadoCitaFacadeLocal estadoCitaFacadeLocal;
    @EJB
    private ServicioFacadeLocal servicioFacadeLocal;
    @EJB
    private RolFacadeLocal rolFacadeLocal;

    //Creacion de instancia clase mapeada
    private Cita cita;

    //Estructura para llaves foraneas Usuario (Funcionalidades)
    @Inject
    private Usuario usuario;
    @Inject
    private EstadoCita estadoCita;
    @Inject
    private Servicio servicio;
    @Inject
    private Rol rol;

    //Lista Local (Nombres Listas en prural)
    private List<Cita> citas;
    //Estructura Para llaves foraneas
    private List<EstadoCita> estadoCitas;
    private List<Usuario> usuarios;
    private List<Servicio> servicios;
    private List<Rol> roles;

    //Instancias de Cita
    private Cita citaReg = new Cita();
    private Cita citaTemporal = new Cita();

    //Estructura para encontrar elementos al iniciar la app (Listar datos en la vista)
    @PostConstruct
    public void init() {
        //Usar para estructura local 
        citas = citaFacadeLocal.findAll();
        //Estrucutura para llaves foraneas
        estadoCitas = estadoCitaFacadeLocal.findAll();
        usuarios = usuarioFacadeLocal.findAll();
        servicios = servicioFacadeLocal.findAll();
        //Limpiar Formulario

    }

    //registrat Cita 
    public void registrarCita() {
        try {
            //Estructura para llaves foraneas
            this.citaReg.setUsuarioIdUsuario(usuario);
            this.citaReg.setServicioCódigoServicio(servicio);
            this.citaReg.setEstadoCitaIdEstadoCita(estadoCita);
            //Creacion de usuario
            citaFacadeLocal.create(citaReg);
            //Limpiar Formulario de Agendamiento
            citaReg = new Cita();
            //Render Citas
            citas = citaFacadeLocal.findAll();
        } catch (Exception e) {
            System.out.println("Error de registro");
        }
    }

    //Recuperar datos temporales para editar usuario
    public void guardarTemporal(Cita ac) {
        citaTemporal = ac;
    }

    //Editar Usuario
    public void editarCita() {
        try {
            //Usutemporal sirve para el ciclo de vida de sólo la edición
            this.citaTemporal.setUsuarioIdUsuario(usuario);
            this.citaTemporal.setServicioCódigoServicio(servicio);
            this.citaTemporal.setEstadoCitaIdEstadoCita(estadoCita);
            //Edicion de Usuario 
            citaFacadeLocal.edit(citaTemporal);
            //Fin del ciclo de vida

            //Encontrar datos
            citas = citaFacadeLocal.findAll();
        } catch (Exception e) {
        }
    }

    //Eliminar Usuario
    public void eliminarCita(Cita ac) {
        try {
            this.citaFacadeLocal.remove(ac);
            citas = citaFacadeLocal.findAll();
        } catch (Exception e) {
        }
    }

    //Mostrar solo usuarios con rol empleado
    public List<Cita> mostrarEmpl() {
        try {
            this.citaFacadeLocal.mostrarEmpl();
            citas = citaFacadeLocal.findAll();
        } catch (Exception e) {

        }
        return citaFacadeLocal.mostrarEmpl();
    }

    //Reportes
    /*public void generarArchivo(String tipoArchivo) throws JRException, IOException {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext context = facesContext.getExternalContext();
        HttpServletResponse response = (HttpServletResponse) context.getResponse();
        File jasper = new File(context.getRealPath("/reportes/agendarCitas.jasper"));
        try {
            JasperPrint jp = JasperFillManager.fillReport(jasper.getPath(), new HashMap(), dataSource.getConnection());
            switch (tipoArchivo) {
                case "pdf":
                    response.setContentType("application/pdf");
                    response.addHeader("Content-disposition", "attachment; filename=Lista agendarCitas.pdf");
                    OutputStream os = response.getOutputStream();
                    JasperExportManager.exportReportToPdfStream(jp, os);
                    os.flush();
                    os.close();
                    break;

                case "xlsx":
                    response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
                    response.addHeader("Content-disposition", "attachment; filename=Lista agendarCitas.xlsx");

                    JRXlsxExporter exporter = new JRXlsxExporter(); // initialize exporter 
                    exporter.setExporterInput(new SimpleExporterInput(jp)); // set compiled report as input
                    exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(response.getOutputStream()));

                    SimpleXlsxReportConfiguration configuration = new SimpleXlsxReportConfiguration();
                    configuration.setOnePagePerSheet(true); // setup configuration
                    configuration.setDetectCellType(true);
                    configuration.setSheetNames(new String[]{"agendarCitas"});
                    exporter.setConfiguration(configuration); // set configuration    
                    exporter.exportReport();
                    break;

                case "docx":
                    response.setContentType("application/vnd.openxmlformats-officedocument.wordprocessingml.document");
                    response.addHeader("Content-disposition", "attachment; filename=Lista agendarCitas.docx");

                    JRDocxExporter exporterDoc = new JRDocxExporter(); // initialize exporter 
                    exporterDoc.setExporterInput(new SimpleExporterInput(jp)); // set compiled report as input
                    exporterDoc.setExporterOutput(new SimpleOutputStreamExporterOutput(response.getOutputStream()));

                    SimpleDocxExporterConfiguration configurationDoc = new SimpleDocxExporterConfiguration();
                    configurationDoc.setMetadataAuthor("Gloss Nails G"); // setup configuration
                    configurationDoc.setMetadataTitle("Reporte de Citas");
                    configurationDoc.setMetadataSubject("Listado de Citas");

                    exporterDoc.setConfiguration(configurationDoc); // set configuration    
                    exporterDoc.exportReport();
                    break;

                default:
                    System.err.println(" No se encontro este caso :: AgendarCitas::generarArchivo");
                    break;

            }
            facesContext.responseComplete();

        } catch (SQLException ex) {
            Logger.getLogger(AgendarCitas.class.getName()).log(Level.SEVERE, null, ex);
        }

    }*/
    public CitaFacadeLocal getCitaFacadeLocal() {
        return citaFacadeLocal;
    }

    public void setCitaFacadeLocal(CitaFacadeLocal citaFacadeLocal) {
        this.citaFacadeLocal = citaFacadeLocal;
    }

    public UsuarioFacadeLocal getUsuarioFacadeLocal() {
        return usuarioFacadeLocal;
    }

    public void setUsuarioFacadeLocal(UsuarioFacadeLocal usuarioFacadeLocal) {
        this.usuarioFacadeLocal = usuarioFacadeLocal;
    }

    public EstadoCitaFacadeLocal getEstadoCitaFacadeLocal() {
        return estadoCitaFacadeLocal;
    }

    public void setEstadoCitaFacadeLocal(EstadoCitaFacadeLocal estadoCitaFacadeLocal) {
        this.estadoCitaFacadeLocal = estadoCitaFacadeLocal;
    }

    public ServicioFacadeLocal getServicioFacadeLocal() {
        return servicioFacadeLocal;
    }

    public void setServicioFacadeLocal(ServicioFacadeLocal servicioFacadeLocal) {
        this.servicioFacadeLocal = servicioFacadeLocal;
    }

    public RolFacadeLocal getRolFacadeLocal() {
        return rolFacadeLocal;
    }

    public void setRolFacadeLocal(RolFacadeLocal rolFacadeLocal) {
        this.rolFacadeLocal = rolFacadeLocal;
    }

    public Cita getCita() {
        return cita;
    }

    public void setCita(Cita cita) {
        this.cita = cita;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public EstadoCita getEstadoCita() {
        return estadoCita;
    }

    public void setEstadoCita(EstadoCita estadoCita) {
        this.estadoCita = estadoCita;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public List<Cita> getCitas() {
        return citas;
    }

    public void setCitas(List<Cita> citas) {
        this.citas = citas;
    }

    public List<EstadoCita> getEstadoCitas() {
        return estadoCitas;
    }

    public void setEstadoCitas(List<EstadoCita> estadoCitas) {
        this.estadoCitas = estadoCitas;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public List<Servicio> getServicios() {
        return servicios;
    }

    public void setServicios(List<Servicio> servicios) {
        this.servicios = servicios;
    }

    public List<Rol> getRoles() {
        return roles;
    }

    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }

    public Cita getCitaReg() {
        return citaReg;
    }

    public void setCitaReg(Cita citaReg) {
        this.citaReg = citaReg;
    }

    public Cita getCitaTemporal() {
        return citaTemporal;
    }

    public void setCitaTemporal(Cita citaTemporal) {
        this.citaTemporal = citaTemporal;
    }

}
