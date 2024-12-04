package Pricipal;

import EntradaSalida.MyInput;

public class MenuCoches extends MenuPrincipal{

    public static void principal(){
        int opcion;
        boolean salir = true;
        while (salir) {
            mostrar_opciones();
            opcion = elegir_opcion();
            switch (opcion) {
                case 0:
                    salir = false;
                    break;
                case 1:
                    System.out.println("En proceso");
                    break;
                case 2:
                    System.out.println("En proceso");
                    break;
                case 3:
                    System.out.println("En proceso");
                    break;
                case 4:
                    System.out.println("En proceso");
                    break;
                default:
                    System.out.println("Opcion no Correcta");
            }
        }
    }

    public static void mostrar_opciones(){
        System.out.println("Menu de coches");
        System.out.println("-----------------");
        System.out.println("0. Salir del menu de usuarios");
        System.out.println("1. Alta de coches");
        System.out.println("2. Mostrar detalles de un coche");
        System.out.println("3. Aumentar el stock");
        System.out.println("4. Mostrar todos los coches de una seccion");
    }
    public static int elegir_opcion(){
        return MyInput.readInt();
    }
}

