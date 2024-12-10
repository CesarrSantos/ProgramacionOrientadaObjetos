package GestionableConcesionario;
import Concesionario.*;
import java.util.ArrayList;
import java.util.List;


public interface IGestionable<T, K, V> {
    /**
     * Agrega un nuevo elemento al sistema.
     *
     * @param elemento el elemento a agregar
     */
    void alta(T elemento);


    /**
     * Busca un elemento en el sistema utilizando una clave primaria.
     *
     * @param clave la clave primaria del elemento
     * @return el elemento encontrado o null si no existe
     */
    T buscar(K clave);

    /**
     * Recupera un elemento por índice en una lista ordenada.
     *
     * @param indice el índice del elemento
     * @return el elemento correspondiente o null si el índice no es válido
     */
    T recuperar(V indice);

    /**
     * Devuelve el número total de elementos gestionados.
     *
     * @return el número de elementos
     */
    int numeroElementos();

    /**
     * Devuelve una lista con todos los elementos gestionados.
     *
     * @return la lista de elementos
     */
    List<T> listar();
}
