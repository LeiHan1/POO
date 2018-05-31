/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bolsa;

import General.Escaner;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
    private boolean existeEmpresa = false;
    //private ArrayList<Banco> listaBancos;
    
    public BolsaDeValores(String nombre){
        
        this.nombreBolsa = nombre;
        listaEmpresas = new ArrayList<>();
        //listaBancos = new ArrayList<>();
    }
    
    public boolean existeEmpresa(){
        return this.existeEmpresa;
    }

    public String getNombreBolsa() {
        return nombreBolsa;
    }
    public void aniadirEmpresa(Empresa i){
        
        listaEmpresas.add(i);
    }
    
    public void borrarEmpresa(int i){
        
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
    public int buscarEmpresaRecomendada(){
        int indice = 0;
        ArrayList<Empresa> lista = this.getListaEmpresas();
        double variacionMax = lista.get(0).getVariacion();
        for (int i = 0; i < this.getListaEmpresas().size(); i++){
            if (variacionMax <= lista.get(i).getVariacion()){
                variacionMax = lista.get(i).getVariacion();
                indice = i;
            }
        }            
        //} // end if else
        return indice;
    }
    
    
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

    
    public void opActualizacionDeValores(){ //11.actualizacion de valores de acciones
        for (Empresa listaEmpresa : listaEmpresas) {
            int aleatorio = (int) Math.floor(Math.random()*(1500-(-1500)+1)+-1500);
            double nuevoValor = listaEmpresa.getValorActual() + aleatorio;
            listaEmpresa.setValorPrevio(listaEmpresa.getValorActual());
            
            listaEmpresa.setValorActual(nuevoValor);
            listaEmpresa.setVariacion(listaEmpresa.getVariacion(), aleatorio);
        }
        System.out.println ("Valores actualizados");
    }

    public void opRealizarCopia() throws IOException{ //12.realizar copia de seguridad
        System.out.println ("Realizar copia de seguridad (bolsa)");
        File archivo;
        
        ObjectOutputStream oss;
        
        
        archivo = new File("Copia de Seguridad de Bolsa");
        try {    
            
            oss = new ObjectOutputStream (new FileOutputStream(archivo));   
            oss.writeObject(listaEmpresas);
            oss.close();
        } catch (IOException ex) { }  
        int datos = listaEmpresas.size();
        System.out.println("Se ha creado una Copia de Seguridad en la carpeta del proyecto con "+ datos+ " Empresas");
        }

    public void opRestaurarCopia() throws FileNotFoundException, IOException {
        ObjectInputStream ois;
        try{   
            ois = new ObjectInputStream( new FileInputStream("Copia de Seguridad de Bolsa"));
            listaEmpresas = (ArrayList<Empresa>) ois.readObject();
        } catch (ClassNotFoundException e){
            System.out.println("No se encuentra el archivo");
            }    
    }
    
    
    
    
}

        
    
        
        


    
    
    
    
    
    
    
    
    
    
    
    

