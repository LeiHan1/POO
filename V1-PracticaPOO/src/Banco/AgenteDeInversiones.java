/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Banco;

import Mensajes.*;
import Bolsa.BolsaDeValores;
import Bolsa.Empresa;
import General.Utilidades;
import java.util.HashMap;

/**
 *
 * @author sergio
 */
public class AgenteDeInversiones extends Persona {

    private HashMap<Mensaje, String> mensajes = new HashMap<>();
    private HashMap<Empresa, String> actualizacionPendiente = new HashMap<>();

    public AgenteDeInversiones(String n, String d) {
        this.nombre = n;
        this.dni = d;
    }

    public void addMapMensaje(Mensaje m, String s) {
        mensajes.put(m, s);
    }

    public HashMap<Mensaje, String> getMensajes() {
        return mensajes;
    }

    public HashMap<Empresa, String> getActualizacionPendiente() {
        return actualizacionPendiente;
    }

    public void intentaOperacion(Mensaje k, String v) { //18. ejecutar operacion
        String barra = "|";
        String m = k.toString();
        char bar = barra.charAt(0); //transformar la barra de string a char
        int ini = 0;
        int count = 0;
        int id = 0;

        String cliente = null;
        String empresa = null;
        int n = 0;
        //for (int n = 0; n < m.length(); n++) {
        while (n < m.length()) {
            if (m.charAt(n) == bar) {
                count++;
                switch (count) {
                    case 1: // campo del id
                        String idAux = m.substring(ini, n);
                        ini = n;
                        id = Integer.parseInt(idAux);
                        //System.out.println("El id es " + id);
                        break;

                    case 2: // campo del cliente
                        cliente = m.substring(ini + 1, n);
                        ini = n;
                        //System.out.println("El Cliente es " +cliente);
                        break;

                    case 3: // campo de la empresa
                        empresa = m.substring(ini + 1, n);
                        ini = n;
                        //System.out.println("La Empresa es " +empresa);
                        break;

                    default:
                        break;
                } // end switch
            } // end if
            n++;
        } // end while  
        String stringAux = m.substring(ini + 1, m.length());

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
                boolean sePuedeComprar = false;
                if (cli.getSaldo() < valorAccion) {
                    MensajeRespuestaCompra resCompra = new MensajeRespuestaCompra(id, cliente, empresa, cantidad, sePuedeComprar, valorAccion);
                    System.out.println(resCompra.toString());
                } else {
                    MensajeRespuestaCompra resCompra = new MensajeRespuestaCompra(id, cliente, empresa, cantidad, true, valorAccion);
                    System.out.println(resCompra.toString());

                    PaqueteDeAcciones p = new PaqueteDeAcciones(empresa, resCompra.getnTituloComprado(), valorAccion);
                    cli.aniadirPaquete(p);
                    cli.setSaldo(cli.getSaldo() - cantidad + resCompra.getDineroSobrado());

                    actualizacionPendiente.put(em, "Compra");
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
                System.out.println(resVenta.toString());
                cli.setSaldo(cli.getSaldo() + valorTotal);
                actualizacionPendiente.put(e, "Venta");

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
                System.out.println(resAct.toString());
                actualizacionPendiente.clear();

                break;
        }

    }// END INTENTA OPERACION

    public void opImprimirOperaciones() { //17.imprimir operaciones pendientes
        System.out.println("Imprimir peticiones pendientes:");
        mensajes.forEach((k, v) -> System.out.println(v+" "+ k.toString() ));
    }

    public void vaciarLista() { //17.imprimir operaciones pendientes
        System.out.println("Ejecutando la lista de peticiones");
        mensajes.forEach((k, v)
                -> {
            intentaOperacion(k, v);

        }); //end for each
        mensajes.clear();

    }

}
