/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Banco;

/**
 *
 * @author sergio
 */
class PaqueteDeAcciones {
    
    private String nombreEmpresa;
    private int numTitulos;
    private double valorActual;
    private double valorPaquete;
    
    public PaqueteDeAcciones (){
        
    }
    
    public PaqueteDeAcciones (String n, int num, double actual){
        
        this.nombreEmpresa = n;
        this.numTitulos = num;
        this.valorActual = actual;
        this.valorPaquete = (valorActual * numTitulos);
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public int getNumTitulos() {
        return numTitulos;
    }

    public void setNumTitulos(int numTitulos) {
        this.numTitulos = numTitulos;
    }

    public double getValorActual() {
        return valorActual;
    }

    public void setValorActual(double valorActual) {
        this.valorActual = valorActual;
    }

    public double getValorPaquete() {
        return valorPaquete;
    }

    public void setValorPaquete(double valorPaquete) {
        this.valorPaquete = valorPaquete;
    }
    
    
    
}
