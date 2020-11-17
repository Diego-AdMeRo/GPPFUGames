/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugames.sessionBeans;

import com.ugames.entities.Genero;
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
public class GeneroFacade extends AbstractFacade<Genero> implements GeneroFacadeLocal {

    @PersistenceContext(unitName = "UGamesDB")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GeneroFacade() {
        super(Genero.class);
    }
    
     @Override
    public void create(Genero genero) {
        em.persist(genero);
    }

    @Override
    public void edit(Genero genero) {
        em.merge(genero);
    }

    @Override
    public Genero find(String genero) {
        return em.find(Genero.class, genero);
    }

    @Override
    public List<Genero> findAll() {
        return em.createNamedQuery("Genero.findAll").getResultList();
    }

    @Override
    public void remove(String genero) {
        Query query = em.createQuery("DELETE FROM Genero AS r WHERE r.idgenero = :genero");
        query.setParameter("genero", genero);
        query.executeUpdate();
        em.remove(find(genero));
    }

    @Override
    public Genero getGenero(String genero) {
        TypedQuery<Genero> query = em.createQuery("SELECT c FROM Genero AS c WHERE c.idgenero = :genero", Genero.class);
        query.setParameter("genero", genero);
        return query.getSingleResult();
    }
    
}
