/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import ejb.PqrsFacadeLocal;
import ejb.TipopqrsFacadeLocal;
import ejb.UsuarioFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import modelo.Pqrs;
import modelo.Tipopqrs;
import modelo.Usuario;

/**
 *
 * @author jhoann
 */
@Named(value="qrsSesion")
@SessionScoped
public class PqrsSesion implements Serializable {
    
    
    @EJB
    private PqrsFacadeLocal  pqrsFacadeLocal ;
    
    //estructura para las llaves foraneas
    
    @EJB 
    private TipopqrsFacadeLocal tipopqrsFacadeLocal ; 
    
    @EJB 
    private UsuarioFacadeLocal  usuarioFacadeLocal ; 
    
    private Pqrs pqrs ; 
    
    //inyeccion de dependecias (llaves foraneas ) 
    @Inject 
    private Tipopqrs tipopqrs ;
    @Inject
    private Usuario usuario ; 
    
    
    private List<Pqrs> pqrss ; 
    
    
    //Estructura para listas de llaves foraneas (inyeccion de dependencias)
    private List<Tipopqrs> tipopqrss; 
    private List<Usuario> usuarios ; 
    
    
    private Pqrs pqr = new Pqrs () ; 
    private Pqrs pqrtemporal = new Pqrs () ; 
    
    
    
    @PostConstruct 
    
    public void init(){
        
        //estructura para renderizado llaves foraneas 
        tipopqrss=tipopqrsFacadeLocal.findAll();
        usuarios = usuarioFacadeLocal.findAll();
        pqrss=pqrsFacadeLocal.findAll();
        pqrs = new Pqrs () ; 
        
         
    }
    
    public void registrarPqrs(){
        
        try {
            pqr.setTipoPqrs(tipopqrs);
            pqr.setUsuarioIdusuario(usuario);
            pqrsFacadeLocal.create(pqr) ;
            
            tipopqrs = new Tipopqrs() ; 
            usuario = new Usuario () ;
            pqr = new Pqrs () ; 
            pqrss=pqrsFacadeLocal.findAll();
            
         } catch (Exception e) {
        }
    }
    
    public void guardarTemporal(Pqrs t){
        
        pqrtemporal = t;
        
    }
    public void editarPqrs () {
        
        try {
            pqrtemporal.setTipoPqrs(tipopqrs);
            pqrtemporal.setUsuarioIdusuario(usuario);
            pqrsFacadeLocal.edit(pqrtemporal);
            
            tipopqrs = new Tipopqrs() ; 
            usuario = new Usuario () ; 
            pqrtemporal= new Pqrs(); 
            pqrss=pqrsFacadeLocal.findAll();
        } catch (Exception e) {
        }
    }
    public void eliminarPqrs (Pqrs t){
        
        try {
            pqrsFacadeLocal.remove(t);
            pqrss=pqrsFacadeLocal.findAll(); 
            
        } catch (Exception e) {
        }
    }

    public Pqrs getPqrs() {
        return pqrs;
    }

    public void setPqrs(Pqrs pqrs) {
        this.pqrs = pqrs;
    }

    public Tipopqrs getTipopqrs() {
        return tipopqrs;
    }

    public void setTipopqrs(Tipopqrs tipopqrs) {
        this.tipopqrs = tipopqrs;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Pqrs> getPqrss() {
        return pqrss;
    }

    public void setPqrss(List<Pqrs> pqrss) {
        this.pqrss = pqrss;
    }

    public List<Tipopqrs> getTipopqrss() {
        return tipopqrss;
    }

    public void setTipopqrss(List<Tipopqrs> tipopqrss) {
        this.tipopqrss = tipopqrss;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public Pqrs getPqr() {
        return pqr;
    }

    public void setPqr(Pqrs pqr) {
        this.pqr = pqr;
    }

    public Pqrs getPqrtemporal() {
        return pqrtemporal;
    }

    public void setPqrtemporal(Pqrs pqrtemporal) {
        this.pqrtemporal = pqrtemporal;
    }
    
    
    
    
    
    
}
