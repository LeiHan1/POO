/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mensajes;

import java.util.ArrayList;

/**
 *
 * @author sergio
 */
public class Mensaje {
    
    private String nombreCliente;
    private String nombreEmpresa;
    private int id;
    private ArrayList<Mensaje>listaPeticiones = new ArrayList<>();
    
    public void aniadirMensaje(Mensaje m){

       listaPeticiones.add(m);
    }
    
    public void rescatarMensajeBanco(){
        for (Mensaje mensaje:listaPeticiones){
            if mensaje 
            System.out.println(MensajeCompra.getTexto());
        }
         
    }

    public ArrayList<Mensaje> getListaPeticiones() {
        return listaPeticiones;
    }

    public void setListaPeticiones(ArrayList<Mensaje> listaPeticiones) {
        this.listaPeticiones = listaPeticiones;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }
/*
    public double getCantidadInvertir() {
        return cantidadInvertir;
    }

    public void setCantidadInvertir(double cantidadInvertir) {
        this.cantidadInvertir = cantidadInvertir;
    }
*/
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public void imprimir(){}
    
/*
    public double getNumTitulos() {
        return numTitulos;
    }

    public void setNumTitulos(double numTitulos) {
        this.numTitulos = numTitulos;
    }
*/    
    
    
}
