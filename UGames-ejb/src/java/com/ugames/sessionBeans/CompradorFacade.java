
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugames.sessionBeans;

import com.ugames.entities.Comprador;
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
public class CompradorFacade extends AbstractFacade<Comprador> implements CompradorFacadeLocal {

    @PersistenceContext(unitName = "UGamesDB")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CompradorFacade() {
        super(Comprador.class);
    }

     @Override
    public void create(Comprador comprador) {
        em.persist(comprador);
    }

    @Override
    public void edit(Comprador comprador) {
        em.merge(comprador);
    }

    @Override
    public Comprador find(String comprador) {
        return em.find(Comprador.class, comprador);
    }

    @Override
    public List<Comprador> findAll() {
        return em.createNamedQuery("Comprador.findAll").getResultList();
    }

    @Override
    public void remove(String email) {
        Query query = em.createQuery("DELETE FROM Comprador AS r WHERE r.email = :email");
        query.setParameter("email", email);
        query.executeUpdate();
        em.remove(find(email));
    }

    @Override
    public Comprador getComprador(String email) {
        TypedQuery<Comprador> query = em.createQuery("SELECT c FROM Comprador AS c WHERE c.email = :email", Comprador.class);
        query.setParameter("email", email);
        return query.getSingleResult();
    }

    
}
