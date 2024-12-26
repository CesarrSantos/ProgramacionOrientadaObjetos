package Principal;


import GestionableConcesionario.*;

public class Main {
    public static void main(String[] args) {
        MenuPrincipal menuPrincipal = new MenuPrincipal();
        Concesionario concesionario = new Concesionario();


// Create all managers with the concesionario reference
        GestionUsuarios gestionUsuarios = new GestionUsuarios(concesionario);
        GestionCoches  gestionCoches = new GestionCoches(concesionario);
        GestionSeccion gestionSeccion = new GestionSeccion(concesionario);
        //GestionVentas  gestionventas= new GestionSeccion(concesionario);

// Add them to concesionario in the correct order
        concesionario.agregar(gestionSeccion);  // index 0
        concesionario.agregar(gestionUsuarios);    // index 1
        concesionario.agregar(gestionCoches);   //index 2
        //concesionario.agregar(gestionventas); // index 3

         menuPrincipal.principal(concesionario);
    }
}