/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugames.sessionBeans;

import com.ugames.entities.Plataforma;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Diego
 */
@Local
public interface PlataformaFacadeLocal {

    public void create(Plataforma plataforma);

    public void edit(Plataforma plataforma);

    public void remove(String plaforma);

    public Plataforma find(String plataforma);

    public List<Plataforma> findAll();

    public List<Plataforma> findRange(int[] range);

    public int count();
    
    public Plataforma getPlataforma (String plataforma);
    
}
