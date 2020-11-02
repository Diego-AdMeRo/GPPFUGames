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
import com.ugames.sessionBeans.UsuarioFacadeLocal;
import javax.ejb.EJB;



/**
 *
 * @author Diego
 */
public class OperacionUsuario {

    @EJB
    private UbicacionFacadeLocal ubicacion;
    @EJB
    private CompradorFacadeLocal comprador;
    @EJB
    private FacturaFacadeLocal factura;
    @EJB
    private TiendaFacadeLocal tienda;
    @EJB
    private UsuarioFacadeLocal usuario;
    
    public void ingreso(){
    
    }
    
    public String registroComprador(){
        return null;
    }
    
    public String registroTienda(){
        return null;
    }
    
    public String cambioContrasena(){
        return null;
    }
    
    public String eliminarCuenta(){
        return null;
    }
    
}
