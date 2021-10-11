
package controlador;
import ejb.EntradaFacadeLocal;
import ejb.InventarioFacadeLocal;
import ejb.ProductoFacadeLocal;
import ejb.SalidaFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import modelo.Entrada;
import modelo.Inventario;
import modelo.Producto;
import modelo.Salida;


@Named(value = "inventarioBeanss")

/**
 *
 * @author Frederick Bosa S
 */
@SessionScoped
public class InventarioView implements Serializable{
   
    @EJB
    private InventarioFacadeLocal inventarioFacadeLocal;
    @EJB
    private EntradaFacadeLocal entradaFacadeLocal;
    @EJB
    private SalidaFacadeLocal salidaFacadeLocal;
    @EJB
    private ProductoFacadeLocal productoFacadeLocal;
    
    private Inventario inventario;
    private Producto producto;
    private Salida salida;
    private Entrada entrada;
    
    private List<Inventario> inventarios;
    private List<Producto> productos;
    private List<Salida> salidas;
    private List<Entrada> entradas;

    @PostConstruct
    public void init() {
        //Usar para estructura local 
        inventarios = inventarioFacadeLocal.findAll();
        entradas = entradaFacadeLocal.findAll();
        salidas = salidaFacadeLocal.findAll();
        productos = productoFacadeLocal.findAll();
        
    }
    
    public EntradaFacadeLocal getEntradaFacadeLocal() {
        return entradaFacadeLocal;
    }

    public void setEntradaFacadeLocal(EntradaFacadeLocal entradaFacadeLocal) {
        this.entradaFacadeLocal = entradaFacadeLocal;
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

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Salida getSalida() {
        return salida;
    }

    public void setSalida(Salida salida) {
        this.salida = salida;
    }

    public Entrada getEntrada() {
        return entrada;
    }

    public void setEntrada(Entrada entrada) {
        this.entrada = entrada;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public List<Salida> getSalidas() {
        return salidas;
    }

    public void setSalidas(List<Salida> salidas) {
        this.salidas = salidas;
    }

    public List<Entrada> getEntradas() {
        return entradas;
    }

    public void setEntradas(List<Entrada> entradas) {
        this.entradas = entradas;
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
    
}