package Principal;

import EntradaSalida.MyInput;
import GestionableConcesionario.Concesionario;
import GestionableConcesionario.IGestionable;

import java.util.ArrayList;


public class MenuPrincipal  {

    private Concesionario concesionario;
    private ArrayList<MenuPrincipal> menus;

    public MenuPrincipal(Concesionario concesionario) {
        this.concesionario = concesionario;

        this.menus = new ArrayList<MenuPrincipal>();
    }

    public void agregar_menu(MenuPrincipal menu){
        menus.add(menu);
    }

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

    public IGestionable<?,?,?> getGestionable(int indice){
        return concesionario.recuperar(indice);
    }
}
