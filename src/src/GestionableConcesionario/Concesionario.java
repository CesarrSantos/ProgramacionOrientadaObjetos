package GestionableConcesionario;

import java.util.ArrayList;
import Concesionario.Cliente;
import Concesionario.Venta;
public class Concesionario {

    private static GestionUsuarios gestionUsuarios = new GestionUsuarios();
    private static GestionSeccion  gestionSeccion = new GestionSeccion();
    private static GestionCoches   gestionCoches = new GestionCoches();
    private ArrayList <Cliente> clientes;
    private ArrayList <Venta>  Ventas;

    public static GestionUsuarios getGestionUsuarios() {
        return gestionUsuarios;
    }

    public static GestionSeccion getGestionSeccion() {
        return gestionSeccion;
    }

    public static GestionCoches getGestionCoches() {
        return gestionCoches;
    }

}
