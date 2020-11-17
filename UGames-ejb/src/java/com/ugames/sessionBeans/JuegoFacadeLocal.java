/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugames.sessionBeans;

import com.ugames.entities.Juego;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Diego
 */
@Local
public interface JuegoFacadeLocal {

     public void create(Juego juego);

    public void edit(Juego juego);

    public void remove(String juego);

    public Juego find(String juego);

    public List<Juego> findAll();

    public List<Juego> findRange(int[] range);

    public int count();
    
    public Juego getJuego (String juego);
    
}
