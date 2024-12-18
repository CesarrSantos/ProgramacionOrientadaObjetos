package Principal;


import GestionableConcesionario.*;

public class Main {
    public static void main(String[] args) {
        MenuPrincipal menuPrincipal = new MenuPrincipal();
        menuPrincipal.principal();
        Concesionario concesionario = new Concesionario();
        concesionario.agregar(new GestionSeccion());
    }
}