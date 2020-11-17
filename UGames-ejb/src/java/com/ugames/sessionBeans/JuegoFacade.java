/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugames.sessionBeans;

import com.ugames.entities.Juego;
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
public class JuegoFacade extends AbstractFacade<Juego> implements JuegoFacadeLocal {

    @PersistenceContext(unitName = "UGamesDB")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public JuegoFacade() {
        super(Juego.class);
    }
    
     @Override
    public void create(Juego juego) {
        em.persist(juego);
    }

    @Override
    public void edit(Juego juego) {
        em.merge(juego);
    }

    @Override
    public Juego find(String juego) {
        return em.find(Juego.class, juego);
    }

    @Override
    public List<Juego> findAll() {
        return em.createNamedQuery("Juego.findAll").getResultList();
    }

    @Override
    public void remove(String juego) {
        Query query = em.createQuery("DELETE FROM Juego AS r WHERE r.idjuego = :juego");
        query.setParameter("juego", juego);
        query.executeUpdate();
        em.remove(find(juego));
    }

    @Override
    public Juego getJuego(String juego) {
        TypedQuery<Juego> query = em.createQuery("SELECT c FROM Juego AS c WHERE c.idjuego = :juego", Juego.class);
        query.setParameter("juego", juego);
        return query.getSingleResult();
    }
    
}
