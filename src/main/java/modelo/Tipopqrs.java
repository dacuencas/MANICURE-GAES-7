/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jhoann
 */
@Entity
@Table(name = "tipopqrs")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipopqrs.findAll", query = "SELECT t FROM Tipopqrs t"),
    @NamedQuery(name = "Tipopqrs.findByIdtipoPqrs", query = "SELECT t FROM Tipopqrs t WHERE t.idtipoPqrs = :idtipoPqrs"),
    @NamedQuery(name = "Tipopqrs.findByDescripcion", query = "SELECT t FROM Tipopqrs t WHERE t.descripcion = :descripcion")})
public class Tipopqrs implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtipoPqrs")
    private Integer idtipoPqrs;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoPqrs", fetch = FetchType.LAZY)
    private List<Pqrs> pqrsList;

    public Tipopqrs() {
    }

    public Tipopqrs(Integer idtipoPqrs) {
        this.idtipoPqrs = idtipoPqrs;
    }

    public Tipopqrs(Integer idtipoPqrs, String descripcion) {
        this.idtipoPqrs = idtipoPqrs;
        this.descripcion = descripcion;
    }

    public Integer getIdtipoPqrs() {
        return idtipoPqrs;
    }

    public void setIdtipoPqrs(Integer idtipoPqrs) {
        this.idtipoPqrs = idtipoPqrs;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<Pqrs> getPqrsList() {
        return pqrsList;
    }

    public void setPqrsList(List<Pqrs> pqrsList) {
        this.pqrsList = pqrsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtipoPqrs != null ? idtipoPqrs.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipopqrs)) {
            return false;
        }
        Tipopqrs other = (Tipopqrs) object;
        if ((this.idtipoPqrs == null && other.idtipoPqrs != null) || (this.idtipoPqrs != null && !this.idtipoPqrs.equals(other.idtipoPqrs))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Tipopqrs[ idtipoPqrs=" + idtipoPqrs + " ]";
    }
    
}
