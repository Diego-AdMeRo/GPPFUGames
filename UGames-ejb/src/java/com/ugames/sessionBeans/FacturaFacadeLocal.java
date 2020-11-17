/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugames.sessionBeans;

import com.ugames.entities.Factura;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Diego
 */
@Local
public interface FacturaFacadeLocal {

    public void create(Factura factura);

    public void edit(Factura factura);

    public void remove(String factura);

    public Factura find(String factura);

    public List<Factura> findAll();

    public List<Factura> findRange(int[] range);

    public int count();
    
    public Factura getFactura (String factura);
    
}
