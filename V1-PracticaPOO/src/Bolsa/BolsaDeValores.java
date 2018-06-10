/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bolsa;

import Banco.*;
import General.*;
import Mensajes.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;


/**
 *
 * @author sergio
 */
public class BolsaDeValores implements Serializable {

    private String nombreBolsa;
    private static ArrayList<Empresa> listaEmpresas;
    //private ArrayList<Banco> listaBancos;
    private HashMap<Empresa, String> actualizacionPendiente = new HashMap<>();

    public BolsaDeValores(String nombre) {

        this.nombreBolsa = nombre;
        listaEmpresas = new ArrayList<>();
       
    }

    public String getNombreBolsa() {
        return nombreBolsa;
    }

    public void aniadirEmpresa(Empresa i) {

        listaEmpresas.add(i);
    }

    public void borrarEmpresa(int i) {

        listaEmpresas.remove(i);
    }

    public void setNombreBolsa(String nombreBolsa) {
        this.nombreBolsa = nombreBolsa;
    }

    public static ArrayList<Empresa> getListaEmpresas() {
        return listaEmpresas;
    }

    public void setListaEmpresas(ArrayList<Empresa> listaEmpresas) {
        this.listaEmpresas = listaEmpresas;
    }

    public void mostrarEmpresas(ArrayList<Empresa> empresa) {
        if (empresa.isEmpty()) {
            System.out.println("No hay ninguna empresa.");
        } else {
            int j = 1;
            for (Empresa i : listaEmpresas) {
                System.out.println(j++ + ". Nombre Empresa: " + i.getNombre() + " Valor actual: " + i.getValorActual() + " Variacion: " + i.getVariacion());
            }
        }
    }


    public void entrarBolsa(Empresa e) {

        listaEmpresas.add(e);
    }

    public void borraEmpresa(Empresa e) {

        listaEmpresas.remove(e);
    }

    public HashMap<Empresa, String> getActualizacionPendiente() {
        return actualizacionPendiente;
    }

    
    
    public int buscarEmpresaRecomendada() {
        int indice = 0;
        ArrayList<Empresa> lista = this.getListaEmpresas();
        double variacionMax = lista.get(0).getVariacion();
        for (int i = 0; i < this.getListaEmpresas().size(); i++) {
            if (variacionMax <= lista.get(i).getVariacion()) {
                variacionMax = lista.get(i).getVariacion();
                indice = i;
            }
        }
        //} // end if else
        return indice;
    }

    public void opActualizacionDeValores() { //11.actualizacion de valores de acciones
        for (Empresa listaEmpresa : listaEmpresas) {
            int aleatorio = (int) Math.floor(Math.random() * (1500 - (-1500) + 1) + -1500);
            double nuevoValor = listaEmpresa.getValorActual() + aleatorio;
            listaEmpresa.setValorPrevio(listaEmpresa.getValorActual());

            listaEmpresa.setValorActual(nuevoValor);
            listaEmpresa.setVariacion(listaEmpresa.getVariacion(), aleatorio);
        }
        System.out.println("Valores actualizados");
    }

    public void opRealizarCopia() throws IOException { //12.realizar copia de seguridad
        System.out.println("Realizar copia de seguridad (bolsa)");
        File archivo;

        ObjectOutputStream oss;

        archivo = new File("Copia de Seguridad de Bolsa");
        try {

            oss = new ObjectOutputStream(new FileOutputStream(archivo));
            oss.writeObject(listaEmpresas);
            oss.close();
        } catch (IOException ex) {
        }
        int datos = listaEmpresas.size();
        System.out.println("Se ha creado una Copia de Seguridad en la carpeta del proyecto con " + datos + " Empresas");
    }

    public void opRestaurarCopia() throws FileNotFoundException, IOException {
        ObjectInputStream ois;
        try {
            ois = new ObjectInputStream(new FileInputStream("Copia de Seguridad de Bolsa"));
            listaEmpresas = (ArrayList<Empresa>) ois.readObject();
        } catch (ClassNotFoundException e) {
            System.out.println("No se encuentra el archivo");
        }
    }

