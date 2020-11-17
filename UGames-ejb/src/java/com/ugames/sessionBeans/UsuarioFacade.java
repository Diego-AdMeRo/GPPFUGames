/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugames.sessionBeans;

import com.ugames.entities.Usuario;
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
public class UsuarioFacade extends AbstractFacade<Usuario> implements UsuarioFacadeLocal {

    @PersistenceContext(unitName = "UGamesDB")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }
    
     @Override
    public void create(Usuario usuario) {
        em.persist(usuario);
    }

    @Override
    public void edit(Usuario usuario) {
        em.merge(usuario);
    }

    @Override
    public Usuario find(String usuario) {
        return em.find(Usuario.class, usuario);
    }

    @Override
    public List<Usuario> findAll() {
        return em.createNamedQuery("Usuario.findAll").getResultList();
    }

    @Override
    public void remove(String usuario) {
        Query query = em.createQuery("DELETE FROM Usuario AS r WHERE r.email = :usuario");
        query.setParameter("usuario", usuario);
        query.executeUpdate();
        em.remove(find(usuario));
    }

    @Override
    public Usuario getUsuario(String usuario) {
        TypedQuery<Usuario> query = em.createQuery("SELECT c FROM Usuario AS c WHERE c.email = :usuario", Usuario.class);
        query.setParameter("usuario", usuario);
        return query.getSingleResult();
    }
    
}
