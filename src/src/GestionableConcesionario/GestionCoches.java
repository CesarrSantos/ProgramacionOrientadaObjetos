package GestionableConcesionario;

import Concesionario.Coches;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase GestionCoches que implementa la interfaz IGestionableCoches y Serializable.
 * Gestiona una lista de objetos de tipo Coches, proporcionando operaciones como alta,
 * búsqueda, recuperación y listado de coches.
 */
public class GestionCoches implements IGestionableCoches, Serializable {
    private final ArrayList<Coches> coches = new ArrayList<>();

    public GestionCoches() {

    }

    /**
     * Agrega un coche a la lista.
     *
     * @param coche el coche que se desea añadir.
     */
    @Override
    public void alta(Coches coche) {
        coches.add(coche);
        System.out.println("Coche añadido exitosamente.");
    }

    /**
     * Busca un coche en la lista por su identificador único.
     *
     * @param idCoche el identificador del coche que se desea buscar.
     * @return el coche encontrado, o {@code null} si no se encuentra.
     */
    @Override
    public Coches buscar(String idCoche) {
        for (Coches coche : coches) {
            if (coche.getIdCoche().equals(idCoche)) {
                return coche;
            }
        }
        return null; // No encontrado
    }

    /**
     * Busca un coche en la lista por su identificador único y su seccion.
     *
     * @param idSeccion el identificador de la seccion del coche
     * @param idCoche el identificador del coche que se desea buscar.
     * @return el coche encontrado, o {@code null} si no se encuentra.
     */
    public Coches buscar(String idSeccion, String idCoche) {
        for (Coches coche : coches) {
            if (coche.getIdSeccion().equals(idSeccion) && coche.getIdCoche().equals(idCoche)) {
                return coche;
            }
        }
        return null;
    }

    /**
     * Recupera un coche de la lista según su índice.
     *
     * @param indice el índice del coche que se desea recuperar.
     * @return el coche en la posición especificada, o {@code null} si no se encuentra implementado.
     */
    @Override
    public Coches recuperar(Integer indice) {
        if(indice < 0 || indice >= coches.size()) {
            return null;
        }

        return coches.get(indice);
    }

    /**
     * Devuelve el número de coches en la lista.
     *
     * @return el número de elementos en la lista.
     */
    @Override
    public int numeroElementos() {
        return coches.size();
    }

    /**
     * Devuelve una lista con todos los coches gestionados.
     *
     * @return una copia de la lista de coches.
     */
    @Override
    public List<Coches> listar() {
        return new ArrayList<>(coches); // Devuelve una copia de la lista
    }

    /**
     * Verifica si existen coches en una sección específica.
     *
     * @param idSeccion el identificador de la sección.
     * @return {@code true} si hay coches en la sección, {@code false} en caso contrario.
     */
    @Override
    public boolean cochesEnSeccion(String idSeccion) {
        for (Coches coche : coches) {
            if (coche.getIdSeccion().equals(idSeccion)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Devuelve la lista de coches gestionados.
     *
     * @return la lista de coches.
     */
    public ArrayList<Coches> getCoches() {
        return coches;
    }

    /**
     * Verifica si existe un coche con un identificador específico.
     *
     * @param idCoche el identificador del coche.
     * @return {@code true} si el coche existe, {@code false} en caso contrario.
     */
    @Override
    public boolean existeCoche(String idCoche) {
        return buscar(idCoche) != null;
    }
}