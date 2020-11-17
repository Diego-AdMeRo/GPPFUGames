/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugames.sessionBeans;

import com.ugames.entities.Valoracion;
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
public class ValoracionFacade extends AbstractFacade<Valoracion> implements ValoracionFacadeLocal {

    @PersistenceContext(unitName = "UGamesDB")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ValoracionFacade() {
        super(Valoracion.class);
    }
    
     @Override
    public void create(Valoracion valoracion) {
        em.persist(valoracion);
    }

    @Override
    public void edit(Valoracion valoracion) {
        em.merge(valoracion);
    }

    @Override
    public Valoracion find(String valoracion) {
        return em.find(Valoracion.class, valoracion);
    }

    @Override
    public List<Valoracion> findAll() {
        return em.createNamedQuery("Valoracion.findAll").getResultList();
    }

    @Override
    public void remove(String valoracion) {
        Query query = em.createQuery("DELETE FROM Valoracion AS r WHERE r.idvaloracion = :valoracion");
        query.setParameter("valoracion", valoracion);
        query.executeUpdate();
        em.remove(find(valoracion));
    }

    @Override
    public Valoracion getValoracion(String valoracion) {
        TypedQuery<Valoracion> query = em.createQuery("SELECT c FROM Valoracion AS c WHERE c.idvaloracion = :valoracion", Valoracion.class);
        query.setParameter("valoracion", valoracion);
        return query.getSingleResult();
    }
    
}
