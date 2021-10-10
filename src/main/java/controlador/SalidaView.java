package controlador;

import ejb.InventarioFacadeLocal;
import ejb.ProductoFacadeLocal;
import ejb.SalidaFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import modelo.Inventario;
import modelo.Producto;
import modelo.Salida;

@Named(value = "salidaBeanss")
/**
 *
 * @author Frederick Bosa S
 */
@SessionScoped
public class SalidaView implements Serializable{
   
    @EJB
    private SalidaFacadeLocal salidaFacadeLocal;
    @EJB
    private ProductoFacadeLocal productoFacadeLocal;
    @EJB
    private InventarioFacadeLocal inventarioFacadeLocal;
    
    private Inventario inventario;
    
    private Salida salida;
    
    private List<Salida> salidas;
    private List<Inventario> inventarios;
    
    private Salida salidaReg = new Salida();

    
    @Inject
    private Producto producto;
    
    private List<Producto> productos;
    
    @PostConstruct
    public void init() {
        //Usar para estructura local 
        salidas = salidaFacadeLocal.findAll();
        inventarios = inventarioFacadeLocal.findAll();
        
        productos = productoFacadeLocal.findAll();
        
        
    }
    
     public void registrarSalida() {
        try {
            salidaReg.setSalProCodigo(producto);
            //Creacion de usuario
            salidaFacadeLocal.create(salidaReg);
            //Render Usuarios
            salidaReg = new Salida();
            salidas = salidaFacadeLocal.findAll();
            inventarios = inventarioFacadeLocal.findAll();
        } catch (Exception e) {
            System.out.println("Error de registro");
        }
    }

    public InventarioFacadeLocal getInventarioFacadeLocal() {
        return inventarioFacadeLocal;
    }

    public void setInventarioFacadeLocal(InventarioFacadeLocal inventarioFacadeLocal) {
        this.inventarioFacadeLocal = inventarioFacadeLocal;
    }

    public Inventario getInventario() {
        return inventario;
    }

    public void setInventario(Inventario inventario) {
        this.inventario = inventario;
    }

    public List<Inventario> getInventarios() {
        return inventarios;
    }

    public void setInventarios(List<Inventario> inventarios) {
        this.inventarios = inventarios;
    }
     
    public SalidaFacadeLocal getSalidaFacadeLocal() {
        return salidaFacadeLocal;
    }

    public void setSalidaFacadeLocal(SalidaFacadeLocal salidaFacadeLocal) {
        this.salidaFacadeLocal = salidaFacadeLocal;
    }

    public ProductoFacadeLocal getProductoFacadeLocal() {
        return productoFacadeLocal;
    }

    public void setProductoFacadeLocal(ProductoFacadeLocal productoFacadeLocal) {
        this.productoFacadeLocal = productoFacadeLocal;
    }

    public Salida getSalida() {
        return salida;
    }

    public void setSalida(Salida salida) {
        this.salida = salida;
    }

    public List<Salida> getSalidas() {
        return salidas;
    }

    public void setSalidas(List<Salida> salidas) {
        this.salidas = salidas;
    }

    public Salida getSalidaReg() {
        return salidaReg;
    }

    public void setSalidaReg(Salida salidaReg) {
        this.salidaReg = salidaReg;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
}
