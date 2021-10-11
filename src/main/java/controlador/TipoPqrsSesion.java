/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import ejb.TipopqrsFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import modelo.Tipopqrs;


/**
 *
 * @author jhoann
 */
@Named (value = "tipoPqrsSesion" )
public class TipoPqrsSesion implements Serializable {
    
    
    @EJB
    private TipopqrsFacadeLocal tipopqrsFacadeLocal ; 
    
    private Tipopqrs tipopqrs ; 
    
    private List<Tipopqrs> tipopqrss ; 
    
    private Tipopqrs pq = new Tipopqrs () ; 
    private Tipopqrs pqtemporal = new Tipopqrs () ;
    
    
    
    
        @PostConstruct 
        public void init(){
            
            tipopqrss = tipopqrsFacadeLocal.findAll() ; 
            
            tipopqrs = new Tipopqrs() ; 
            
        }
    
        public void registrarTipopqrs(){
            try {
                tipopqrsFacadeLocal.create(pq) ; 
                
                tipopqrss = tipopqrsFacadeLocal.findAll() ; 
                
                pq = new Tipopqrs () ; 
                       
            } catch (Exception e) {
            }
        }
   
        public void guardarTemporal (Tipopqrs t){
            pqtemporal = t ; 
        }
        
        public void editarTipopqrs () {
            try {
                tipopqrsFacadeLocal.edit(pqtemporal) ; 
                
                tipopqrss = tipopqrsFacadeLocal.findAll() ;
                
                pqtemporal = new Tipopqrs () ; 
            } catch (Exception e) {
            }
        }
        
        public void eliminarTipopqrs (Tipopqrs t){ 
            try {
                tipopqrsFacadeLocal.remove(t); 
                tipopqrss = tipopqrsFacadeLocal.findAll() ;
            } catch (Exception e) {
            }
        }

    public Tipopqrs getTipopqrs() {
        return tipopqrs;
    }

    public void setTipopqrs(Tipopqrs tipopqrs) {
        this.tipopqrs = tipopqrs;
    }

    public List<Tipopqrs> getTipopqrss() {
        return tipopqrss;
    }

    public void setTipopqrss(List<Tipopqrs> tipopqrss) {
        this.tipopqrss = tipopqrss;
    }

    public Tipopqrs getPq() {
        return pq;
    }

    public void setPq(Tipopqrs pq) {
        this.pq = pq;
    }

    public Tipopqrs getPqtemporal() {
        return pqtemporal;
    }

    public void setPqtemporal(Tipopqrs pqtemporal) {
        this.pqtemporal = pqtemporal;
    }
        
        
      
}



