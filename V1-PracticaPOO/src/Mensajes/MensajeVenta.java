/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mensajes;

import Banco.AgenteDeInversiones;
import Mensajes.Mensaje;

/**
 *
 * @author Han Lei
 */
public class MensajeVenta extends Mensaje{
    private double numTitulos;
    
    public MensajeVenta(String nC, String nE, double titulos) {
        this.nombreCliente = nC;
        this.nombreEmpresa = nE;
        this.numTitulos = titulos;
        this.id = id + 1;
        this.texto = (id + "|" + nE +"|"+ nC + "|" + numTitulos);
    }

    public double getNumTitulos() {
        return numTitulos;
    }

    public void setNumTitulos(double numTitulos) {
        this.numTitulos = numTitulos;
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

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }
    
    public static String getTexto() {
        return texto;
    }
    
@Override
    public void imprimir(){
        System.out.println(id+"|"+nombreCliente + "|"+nombreEmpresa + "|" +numTitulos);
    }
}
