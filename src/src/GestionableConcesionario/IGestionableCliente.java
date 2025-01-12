package GestionableConcesionario;

import Concesionario.Cliente;
import java.util.List;

/**
 * Interfaz IGestionableCliente que extiende la interfaz IGestionable.
 * Define las operaciones específicas para la gestión de clientes.
 */
public interface IGestionableCliente extends IGestionable<Cliente, String, Integer> {

    /**
     * Recupera un cliente según su índice en la lista.
     *
     * @param indice el índice del cliente que se desea recuperar.
     * @return el cliente ubicado en la posición especificada.
     */
    Cliente recuperar(Integer indice);

    /**
     * Devuelve el número total de clientes gestionados.
     *
     * @return la cantidad de clientes.
     */
    int numeroElementos();

    /**
     * Devuelve una lista con todos los clientes gestionados.
     *
     * @return una lista de objetos Cliente.
     */
    List<Cliente> listar();

    /**
     * Lista los clientes que desean recibir publicidad.
     * Muestra información relevante de estos clientes.
     */
    void listarClientesPublicidad();

    /**
     * Lista la información de un cliente específico basado en su DNI.
     *
     * @param dni el DNI del cliente que se desea listar.
     */
    void listarClienteDni(String dni);

    /**
     * Lista todos los clientes gestionados.
     * Muestra información relevante de cada cliente.
     */
    void listarClientes();
}
