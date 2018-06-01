/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mensajes;
/**
 *
 * @author Han Lei
 */
public class MensajeCompra extends Mensaje {
    
    private double cantidadInvertir;
     
    public MensajeCompra(String nC, String nE, double cantidad) {
        this.nombreCliente = nC;
        this.nombreEmpresa = nE;
        this.cantidadInvertir = cantidad;
        this.id = id +1;
        this.texto = (id + "|" + nC +"|"+ nE + "|" + cantidad);
        
    }

    public double getCantidadInvertir() {
        return cantidadInvertir;
    }

    public void setCantidadInvertir(double cantidadInvertir) {
        this.cantidadInvertir = cantidadInvertir;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    @Override
    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }
/*
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
*/
    public static String getTexto() {
        return texto;
    }
    
    @Override
    public void imprimir(){
        System.out.println(id+"|"+nombreCliente + "|"+nombreEmpresa + "|" +cantidadInvertir);
    }

}
