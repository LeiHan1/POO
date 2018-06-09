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
    double valorPorAccion, valorTotal;
    public MensajeRespuestaVenta(int id, String nC, String nE, int titulos, double valorAccion, double valorTot) {
        super(nC, nE, titulos);
        this.id = id;
        valorPorAccion = valorAccion;
        valorTotal = valorTot;
    }
    
    @Override
    public void imprimir(){
        
//        System.out.println( id+" |"+nombreCliente + "|"+nombreEmpresa + "|" +numTitulos);
    }

    @Override
    public String toString(){
        return (id+"|"+nombreCliente + "|"+nombreEmpresa+ "|" + this.getNumTitulos() +"|"+ true + "|"+valorPorAccion+"|"+valorTotal);
    
    }
}
