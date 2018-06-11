/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package General;

import Banco.*;
import Bolsa.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class Simulador implements Serializable {
    
    public Banco banco;
    
    public BolsaDeValores bolsa;
    public int num;

    InterfazDeUsuario interfaz = new InterfazDeUsuario();

  
    public Simulador() {

        AgenteDeInversiones agente = new AgenteDeInversiones("Ana", "456");
        banco = new Banco("BancoA", "Carlos", "2222");
        banco.setAgente(agente);
        GestorDeInversiones Bob = new GestorDeInversiones("Bob", "S3333");
        bolsa = new BolsaDeValores("bolsa1");
        ClientePremium Lei = new ClientePremium("Lei", "G123", 5000);
        Lei.setPremium(true);
        Lei.asignarGestor(Bob);
        ClientePremium Carlos = new ClientePremium("Carlos", "C123", 1500);
        banco.aniadirInversor(Lei);
        banco.aniadirInversor(Carlos);

        Empresa e1 = new Empresa("EmpresaA", 2000);
        Empresa e2 = new Empresa("EmpresaB", 3500);
        bolsa.aniadirEmpresa(e1);
        bolsa.aniadirEmpresa(e2);
        bolsa.opActualizacionDeValores();

    }

// --- las operaciones del menu --- //
//0. salir del programa
    public void opecacion0() {
        System.out.println("Se ha salido del programa.");
        System.exit(0);
       
               
    }
//1. mostrar clientes    

    public void operacion1() {
        System.out.println("<< Estado de los clientes >>");
        
        banco.mostrarClientes(Banco.getInversores());
    }
//2. mostrar bolsas

    public void operacion2() {
        System.out.println("<< Estado de la bolsa >>");
        bolsa.mostrarEmpresas(BolsaDeValores.getListaEmpresas());
    }
//3. añadir cliente    

    public void operacion3() {
        Escaner datos = new Escaner();
        System.out.println("<< Añadir cliente >>");
        String nombre = datos.pedirNombre();
        Utilidades util = new Utilidades();
        if ((util.existeCliente(nombre, Banco.getInversores()) == true)) {
            System.out.println("El cliente ya existe.");
        } else {
            String dni = datos.pedirDni();
            double saldo = datos.pedirSaldo();
            ClientePremium cliente = new ClientePremium(nombre, dni, saldo);
            banco.aniadirInversor(cliente);
            System.out.println("El cliente " + cliente.getNombre() + " con dni " + cliente.getDni() + " y saldo " + cliente.getSaldo() + " ha sido añadido");
        }
    }
//4. eliminar cliente    

    public void operacion4() {
        System.out.println("<< Eliminar cliente >>");
        Escaner eliminar = new Escaner();
        String nom = eliminar.pedirNombre();
        Utilidades util = new Utilidades();
        if (Banco.getInversores().isEmpty() || (util.existeCliente(nom, Banco.getInversores()) == false)) {
            System.out.println("No existe el cliente o la lista de clientes está vacía.");
        } else {
            int i = util.buscarCliente(nom, Banco.getInversores());
            banco.eliminarInversor(i);
            System.out.println("El cliente " + nom + " ha sido eliminado");
        }
    }
//5. realizar copia de seguridad del banco    

    public void operacion5() {
        System.out.println("<< Realizar copia de seguridad >>");
        File archivo;
        ObjectOutputStream oss;
        archivo = new File("Copia de Seguridad de Clientes");
        try {
            
            oss = new ObjectOutputStream(new FileOutputStream(archivo));
            oss.writeObject(Banco.clientes);
            oss.close();

        } catch (IOException ex) {
        }
        
        int datos = Banco.clientes.size();
        System.out.println("Se ha creado una Copia de Seguridad en la carpeta del proyecto con " + datos + " Clientes");
    }

//6. restaurar copia de seguridad del banco    
    public void operacion6() throws FileNotFoundException, IOException {
        
        ObjectInputStream ois;
        try {
            ois = new ObjectInputStream(new FileInputStream("Copia de Seguridad de Clientes"));
            Banco.clientes = (ArrayList<ClientePremium>) ois.readObject();
            
            
        } catch (ClassNotFoundException e) {
            System.out.println("No se encuentra el archivo");
        }
    }

//7. mejorar un cliente a premium    
    public void operacion7() {
        System.out.println("<< Mejora cliente a premium >>");
        Escaner c = new Escaner();
        String n = c.pedirNombre();
        Utilidades util = new Utilidades();
        if (Banco.getInversores().isEmpty() || (util.existeCliente(n, Banco.getInversores()) == false)) {
            System.out.println("No existe el cliente o la lista de clientes está vacía.");
        } else {
            int i = util.buscarCliente(n, Banco.getInversores());

            banco.hacerClientePremium(Banco.getInversores().get(i));

        }
    }
    
//8. solicitar recomendacion de inversion    
    public void operacion8() {
        System.out.println("<< Solicita recomendacion de inversion >>");
        Escaner es = new Escaner();
        Utilidades util = new Utilidades();
        System.out.println("Introduce su nombre: ");
        String nomCliente = es.pedirNombre();

        if (Banco.getInversores().isEmpty() || (util.existeCliente(nomCliente, Banco.getInversores()) == false)) {
            System.out.println("No existe el cliente o la lista de clientes está vacía.");
        } else {
            int iC = util.buscarCliente(nomCliente, Banco.getInversores());
            Cliente c = Banco.getInversores().get(iC);
            if (c.isPremium() == false) {
                System.out.println("Usted no es cliente premium, no puede solicitar recomendacion.");
            } else {
                int jEmpresa = bolsa.buscarEmpresaRecomendada();
                Empresa e = BolsaDeValores.getListaEmpresas().get(jEmpresa);
                System.out.print("Su gestor " + Banco.getInversores().get(iC).getNomGestor());
                System.out.println(" le recomienda invertir en la empresa: " + e.getNombre() + " con valor actual: " + e.getValorActual() + " y variacion: " + e.getVariacion());

            }
        }
    }

//9. añadir empresa a la bolsa    
    public void operacion9() {
        System.out.println("<< Añadir empresa a la bolsa >>");
        Escaner es = new Escaner();
        String nombreEmpresa = es.pedirNomEmpresa();
        Utilidades util = new Utilidades();
        if ((util.existeCliente(nombreEmpresa, Banco.getInversores()) == true)) {
            System.out.println("La empresa ya existe.");
        } else {
            double actual = es.pedirValorActual();
            Empresa e = new Empresa(nombreEmpresa, actual);
            bolsa.entrarBolsa(e);
            System.out.println("Empresa añadida");
        }
    }
//10. eliminar empresa de la bolsa    

    public void operacion10() {
        System.out.println("<< Eliminar empresa de la bolsa >>");
        Utilidades util = new Utilidades();
        Escaner es = new Escaner();
        String nombreE = es.pedirNomEmpresa();
        if (BolsaDeValores.getListaEmpresas().isEmpty() || (util.existeEmpresa(nombreE, BolsaDeValores.getListaEmpresas()) == false)) {
            System.out.println("No existe la empresa o la lista de empresas está vacía.");
        } else {
            int i = util.buscarEmpresa(nombreE, BolsaDeValores.getListaEmpresas());
            this.bolsa.borrarEmpresa(i);
            System.out.println("Empresa eliminada.");

        }// end else
    }

//11. actualizar valores    
    public void operacion11() {
        System.out.println("<< Actualizacion de valores de las empresas >>");
        bolsa.opActualizacionDeValores();
    }

//12. realizar copia de seguridad de la bolsa
    public void operacion12() throws IOException {
        System.out.println("<< Realizar copia de seguridad de la bolsa>>");
        bolsa.opRealizarCopia();
    }

    //13. restaurar copia de seguridad de la bolsa
    public void operacion13() throws IOException, ClassNotFoundException {
        System.out.println("<< Restaurar copia de seguridad de la bolsa>>");
        bolsa.opRestaurarCopia();
    }

    //14. solicitar compra de acciones
    public void operacion14() {
        System.out.println("<< Solicitar compra de acciones >>");
        Escaner es = new Escaner();
        Utilidades util = new Utilidades();
        String nombreC = es.pedirNombre();
        ArrayList<ClientePremium> clientes = Banco.getInversores();
        ArrayList<Empresa> empresas = BolsaDeValores.getListaEmpresas();
        if (clientes.isEmpty() || (util.existeCliente(nombreC, clientes) == false)) {
            System.out.println("No existe el cliente o la lista de clientes está vacía.");
        } else {
            int iC = util.buscarCliente(nombreC, clientes);
            String nombreE = es.pedirNomEmpresa();
            if (empresas.isEmpty() || (util.existeEmpresa(nombreE, empresas) == false)) {
                System.out.println("No existe la empresa o la lista de empresas está vacía.");
            } else {
                int iE = util.buscarEmpresa(nombreE, empresas);
                double cantidad = es.pedirCantidadAccion();
                if (clientes.get(iC).getSaldo() < cantidad) {
                    System.out.println("No tiene suficiente saldo (saldo actual: " + clientes.get(iC).getSaldo() + ") para comprar.");
                } else {
                    banco.opSolicitaCompraAcciones(nombreC, nombreE, cantidad);
                } // end else
            } // end else
        } // end else
    }

//15. solicitar venta de acciones 
    public void operacion15() {
        System.out.println("<< Solicitar venta de acciones >>");
        Escaner es = new Escaner();
        Utilidades util = new Utilidades();
        String nombreC = es.pedirNombre(); // pedir y comprobar nombre cliente
        ArrayList<ClientePremium> clientes = Banco.getInversores();
        ArrayList<Empresa> empresas = BolsaDeValores.getListaEmpresas();
        if (clientes.isEmpty() || (util.existeCliente(nombreC, clientes) == false)) {
            System.out.println("No existe el cliente o la lista de clientes está vacía.");
        } else {
            int iC = util.buscarCliente(nombreC, clientes);
            Cliente c = clientes.get(iC);
            ArrayList<PaqueteDeAcciones> paquetes = c.getCartera();
            String nombreE = es.pedirNomEmpresa(); // pedir y comprobar nombre empresa
            if (c.getCartera().isEmpty() || (util.existePaquete(nombreE, paquetes) == false)) {
                System.out.println("No existe el paquete o la lista está vacía.");
            } else {
                int iP = util.buscarPaquete(nombreE, paquetes);
                PaqueteDeAcciones p = paquetes.get(iP);
                int titulo = es.pedirTitulosVender(); // pedir y comprobar titulos del paquete

                if (titulo > p.getNumTitulos()) {
                    System.out.println("No tiene suficiente titulo (titulo actual: " + p.getNumTitulos() + ") para vender.");
                } else {
                    banco.opSolicitaVentaAcciones(nombreC, nombreE, titulo); // se crea el mensaje de venta
                } // end else
            } // end else
        } // end else

    }
//16. solicitar actualizacion de valores

    public void operacion16() {
        System.out.println("<< Solicitar actualizacion de valores >>");
        // obtener fecha
        SimpleDateFormat dateFormat = new SimpleDateFormat("YYYYMMddhhmmss");
        String dateString = dateFormat.format(new Date());
        banco.opSolicitaActualizacion(banco.getNombreBanco(), dateString);
    }

//17. imprimir opraciones pendeientes del agente
    public void operacion17() {
        System.out.println("<< Imprimir operaciones pendientes >>");
        banco.getAgente().opImprimirOperaciones();
    }

//18. ejecutar operaciones pendientes 
    public void operacion18() {
        System.out.println("<< Ejecutar operaciones pendientes >>");
        if (banco.getAgente().getMensajes().isEmpty()){
            System.out.println("No hay actualizaciones pendientes");
        } else {
            banco.getAgente().getMensajes().forEach((k, v)
                -> {
                    String str = bolsa.intentaOperacion(k.toString(), v);
                    System.out.println(str);

        }); //end for each
        }
        
    }

    public void operacionesSimulador() throws IOException, ClassNotFoundException {
        do {
            
            num = interfaz.leerOpcion();

            switch (num) {
                case 0: //salir
                    opecacion0();

                //------------------ESTADO------------------
                case 1: //imprimir estado de los listaClientes
                    operacion1();
                    break;

                case 2: // imprimir estado de la bolsa
                    operacion2();
                    break;
                //------------------BANCO------------------
                case 3: // añadir cliente
                    operacion3();
                    break;

                case 4: // eliminar cliente
                    operacion4();
                    break;

                case 5: // realizar copia de seguridad del banco
                    operacion5();
                    break;

                case 6: // recuperar informacion de la copia de seguridad del banco
                    operacion6();
                    break;

                case 7: // mejorar un cliente a premium
                    operacion7();
                    break;

                case 8: // solicitar recomendacion de inversion
                    operacion8();
                    break;
                //------------------BOLSA------------------
                case 9: // añadir empresa a la bolsa
                    operacion9();
                    break;

                case 10: // eliminar empresa de la bolsa
                    operacion10();
                    break;

                case 11: // actualizar valores
                    operacion11();
                    break;

                case 12: // realizar copia de seguridad de la bolsa 
                    operacion12();
                    break;

                case 13: // restaurar copia de seguridad
                    operacion13();
                    break;
                //------------------OPERACIONES------------------
                case 14: // solicitar compra de acciones
                    operacion14();
                    break;

                case 15: // solicitar venta de acciones 
                    operacion15();
                    break;

                case 16: // solicitar actualizacion de valores
                    operacion16();
                    break;
                //------------------BROKER------------------
                case 17: // imprimir opraciones pendeientes del agente
                    operacion17();
                    break;

                case 18: // ejecutar operaciones pendientes 
                    operacion18();
                    break;

                default:
                    System.out.println("No has elegido una opcion correcta");
                    break;

            } // end switch 

            System.out.println();
            Escaner e = new Escaner();
            e.siguiente();
            interfaz.menu();
        } while (num != 0);

    }

}
