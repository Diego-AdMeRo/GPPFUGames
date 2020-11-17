/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugames.sessionBeans;

import com.ugames.entities.Tienda;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Diego
 */
@Local
public interface TiendaFacadeLocal {

    public void create(Tienda tienda);

    public void edit(Tienda tienda);

    public void remove(String tienda);

    public Tienda find(String tienda);

    public List<Tienda> findAll();

    public List<Tienda> findRange(int[] range);

    public int count();
    
    public Tienda getComprador (String tienda);
    
}
