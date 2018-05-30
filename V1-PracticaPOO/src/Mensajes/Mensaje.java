/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mensajes;

/**
 *
 * @author sergio
 */
public class Mensaje {
    
    protected String nombreCliente;
    protected String nombreEmpresa;
    protected int id;

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }
/*
    public double getCantidadInvertir() {
        return cantidadInvertir;
    }

    public void setCantidadInvertir(double cantidadInvertir) {
        this.cantidadInvertir = cantidadInvertir;
    }
*/
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public void imprimir(){}
    
/*
    public double getNumTitulos() {
        return numTitulos;
    }

    public void setNumTitulos(double numTitulos) {
        this.numTitulos = numTitulos;
    }
*/    
    
    
}
