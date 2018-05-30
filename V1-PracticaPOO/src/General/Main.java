/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package General;

import java.io.IOException;

/**
 *
 * @author sergio
 */
public class Main {
   static InterfazDeUsuario menu = new InterfazDeUsuario();
   static Simulador simulador = new Simulador();
   
    public static void main(String[] args) throws IOException, ClassNotFoundException {
       
        menu.menu();
        simulador.operacionesSimulador();

    }
}
