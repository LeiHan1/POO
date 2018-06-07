/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Banco;
import General.*;
import Mensajes.*;
import Bolsa.BolsaDeValores;
import Bolsa.Empresa;
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
         String barra= "|";
         char c = barra.charAt(0);
         char s;
         String id = null;
         String cliente = null;
         String empresa = null;
         String cantInver = null;
         int n = 0;
         String numTitulos = null;
         while (m.charAt(n) < m.length()){
             s = m.charAt(n);
             id = id + s;
             if(m.charAt(n) == c){
                 n++;
             }
         }
        while (m.charAt(n) < m.length()){
              s = m.charAt(n);
             cliente = cliente + s;
             if(m.charAt(n) == c){
                 n++;
             }   
        }
        while (m.charAt(n) < m.length()){
             s = m.charAt(n);
             empresa = empresa + s;
             if(m.charAt(n) == c){
                 n++;
             }
         }
        for(Mensaje me:listaPeticiones){
            
            if (me.getNombreCliente().equals(cliente) && (me.getId() == 1)){
                while (m.charAt(n) < m.length()){
                     s = m.charAt(n);
                     cantInver = cantInver + s;
             }
            }else if (me.getNombreCliente().equals(cliente) && (me.getId() == 2)){
                     while (m.charAt(n) < m.length()){
                     s = m.charAt(n);
                     numTitulos = numTitulos + s;
                     int num = Integer.parseInt(numTitulos);
                     }
                     }
        }
         BolsaDeValores e = null;
         Banco cl = null;
         double cantidad = Double.parseDouble(cantInver);
         int idd = Integer.parseInt(id);
         
         for(Empresa em:e.getListaEmpresas()){
            if(em.getNombre().equals(empresa)){
                PaqueteDeAcciones p = new PaqueteDeAcciones(em.getNombre(), (int) (cantidad/em.getValorActual()),em.getValorActual());
                }
            }
         for(Cliente cli:cl.getInversores()){
            if(idd == 1){
                 
                 if (cli.nombre.equals(cliente)){
                     cli.setSaldo(cli.getSaldo() - cantidad);
                     cli.getCartera().add(p);
                     
                 }
             }
             System.out.println("");
         }
         if(idd == 2){
             for(Empresa em:e.getListaEmpresas()){
                if(em.getNombre().equals(empresa)){
                   double val = em.getValorActual();
                }
            }
         for(Cliente clii:cl.getInversores()){
                 
                 if (clii.nombre.equals(cliente)){
                     
                     clii.setSaldo(clii.getSaldo() - (num * val));
                     cli.getCartera().add(p);
                     
                 }
                  
                 
             }
                     
                 }
             
             System.out.println("");
             
         }
        /* for (int n = 0; n <m.length (); n++) { 
             
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
             
         
     }*/
     
     
     
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
