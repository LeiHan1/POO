package General;
import java.util.Scanner;

 
public class InterfazDeUsuario {
    
    public void menu(){
        
        int i = 0;
            System.out.println("<<<<<<< BIENVENIDO AL MENU >>>>>>>");
            System.out.println(i+++".- Salir");
            System.out.println("----------------- ESTADO -------------------");
            System.out.println(i+++".- Imprimir estado de los clientes.");
            System.out.println(i+++".- Imprimir estado de la bolsa.");
            System.out.println("----------------- BANCO --------------------");
            System.out.println(i+++".- Añadir cliente.");
            System.out.println(i+++".- Eliminar cliente.");
            System.out.println(i+++".- Realizar copia de seguridad.");
            System.out.println(i+++".- Restaurar copia de seguridad.");
            System.out.println(i+++".- Mejorar a cliente premium.");
            System.out.println(i+++".- Solicitar recomendacion de inversion.");
            System.out.println("----------------- BOLSA --------------------");
            System.out.println(i+++".- Añadir empresa a la bolsa.");
            System.out.println(i+++".- Eliminar empresa de la bolsa.");
            System.out.println(i+++".- Actualizacion de valores.");
            System.out.println(i+++".- Realizar copia de seguridad.");
            System.out.println(i+++".- Restaurar copia de seguridad.");
            System.out.println("--------------- OPERACIONES ----------------");
            System.out.println(i+++".- Solicitar compra de acciones.");
            System.out.println(i+++".- Solicitar venta de acciones.");
            System.out.println(i+++".- Solicitar actualizacion de valores.");
            System.out.println("----------------- BROKER -------------------");
            System.out.println(i+++".- Imprimir operaciones pendientes.");
            System.out.println(i+++".- Ejecutar operaciones pendientes.");
            System.out.println("--------------------------------------------");
            System.out.println();
            System.out.print("Escoger opción: ");
            
        }
   
    public int leerOpcion(){
        Scanner numero = new Scanner(System.in);
        int num = numero.nextInt();
        return num;
    }


} 
    

