/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package General;
/*
 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Scanner;
/**
 *
 * @author Adrian
 */
public class Escaner {

    //private Scanner es = new Scanner(System.in);

    public int pedirNum() {
        Scanner n = new Scanner(System.in);
        int num = n.nextInt();
        return num;
        
    }
    
    public String pedirNombre() {
        String nom;
        System.out.println("Escribe el nombre del cliente");
        Scanner nombre = new Scanner(System.in);
        nom = nombre.nextLine();
        return nom;
        
    }
    
    public String pedirDni() {
        System.out.println("Escribe el dni del cliente");
        Scanner documentonacional = new Scanner(System.in);
        String dni = documentonacional.nextLine();
        return dni;
}
   
    public double pedirSaldo() {
        double saldo;
        System.out.println("Escribe el saldo del cliente en Euros");
        Scanner dinero = new Scanner(System.in);
        saldo = dinero.nextDouble();
        return saldo;
}

  
    public String pedirRuta() {
        String ruta;
        System.out.println("Escribe la ruta donde guardar los datos:");
        Scanner direccion = new Scanner(System.in);
        ruta = direccion.nextLine();
        return ruta;
        
 
    }
    public String pedirNombreGestor() {
        String nom;
        System.out.println("Escribe el nombre del gestor");
        Scanner nombreG = new Scanner(System.in);
        nom = nombreG.nextLine();
        return nom;
        
    }
    
    public String pedirDniGestor() {
        String dni;
        System.out.println("Escribe el dni del gestor");
        Scanner documentonacionalG = new Scanner(System.in);
        dni = documentonacionalG.nextLine();
        return dni;
    }
    
    public String pedirNomEmpresa() {
        String nomEmpresa;
        System.out.println("Escribe el nombre de la empresa");
        Scanner empresa = new Scanner(System.in);
        nomEmpresa = empresa.nextLine();
        return nomEmpresa;
        
    }
    
    public double pedirValorActual() {
        double valor;
        System.out.println("Escribe el valor actual de la empresa");
        Scanner actual = new Scanner(System.in);
        valor = actual.nextDouble();
        return valor;
    }
    
    public String pedirNomBolsa() {
        String nom;
        System.out.println("Escribe el nombre de la bolsa");
        Scanner nombre = new Scanner(System.in);
        nom = nombre.nextLine();
        return nom;
        
    }
    
    public double pedirCantidadAccion() {
        double valor;
        System.out.println("Introduce la cantidad a invertir: ");
        Scanner actual = new Scanner(System.in);
        valor = actual.nextDouble();
        return valor;
    }
    
    public int pedirTitulosVender() {
        int valor;
        System.out.println("Introduce los titulos a vender: ");
        Scanner actual = new Scanner(System.in);
        valor = actual.nextInt();
        return valor;
    }
    
    public void siguiente() {
        System.out.println("- Operacion finalizada, pulse la tecla intro para volver al menu -");
        Scanner intro = new Scanner(System.in);
        intro.nextLine();
    }
    
    
}
    
