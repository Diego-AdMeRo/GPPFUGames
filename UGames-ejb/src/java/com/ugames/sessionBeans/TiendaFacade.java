/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugames.sessionBeans;

import com.ugames.entities.Tienda;
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
public class TiendaFacade extends AbstractFacade<Tienda> implements TiendaFacadeLocal {

    @PersistenceContext(unitName = "UGamesDB")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TiendaFacade() {
        super(Tienda.class);
    }
    
     @Override
    public void create(Tienda tienda) {
        em.persist(tienda);
    }

    @Override
    public void edit(Tienda tienda) {
        em.merge(tienda);
    }

    @Override
    public Tienda find(String tienda) {
        return em.find(Tienda.class, tienda);
    }

    @Override
    public List<Tienda> findAll() {
        return em.createNamedQuery("Tienda.findAll").getResultList();
    }

    @Override
    public void remove(String tienda) {
        Query query = em.createQuery("DELETE FROM Tienda AS r WHERE r.nit = :tienda");
        query.setParameter("tienda", tienda);
        query.executeUpdate();
        em.remove(find(tienda));
    }

    @Override
    public Tienda getComprador(String tienda) {
        TypedQuery<Tienda> query = em.createQuery("SELECT c FROM Tienda AS c WHERE c.nit = :tienda", Tienda.class);
        query.setParameter("tienda", tienda);
        return query.getSingleResult();
    }
    
}
