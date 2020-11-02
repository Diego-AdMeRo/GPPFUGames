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
@Table(name = "PLATAFORMA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Plataforma.findAll", query = "SELECT p FROM Plataforma p")
    , @NamedQuery(name = "Plataforma.findByIdplataforma", query = "SELECT p FROM Plataforma p WHERE p.idplataforma = :idplataforma")
    , @NamedQuery(name = "Plataforma.findByTipoplataforma", query = "SELECT p FROM Plataforma p WHERE p.tipoplataforma = :tipoplataforma")})
public class Plataforma implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "IDPLATAFORMA")
    private String idplataforma;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "TIPOPLATAFORMA")
    private String tipoplataforma;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idplataforma")
    private Collection<Juego> juegoCollection;

    public Plataforma() {
    }

    public Plataforma(String idplataforma) {
        this.idplataforma = idplataforma;
    }

    public Plataforma(String idplataforma, String tipoplataforma) {
        this.idplataforma = idplataforma;
        this.tipoplataforma = tipoplataforma;
    }

    public String getIdplataforma() {
        return idplataforma;
    }

    public void setIdplataforma(String idplataforma) {
        this.idplataforma = idplataforma;
    }

    public String getTipoplataforma() {
        return tipoplataforma;
    }

    public void setTipoplataforma(String tipoplataforma) {
        this.tipoplataforma = tipoplataforma;
    }

    @XmlTransient
    public Collection<Juego> getJuegoCollection() {
        return juegoCollection;
    }

    public void setJuegoCollection(Collection<Juego> juegoCollection) {
        this.juegoCollection = juegoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idplataforma != null ? idplataforma.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Plataforma)) {
            return false;
        }
        Plataforma other = (Plataforma) object;
        if ((this.idplataforma == null && other.idplataforma != null) || (this.idplataforma != null && !this.idplataforma.equals(other.idplataforma))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ugames.entities.Plataforma[ idplataforma=" + idplataforma + " ]";
    }
    
}
