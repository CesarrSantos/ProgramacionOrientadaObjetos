package Pricipal;

import EntradaSalida.MyInput;

import GestionableConcesionario.GestionUsuarios;
import GestionableConcesionario.IGestionable;


public class MenuUsuarios extends MenuPrincipal {


    public static void gestionarUsuarios(GestionUsuarios gestionUsuarios){
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
                    gestionUsuarios.agregarCliente(gestionUsuarios);
                    break;
                case 2:
                    IGestionable.listarClientes(gestionUsuarios);
                    break;
                case 3:
                     GestionUsuarios.listarClienteDni(gestionUsuarios,MyInput.readString());
                     break;
                case 4:
                    GestionUsuarios.listarClientesPublicidad(gestionUsuarios);
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
        System.out.println("3. Listar usuario a partir de un dni");
        System.out.println("4. Listar usuarios que quieren publicidad");
    }
    public static int elegir_opcion(){
        return MyInput.readInt();
    }
}
