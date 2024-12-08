package Principal;

import EntradaSalida.MyInput;
import GestionableConcesionario.Concesionario;
import GestionableConcesionario.GestionSeccion;

public class MenuSeccion extends MenuPrincipal{

    public static void gestionarSeccion(GestionSeccion gestionSeccion){
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
                    Concesionario.getGestionSeccion().agregarSeccion();
                    break;
                case 2:
                    Concesionario.getGestionSeccion().bajaSeccion();
                    break;
                case 3:
                    Concesionario.getGestionSeccion().mostrarSecciones();
                    break;
                default:
                    System.out.println("Opcion no Correcta");
            }
        }
    }

    public static void mostrar_opciones(){
        System.out.println("Menu de Secciones");
        System.out.println("-----------------");
        System.out.println("0. Salir del menu de secciones");
        System.out.println("1. Añadir nueva Seccion");
        System.out.println("2. Baja de Seccion");
        System.out.println("3. Mostrar Secciones");
    }
    public static int elegir_opcion(){
        return MyInput.readInt();
    }
}
