package Pricipal;

import Concesionario.Cliente;
import EntradaSalida.MyInput;
import GestionableConcesionario.GestionUsuario;

public class Main {
    public static void main(String[] args) {

        int opcion;
        boolean salir = true;
        while (salir == true) {
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
                    menu_usuario();
                    break;
                case 3:
                    System.out.println("En proceso");
                    break;
                default:
                    System.out.println("Opcion no Correcta");

            }
        }
    }
    /*
        OPCIONES DE USUARIOS
     */
    //Temporalmente lo hago en el main
    public static void menu_usuario(){

        int opcion;
        boolean salir = true;
        while (salir == true) {
            opciones_usuario();
            opcion = elegir_opcion();
            switch (opcion) {
                case 0:
                    salir = false;
                    break;
                case 1:
                    Cliente.agregarCliente();
                    break;
                case 2:
                    Cliente.listarClientes();
                    break;
                default:
                    System.out.println("Opcion no Correcta");
            }
        }
    }

    public static void opciones_usuario(){
        System.out.println("Menu de Usuarios");
        System.out.println("-----------------");
        System.out.println("0. Salir del menu de usuarios");
        System.out.println("1. Añadir usuario");
        System.out.println("2. Listar usuarios");
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

}