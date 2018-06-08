/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Banco;

import Bolsa.BolsaDeValores.*;
import Bolsa.Empresa;
import General.Escaner;
import Mensajes.Mensaje;
import Mensajes.MensajeCompra;
import Mensajes.MensajeVenta;
    import java.util.ArrayList;
    import java.io.Serializable;
/**
 *
 * @author sergio
 */
public class Banco implements Serializable{
    
    private String nombreBanco;
    private static ArrayList <ClientePremium> clientes;
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

    public static ArrayList<ClientePremium> getInversores() {
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
            for(ClientePremium i:Banco.clientes){
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
    
  
   
    public int opSolicitaCompraAcciones(){ //14.solicitar compra de acciones
    //solicitar datos
        Escaner es = new Escaner();
        System.out.println ("Solicitar compra de acciones");
        
        String nombreCliente = es.pedirNombre();
        
        buscarCliente(nombreCliente);
        if (this.existeCliente == true){}
            else{
                System.out.println ("El cliente no existe");
                return 0;
            }
        
        
        
        String nombreEmpresa = es.pedirNomEmpresa();
       
        for (Empresa em: Bolsa.BolsaDeValores.getListaEmpresas()){
            while (em.getNombre().equals(nombreEmpresa)){
            
                double cantidad = es.pedirCantidadAccion();
                    for (ClientePremium s:Banco.getInversores()){
                        while (s.getNombre().equals(nombreCliente)){
                            if (s.getSaldo()>cantidad){
                                Mensaje p = new MensajeCompra(nombreCliente, nombreEmpresa, cantidad);
                                agente.addMapMensaje(p, "Compra");
                                p.imprimir();
                                return 0;
                            }
                            else{
                            System.out.println ("Tiene menos dinero del que desea invertir");
                            return 0;
                        }
                        } 
                        
                    }  
            }
            
        }
        System.out.println ("No existe la empresa");
        return 0;
        
    }

    public int opSolicitaVentaAcciones(){ //15.solicitar venta de acciones
    //solicitar datos
        System.out.println ("Solicitar venta de acciones");
        Escaner es = new Escaner();
        String nombreC = es.pedirNombre();
        buscarCliente(nombreC);
        if (this.existeCliente == true){}
            else{
                System.out.println ("El cliente no existe");
                return 0;
            }
        
        String nombreE = es.pedirNomEmpresa();
        for (Empresa em: Bolsa.BolsaDeValores.getListaEmpresas()){
            while (em.getNombre().equals(nombreE)){
            
                int titulos = es.pedirTitulosVender();
                    for (ClientePremium s:Banco.getInversores()){
                    int Titulosquetiene = 0; //llamar a los titulos que tiene cada cliente
                        if (titulos>Titulosquetiene){
                        Mensaje p = new MensajeVenta(nombreC, nombreE, titulos);
                        agente.addMapMensaje(p, "Venta");
                        p.imprimir();
                        return 0;
                        } 
                        else{
                            System.out.println ("Tiene menos dinero del que desea invertir");
                            return 0;
                        }
                    }  
            }
            
        }
        System.out.println ("No existe la empresa");
        return 0;
        
    }
        
        /*int titulos = es.pedirTitulosVender();
        Mensaje p = new MensajeVenta(nombreC, nombreE, titulos);
        //agente.getListaPeticiones().add(p);
        //System.out.println();
        agente.addMapMensaje(p, "Venta");
        p.imprimir();
        return 0;*/
        
    

    public AgenteDeInversiones getAgente() {
        return agente;
    }
    
        
    }
    
    
