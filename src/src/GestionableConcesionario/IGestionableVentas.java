package GestionableConcesionario;
import Concesionario.Venta;
import Concesionario.Cliente;

import java.util.List;

/**
 * Interfaz IGestionableVentas que extiende la interfaz IGestionable.
 * Define las operaciones específicas para la gestión de ventas.
 */
public interface IGestionableVentas extends  IGestionable<Venta, String, Integer>{

    /**
     * Recupera una venta según su índice en la lista.
     *
     * @param indice el índice de la venta que se desea recuperar.
     * @return la venta ubicada en la posición especificada.
     */
    Venta recuperar(Integer indice);

    /**
     * Devuelve el número total de ventas gestionadas.
     *
     * @return la cantidad de ventas.
     */
    int numeroElementos();

    /**
     * Devuelve una lista con todas las ventas gestionadas.
     *
     * @return una lista de objetos Venta.
     */
    List<Venta> listar();

    /**
     * Lista una venta específica basada en su identificador único.
     *
     * @param clave el identificador de la venta que se desea listar.
     */
    void listarVenta(String clave);

    /**
     * Lista todas las ventas realizadas por un cliente específico.
     *
     * @param cliente el cliente cuyas ventas se desean listar.
     */
    void listarVentas(Cliente cliente);
}
