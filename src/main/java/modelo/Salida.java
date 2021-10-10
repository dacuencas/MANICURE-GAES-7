/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Frederick Bosa S
 */
@Entity
@Table(name = "salida")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Salida.findAll", query = "SELECT s FROM Salida s"),
    @NamedQuery(name = "Salida.findBySalId", query = "SELECT s FROM Salida s WHERE s.salId = :salId"),
    @NamedQuery(name = "Salida.findBySalFactura", query = "SELECT s FROM Salida s WHERE s.salFactura = :salFactura"),
    @NamedQuery(name = "Salida.findBySalFecha", query = "SELECT s FROM Salida s WHERE s.salFecha = :salFecha"),
    @NamedQuery(name = "Salida.findBySalCantidad", query = "SELECT s FROM Salida s WHERE s.salCantidad = :salCantidad")})
public class Salida implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "sal_id")
    private Integer salId;
    @Size(max = 30)
    @Column(name = "sal_factura")
    private String salFactura;
    @Size(max = 11)
    @Column(name = "sal_fecha")
    private String salFecha;
    @Column(name = "sal_cantidad")
    private Integer salCantidad;
    @JoinColumn(name = "sal_pro_codigo", referencedColumnName = "pro_codigo")
    @ManyToOne
    private Producto salProCodigo;

    public Salida() {
    }

    public Salida(Integer salId) {
        this.salId = salId;
    }

    public Integer getSalId() {
        return salId;
    }

    public void setSalId(Integer salId) {
        this.salId = salId;
    }

    public String getSalFactura() {
        return salFactura;
    }

    public void setSalFactura(String salFactura) {
        this.salFactura = salFactura;
    }

    public String getSalFecha() {
        return salFecha;
    }

    public void setSalFecha(String salFecha) {
        this.salFecha = salFecha;
    }

    public Integer getSalCantidad() {
        return salCantidad;
    }

    public void setSalCantidad(Integer salCantidad) {
        this.salCantidad = salCantidad;
    }

    public Producto getSalProCodigo() {
        return salProCodigo;
    }

    public void setSalProCodigo(Producto salProCodigo) {
        this.salProCodigo = salProCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (salId != null ? salId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Salida)) {
            return false;
        }
        Salida other = (Salida) object;
        if ((this.salId == null && other.salId != null) || (this.salId != null && !this.salId.equals(other.salId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Salida[ salId=" + salId + " ]";
    }
    
}
