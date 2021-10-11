package controlador;

import ejb.EntradaFacadeLocal;
import ejb.InventarioFacadeLocal;
import ejb.ProductoFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import modelo.Entrada;
import modelo.Inventario;
import modelo.Producto;

@Named(value = "entradaBeanss")
/**
 *
 * @author Frederick Bosa S
 */
@SessionScoped
public class EntradaView implements Serializable{
   
    @EJB
    private EntradaFacadeLocal entradaFacadeLocal;
    @EJB
    private ProductoFacadeLocal productoFacadeLocal;
    @EJB
    private InventarioFacadeLocal inventarioFacadeLocal;
    
    private Inventario inventario;
    
    private Entrada entrada;
    
    private List<Entrada> entradas;
    private List<Inventario> inventarios;
    
    private Entrada entradaReg = new Entrada();
    
    
    @Inject
    private Producto producto;
    
    private List<Producto> productos;
    
    @PostConstruct
    public void init() {
        //Usar para estructura local 
        entradas = entradaFacadeLocal.findAll();
        inventarios = inventarioFacadeLocal.findAll();
        productos = productoFacadeLocal.findAll();
        
    }
    
     public void registrarEntrada() {
        try {
            entradaReg.setEntProCodigo(producto);
            //Creacion de usuario
            entradaFacadeLocal.create(entradaReg);
            //Render Usuarios
            entradaReg = new Entrada();
            entradas = entradaFacadeLocal.findAll();
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

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public EntradaFacadeLocal getEntradaFacadeLocal() {
        return entradaFacadeLocal;
    }

    public void setEntradaFacadeLocal(EntradaFacadeLocal entradaFacadeLocal) {
        this.entradaFacadeLocal = entradaFacadeLocal;
    }

    public Entrada getEntrada() {
        return entrada;
    }

    public void setEntrada(Entrada entrada) {
        this.entrada = entrada;
    }

    public List<Entrada> getEntradas() {
        return entradas;
    }

    public void setEntradas(List<Entrada> entradas) {
        this.entradas = entradas;
    }

    public Entrada getEntradaReg() {
        return entradaReg;
    }

    public void setEntradaReg(Entrada entradaReg) {
        this.entradaReg = entradaReg;
    }   
}
