/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Banco;


import General.Escaner;
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
    
/*    
    public void peticionCompra(Peticion p, ArrayList<String> lista){
        
        String pet = p.toString();
        lista.add(pet);
    }
*/
    
/*    
    public String toString(Peticion p){
        
        String sol = ("Solicitud de compra:\n Identificador: "+p.getId()+".\n Nombre del Cliente: "+p.getNombreCliente()+".\n Nombre de la Empresa: "+p.getNombreEmpresa()+".\n Catidad Maxima: "+p.getCantidadInvertir()+" €");
        return sol;
    }
*/    
    public void guardarDatosBanco(String ruta, ArrayList<Banco> bancos) throws IOException{
        
        ObjectOutputStream file = new ObjectOutputStream(new FileOutputStream (ruta));
        try {
            
            for(Banco b:bancos){
                
                file.writeObject(b);
            }
        } catch (IOException ex) {
            
            System.out.println("Error en la escritura del archivo.");
        }
        finally{
            file.close();
            System.out.println("Archivo guardado correctamente.");
            
        }
        
    }
    
    
}
