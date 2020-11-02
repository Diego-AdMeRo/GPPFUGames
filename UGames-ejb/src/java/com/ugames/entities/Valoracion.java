/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugames.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Diego
 */
@Entity
@Table(name = "VALORACION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Valoracion.findAll", query = "SELECT v FROM Valoracion v")
    , @NamedQuery(name = "Valoracion.findByIdvaloracion", query = "SELECT v FROM Valoracion v WHERE v.idvaloracion = :idvaloracion")
    , @NamedQuery(name = "Valoracion.findByComentario", query = "SELECT v FROM Valoracion v WHERE v.comentario = :comentario")
    , @NamedQuery(name = "Valoracion.findByCalificacion", query = "SELECT v FROM Valoracion v WHERE v.calificacion = :calificacion")
    , @NamedQuery(name = "Valoracion.findByFecha", query = "SELECT v FROM Valoracion v WHERE v.fecha = :fecha")})
public class Valoracion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "IDVALORACION")
    private String idvaloracion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "COMENTARIO")
    private String comentario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "CALIFICACION")
    private String calificacion;
    @Size(max = 30)
    @Column(name = "FECHA")
    private String fecha;
    @JoinColumn(name = "IDJUEGO", referencedColumnName = "IDJUEGO")
    @ManyToOne(optional = false)
    private Juego idjuego;

    public Valoracion() {
    }

    public Valoracion(String idvaloracion) {
        this.idvaloracion = idvaloracion;
    }

    public Valoracion(String idvaloracion, String comentario, String calificacion) {
        this.idvaloracion = idvaloracion;
        this.comentario = comentario;
        this.calificacion = calificacion;
    }

    public String getIdvaloracion() {
        return idvaloracion;
    }

    public void setIdvaloracion(String idvaloracion) {
        this.idvaloracion = idvaloracion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(String calificacion) {
        this.calificacion = calificacion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Juego getIdjuego() {
        return idjuego;
    }

    public void setIdjuego(Juego idjuego) {
        this.idjuego = idjuego;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idvaloracion != null ? idvaloracion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Valoracion)) {
            return false;
        }
        Valoracion other = (Valoracion) object;
        if ((this.idvaloracion == null && other.idvaloracion != null) || (this.idvaloracion != null && !this.idvaloracion.equals(other.idvaloracion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ugames.entities.Valoracion[ idvaloracion=" + idvaloracion + " ]";
    }
    
}
