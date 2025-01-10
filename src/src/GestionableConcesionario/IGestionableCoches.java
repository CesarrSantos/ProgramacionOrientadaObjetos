package GestionableConcesionario;
import Concesionario.Coches;

import java.util.List;

/**
 * Interfaz IGestionableCoches que extiende la interfaz IGestionable.
 * Define las operaciones específicas para la gestión de coches.
 */
public interface IGestionableCoches extends IGestionable<Coches, String, Integer> {

    /**
     * Recupera un coche según su índice en la lista.
     *
     * @param indice el índice del coche que se desea recuperar.
     * @return el coche ubicado en la posición especificada.
     */
    Coches recuperar(Integer indice);

    /**
     * Devuelve el número total de coches gestionados.
     *
     * @return la cantidad de coches.
     */
    int numeroElementos();

    /**
     * Devuelve una lista con todos los coches gestionados.
     *
     * @return una lista de objetos Coches.
     */
    List<Coches> listar();

    /**
     * Verifica si existen coches en una sección específica.
     *
     * @param idSeccion el identificador de la sección que se desea verificar.
     * @return {@code true} si hay coches en la sección, {@code false} en caso contrario.
     */
    boolean cochesEnSeccion(String idSeccion);

    /**
     * Verifica si existe un coche con un identificador específico.
     *
     * @param idCoche el identificador del coche que se desea verificar.
     * @return {@code true} si el coche existe, {@code false} en caso contrario.
     */
    boolean existeCoche(String idCoche);
}