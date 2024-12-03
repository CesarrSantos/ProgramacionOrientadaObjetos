package Pricipal;

import EntradaSalida.MyInput;

public class Main {
    public static void main(String[] args) {
        mostrar_opciones();
        int opcion;
        boolean salir = true;
        while (salir == true) {
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

                    break;
                case 3:
                    System.out.println("En proceso");
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
}