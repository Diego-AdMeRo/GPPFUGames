/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugames.sessionBeans;

import com.ugames.entities.Factura;
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
public class FacturaFacade extends AbstractFacade<Factura> implements FacturaFacadeLocal {

    @PersistenceContext(unitName = "UGamesDB")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FacturaFacade() {
        super(Factura.class);
    }
    
     @Override
    public void create(Factura factura) {
        em.persist(factura);
    }

    @Override
    public void edit(Factura factura) {
        em.merge(factura);
    }

    @Override
    public Factura find(String genero) {
        return em.find(Factura.class, genero);
    }

    @Override
    public List<Factura> findAll() {
        return em.createNamedQuery("Factura.findAll").getResultList();
    }

    @Override
    public void remove(String factura) {
        Query query = em.createQuery("DELETE FROM Factura AS r WHERE r.idfactura = :factura");
        query.setParameter("factura", factura);
        query.executeUpdate();
        em.remove(find(factura));
    }

    @Override
    public Factura getFactura(String factura) {
        TypedQuery<Factura> query = em.createQuery("SELECT c FROM Factura AS c WHERE c.idfactura = :factura", Factura.class);
        query.setParameter("factura", factura);
        return query.getSingleResult();
    }
    
}
