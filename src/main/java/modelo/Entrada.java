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
@Table(name = "entrada")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Entrada.findAll", query = "SELECT e FROM Entrada e"),
    @NamedQuery(name = "Entrada.findByEntId", query = "SELECT e FROM Entrada e WHERE e.entId = :entId"),
    @NamedQuery(name = "Entrada.findByEntFactura", query = "SELECT e FROM Entrada e WHERE e.entFactura = :entFactura"),
    @NamedQuery(name = "Entrada.findByEntFecha", query = "SELECT e FROM Entrada e WHERE e.entFecha = :entFecha"),
    @NamedQuery(name = "Entrada.findByEntCantidad", query = "SELECT e FROM Entrada e WHERE e.entCantidad = :entCantidad")})
public class Entrada implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ent_id")
    private Integer entId;
    @Size(max = 30)
    @Column(name = "ent_factura")
    private String entFactura;
    @Size(max = 11)
    @Column(name = "ent_fecha")
    private String entFecha;
    @Column(name = "ent_cantidad")
    private Integer entCantidad;
    @JoinColumn(name = "ent_pro_codigo", referencedColumnName = "pro_codigo")
    @ManyToOne
    private Producto entProCodigo;

    public Entrada() {
    }

    public Entrada(Integer entId) {
        this.entId = entId;
    }

    public Integer getEntId() {
        return entId;
    }

    public void setEntId(Integer entId) {
        this.entId = entId;
    }

    public String getEntFactura() {
        return entFactura;
    }

    public void setEntFactura(String entFactura) {
        this.entFactura = entFactura;
    }

    public String getEntFecha() {
        return entFecha;
    }

    public void setEntFecha(String entFecha) {
        this.entFecha = entFecha;
    }

    public Integer getEntCantidad() {
        return entCantidad;
    }

    public void setEntCantidad(Integer entCantidad) {
        this.entCantidad = entCantidad;
    }

    public Producto getEntProCodigo() {
        return entProCodigo;
    }

    public void setEntProCodigo(Producto entProCodigo) {
        this.entProCodigo = entProCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (entId != null ? entId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Entrada)) {
            return false;
        }
        Entrada other = (Entrada) object;
        if ((this.entId == null && other.entId != null) || (this.entId != null && !this.entId.equals(other.entId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Entrada[ entId=" + entId + " ]";
    }
    
}
