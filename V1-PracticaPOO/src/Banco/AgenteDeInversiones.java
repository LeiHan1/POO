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

    public ArrayList<Mensaje> getListaPeticiones() {
        return listaPeticiones;
    }

  
     public void intentaOperacion(String m){ //18. ejecutar operacion
        String barra= "|";
        char bar = barra.charAt(0); //transformar la barra de string a char
        char c; // sacar del string caracter por carater para ver donde estan las barras y separar los campos
        String cantInver = null;
        int ini = 0;
        int n = 0;
        String numTitulos = null;
        while (n < m.length() &&  m.charAt(n)!=bar){ // sacar el campo id del string
            n++;
        }
        String id = m.substring(ini,n);
        System.out.println (id);        
        n++;
        ini = n;
 
        while (n < m.length() &&  m.charAt(n)!=bar){ // sacar el campo cliente del string
            n++;
        }
        
        String cliente = m.substring(ini,n);
        System.out.println (cliente);
        n++;
        ini = n;
        while (n < m.length() &&  m.charAt(n)!=bar){ // sacar el campo empresa del string
            n++;
        }
        String empresa = m.substring(ini,n);
        System.out.println (empresa);
        
        String precio = m.substring(n+1, m.length());
        double d = Double.parseDouble(precio);
        System.out.println (d);
        
        
        
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
             
             System.out.println("");
             String sub = m.substring(1,4);
        System.out.println(sub);
        */     
    
     } // END INTENTA OPERACION
    
     
     
     
        /* 
        for (int n = 0; n <m.length (); n++) { 
             
         if (m.charAt(n) == bar) {
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
     
     
     
     
    
    

    
    public void opImprimirOperaciones(){ //17.imprimir operaciones pendientes
        System.out.println ("Imprimir peticiones pendientes");
        for (int i=0;i<listaPeticiones.size();i++) {
          listaPeticiones.get(i).imprimir();
        }
    }

    
    
}
