package Principal;

import EntradaSalida.MyInput;

public class MenuVentas extends MenuPrincipal{

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
            System.out.println("Menu de Ventas");
            System.out.println("-----------------");
            System.out.println("0. Salir del menu de usuarios");
            System.out.println("1. Registrar una venta");
            System.out.println("2. Mostrar informacion de una venta a base de su id");
            System.out.println("3. Mostrar informacion de todas las ventas de un cliente");
        }
        public static int elegir_opcion(){
            return MyInput.readInt();
        }
}