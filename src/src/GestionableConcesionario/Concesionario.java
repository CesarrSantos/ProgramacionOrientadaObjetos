package GestionableConcesionario;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Clase Concesionario que implementa la interfaz Serializable.
 * Esta clase se encarga de gestionar una lista de objetos que implementan la interfaz IGestionable.
 */
public class Concesionario implements Serializable {
    private final ArrayList<IGestionable<?,?,?>> gestionables;

    /**
     * Constructor de la clase Concesionario.
     * Inicializa la lista de elementos gestionables.
     */
    public Concesionario(){
        gestionables = new ArrayList<>();
    }

    /**
     * Agrega un elemento gestionable a la lista.
     *
     * @param gestionable el elemento gestionable que se desea agregar.
     */
    public void agregar(IGestionable<?,?,?> gestionable){
        gestionables.add(gestionable);
    }

    /**
     * Recupera un elemento gestionable de la lista según su índice.
     *
     * @param indice el índice del elemento a recuperar.
     * @return el elemento gestionable en la posición especificada.
     */
    public IGestionable<?,?,?> recuperar(int indice){
        return gestionables.get(indice);
    }
}

