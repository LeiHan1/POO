/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mensajes;

/**
 *
 * @author sergio
 */
public class Mensaje {
    
    String nombreCliente;
    String nombreEmpresa;

    int id = (int) Math.floor(Math.random()*(0-1500+1)+1500); 

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    

    
    public void imprimir(){
        System.out.println(id+"|"+nombreCliente + "|"+nombreEmpresa);
    }
    
    
    @Override
    public String toString(){
        return (id+"|"+nombreCliente + "|"+nombreEmpresa);
    }
    
    
}
