package Pricipal;

import EntradaSalida.MyInput;
import GestionableConcesionario.Concesionario;
import GestionableConcesionario.GestionSeccion;
import GestionableConcesionario.IGestionable;

import java.util.Collections;
import java.util.List;


public class MenuPrincipal  {

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
                   MenuSeccion.gestionarSeccion(Concesionario.getGestionSeccion());
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
        System.out.println("2. Gestion de Clientes ");
        System.out.println("3. Gestion de Seccion");
        System.out.println("4. Gestion de Producto");
    }

    public static int elegir_opcion(){
        return MyInput.readInt();
    }


}
