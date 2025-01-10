package GestionableConcesionario;

import Concesionario.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Interfaz IGestionableSeccion que extiende la interfaz IGestionable.
 * Define las operaciones específicas para la gestión de secciones.
 */
public interface IGestionableSeccion extends IGestionable<Seccion, String, Integer> {

    /**
     * Recupera una sección según su índice en la lista.
     *
     * @param indice el índice de la sección que se desea recuperar.
     * @return la sección ubicada en la posición especificada.
     */
    Seccion recuperar(Integer indice);

    /**
     * Devuelve el número total de secciones gestionadas.
     *
     * @return la cantidad de secciones.
     */
    int numeroElementos();

    /**
     * Devuelve una lista con todas las secciones gestionadas.
     *
     * @return una lista de objetos Seccion.
     */
    List<Seccion> listar();

    /**
     * Muestra todas las secciones disponibles, incluyendo su información relevante.
     */
    void mostrarSecciones();

    /**
     * Verifica si existen coches asignados a una sección específica.
     *
     * @param idSeccion el identificador de la sección que se desea verificar.
     * @param coches    la lista de coches a verificar.
     * @return {@code true} si hay coches en la sección, {@code false} en caso contrario.
     */
    boolean cochesEnSeccion(String idSeccion, ArrayList<Coches> coches);
}
