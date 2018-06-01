/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Banco;


import General.Escaner;
import Mensajes.Mensaje;
import Mensajes.MensajeCompra;
import Mensajes.MensajeVenta;
    import java.util.ArrayList;
    import java.io.ObjectOutputStream;
    import java.io.ObjectInputStream;
    import java.io.FileInputStream;
    import java.io.FileOutputStream;
    import java.io.IOException;
    import java.io.Serializable;
    import java.util.logging.Level;
    import java.util.logging.Logger;
/**
 *
 * @author sergio
 */
public class Banco implements Serializable{
    
    private String nombreBanco;
    private final ArrayList <ClientePremium> clientes;
    private ArrayList <String> Operaciones;
    private AgenteDeInversiones agente;
    //private int indice = 0; // indice del cliente en el array
    private boolean existeCliente = false;
    private GestorDeInversiones gestorInv; // gestor asignado al cliente premium
    
    public Banco (String nombre, String nAgente, String dAgente){    
        this.nombreBanco = nombre;
        clientes = new ArrayList<>();
        Operaciones = new ArrayList<>();
        agente = new AgenteDeInversiones(nAgente, dAgente);
    }

    public String getNombreBanco() {
        return nombreBanco;
    }

    public void setNombreBanco(String nombre) {
        this.nombreBanco = nombre;
    }

    public ArrayList<ClientePremium> getInversores() {
        return clientes;
    }
    
    public void aniadirInversor(ClientePremium i){
        clientes.add(i);
    }
    
    public void eliminarInversor(ClientePremium i){
        clientes.remove(i);
    }
    
    public void eliminarInversor(int i){
        clientes.remove(i);
    }
    
    public ClientePremium getCliente(int i){
        return clientes.get(i); 
    }
    
    
    public int buscarCliente(String nombreCliente){
        /*if (clientes.isEmpty()){
            System.out.println("No existe ningún cliente.");
        } else {*/
        int indice = 0;
            for (int i = 0; i < this.getInversores().size(); i++){
                if (nombreCliente.equals(this.getInversores().get(i).getNombre())){
                    indice = i;
                    this.existeCliente = true;
                    break;
                } else {
                    this.existeCliente = false;
                } 
            }
        //} // end if else
        return indice;
    }
    
    public boolean existeCliente(){
        return this.existeCliente;
    }
    
    public void mostrarClientes(ArrayList<ClientePremium> clientes){
        if (clientes.isEmpty()){
            System.out.println("No hay ningún cliente.");
        } else {
            int j = 1;
            for(ClientePremium i:this.clientes){
                System.out.println(j++ +". " +i/* + ". Nombre: "+i.getNombre()+ "     DNI: "+ i.getDni()+"    Saldo: "+i.getSaldo()*/);
                System.out.println("   Es cliente premium : " + i.isPremium());
                if (i.isPremium() == true) {
                    System.out.println("   Gestor de inversión : " + i.getNomGestor() + "      DNI : " + i.getDniGestor());
                }
                System.out.println();
            } // end for
        } // end if else
    }
    
    public void hacerClientePremium(String nombreCliente){
        
        int indiceCliente = buscarCliente(nombreCliente);
        if (this.existeCliente == true){
            this.getInversores().get(indiceCliente).setPremium(true);
            System.out.println ("Introduce el dato del gestor a asignar");
            
            Escaner gestor = new Escaner();
            String nGestor = gestor.pedirNombreGestor();
            String dniGestor = gestor.pedirDniGestor();

            gestorInv = new GestorDeInversiones(nGestor, dniGestor);
            ClientePremium cPremium = this.getCliente(indiceCliente);
            cPremium.asignarGestor(gestorInv);
            
            System.out.println ("El gestor " + gestorInv.getNombre() + " con DNI " + gestorInv.getDni() + " ha sido asignado al cliente " + cPremium.getNombre());
        } else {
            System.out.println ("No existe el cliente.");  
        }
     
    }
    
public void opSolicitaCompraAcciones(){ //14.solicitar compra de acciones
    //solicitar datos
        Escaner es = new Escaner();
        System.out.println ("Solicitar compra de acciones");
        String nombreCliente = es.pedirNombre();
        
        
 
        String nombreEmpresa = es.pedirNomEmpresa();

        double cantidad = es.pedirCantidadAccion();

        
    
        Mensaje p = new MensajeCompra(nombreCliente, nombreEmpresa, cantidad);
        agente.getListaPeticiones().add(p);
   
        p.imprimir();
    }
    
    public void opSolicitaVentaAcciones(){ //15.solicitar venta de acciones
    //solicitar datos
        System.out.println ("Solicitar venta de acciones");
        Escaner es = new Escaner();
        String nombreC = es.pedirNombre();
        
        String nombreE = es.pedirNomEmpresa();
        
        int titulos = es.pedirTitulosVender();
        
    
        Mensaje p = new MensajeVenta(nombreC, nombreE, titulos);
        agente.getListaPeticiones().add(p);
        //System.out.println();
        p.imprimir();
    
    }

    public AgenteDeInversiones getAgente() {
        return agente;
    }
    
        
    }
    
    
