/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Banco;

import java.io.Serializable;

/**
 *
 * @author Han Lei
 */
public class ClientePremium extends Cliente implements Serializable{
    private GestorDeInversiones gestor;

//constructor    
    public ClientePremium(String nombre, String dni, double saldo) {
        super(nombre, dni, saldo);
    }
    
    public ClientePremium(Cliente cliente) {
        super(cliente.getNombre(), cliente.getDni(), cliente.getSaldo());
    }
    
//metodo    
    public void asignarGestor(GestorDeInversiones g){    
        //super.setPremium(true);
        this.gestor = g;
    }
       
    /*
    public void asignarGestor(String nombre, String dni){    
        //super.setPremium(true);
        this.gestor.setNombre(nombre);
        this.gestor.setDni(dni);
    }
*/
    
    public GestorDeInversiones getGestor(){
        return this.gestor;
    }
    
    public String getNomGestor(){
        return this.gestor.getNombre();
    }
    
    public String getDniGestor(){
        return this.gestor.getDni();
    }
    
    
}
