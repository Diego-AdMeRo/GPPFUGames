/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugames.sessionBeans;

import com.ugames.entities.Plataforma;
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
public class PlataformaFacade extends AbstractFacade<Plataforma> implements PlataformaFacadeLocal {

    @PersistenceContext(unitName = "UGamesDB")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PlataformaFacade() {
        super(Plataforma.class);
    }
    
     @Override
    public void create(Plataforma plataforma) {
        em.persist(plataforma);
    }

    @Override
    public void edit(Plataforma plataforma) {
        em.merge(plataforma);
    }

    @Override
    public Plataforma find(String plataforma) {
        return em.find(Plataforma.class, plataforma);
    }

    @Override
    public List<Plataforma> findAll() {
        return em.createNamedQuery("Plataforma.findAll").getResultList();
    }

    @Override
    public void remove(String plataforma) {
        Query query = em.createQuery("DELETE FROM Plataforma AS r WHERE r.idplataforma = :plataforma");
        query.setParameter("plataforma", plataforma);
        query.executeUpdate();
        em.remove(find(plataforma));
    }

    @Override
    public Plataforma getPlataforma(String plataforma) {
        TypedQuery<Plataforma> query = em.createQuery("SELECT c FROM Plataforma AS c WHERE c.idplataforma = :plataforma", Plataforma.class);
        query.setParameter("plataforma", plataforma);
        return query.getSingleResult();
    }
    
}
