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

    public void create(Comprador comprador);

    public void edit(Comprador comprador);

    public void remove(String comprador);

    public Comprador find(String comprador);

    public List<Comprador> findAll();

    public List<Comprador> findRange(int[] range);

    public int count();
    
    public Comprador getComprador (String comprador);
    
}
