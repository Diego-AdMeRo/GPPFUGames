/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugames.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
 * @author Diego
 */
@Entity
@Table(name = "COMPRADOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Comprador.findAll", query = "SELECT c FROM Comprador c")
    , @NamedQuery(name = "Comprador.findByDocidentidad", query = "SELECT c FROM Comprador c WHERE c.docidentidad = :docidentidad")
    , @NamedQuery(name = "Comprador.findByNombre", query = "SELECT c FROM Comprador c WHERE c.nombre = :nombre")
    , @NamedQuery(name = "Comprador.findByApellido", query = "SELECT c FROM Comprador c WHERE c.apellido = :apellido")
    , @NamedQuery(name = "Comprador.findByTelefono", query = "SELECT c FROM Comprador c WHERE c.telefono = :telefono")})
public class Comprador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "DOCIDENTIDAD")
    private String docidentidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "APELLIDO")
    private String apellido;
    @Size(max = 10)
    @Column(name = "TELEFONO")
    private String telefono;
    @JoinColumn(name = "EMAIL", referencedColumnName = "EMAIL")
    @ManyToOne(optional = false)
    private Usuario email;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "docidentidad")
    private Collection<Factura> facturaCollection;

    public Comprador() {
    }

    public Comprador(String docidentidad) {
        this.docidentidad = docidentidad;
    }

    public Comprador(String docidentidad, String nombre, String apellido) {
        this.docidentidad = docidentidad;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getDocidentidad() {
        return docidentidad;
    }

    public void setDocidentidad(String docidentidad) {
        this.docidentidad = docidentidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Usuario getEmail() {
        return email;
    }

    public void setEmail(Usuario email) {
        this.email = email;
    }

    @XmlTransient
    public Collection<Factura> getFacturaCollection() {
        return facturaCollection;
    }

    public void setFacturaCollection(Collection<Factura> facturaCollection) {
        this.facturaCollection = facturaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (docidentidad != null ? docidentidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comprador)) {
            return false;
        }
        Comprador other = (Comprador) object;
        if ((this.docidentidad == null && other.docidentidad != null) || (this.docidentidad != null && !this.docidentidad.equals(other.docidentidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ugames.entities.Comprador[ docidentidad=" + docidentidad + " ]";
    }
    
}
