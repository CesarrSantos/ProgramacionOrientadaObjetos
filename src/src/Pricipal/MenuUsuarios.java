package Pricipal;

import EntradaSalida.MyInput;
import GestionableConcesionario.GestionUsuarios;

public class MenuUsuarios extends MenuPrincipal {
    /*
    OPCIONES DE USUARIOS
    */
    //Temporalmente lo hago en el main

    public static void principal(){

        int opcion;
        boolean salir = true;
        while (salir == true) {
            mostrar_opciones();
            opcion = elegir_opcion();
            switch (opcion) {
                case 0:
                    salir = false;
                    break;
                case 1:
                    GestionUsuarios.agregarCliente();
                    break;
                case 2:
                    GestionUsuarios.listarClientes();
                    break;
                default:
                    System.out.println("Opcion no Correcta");
            }
        }
    }

    public static void mostrar_opciones(){
        System.out.println("Menu de Usuarios");
        System.out.println("-----------------");
        System.out.println("0. Salir del menu de usuarios");
        System.out.println("1. Añadir usuario");
        System.out.println("2. Listar usuarios");
    }
    public static int elegir_opcion(){
        return MyInput.readInt();
    }
}
