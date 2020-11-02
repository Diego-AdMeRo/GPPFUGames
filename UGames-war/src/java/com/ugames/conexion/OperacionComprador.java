/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugames.conexion;

import com.ugames.sessionBeans.CompradorFacadeLocal;
import com.ugames.sessionBeans.FacturaFacadeLocal;
import com.ugames.sessionBeans.JuegoFacadeLocal;
import java.util.List;
import javax.ejb.EJB;


/**
 *
 * @author Diego
 */
public class OperacionComprador {

    @EJB
    private JuegoFacadeLocal juegoFacade;
    @EJB
    private CompradorFacadeLocal comprador;
    @EJB
    private FacturaFacadeLocal factura;
    
    
    public List<Object[]> buscarJuego(){
        return null;
    }
    
    public void actualizarDatos(){
    
    } 
    
    public String reservar(){
        return null;
    }
    
    public List<Object[]> reservasActivas(){
        return null;
    }
    
    public void cancelarReserva(){
    
    }
    
    public String comprar(){
        return null;
    }
    
    public List<Object[]> comprasActivas(){
        return null;
    }
    
    public String facturacion(){
        return null;
    }
    
}
