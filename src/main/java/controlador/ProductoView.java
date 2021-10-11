/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import ejb.InventarioFacadeLocal;
import ejb.ProductoFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import modelo.Inventario;
import modelo.Producto;
import static modelo.Producto_.proCodigo;
@Named(value = "productoBeanss")
/**
 *
 * @author Frederick Bosa S
 */
@SessionScoped
public class ProductoView implements Serializable{
   
    @EJB
    private ProductoFacadeLocal productoFacadeLocal;
    @EJB
    private InventarioFacadeLocal inventarioFacadeLocal;
    
     private Inventario inventario;
    
    private Producto producto;
    
    private List<Producto> productos;
    private List<Inventario> inventarios;
    
    private Producto productoReg = new Producto();
    private Producto productoTemp = new Producto();
    
    @PostConstruct
    public void init() {
        //Usar para estructura local 
        productos = productoFacadeLocal.findAll();
        inventarios = inventarioFacadeLocal.findAll();
    }
    
     public void registrarInsumo() {
        try {
            //Creacion de usuario
            productoFacadeLocal.create(productoReg);
            //Limpiar Formulario de registro
            productoReg = new Producto();
            //Render Usuarios
            productos = productoFacadeLocal.findAll();
            inventarios = inventarioFacadeLocal.findAll();
        } catch (Exception e) {
            System.out.println("Error de registro");
        }
    }
    public void guardarTemporal(Producto p) {
        productoTemp = p;
    }
    
     public void editarInsumo() {
        try {
            //Usutemporal sirve para el ciclo de vida de sólo la edición
            //Edicion de Usuario 
            productoFacadeLocal.edit(productoTemp);
            //Fin del ciclo de vida
           
            //Encontrar datos
            productos = productoFacadeLocal.findAll();
            
            
        } catch (Exception e) {
        }
    }

    //Eliminar Usuario
    public void eliminarProducto(Producto p) {
        try {
            this.productoFacadeLocal.remove(p);
            productos = productoFacadeLocal.findAll();
        } catch (Exception e) {
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
        productos = productoFacadeLocal.findAll();
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public Producto getProductoReg() {
        return productoReg;
    }

    public void setProductoReg(Producto productoReg) {
        this.productoReg = productoReg;
    }

    public Producto getProductoTemp() {
        return productoTemp;
    }

    public void setProductoTemp(Producto productoTemp) {
        this.productoTemp = productoTemp;
    }

    @Override
    public String toString() {
        return "proCodigo [id=" + proCodigo + "]";
    }
    
    
}
