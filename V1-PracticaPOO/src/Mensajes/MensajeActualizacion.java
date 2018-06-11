/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mensajes;

public class MensajeActualizacion extends Mensaje {

    private String fecha;
    private String nombreBanco;

    public MensajeActualizacion(String nBanco, String f) {
        nombreBanco = nBanco;
        fecha = f;
    }

    public MensajeActualizacion(int id, String nBanco, String fecha) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getNombreBanco() {
        return nombreBanco;
    }

    public void setNombreBanco(String nombreBanco) {
        this.nombreBanco = nombreBanco;
    }
    
    
    @Override
    public void imprimir(){
        System.out.println(id + "|" + nombreBanco + "|Actualizacion|" + fecha);
    }
    @Override
    public String toString() {
        return (id + "|" + nombreBanco + "|Actualizacion|" + fecha);
    }

}
