/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mensajes;

/**
 *
 * @author Adrian
 */
public class MensajeRespuestaCompra extends MensajeCompra{
    boolean sePuedeComprar;
    int nTituloComprado;
    double dineroSobrado;
    double precioAccion;
    
    public MensajeRespuestaCompra(int id, String nC, String nE, double cantidad, boolean b, int accionesCompradas, double accion, double restante) {
        super(nC, nE, cantidad);
        sePuedeComprar = b;
        System.out.println(id+"|"+nC+"|"+nE+"|"+cantidad+"|"+b+"|"+accionesCompradas+"|"+accion+"|"+restante);
  
    }
    /*
    public void formarMensaje(){
        nTituloComprado = (int)(precioAccion/this.cantidadInvertir);
        dineroSobrado = (precioAccion%this.cantidadInvertir);
    
    }
*/

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getNombreCliente() {
        return nombreCliente;
    }

    @Override
    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    @Override
    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    @Override
    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public double getCantidadInvertir() {
        return cantidadInvertir;
    }

   

    @Override
    public void imprimir(){
        
    //    System.out.println( id+" |"+nombreCliente + "|"+nombreEmpresa + "|" +numTitulos);
    }

     @Override
    public String toString(){
        if (sePuedeComprar == true){
            return (id+"|"+nombreCliente + "|"+nombreEmpresa+ "|" + cantidadInvertir +"|"+ sePuedeComprar + "|"+nTituloComprado+"|"+precioAccion+"|"+dineroSobrado);
        } else {
            return (id+"|"+nombreCliente + "|"+nombreEmpresa+ "|" + cantidadInvertir +"|"+ sePuedeComprar);
        }
       
    }
   
}
