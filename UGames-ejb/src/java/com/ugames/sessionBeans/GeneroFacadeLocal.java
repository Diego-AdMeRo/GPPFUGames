/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugames.sessionBeans;

import com.ugames.entities.Genero;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Diego
 */
@Local
public interface GeneroFacadeLocal {

    public void create(Genero genero);

    public void edit(Genero genero);

    public void remove(String genero);

    public Genero find(String genero);

    public List<Genero> findAll();

    public List<Genero> findRange(int[] range);

    public int count();
    
    public Genero getGenero (String genero);
    
}
