/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mensajes;

/**
 *
 * @author Adrian
 */
public class MensajeRespuestaVenta extends MensajeVenta{
    
    public MensajeRespuestaVenta(String nC, String nE, int titulos) {
        super(nC, nE, titulos);
    }
    
    @Override
    public void imprimir(){
        
//        System.out.println( id+" |"+nombreCliente + "|"+nombreEmpresa + "|" +numTitulos);
    }

     @Override
    public String toString(){
    //    return (id+"|"+nombreCliente + "|"+nombreEmpresa+ "|" +cantidadInvertir);
    return null;
    }
}
