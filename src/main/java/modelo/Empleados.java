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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Camilo
 */
@Entity
@Table(name = "empleados")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empleados.findAll", query = "SELECT e FROM Empleados e"),
    @NamedQuery(name = "Empleados.findByIdEmpelado", query = "SELECT e FROM Empleados e WHERE e.idEmpelado = :idEmpelado"),
    @NamedQuery(name = "Empleados.findByApellido", query = "SELECT e FROM Empleados e WHERE e.apellido = :apellido"),
    @NamedQuery(name = "Empleados.findByNombre", query = "SELECT e FROM Empleados e WHERE e.nombre = :nombre"),
    @NamedQuery(name = "Empleados.findByRol", query = "SELECT e FROM Empleados e WHERE e.rol = :rol")})
public class Empleados implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_empelado")
    private Integer idEmpelado;
    @Size(max = 255)
    @Column(name = "apellido")
    private String apellido;
    @Size(max = 255)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 255)
    @Column(name = "rol")
    private String rol;

    public Empleados() {
    }

    public Empleados(Integer idEmpelado) {
        this.idEmpelado = idEmpelado;
    }

    public Integer getIdEmpelado() {
        return idEmpelado;
    }

    public void setIdEmpelado(Integer idEmpelado) {
        this.idEmpelado = idEmpelado;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEmpelado != null ? idEmpelado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empleados)) {
            return false;
        }
        Empleados other = (Empleados) object;
        if ((this.idEmpelado == null && other.idEmpelado != null) || (this.idEmpelado != null && !this.idEmpelado.equals(other.idEmpelado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Empleados[ idEmpelado=" + idEmpelado + " ]";
    }
    
}
