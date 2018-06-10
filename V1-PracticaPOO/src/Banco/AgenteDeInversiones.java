/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Banco;

import Mensajes.*;
import java.util.HashMap;

/**
 *
 * @author sergio
 */
public class AgenteDeInversiones extends Persona {

    private HashMap<Mensaje, String> mensajes = new HashMap<>();
   

    public AgenteDeInversiones(String n, String d) {
        this.nombre = n;
        this.dni = d;
    }

    public void addMapMensaje(Mensaje m, String s) {
        mensajes.put(m, s);
    }

    public HashMap<Mensaje, String> getMensajes() {
        return mensajes;
    }
    
    public void opImprimirOperaciones() { //17.imprimir operaciones pendientes
        System.out.println("Imprimir peticiones pendientes:");
        mensajes.forEach((k, v) -> System.out.println(v+" "+ k.toString() ));
    }

}
