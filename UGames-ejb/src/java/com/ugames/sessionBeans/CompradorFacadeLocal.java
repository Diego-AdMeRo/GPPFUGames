/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugames.sessionBeans;

import com.ugames.entities.Comprador;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Diego
 */
@Local
public interface CompradorFacadeLocal {

    void create(Comprador comprador);

    void edit(Comprador comprador);

    void remove(Comprador comprador);

    Comprador find(Object id);

    List<Comprador> findAll();

    List<Comprador> findRange(int[] range);

    int count();
    
}
