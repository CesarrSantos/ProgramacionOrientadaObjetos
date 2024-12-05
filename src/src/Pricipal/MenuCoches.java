package Pricipal;

import EntradaSalida.MyInput;
import GestionableConcesionario.GestionCoches;
import GestionableConcesionario.IGestionable;

public class MenuCoches extends MenuPrincipal{

    public static void gestionarCoches(GestionCoches gestionCoches){
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
                    IGestionable.agregarCoche(gestionCoches);
                    break;
                case 2:
                    IGestionable.detalleEspecificosCoche(gestionCoches);
                    break;
                case 3:
                    IGestionable.aumentarStock(gestionCoches);
                    break;
                case 4:
                    IGestionable.mostrarDetallesSeccion(gestionCoches);
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
        System.out.println("1. Agregar un coche");
        System.out.println("2. Detalles especificos de un coche");
        System.out.println("3. Aumentar el stock");
        System.out.println("4. Mostrar todos los coches de una seccion");
    }
    public static int elegir_opcion(){
        return MyInput.readInt();
    }
}

