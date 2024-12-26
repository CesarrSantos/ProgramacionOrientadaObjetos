package Principal;

import EntradaSalida.MyInput;
import GestionableConcesionario.Concesionario;


    public class MenuPrincipal  {

        public void principal(Concesionario concesionario)
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
                        MenuUsuarios menuUsuarios = new MenuUsuarios(concesionario);
                        menuUsuarios.gestionarUsuarios();
                        break;
                    case 3:
                        MenuSeccion menuSeccion = new MenuSeccion(concesionario);
                        menuSeccion.gestionable();
                        break;
                    case 4:
                        MenuCoches menuCoches = new MenuCoches(concesionario);
                        menuCoches.gestionarCoches();
                        break;
                    default:
                        System.out.println("Opcion no Correcta");

                }
            }
        }


    public void mostrar_opciones(){
        System.out.println("Opciones del Concesionario");
        System.out.println("--------------------------");
        System.out.println("0. Salir del Concesionario");
        System.out.println("1. Gestion de Ventas ");
        System.out.println("2. Gestion de Clientes ");
        System.out.println("3. Gestion de Seccion");
        System.out.println("4. Gestion de Coches ");
    }

    public int elegir_opcion(){
        return MyInput.readInt();
    }


}
