/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugames.conexion;

import com.ugames.sessionBeans.CompradorFacadeLocal;
import com.ugames.sessionBeans.FacturaFacadeLocal;
import com.ugames.sessionBeans.JuegoFacadeLocal;
import com.ugames.sessionBeans.TiendaFacadeLocal;
import com.ugames.sessionBeans.UbicacionFacadeLocal;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author Diego
 */
public class OperacionVendedor {
    
    @EJB
    private JuegoFacadeLocal juegoFacade;
    @EJB
    private CompradorFacadeLocal comprador;
    @EJB
    private FacturaFacadeLocal factura;
    @EJB
    private TiendaFacadeLocal tienda;
    @EJB
    private UbicacionFacadeLocal ubicacion;
    
    
    public String agregarJuego(){
        return null;
    }
    
    public String actualizarDatos(){
        return null;
    }
    
    public String actualizarJuego(){
        return null;
    }
    
    public String eliminarJuego(){
        return null;
    }
    
    public List<Object[]> reservasActivas(){
        return null;
    }
    
    public List<Object[]> comprasActivas(){
        return null;
    }
    
    public void enviarJuego(){
    
    }
}
