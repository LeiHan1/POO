/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Banco;
import General.*;
import Mensajes.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author sergio
 */
public class AgenteDeInversiones extends Persona {
    
    private final ArrayList<Mensaje>listaPeticiones = new ArrayList<>();
    
    public AgenteDeInversiones (String n, String d){
        this.nombre = n;
        this.dni = d;
    }
    
    public void aniadirMensaje(Mensaje m){

       listaPeticiones.add(m);
    }
    
    //public String codificacionPeticion(Mensaje p){}

    public ArrayList<Mensaje> getListaPeticiones() {
        return listaPeticiones;
    }

    
    
    

    
    
    
    public void opSolicitaActualizacionAcciones(){ //16.solicitar actualizacion de acciones
    
    
    }
    
    
    public void opImprimirOperaciones(){ //17.imprimir operaciones pendientes
        System.out.println ("Imprimir peticiones pendientes");
        for (int i=0;i<listaPeticiones.size();i++) {
          listaPeticiones.get(i).imprimir();
        }
        
            
        
    
    
    
    }

    
}
