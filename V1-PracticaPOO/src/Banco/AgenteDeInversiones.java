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
    
    private static ArrayList<Mensaje>listaPeticiones;
    
    public AgenteDeInversiones (String n, String d){
        this.nombre = n;
        this.dni = d;
        listaPeticiones = new ArrayList<>();
    }
    
    //public String codificacionPeticion(Mensaje p){}

    public static int getTamañoListaPeticiones() {
        return listaPeticiones.size();
    }

    public void setListaPeticiones(ArrayList<Mensaje> listaPeticiones) {
        this.listaPeticiones = listaPeticiones;
    }
    
    public Mensaje recatarMensajeBanco(){
        
        return listaPeticiones.get(0);
    }
    
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

    //almacenar en la lista    
    //hay que anadir la condicion de que si existe el cliente y tiene saldo
        Mensaje p = new MensajeCompra(nombreCliente, nombreEmpresa, cantidad);
        listaPeticiones.add(p);
    }
    
    public void opSolicitaVentaAcciones(){ //15.solicitar venta de acciones
    //solicitar datos
        System.out.println ("Solicitar venta de acciones");
        System.out.print ("Introduce el nombre del cliente: ");
        Scanner scanner = new Scanner(System.in);
        String nombreC = scanner.nextLine();
        System.out.print ("Introduce el nombre de la empresa: ");
        String nombreE = scanner.nextLine();
        System.out.print ("Introduce titulos a vender: ");
        int titulos = scanner.nextInt();
    //almacenar en la lista    
    //hay que anadir la condicion de que si existe el cliente y tiene saldo
        Mensaje p = new MensajeVenta(nombreC, nombreE, titulos);
        listaPeticiones.add(p);
    
    }
    
    public void opSolicitaActualizacionAcciones(){ //16.solicitar actualizacion de acciones
    // falta por hacer
    
    }
    
    
    public void opImprimirOperaciones(){ //17.imprimir operaciones pendientes
        System.out.println ("Imprimir peticiones pendientes");
        for (Mensaje p : listaPeticiones) {
            p.imprimir();
        }
    
    
    
    }
    
}
