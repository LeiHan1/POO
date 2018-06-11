/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mensajes;


public class MensajeRespuestaActualizacion extends MensajeActualizacion{
    
    public MensajeRespuestaActualizacion(int id, String nBanco, String f) {
        super(nBanco, f);
        this.id = id;
    }
    
    
    
    

    @Override
    public void imprimir(){
        System.out.println(id + "|" + this.getNombreBanco() + "|" + this.getFecha() + "|Actualizada.");
    }
    
    @Override
    public String toString(){
        return (id + "|" + this.getNombreBanco() + "|" + this.getFecha() + "|Actualizada.");
    }

}
