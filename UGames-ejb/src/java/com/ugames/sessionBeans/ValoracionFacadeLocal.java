/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugames.sessionBeans;

import com.ugames.entities.Valoracion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Diego
 */
@Local
public interface ValoracionFacadeLocal {

    public void create(Valoracion valoracion);

    public void edit(Valoracion valoracion);

    public void remove(String valoracion);

    public Valoracion find(String valoracion);

    public List<Valoracion> findAll();

    public List<Valoracion> findRange(int[] range);

    public int count();
    
    public Valoracion getValoracion (String valoracion);
    
}
