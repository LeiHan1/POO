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

    
    
    
    public String intentaOperacion(String mensajeCodificado){
        
        String sId= mensajeCodificado.substring(38);
        String sCliente= mensajeCodificado.substring(62);
        String sEmpresa= mensajeCodificado.substring(86);
        String sCantidad= mensajeCodificado.substring(104);
        String mensajeCod = (sId+" | "+sCliente+" | "+sEmpresa+" | "+sCantidad);
        return mensajeCod;
    }
    
    public void opSolicitaCompraAcciones(){ //14.solicitar compra de acciones
    //solicitar datos
        Escaner es = new Escaner();
        System.out.println ("Solicitar compra de acciones");
        String nombreCliente = es.pedirNombre();
 
        String nombreEmpresa = es.pedirNomEmpresa();

        double cantidad = es.pedirCantidadAccion();

        
    //hay que anadir la condicion de que si existe el cliente y tiene saldo
        Mensaje p = new MensajeCompra(nombreCliente, nombreEmpresa, cantidad);
        listaPeticiones.add(p);
        //System.out.println(MensajeCompra.getTexto());
        //System.out.println(listaPeticiones);
        p.imprimir();
    }
    
    public void opSolicitaVentaAcciones(){ //15.solicitar venta de acciones
    //solicitar datos
        System.out.println ("Solicitar venta de acciones");
        Escaner es = new Escaner();
        String nombreC = es.pedirNombre();
        
        String nombreE = es.pedirNomEmpresa();
        
        double titulos = es.pedirTitulosVender();
        
    //almacenar en la lista    
    //hay que anadir la condicion de que si existe el cliente y tiene saldo
        Mensaje p = new MensajeVenta(nombreC, nombreE, titulos);
        listaPeticiones.add(p);
        //System.out.println();
        p.imprimir();
    
    }
    
    public void opSolicitaActualizacionAcciones(){ //16.solicitar actualizacion de acciones
    // falta por hacer
    
    }
    
    
    public void opImprimirOperaciones(){ //17.imprimir operaciones pendientes
        System.out.println ("Imprimir peticiones pendientes");
        for (int i=0;i<listaPeticiones.size();i++) {
          listaPeticiones.get(i).imprimir();
        }
        
            
        
    
    
    
    }

    
}
