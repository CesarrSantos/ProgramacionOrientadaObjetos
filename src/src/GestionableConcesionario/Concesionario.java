package GestionableConcesionario;

import java.util.ArrayList;
import Concesionario.Cliente;
import Concesionario.Venta;
public class Concesionario {

    private static GestionUsuarios gestionUsuarios = new GestionUsuarios();
    private ArrayList <Cliente> clientes;
    private ArrayList <Venta>  Ventas;

    public static GestionUsuarios getGestionUsuarios() {
        return gestionUsuarios;
    }

}
