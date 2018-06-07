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
import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;
import java.util.HashSet;
import java.util.Iterator;

/**
 *
 * @author sergio
 */
public class AgenteDeInversiones extends Persona {
    
    private final HashMap<Mensaje, String> mensajes = new HashMap<>();
    
    public AgenteDeInversiones (String n, String d){
        this.nombre = n;
        this.dni = d;
    }

    
    public void addMapMensaje (Mensaje m, String s){
        mensajes.put(m, s);
    };
    
     public void intentaOperacion(Mensaje k, String v){ //18. ejecutar operacion
        String barra= "|";
                String m = k.toString();
                char bar = barra.charAt(0); //transformar la barra de string a char
                int ini = 0;
                int count = 0;
                int id = 0;
                String cliente = null;
                String empresa = null;
                for (int n = 0; n < m.length (); n++) { 
             
                    if (m.charAt(n) == bar) {
                        count++;
                        switch (count) {
                            case 1: // campo del id
                                String idAux = m.substring(ini,n);
                                ini = n;
                                id = Integer.parseInt(idAux);
                                //System.out.println("El id es " + id);
                            break;
                
                            case 2: // campo del cliente
                                cliente = m.substring(ini+1,n);                    
                                ini = n;
                                //System.out.println("El Cliente es " +cliente);
                                break;
                
                            case 3: // campo de la empresa
                                empresa = m.substring(ini+1,n);
                                ini = n;
                                //System.out.println("La Empresa es " +empresa);
                                break;
                
                            default: break;   
                        } // end switch
                    } // end if            
                } // end for  
                String numAux = m.substring(ini+1,m.length());
                
                switch (v){
                    case "Compra": 
                        double cantidad = Double.parseDouble(numAux);
                        
/* hay que añadir una condicion de que si cantidad > precio de la accion se crea el mensaje
    boolean b = (cantidad > accion)? true : false;                    
    Mensaje resCompra = new MensajeRespuestaCompra(cliente, empresa, cantidad, b);
    
*/
                        Mensaje resCompra = new MensajeRespuestaCompra(cliente, empresa, cantidad, true, 3555);
                        resCompra.setId(id);
                        //System.out.println ("El precio es " + cantidad);
                        System.out.println ("Id: " + resCompra.getId());
                        System.out.println ("Cliente: " + resCompra.getNombreCliente());
                        System.out.println ("Empresa: " + resCompra.getNombreEmpresa());
                        System.out.println (resCompra.toString());
                        
                        
                        break;
                        
                    default: break;
                
                
                }
        
        /*
        int num = 0;
        for(Mensaje me:listaPeticiones){ // sacar el campo de cantidad invertida/titulos a vender
            
            if (me.getNombreCliente().equals(cliente) && (me.getId() == 1)){
                while (m.charAt(n) < m.length()){
                     c = m.charAt(n);
                     cantInver = cantInver + c;
             }
            }else if (me.getNombreCliente().equals(cliente) && (me.getId() == 2)){
                     while (m.charAt(n) < m.length()){
                     c = m.charAt(n);
                     numTitulos = numTitulos + c;
                     num = Integer.parseInt(numTitulos);
                     }
            } // end else
        } // end for
         BolsaDeValores e = null;
         Banco cl = null;
         double cantidad = Double.parseDouble(cantInver);
         int idd = Integer.parseInt(id);
         
         PaqueteDeAcciones p = new PaqueteDeAcciones();
         for(Empresa em:e.getListaEmpresas()){
            if(em.getNombre().equals(empresa)){
                p = new PaqueteDeAcciones(em.getNombre(), (int) (cantidad/em.getValorActual()),em.getValorActual());
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
         double val = 0; 
         if(idd == 2){
             for(Empresa em:e.getListaEmpresas()){
                if(em.getNombre().equals(empresa)){
                   val = em.getValorActual();
                }
            }
             
         for(Cliente cli:cl.getInversores()){
                 
                 if (cli.nombre.equals(cliente)){
                     
                     cli.setSaldo(cli.getSaldo() - (num * val));
                     cli.getCartera().add(p);
                     
                 }
                  
                 
             }
                     
                 }
             
          
        */     
    
     } // END INTENTA OPERACION
    
     

     public void opImprimirOperaciones(){ //17.imprimir operaciones pendientes
        System.out.println ("Imprimir peticiones pendientes:");
            mensajes.forEach((k,v) -> System.out.println("Key: " + k.toString() + ";    Value: " + v));
        }
    
     
     public void vaciarLista(){ //17.imprimir operaciones pendientes
        System.out.println ("Ejecutando la lista de peticiones");
        mensajes.forEach((k,v) ->
           {
               intentaOperacion(k,v); 
               
               
        }); //end for each
        
    
    
    
    }



}
     
