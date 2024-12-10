package Principal;

import EntradaSalida.MyInput;

import GestionableConcesionario.GestionUsuarios;


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
                    gestionUsuarios.agregarCliente();
                    break;
                case 2:
                    gestionUsuarios.listarClientes();
                    break;
                case 3:
                     gestionUsuarios.listarClienteDni(MyInput.readString());
                     break;
                case 4:
                    gestionUsuarios.listarClientesPublicidad();
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
