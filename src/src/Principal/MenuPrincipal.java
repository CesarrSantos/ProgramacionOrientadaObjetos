package Principal;

import EntradaSalida.MyInput;
import GestionableConcesionario.Concesionario;
import GestionableConcesionario.IGestionable;

import java.util.ArrayList;

/**
 * Clase que representa el menú principal del concesionario.
 * Permite gestionar diferentes submenús y realizar operaciones relacionadas con el concesionario.
 */
public class MenuPrincipal  {


    private final Concesionario concesionario;
    private final ArrayList<MenuPrincipal> menus;

    /**
     * Constructor de la clase MenuPrincipal.
     *
     * @param concesionario Objeto concesionario que se asociará al menú principal.
     */
    public MenuPrincipal(Concesionario concesionario) {
        this.concesionario = concesionario;
        this.menus = new ArrayList<>();
    }
    /**
     * Agrega un submenú al menú principal.
     *
     * @param menu Objeto MenuPrincipal que se agregará como submenú.
     */
    public void agregar_menu(MenuPrincipal menu){
        menus.add(menu);
    }

    /**
     * Método principal del menú.
     * Permite interactuar con las opciones del menú y navegar entre submenús.
     */
    public void principal(){
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
                    menus.get(0).principal();
                    break;
                case 2:
                    menus.get(1).principal();
                    break;
                case 3:
                    menus.get(2).principal();
                    break;
                case 4:
                    menus.get(3).principal();
                    break;
                default:
                    System.out.println("Opcion no Correcta");

            }
        }
    }

    /**
     * Muestra las opciones del menú principal en la consola.
     */
    public void mostrar_opciones(){
        System.out.println("Opciones del Concesionario");
        System.out.println("--------------------------");
        System.out.println("0. Salir del Concesionario");
        System.out.println("1. Gestion de Ventas ");
        System.out.println("2. Gestion de Clientes ");
        System.out.println("3. Gestion de Seccion");
        System.out.println("4. Gestion de Coches ");
    }

    /**
     * Permite al usuario elegir una opción del menú.
     *
     * @return El número de la opción elegida por el usuario.
     */
    public int elegir_opcion(){
        return MyInput.readInt();
    }
    /**
     * Recupera un objeto gestionable del concesionario basado en un índice.
     *
     * @param indice Índice del objeto gestionable a recuperar.
     * @return Objeto gestionable correspondiente al índice especificado.
     */
    public IGestionable<?,?,?> getGestionable(int indice){
        return concesionario.recuperar(indice);
    }
}
