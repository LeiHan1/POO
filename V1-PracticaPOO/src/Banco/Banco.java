/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Banco;

import General.Escaner;
import Mensajes.*;
import java.util.ArrayList;
import java.io.Serializable;

/**
 *
 * @author sergio
 */
public class Banco implements Serializable {

    private String nombreBanco;
    public static ArrayList<ClientePremium> clientes;
    private final ArrayList<String> Operaciones;
    private AgenteDeInversiones agente;
    private GestorDeInversiones gestorInv; // gestor asignado al cliente premium

    public Banco(String nombre, String nAgente, String dAgente) {
        this.nombreBanco = nombre;
        clientes = new ArrayList<>();
        Operaciones = new ArrayList<>();
        agente = new AgenteDeInversiones(nAgente, dAgente);
    }

    public void setAgente(AgenteDeInversiones agente) {
        this.agente = agente;
    }
    

    public String getNombreBanco() {
        return nombreBanco;
    }

    public void setNombreBanco(String nombre) {
        this.nombreBanco = nombre;
    }

    public static ArrayList<ClientePremium> getInversores() {
        return clientes;
    }
    

    public void aniadirInversor(ClientePremium i) {
        clientes.add(i);
    }

    public void eliminarInversor(ClientePremium i) {
        clientes.remove(i);
    }

    public void eliminarInversor(int i) {
        clientes.remove(i);
    }

    public ClientePremium getCliente(int i) {
        return clientes.get(i);
    }

    public void mostrarClientes(ArrayList<ClientePremium> clientes) {
        if (clientes.isEmpty()) {
            System.out.println("No hay ningún cliente.");
        } else {
            int j = 1;
            for (ClientePremium i : Banco.clientes) {
                System.out.println(j++ + ". " + i/* + ". Nombre: "+i.getNombre()+ "     DNI: "+ i.getDni()+"    Saldo: "+i.getSaldo()*/);
                System.out.println("   Es cliente premium : " + i.isPremium());
                if (i.isPremium() == true) {
                    System.out.println("   Gestor de inversión : " + i.getNomGestor() + "      DNI : " + i.getDniGestor());
                }
                System.out.println();
            } // end for
        } // end if else
    }

    public void hacerClientePremium(ClientePremium cliente) {

        cliente.setPremium(true);
        System.out.println("Introduce el dato del gestor a asignar");

        Escaner gestor = new Escaner();
        String nGestor = gestor.pedirNombreGestor();
        String dniGestor = gestor.pedirDniGestor();

        gestorInv = new GestorDeInversiones(nGestor, dniGestor);
        cliente.asignarGestor(gestorInv);

        System.out.println("El gestor " + gestorInv.getNombre() + " con DNI " + gestorInv.getDni() + " ha sido asignado al cliente " + cliente.getNombre());

    }

//14.solicitar compra de acciones
    public void opSolicitaCompraAcciones(String nombreCliente, String nombreEmpresa, double cantidad) { 
        Mensaje p = new MensajeCompra(nombreCliente, nombreEmpresa, cantidad);
        agente.addMapMensaje(p, "Compra"); 
        
    }
    
//15.solicitar venta de acciones
    public void opSolicitaVentaAcciones(String nombreC, String nombreE, int titulos) { 
        Mensaje p = new MensajeVenta(nombreC, nombreE, titulos);
        agente.addMapMensaje(p, "Venta");
    }
    
//16.solicitar actualizacion de acciones
    public void opSolicitaActualizacion(String nombreBanco, String fecha){
        Mensaje p = new MensajeActualizacion(nombreBanco, fecha);
        agente.addMapMensaje(p, "Actualizacion");   
    }
    
    public AgenteDeInversiones getAgente() {
        return agente;
    }

}
