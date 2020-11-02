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
@Table(name = "UBICACION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ubicacion.findAll", query = "SELECT u FROM Ubicacion u")
    , @NamedQuery(name = "Ubicacion.findByCodigopostal", query = "SELECT u FROM Ubicacion u WHERE u.codigopostal = :codigopostal")
    , @NamedQuery(name = "Ubicacion.findByDepartamento", query = "SELECT u FROM Ubicacion u WHERE u.departamento = :departamento")
    , @NamedQuery(name = "Ubicacion.findByLocalidad", query = "SELECT u FROM Ubicacion u WHERE u.localidad = :localidad")
    , @NamedQuery(name = "Ubicacion.findByCiudad", query = "SELECT u FROM Ubicacion u WHERE u.ciudad = :ciudad")})
public class Ubicacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "CODIGOPOSTAL")
    private String codigopostal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "DEPARTAMENTO")
    private String departamento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "LOCALIDAD")
    private String localidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "CIUDAD")
    private String ciudad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigopostal")
    private Collection<Usuario> usuarioCollection;

    public Ubicacion() {
    }

    public Ubicacion(String codigopostal) {
        this.codigopostal = codigopostal;
    }

    public Ubicacion(String codigopostal, String departamento, String localidad, String ciudad) {
        this.codigopostal = codigopostal;
        this.departamento = departamento;
        this.localidad = localidad;
        this.ciudad = ciudad;
    }

    public String getCodigopostal() {
        return codigopostal;
    }

    public void setCodigopostal(String codigopostal) {
        this.codigopostal = codigopostal;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    @XmlTransient
    public Collection<Usuario> getUsuarioCollection() {
        return usuarioCollection;
    }

    public void setUsuarioCollection(Collection<Usuario> usuarioCollection) {
        this.usuarioCollection = usuarioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigopostal != null ? codigopostal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ubicacion)) {
            return false;
        }
        Ubicacion other = (Ubicacion) object;
        if ((this.codigopostal == null && other.codigopostal != null) || (this.codigopostal != null && !this.codigopostal.equals(other.codigopostal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ugames.entities.Ubicacion[ codigopostal=" + codigopostal + " ]";
    }
    
}
