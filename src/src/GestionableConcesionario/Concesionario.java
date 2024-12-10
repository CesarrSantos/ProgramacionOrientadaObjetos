package GestionableConcesionario;

import java.util.ArrayList;
import Concesionario.Cliente;
import Concesionario.Coches;
import Concesionario.Seccion;

public class Concesionario {

    private static GestionUsuarios gestionUsuarios = new GestionUsuarios();
    private static GestionCoches gestionCoches = new GestionCoches();
    private static GestionSeccion gestionSeccion = new GestionSeccion();

    // Métodos estáticos para acceder a las gestiones
    public static GestionUsuarios getGestionUsuarios() {
        return gestionUsuarios;
    }

    public static GestionCoches getGestionCoches() {
        return gestionCoches;
    }

    public static GestionSeccion getGestionSeccion() {
        return gestionSeccion;
    }
}

