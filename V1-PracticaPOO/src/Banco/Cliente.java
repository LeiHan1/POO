/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Banco;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author sergio
 */
public class Cliente extends Persona implements Serializable {

    private double saldo;
    private ArrayList<PaqueteDeAcciones> cartera;
    private boolean premium;
    //private GestorDeInversiones gestor;
    //private ClientePremium clientePremium;

    public Cliente(String nombre, String dni, double saldo) {
        this.nombre = nombre;
        this.dni = dni;
        this.saldo = saldo;
        this.premium = false;
        cartera = new ArrayList<>();
    }

    public double getSaldo() {

        return saldo;
    }

    public void setSaldo(double saldo) {

        this.saldo = saldo;
    }

    public ArrayList<PaqueteDeAcciones> getCartera() {
        return cartera;
    }

    public void setCartera(ArrayList<PaqueteDeAcciones> cartera) {
        this.cartera = cartera;
    }

    public boolean isPremium() {
        return premium;
    }

    public void setPremium(boolean premium) {
        this.premium = premium;
    }

    public void aniadirPaquete(PaqueteDeAcciones p) {
        cartera.add(p);
    }

    public void eliminarPaquete(PaqueteDeAcciones p) {
        cartera.remove(p);
    }

    public boolean existePaquete(PaqueteDeAcciones p) {
        return cartera.contains(p);
    }

    public double valorPaquetes() {

        double total = 0;
        for (PaqueteDeAcciones p : cartera) {

            total = total + p.getValorPaquete();
        }
        return total;
    }

    @Override
    public String toString() {

        String mensaje = "Nombre: " + nombre + ". Nº de DNI: " + dni + ". Saldo Disponible: " + saldo + ". Valor Paquetes:" + valorPaquetes();
        return mensaje;
    }
}
