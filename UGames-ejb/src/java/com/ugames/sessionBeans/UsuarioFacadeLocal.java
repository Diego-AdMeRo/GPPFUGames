/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugames.sessionBeans;

import com.ugames.entities.Usuario;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Diego
 */
@Local
public interface UsuarioFacadeLocal {

     public void create(Usuario usuario);

    public void edit(Usuario usuario);

    public void remove(String usuario);

    public Usuario find(String usuario);

    public List<Usuario> findAll();

    public List<Usuario> findRange(int[] range);

    public int count();
    
    public Usuario getUsuario (String usuario);
    
}
