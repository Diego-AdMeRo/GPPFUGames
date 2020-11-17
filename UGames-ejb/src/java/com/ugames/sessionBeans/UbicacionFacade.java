/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugames.sessionBeans;

import com.ugames.entities.Ubicacion;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author Diego
 */
@Stateless
public class UbicacionFacade extends AbstractFacade<Ubicacion> implements UbicacionFacadeLocal {

    @PersistenceContext(unitName = "UGamesDB")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UbicacionFacade() {
        super(Ubicacion.class);
    }
    
    
     @Override
    public void create(Ubicacion ubicacion) {
        em.persist(ubicacion);
    }

    @Override
    public void edit(Ubicacion ubicacion) {
        em.merge(ubicacion);
    }

    @Override
    public Ubicacion find(String ubicacion) {
        return em.find(Ubicacion.class, ubicacion);
    }

    @Override
    public List<Ubicacion> findAll() {
        return em.createNamedQuery("Ubicacion.findAll").getResultList();
    }

    @Override
    public void remove(String ubicacion) {
        Query query = em.createQuery("DELETE FROM Ubicacion AS r WHERE r.codigopostal = :ubicacion");
        query.setParameter("ubicacion", ubicacion);
        query.executeUpdate();
        em.remove(find(ubicacion));
    }

    @Override
    public Ubicacion getUbicacion(String ubicacion) {
        TypedQuery<Ubicacion> query = em.createQuery("SELECT c FROM Ubicacion AS c WHERE c.codigopostal = :ubicacion", Ubicacion.class);
        query.setParameter("ubicacion", ubicacion);
        return query.getSingleResult();
    }
}
