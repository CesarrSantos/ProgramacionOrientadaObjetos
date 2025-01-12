package GestionableConcesionario;

public interface IGestionable<T, K,V> {
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
}
