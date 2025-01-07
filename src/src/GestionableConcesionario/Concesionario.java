package GestionableConcesionario;

import java.io.Serializable;
import java.util.ArrayList;
import Concesionario.Cliente;
import Concesionario.Coches;
import Concesionario.Seccion;

public class Concesionario implements Serializable {

    /*private static GestionUsuarios gestionUsuarios = new GestionUsuarios();
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
    }*/

    private ArrayList<IGestionable<?,?,?>> g;
    public Concesionario(){
        g= new ArrayList<IGestionable<?,?,?>>();
    }

    public void agregar(IGestionable<?,?,?> ge){
        g.add(ge);
    }

    public IGestionable<?,?,?> recuperar(int indice){
        return g.get(indice);
    }
}

