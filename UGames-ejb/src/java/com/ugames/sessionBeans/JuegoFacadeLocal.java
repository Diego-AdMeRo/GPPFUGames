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

    void create(Juego juego);

    void edit(Juego juego);

    void remove(Juego juego);

    Juego find(Object id);

    List<Juego> findAll();

    List<Juego> findRange(int[] range);

    int count();
    
}
