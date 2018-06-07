/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mensajes;
/**
 *
 * @author Han Lei
 */
public class MensajeCompra extends Mensaje {
    
    double cantidadInvertir;
     
    public MensajeCompra(String nC, String nE, double cantidad) {
        this.nombreCliente = nC;
        this.nombreEmpresa = nE;
        this.cantidadInvertir = cantidad;
    }

    

    public void setCantidadInvertir(double cantidadInvertir) {
        this.cantidadInvertir = cantidadInvertir;
    }

    @Override
    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    @Override
    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    @Override
    public String getNombreCliente() {
        return nombreCliente;
    }

    @Override
    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    @Override
    public void imprimir(){
        System.out.println(id+"|"+nombreCliente + "|"+nombreEmpresa + "|" +cantidadInvertir);
    }

    @Override
    public String toString(){
        return (id+"|"+nombreCliente + "|"+nombreEmpresa+ "|" +cantidadInvertir);
    }
    
    
}
