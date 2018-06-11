/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package General;

import java.io.IOException;

public class Main {
   
   static Simulador simulador = new Simulador();
   static InterfazDeUsuario menu = new InterfazDeUsuario();
   
    public static void main(String[] args) throws IOException, ClassNotFoundException {
       
        menu.menu();
        simulador.operacionesSimulador();
                

    }
}
