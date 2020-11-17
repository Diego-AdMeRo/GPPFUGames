/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugames.sessionBeans;

import com.ugames.entities.Ubicacion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Diego
 */
@Local
public interface UbicacionFacadeLocal {

     public void create(Ubicacion ubicacion);

    public void edit(Ubicacion ubicacion);

    public void remove(String ubicacion);

    public Ubicacion find(String ubicacion);

    public List<Ubicacion> findAll();

    public List<Ubicacion> findRange(int[] range);

    public int count();
    
    public Ubicacion getUbicacion (String ubicacion);
    
}
