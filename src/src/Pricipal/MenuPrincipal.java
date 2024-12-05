package Pricipal;

import EntradaSalida.MyInput;
import GestionableConcesionario.Concesionario;
import GestionableConcesionario.GestionUsuarios;
import GestionableConcesionario.IGestionable;
import Concesionario.Cliente;
import java.util.Collections;
import java.util.List;


public class MenuPrincipal implements IGestionable {

    public static void principal()

    {
        int opcion;
        boolean salir = true;
        while (salir) {
            mostrar_opciones();
            opcion = elegir_opcion();
            switch (opcion) {
                case 0:
                    System.out.println("En proceso");
                    salir = false;
                    break;
                case 1:
                    System.out.println("En proceso");
                    break;
                case 2:
                    MenuUsuarios.gestionarUsuarios(Concesionario.getGestionUsuarios());
                    break;
                case 3:
                   MenuVentas.principal();
                    break;
                default:
                    System.out.println("Opcion no Correcta");

            }
        }
    }


    public static void mostrar_opciones(){
        System.out.println("Opciones del Concesionario");
        System.out.println("--------------------------");
        System.out.println("0. Salir del Concesionario");
        System.out.println("1. Gestion de Ventas ");
        System.out.println("2. Gestion de Cliente");
        System.out.println("3. Gestion de Producto");
    }

    public static int elegir_opcion(){
        return MyInput.readInt();
    }


    @Override
    public void agregarCliente(GestionUsuarios gestionUsuarios) {

    }

    @Override
    public List<Cliente> listar() {
        return Collections.emptyList();
    }
}
