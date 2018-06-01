/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mensajes;

import Banco.AgenteDeInversiones;
import Mensajes.Mensaje;

/**
 *
 * @author Han Lei
 */
public class MensajeVenta extends Mensaje{
    private int numTitulos;
    
    public MensajeVenta(String nC, String nE, int titulos) {
        this.nombreCliente = nC;
        this.nombreEmpresa = nE;
        this.numTitulos = titulos;
        //this.id = AgenteDeInversiones.getTamañoListaPeticiones();
    }
    
    
    public void imprimir(){
        System.out.println ("Peticion de venta");
        System.out.println ("ID: "+id +"Cliente: "+nombreCliente +" Empresa: "+nombreEmpresa +" Titulos: "+numTitulos);
    }
}
