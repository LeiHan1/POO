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

    
    
    

    
    
    
    /*public void opSolicitaActualizacionAcciones(){ //16.solicitar actualizacion de acciones
    
    
    }
*/
  
     public void intentaOperacion(String m){ //16.solicitar actualizacion de acciones
         int ini=0;
         int fin=0;
         int cont=0;
         String barra= "|";
         char c = barra.charAt(0);
         char s;
         String cliente = null;
         String empresa = null;
         String cantInver = null;
         int n = 0;
         Cliente p;
         
         while (m.charAt(n) < m.length()){
             if(m.charAt(n) == c){
                 n++;
             }else if(n < 5){
                 s = m.charAt(n);
                 cliente = cliente + s;
             }else if (n < 9){
                 s = m.charAt(n);
                 empresa = empresa + s;
             }else{
                 s = m.charAt(n);
                 cantInver = cantInver + s;
                 int cantidad = Integer.parseInt(cantInver);
             }
             n++;
         }
         double cantidad = Double.parseDouble(cantInver);
         if(m.charAt(0) == 1){
             for(Cliente cli:Banco.getInversores()){
                 if (cli.nombre == cliente){
                     
                 }
             }
             System.out.println("");
         }else if(m.charAt(0) == 2){
             for(Cliente cli:Banco.getInversores()){
                 if (cli.nombre == cliente){
                     
                 }
             }
             System.out.println("");
             
         }else if(m.charAt(0) == 3){
             System.out.println("");
             
         }
         for (int n = 0; n <m.length (); n++) { 
             
         if (m.charAt(n) == c) {
            cont++;
            switch (cont) {
                case 1:
                    ini=n;
                    break;
                
                case 2:
                    fin=n;
                    cliente = m.substring(ini+1,fin);
                    ini=n;
                    System.out.println("El Cliente es " +cliente);
                    break;
                
                case 3:
                    fin=n;
                    empresa = m.substring(ini+1,fin);
                    ini=n;
                    System.out.println("La Empresa es " +empresa);
                    break;
                
                default: System.out.println ("No has elegido una opcion correcta"); 
                    break;   
             
            
            }
            
         }
             
         
     }
     
     
     
     String sub = m.substring(1,4);
     System.out.println(sub);
    
    }
    
    
    public void opImprimirOperaciones(){ //17.imprimir operaciones pendientes
        System.out.println ("Imprimir peticiones pendientes");
        for (int i=0;i<listaPeticiones.size();i++) {
          listaPeticiones.get(i).imprimir();
        }
    }

    
    
}
