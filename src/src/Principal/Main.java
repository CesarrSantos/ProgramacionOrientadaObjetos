package Principal;


import GestionableConcesionario.*;

public class Main {
    public static void main(String[] args) {
        Concesionario concesionario = new Concesionario();
        concesionario.agregar(new GestionVentas());
        concesionario.agregar(new GestionUsuarios());
        concesionario.agregar(new GestionSeccion());
        concesionario.agregar(new GestionCoches());


        MenuPrincipal menuPrincipal = new MenuPrincipal(concesionario);
        menuPrincipal.agregar_menu(new MenuVentas(concesionario));
        menuPrincipal.agregar_menu(new MenuUsuarios(concesionario));
        menuPrincipal.agregar_menu(new MenuSeccion(concesionario));
        menuPrincipal.agregar_menu(new MenuCoches(concesionario));
        menuPrincipal.principal();
    }
}