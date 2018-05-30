/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bolsa;

import General.Escaner;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
//import Banco.*;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
/**
 *
 * @author sergio
 */
public class BolsaDeValores implements Serializable{
    
    private String nombreBolsa;
    private ArrayList<Empresa> listaEmpresas;
    boolean existeEmpresa = false;
    //private ArrayList<Banco> listaBancos;
    
    public BolsaDeValores(String nombre){
        
        this.nombreBolsa = nombre;
        listaEmpresas = new ArrayList<>();
        //listaBancos = new ArrayList<>();
    }

    public String getNombreBolsa() {
        return nombreBolsa;
    }
    public void aniadirEmpresa(Empresa i){
        
        listaEmpresas.add(i);
    }
    
    public void borrarEmpresa(Empresa i){
        
        listaEmpresas.remove(i);
    }
    
    public void setNombreBolsa(String nombreBolsa) {
        this.nombreBolsa = nombreBolsa;
    }

    public ArrayList<Empresa> getListaEmpresas() {
        return listaEmpresas;
    }

    public void setListaEmpresas(ArrayList<Empresa> listaEmpresas) {
        this.listaEmpresas = listaEmpresas;
    }
    
    public void mostrarEmpresas(ArrayList<Empresa> empresa){
        if (empresa.isEmpty()){
            System.out.println("No hay ninguna empresa.");
        } else{
            int j = 1;
            for(Empresa i:listaEmpresas){
                System.out.println(j++ +". Nombre Empresa: "+i.getNombre()+ " Valor actual: " +i.getValorActual()+ " Variacion: "+ i.getVariacion());
            }
        }
    }
/*    
    public void aniadirBanco(Banco b){
        
        listaBancos.add(b);
    }
    public void borrarBanco(Banco b){
        
        listaBancos.remove(b);
    }
*/    
    public void entrarBolsa(Empresa e){
        
        listaEmpresas.add(e);
    }
    
    public void borraEmpresa(Empresa e){
        
        listaEmpresas.remove(e);
    }
/*
    public ArrayList<Banco> getListaBancos() {
        return listaBancos;
    }

    public void setListaBancos(ArrayList<Banco> listaBancos) {
        this.listaBancos = listaBancos;
    }
*/    
    public void guardarDatos(String ruta, BolsaDeValores b) throws IOException{
        
        ObjectOutputStream file = new ObjectOutputStream(new FileOutputStream (ruta));
        try {          
                file.writeObject(b);               
        } catch (IOException ex) {            
            System.out.println("Error en la escritura del archivo. Codigo de error:"+ex);
        }
        finally{            
            file.close();            
        }        
    }
    
    public void cargarDatos(String ruta)throws IOException, ClassNotFoundException{
        
        ObjectInputStream file = new ObjectInputStream(new FileInputStream(ruta));        
        try {
            file.readObject();
        }        
        catch(IOException ex){            
            System.out.println("Error en la lectura del archivo.");
        }
        catch(ClassNotFoundException e){          
            System.out.println("Error en la lectura del fichero.");
        }
        finally{
            file.close();
        }
    }
/*    
    public void cargarDatosBancos(String ruta)throws IOException{
        
        ObjectInputStream file = new ObjectInputStream(new FileInputStream(ruta));
        Banco b;
        try {
            while(true){
            b = (Banco)file.readObject();
            listaBancos.add(b);
            }
        }        
        catch(IOException ex){            
            System.out.println("Error en la lectura del archivo.");
        }
        catch(ClassNotFoundException e){           
            System.out.println("Error en la lectura del fichero.");
        }
        finally{
            file.close();
        }
    }
*/
    
    public void opAnadirEmpresa(){ //9.anadir empresa a la bolsa
        Escaner es = new Escaner();
        String nombreEmpresa = es.pedirNomEmpresa();
        double actual = es.pedirValorActual();
        Empresa e = new Empresa(nombreEmpresa,actual);
        entrarBolsa(e);
        System.out.println ("Empresa añadida");
        
    }
    
    public int buscarEmpresa(String nombreEmpresa){
        int indice = 0;
            for (int i = 0; i < this.getListaEmpresas().size(); i++){
                if (nombreEmpresa.equals(this.getListaEmpresas().get(i).getNombre())){
                    indice = i;
                    this.existeEmpresa = true;
                    break;
                } else {
                    this.existeEmpresa = false;
                } 
            }
        //} // end if else
        return indice;
    }
    
    
    public void opEliminarEmpresa(){ //10.eliminar empresa a la bolsa
        Escaner es = new Escaner();
        String nombreE = es.pedirNomEmpresa();
        int i = buscarEmpresa(nombreE);
            if (this.existeEmpresa == true){
                this.getListaEmpresas().remove(i);
                System.out.println("Empresa eliminada.");
            } else {
                System.out.println("No existe esta empresa.");
            }
        
        /*
        for (Empresa listaEmpresa : listaEmpresas) {
            
            //buscar elemento por nombre
                if (listaEmpresa.getNombre().equals(nombreE)){
                    borraEmpresa(listaEmpresa);
                    System.out.println ("Empresa eliminada");
                    break;
                } else {
                    System.out.println ("La empresa "+ nombreE + " no existe");
                }
        }
*/
        
            
    }
    
    public void opActualizacionDeValores(){ //11.actualizacion de valores de acciones
        System.out.println ("Actualizacion de valores de las empresas");
        double min = 0;
        double max = 150;
        for (Empresa listaEmpresa : listaEmpresas) { //buscar elemento por nombre
            double nuevoValor = ThreadLocalRandom.current().nextDouble(min, max);
            listaEmpresa.setValorPrevio(listaEmpresa.getValorActual());
            listaEmpresa.setValorActual(nuevoValor);
            System.out.println ("Valores actualizadas");
        }
    }
    public void opRealizarCopia() throws IOException{ //12.realizar copia de seguridad
        //System.out.println ("Realizar copia de seguridad (bolsa)");
        System.out.println ("Introduce la ruta");
        Scanner scanner = new Scanner(System.in);
        String ruta = scanner.nextLine();
        
        ObjectOutputStream file = new ObjectOutputStream(new FileOutputStream (ruta));
        try {          
            file.writeObject(listaEmpresas);                
        } catch (IOException ex) {            
            System.out.println("Error en la escritura del archivo. Codigo de error:"+ex);
        }
        finally{            
            file.close();            
        }        
    }
    
    public void opRestaurarCopia()throws IOException, ClassNotFoundException{ //13.restaurar copia de seguridad
        System.out.println ("Restaurar copia de seguridad (bolsa)");
        System.out.println ("Introduce la ruta");
        Scanner scanner = new Scanner(System.in);
        String ruta = scanner.nextLine();
        
        ObjectInputStream file = new ObjectInputStream(new FileInputStream(ruta));
        try {
            file.readObject();
        }        
        catch(IOException ex){            
            System.out.println("Error en la lectura del archivo.");
        }
        catch(ClassNotFoundException e){          
            System.out.println("Error en la lectura del fichero.");
        }
        finally{
            file.close();
        }
        
    
    }
    
    
    
    
    
    
    
    
    
    
    
    
}
