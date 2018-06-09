/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package General;

import Banco.*;
import Bolsa.*;
import java.util.ArrayList;

/**
 *
 * @author Adrian
 */
public class Utilidades {

    public boolean existeCliente(String nomCliente, ArrayList<ClientePremium> list) {
        boolean existe = false;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getNombre().equals(nomCliente)) {
                existe = true;
                break;
            }
        }
        return existe;
    }
    
    public int buscarCliente(String nomCliente, ArrayList<ClientePremium> list) {
        int indice = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getNombre().equals(nomCliente)) {
                indice = i;
                break;
            }
        }
        return indice;
    }
    
    public boolean existeEmpresa(String nomEmpresa, ArrayList<Empresa> list) {
        boolean existe = false;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getNombre().equals(nomEmpresa)) {
                existe = true;
                break;
            }
        }
        return existe;
    }
    
    public int buscarEmpresa(String nomEmpresa, ArrayList<Empresa> list) {
        int indice = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getNombre().equals(nomEmpresa)) {
                indice = i;
                break;
            }
        }
        return indice;
    }
    
    public boolean existePaquete(String nomEmpresa, ArrayList<PaqueteDeAcciones> list) {
        boolean existe = false;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getNombreEmpresa().equals(nomEmpresa)) {
                existe = true;
                break;
            }
        }
        return existe;
    }
    
    public int buscarPaquete(String nomEmpresa, ArrayList<PaqueteDeAcciones> list) {
        int indice = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getNombreEmpresa().equals(nomEmpresa)) {
                indice = i;
                break;
            }
        }
        return indice;
    }


}
