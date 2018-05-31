/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mensajes;

import Banco.AgenteDeInversiones;

/**
 *
 * @author Han Lei
 */
public class MensajeCompra extends Mensaje {
    private double cantidadInvertir;
    
    public MensajeCompra(String nC, String nE, double cantidad) {
        this.nombreCliente = nC;
        this.nombreEmpresa = nE;
        this.cantidadInvertir = cantidad;
        this.id = AgenteDeInversiones.getTamañoListaPeticiones();
    }
    
    @Override
    public void imprimir(){
        System.out.println ("Peticion de compra");
        System.out.println ("ID: "+id +" Cliente: "+nombreCliente +" Empresa: "+nombreEmpresa +" Cantidad: "+cantidadInvertir);
    }
    
}