    public String intentaOperacion(String m, String v) { //18. ejecutar operacion
        int id = 0;
        String mensajeRespuesta = null;
        String cliente = null;
        String empresa = null;
        String barra = "|";
        char bar = barra.charAt(0); //transformar la barra de string a char
        int ini = 0;
        int count = 0;
        int n = 0;
        while (n < m.length()) { // sacando los campos del mensaje
            if (m.charAt(n) == bar) {
                count++;
                switch (count) {
                    case 1: // campo del id
                        String idAux = m.substring(ini, n);
                        ini = n;
                        id = Integer.parseInt(idAux);
                        break;
                    case 2: // campo del cliente
                        cliente = m.substring(ini + 1, n);
                        ini = n;
                        break;
                    default: // campo de la empresa
                        empresa = m.substring(ini + 1, n);
                        ini = n;
                        break;
                } // end switch
            } // end if
            n++;
        } // end while  
        String stringAux = m.substring(ini + 1, m.length()); // campo de cantidad/titulo

        switch (v) {
            case "Compra":
                //int accionesCompradas = 0;
                double cantidad = Double.parseDouble(stringAux);

                Utilidades util = new Utilidades();
                int iE = util.buscarEmpresa(empresa, BolsaDeValores.getListaEmpresas());
                Empresa em = BolsaDeValores.getListaEmpresas().get(iE);
                int iC = util.buscarCliente(cliente, Banco.getInversores());
                Cliente cli = Banco.getInversores().get(iC);

                double valorAccion = em.getValorActual();
                if (cli.getSaldo() < valorAccion) {
                    MensajeRespuestaCompra resCompra = new MensajeRespuestaCompra(id, cliente, empresa, cantidad, false, valorAccion);
                } else {
                    MensajeRespuestaCompra resCompra = new MensajeRespuestaCompra(id, cliente, empresa, cantidad, true, valorAccion);

                    PaqueteDeAcciones p = new PaqueteDeAcciones(empresa, resCompra.getnTituloComprado(), valorAccion);
                    cli.aniadirPaquete(p);
                    cli.setSaldo(cli.getSaldo() - cantidad + resCompra.getDineroSobrado());

                    actualizacionPendiente.put(em, "Compra");
                    mensajeRespuesta = resCompra.toString();

                }
                break;

            case "Venta":
                int titulo = Integer.parseInt(stringAux);
                util = new Utilidades();

                iC = util.buscarCliente(cliente, Banco.getInversores());
                cli = Banco.getInversores().get(iC);

                iE = util.buscarEmpresa(empresa, BolsaDeValores.getListaEmpresas());
                Empresa e = BolsaDeValores.getListaEmpresas().get(iE);

                int iP = util.buscarPaquete(empresa, cli.getCartera());
                PaqueteDeAcciones p = cli.getCartera().get(iP);

                double valorPorAccion = p.getValorActual();
                double valorTotal = 0;

                if (titulo == p.getNumTitulos()) {
                    valorTotal = p.getValorPaquete();
                    cli.eliminarPaquete(p);
                } else {
                    valorTotal = valorPorAccion * titulo;
                    p.setNumTitulos(p.getNumTitulos() - titulo);
                    p.setValorPaquete(p.getValorPaquete() - valorTotal);
                }

                MensajeRespuestaVenta resVenta = new MensajeRespuestaVenta(id, cliente, empresa, titulo, valorPorAccion, valorTotal);
                cli.setSaldo(cli.getSaldo() + valorTotal);
                actualizacionPendiente.put(e, "Venta");
                mensajeRespuesta = resVenta.toString();

                break;
            default: // actualizacion
                String nBanco = cliente;
                String fecha = stringAux;

                int i = 0;
                actualizacionPendiente.forEach((key, valor) -> {
                    key = BolsaDeValores.getListaEmpresas().get(i);
                    int aleatorio = 0;
                    if (valor.equals("Compra")) {
                        aleatorio = (int) Math.floor(Math.random() * 1500);

                    } else {
                        aleatorio = (int) Math.floor(Math.random() * (-1500));
                    }//end else

                    key.setValorPrevio(key.getValorActual());
                    key.setValorActual(key.getValorActual() + aleatorio);
                    key.setVariacion(key.getVariacion(), aleatorio);
                }); //end for each
                MensajeRespuestaActualizacion resAct = new MensajeRespuestaActualizacion(id, nBanco, fecha);
                actualizacionPendiente.clear();
                mensajeRespuesta = resAct.toString();
                break;
        }

        return mensajeRespuesta;

    }// END INTENTA OPERACION

}
