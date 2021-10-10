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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Frederick Bosa S
 */
@Entity
@Table(name = "inventario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Inventario.findAll", query = "SELECT i FROM Inventario i"),
    @NamedQuery(name = "Inventario.findByInvProCodigo", query = "SELECT i FROM Inventario i WHERE i.invProCodigo = :invProCodigo"),
    @NamedQuery(name = "Inventario.findByInvEntradas", query = "SELECT i FROM Inventario i WHERE i.invEntradas = :invEntradas"),
    @NamedQuery(name = "Inventario.findByInvSalidas", query = "SELECT i FROM Inventario i WHERE i.invSalidas = :invSalidas"),
    @NamedQuery(name = "Inventario.findByInvStock", query = "SELECT i FROM Inventario i WHERE i.invStock = :invStock")})
public class Inventario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "inv_pro_codigo")
    private String invProCodigo;
    @Column(name = "inv_entradas")
    private Integer invEntradas;
    @Column(name = "inv_salidas")
    private Integer invSalidas;
    @Column(name = "inv_stock")
    private Integer invStock;
    @JoinColumn(name = "inv_pro_codigo", referencedColumnName = "pro_codigo", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Producto producto;

    public Inventario() {
    }

    public Inventario(String invProCodigo) {
        this.invProCodigo = invProCodigo;
    }

    public String getInvProCodigo() {
        return invProCodigo;
    }

    public void setInvProCodigo(String invProCodigo) {
        this.invProCodigo = invProCodigo;
    }

    public Integer getInvEntradas() {
        return invEntradas;
    }

    public void setInvEntradas(Integer invEntradas) {
        this.invEntradas = invEntradas;
    }

    public Integer getInvSalidas() {
        return invSalidas;
    }

    public void setInvSalidas(Integer invSalidas) {
        this.invSalidas = invSalidas;
    }

    public Integer getInvStock() {
        return invStock;
    }

    public void setInvStock(Integer invStock) {
        this.invStock = invStock;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (invProCodigo != null ? invProCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Inventario)) {
            return false;
        }
        Inventario other = (Inventario) object;
        if ((this.invProCodigo == null && other.invProCodigo != null) || (this.invProCodigo != null && !this.invProCodigo.equals(other.invProCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Inventario[ invProCodigo=" + invProCodigo + " ]";
    }
    
}
