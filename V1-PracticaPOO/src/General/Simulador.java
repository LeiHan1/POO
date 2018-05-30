/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package General;

import Banco.*;
import Bolsa.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Adrian
 */
public class Simulador {
    public Banco banco;
    public ArrayList <ClientePremium> listaClientes;
    public AgenteDeInversiones agente;
    public GestorDeInversiones gestor;
    public BolsaDeValores bolsa;
    public int num;
    
    InterfazDeUsuario interfaz = new InterfazDeUsuario();

// --- constructor --- //   
    public Simulador(){
        agente = new AgenteDeInversiones("Ana", "456");
        banco = new Banco("BancoA", "Carlos", "2222");
        gestor = new GestorDeInversiones("Ana", "3333");
        bolsa = new BolsaDeValores("bolsa1");
        ClientePremium Lei = new ClientePremium("Lei", "G123", 2000);
        banco.aniadirInversor(Lei);
        Empresa e1 = new Empresa("EmpresaA", 2000);
        Empresa e2 = new Empresa("EmpresaB", 3500);
        bolsa.aniadirEmpresa(e1);
        bolsa.aniadirEmpresa(e2);
    }

// --- las operaciones del menu --- //
    
//0. salir del programa
    public void opecacion0(){ 
        System.out.println ("Se ha salido del programa.");
        System.exit(0);
    }
//1. mostrar clientes    
    public void operacion1(){ 
        System.out.println ("<< Estado de los clientes >>");
        banco.mostrarClientes(banco.getInversores());
    }
//2. mostrar bolsas
    public void operacion2(){
        System.out.println ("<< Estado de la bolsa >>");
        bolsa.mostrarEmpresas(bolsa.getListaEmpresas());
    }
//3. añadir cliente    
    public void operacion3(){
        Escaner datos = new Escaner();
        System.out.println ("<< Añadir cliente >>");
        String nombre = datos.pedirNombre();
        String dni = datos.pedirDni();
        double saldo = datos.pedirSaldo();        
        ClientePremium cliente = new ClientePremium(nombre, dni, saldo);
        banco.aniadirInversor(cliente);
        System.out.println("El cliente "+ cliente.getNombre()+ " con dni "+ cliente.getDni() + " y saldo " + cliente.getSaldo() + " ha sido añadido");
    }
//4. eliminar cliente    
    public void operacion4(){
        System.out.println ("<< Eliminar cliente >>");
        if (banco.getInversores().isEmpty()){
            System.out.println("No hay ningún cliente.");
        } else {
            Escaner eliminar = new Escaner();
            String nom = eliminar.pedirNombre();
            int i = banco.buscarCliente(nom);
            banco.eliminarInversor(i);
            System.out.println("El cliente "+ nom +" ha sido eliminado");
        }
    }
// realizar copia de seguridad del banco    
/**/    public void operacion5(){
        System.out.println ("<< Realizar copia de seguridad(banco) >>");
        // ! FALTA POR IMPLEMENTAR !
    }
// recuperar informacion de la copia de seguridad del banco    
/**/    public void operacion6(){
        System.out.println ("<< Restaurar copia de seguridad(banco) >>");
        // ! FALTA POR IMPLEMENTAR !
    }
// mejorar un cliente a premium    
    public void operacion7(){
        System.out.println ("<< Mejora cliente a premium >>");
            
        if (banco.getInversores().isEmpty()){
            System.out.println("No hay ningún cliente.");
        } else {
            Escaner c = new Escaner();
            String n = c.pedirNombre();
            banco.hacerClientePremium(n);
        }
    }
// solicitar recomendacion de inversion    
/**/    public void operacion8(){
        System.out.println ("<< Solicita recomendacion de inversion >>");
        // ! FALTA POR IMPLEMENTAR !
    }
//añadir empresa a la bolsa    
    public void operacion9(){
        System.out.println ("<< Añadir empresa a la bolsa >>");
        //bolsa.opAnadirEmpresa();
        Escaner es = new Escaner();
        String nombreEmpresa = es.pedirNomEmpresa();
        double actual = es.pedirValorActual();
        Empresa e = new Empresa(nombreEmpresa,actual);
        bolsa.entrarBolsa(e);
        System.out.println ("Empresa añadida");
        
    }
// eliminar empresa de la bolsa    
    public void operacion10(){
        System.out.println ("<< Eliminar empresa de la bolsa >>");
        if (bolsa.getListaEmpresas().isEmpty()){
            System.out.println ("No hay ninguna empresa.");
        } else{
            Escaner es = new Escaner();
            String nombreE = es.pedirNomEmpresa();
            int i = bolsa.buscarEmpresa(nombreE);
            if (this.bolsa.existeEmpresa() == true){
                this.bolsa.borrarEmpresa(i);
                System.out.println("Empresa eliminada.");
            } else {
                System.out.println("No existe esta empresa.");
            } 
        }// end else
    }

// actualizar valores    
/**/    public void operacion11(){
        System.out.println ("<< Actualizacion de valores >>"); 
        /*
        System.out.println ("introduce nombre de la bolsa");
        Escaner datos = new Escaner();  
        String nombreB = datos.pedirNomBolsa();
        bolsa = new BolsaDeValores(nombreB);
        System.out.println ("bolsa creada");
        bolsa.opAnadirEmpresa();
        bolsa.opActualizacionDeValores();
        */
        // hay que revisar
    }
// realizar copia de seguridad de la bolsa  
    /**
     *
     * @throws java.io.IOException
     */
/**/    public void operacion12() throws IOException{
        System.out.println ("<< Realizar copia de seguridad(bolsa) >>");
        /*
        Escaner datos = new Escaner();  
        String nombreB = datos.pedirNomBolsa();
        bolsa = new BolsaDeValores(nombreB);        
        System.out.println ("bolsa creada");
        */
        bolsa.opRealizarCopia();
    // hay que revisar
    }
// restaurar copia de seguridad
    /**
     *
     * @throws java.io.IOException
     */
/**/    public void operacion13() throws IOException, ClassNotFoundException{
    System.out.println ("<< Restaurar copia de seguridad(bolsa) >>");
        Escaner datos = new Escaner();  
        String nombreB = datos.pedirNombre();
        bolsa = new BolsaDeValores(nombreB);
        System.out.println ("bolsa creada");
        bolsa.opRestaurarCopia();
    // hay que revisar
    }
// solicitar compra de acciones
/**/    public void operacion14(){
        System.out.println ("<< Solicitar compra de acciones >>"); 
        agente.opSolicitaCompraAcciones();  
    // hay que revisar
    }
// solicitar venta de acciones 
/**/    public void operacion15(){
        System.out.println ("<< Solicitar venta de acciones >>");
        agente.opSolicitaCompraAcciones();
        agente.opSolicitaVentaAcciones();
    // hay que revisar
    }
// solicitar actualizacion de valores
/**/    public void operacion16(){
        System.out.println ("<< Solicitar actualizacion de valores >>"); 
    
    // ! FALTA POR IMPLEMENTAR !
        
    }
// imprimir opraciones pendeientes del agente
/**/    public void operacion17(){
        System.out.println ("<< Imprimir operaciones pendientes >>"); 
        agente.opSolicitaCompraAcciones();
        agente.opSolicitaVentaAcciones();
        agente.opImprimirOperaciones();
                     
        // hay que revisar

    }
// ejecutar operaciones pendientes 
/**/    public void operacion18(){
        System.out.println ("<< Ejecutar operaciones pendientes >>");
        // ! FALTA POR IMPLEMENTAR !
    }

    
    public void operacionesSimulador() throws IOException, ClassNotFoundException {
    do {
        num = interfaz.leerOpcion();
        
        switch (num) {
            case 0: //salir
                opecacion0();
  
            //------------------ESTADO------------------
            case 1: //imprimir estado de los listaClientes
                operacion1();
                break;
            
            case 2: // imprimir estado de la bolsa
                operacion2(); 
                break;
            //------------------BANCO------------------
            case 3: // añadir cliente
                operacion3();                
                break;
      
            case 4: // eliminar cliente
                operacion4();
                break;

            case 5: // realizar copia de seguridad del banco
                operacion5();
                break;
            
            case 6: // recuperar informacion de la copia de seguridad del banco
                operacion6();
                break;
            
            case 7: // mejorar un cliente a premium
                operacion7();       
                break;
            
            case 8: // solicitar recomendacion de inversion
                operacion8();
                break;
            //------------------BOLSA------------------
            case 9: // añadir empresa a la bolsa
                operacion9();
                break;
            
            case 10: // eliminar empresa de la bolsa
                operacion10();
                break;
            
            case 11: // actualizar valores
                operacion11();
                break;
            
            case 12: // realizar copia de seguridad de la bolsa 
                operacion12();    
                break;
            
            case 13: // restaurar copia de seguridad
                operacion13();
                break;
            //------------------OPERACIONES------------------
            case 14: // solicitar compra de acciones
                operacion14();
                break;
            
            case 15: // solicitar venta de acciones 

                break;
            
            case 16: // solicitar actualizacion de valores
               
                break;
            //------------------BROKER------------------
            case 17: // imprimir opraciones pendeientes del agente
                
                break;
            
            case 18: // ejecutar operaciones pendientes 

                break;
            
            default: System.out.println ("No has elegido una opcion correcta"); break;
            
        } // end switch 
    
        System.out.println();
        Escaner e = new Escaner();
        e.siguiente();
        interfaz.menu();
    } while (num != 0);
    
    
    
    
    }
    
    
    
}
