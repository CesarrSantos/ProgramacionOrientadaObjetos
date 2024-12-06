package GestionableConcesionario;

import java.util.ArrayList;
import Concesionario.*;
public class Concesionario {

    private static GestionUsuarios gestionUsuarios = new GestionUsuarios();
    static {
        System.out.println("Initializing GestionUsuarios...");
        gestionUsuarios = new GestionUsuarios();
    }
    private static GestionSeccion gestionSeccion = new GestionSeccion();
    static {
        System.out.println("Initializing GestionSeccion...");
        gestionSeccion = new GestionSeccion();
    }
    private static GestionCoches gestionCoches = new GestionCoches();
    static {
        System.out.println("Initializing GestionCoches...");
        gestionCoches = new GestionCoches();
    }

    private Concesionario concesionario = new Concesionario();
    private ArrayList <Cliente> clientes = new ArrayList <Cliente> ();
    private ArrayList <Venta>  ventas = new ArrayList <Venta> ();
    private ArrayList <Seccion> seccion = new ArrayList <Seccion> ();

    public ArrayList<Cliente> getClientes() {
        if (clientes == null) {
            clientes = new ArrayList<>(); // Initialize the list if null
        }
        return clientes;
    }
    public static GestionUsuarios getGestionUsuarios() {
        return gestionUsuarios;
    }
    public static GestionSeccion getGestionSeccion() {
        return gestionSeccion;
    }
    public static GestionCoches getGestionCoches() {
        return gestionCoches;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    public ArrayList<Venta> getVentas() {
        return ventas;
    }

    public void setVentas(ArrayList<Venta>  ventas) {
        this.ventas = ventas;
    }

    public ArrayList<Seccion>  getSeccion() {
        return seccion;
    }

    public void setSeccion(ArrayList<Seccion>  seccion) {
        this.seccion = seccion;
    }

}
