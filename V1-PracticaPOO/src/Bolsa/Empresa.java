/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bolsa;

/**
 *
 * @author sergio
 */
public class Empresa {
    
    private String nombre;
    private double valorActual;
    private double valorPrevio;
    private double variacion;
    
    public Empresa(String n, double actual){
        
        this.nombre = n;
        this.valorActual = actual;
        this.valorPrevio = 0;
        this.variacion = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getValorActual() {
        return valorActual;
    }

    public void setValorActual(double valorActual) {
        this.valorActual = valorActual;
    }

    public double getValorPrevio() {
        return valorPrevio;
    }

    public void setValorPrevio(double valorPrevio) {
        this.valorPrevio = valorPrevio;
    }

    public double getVariacion() {
        return variacion;
    }

    public void setVariacion(double previo, double actual) {
        this.variacion = actual - previo;
    }
        
        
    public void actualizarValores(double antiguo, double nuevo, Empresa e){
        
        e.setValorActual(nuevo);
        e.setValorPrevio(antiguo);
    }
    
    public double calcularVariacion(Empresa e){
        
        double previo = e.getValorPrevio();
        double actual = e.getValorActual();
        return actual - previo;
    }
    
    
}
