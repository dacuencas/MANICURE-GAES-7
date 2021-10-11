/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jhoann
 */
@Entity
@Table(name = "pqrs")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pqrs.findAll", query = "SELECT p FROM Pqrs p"),
    @NamedQuery(name = "Pqrs.findByIdpqrs", query = "SELECT p FROM Pqrs p WHERE p.idpqrs = :idpqrs"),
    @NamedQuery(name = "Pqrs.findByComentarioCliente", query = "SELECT p FROM Pqrs p WHERE p.comentarioCliente = :comentarioCliente"),
    @NamedQuery(name = "Pqrs.findByComentarioAdmin", query = "SELECT p FROM Pqrs p WHERE p.comentarioAdmin = :comentarioAdmin"),
    @NamedQuery(name = "Pqrs.findByFechaRegistro", query = "SELECT p FROM Pqrs p WHERE p.fechaRegistro = :fechaRegistro")})
public class Pqrs implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpqrs")
    private Integer idpqrs;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "comentarioCliente")
    private String comentarioCliente;
    @Size(max = 300)
    @Column(name = "comentarioAdmin")
    private String comentarioAdmin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaRegistro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
    @JoinColumn(name = "tipo_pqrs", referencedColumnName = "idtipoPqrs")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Tipopqrs tipoPqrs;

    public Pqrs() {
    }

    public Pqrs(Integer idpqrs) {
        this.idpqrs = idpqrs;
    }

    public Pqrs(Integer idpqrs, String comentarioCliente, Date fechaRegistro) {
        this.idpqrs = idpqrs;
        this.comentarioCliente = comentarioCliente;
        this.fechaRegistro = fechaRegistro;
    }

    public Integer getIdpqrs() {
        return idpqrs;
    }

    public void setIdpqrs(Integer idpqrs) {
        this.idpqrs = idpqrs;
    }

    public String getComentarioCliente() {
        return comentarioCliente;
    }

    public void setComentarioCliente(String comentarioCliente) {
        this.comentarioCliente = comentarioCliente;
    }

    public String getComentarioAdmin() {
        return comentarioAdmin;
    }

    public void setComentarioAdmin(String comentarioAdmin) {
        this.comentarioAdmin = comentarioAdmin;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Tipopqrs getTipoPqrs() {
        return tipoPqrs;
    }

    public void setTipoPqrs(Tipopqrs tipoPqrs) {
        this.tipoPqrs = tipoPqrs;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpqrs != null ? idpqrs.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pqrs)) {
            return false;
        }
        Pqrs other = (Pqrs) object;
        if ((this.idpqrs == null && other.idpqrs != null) || (this.idpqrs != null && !this.idpqrs.equals(other.idpqrs))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Pqrs[ idpqrs=" + idpqrs + " ]";
    }

    public void setUsuarioIdusuario(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
