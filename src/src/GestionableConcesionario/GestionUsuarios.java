package GestionableConcesionario;

import Concesionario.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Clase GestionUsuarios que implementa la interfaz IGestionableCliente y Serializable.
 * Gestiona una lista de clientes, proporcionando operaciones como alta, búsqueda, recuperación,
 * y listados personalizados.
 */
public class GestionUsuarios implements IGestionableCliente, Serializable {
    private final ArrayList<Cliente> clientes = new ArrayList<>();

    /**
     * Agrega un cliente a la lista.
     *
     * @param cliente el cliente que se desea añadir.
     */
    @Override
    public void alta(Cliente cliente) {
        clientes.add(cliente);
        System.out.println("Cliente añadido exitosamente.");
    }

    /**
     * Busca un cliente en la lista por su DNI.
     *
     * @param dni el DNI del cliente que se desea buscar.
     * @return el cliente encontrado, o {@code null} si no se encuentra.
     */
    @Override
    public Cliente buscar(String dni) {
        for (Cliente cliente : clientes) {
            if (cliente.getDni().equals(dni)) {
                return cliente;
            }
        }
        System.out.println("Cliente no encontrado.");
        return null;
    }

    /**
     * Recupera un cliente de la lista según su índice.
     *
     * @param indice el índice del cliente que se desea recuperar.
     * @return el cliente en la posición especificada, o {@code null} si el índice es inválido.
     */
    @Override
    public Cliente recuperar(Integer indice) {
        if (indice >= 0 && indice < clientes.size()) {
            return clientes.get(indice);
        }
        System.out.println("Indice fuera de rango.");
        return null;
    }

    /**
     * Devuelve el número de clientes gestionados.
     *
     * @return el número de elementos en la lista.
     */
    @Override
    public int numeroElementos() {
        return clientes.size();
    }

    /**
     * Devuelve una lista vacía. Este método no devuelve los clientes por diseño actual.
     *
     * @return una lista vacía.
     */
    @Override
    public List<Cliente> listar() {
        return Collections.emptyList();
    }

    /**
     * Lista los clientes que desean recibir publicidad.
     * Muestra el DNI, nombre completo y telefono de cada cliente.
     */
    @Override
    public void listarClientesPublicidad() {
        System.out.println("Clientes que quieren recibir publicidad:");
        for (Cliente cliente : clientes) {
            if (cliente.isRecibePublicidad()) {
                System.out.println("DNI: " + cliente.getDni() +
                                   " Nombre: " + cliente.getNombre() + " " + cliente.getApellido() +
                                   " Telefono: " + cliente.getTelefono());
            }
        }
    }

    /**
     * Muestra la información de un cliente específico basado en su DNI.
     *
     * @param dni el DNI del cliente que se desea listar.
     */
    @Override
    public void listarClienteDni(String dni) {
        Cliente cliente = buscar(dni);
        if (cliente != null) {
            System.out.println("Nombre: " + cliente.getNombre() + " " + cliente.getApellido() + " Telefono: " + cliente.getTelefono());
        }
    }

    /**
     * Lista todos los clientes gestionados, mostrando su DNI, nombre completo y telefono.
     */
    @Override
    public void listarClientes() {
        System.out.println("Lista de clientes:");
        for (Cliente cliente : clientes) {
            System.out.println("DNI: " + cliente.getDni() +
                    " Nombre: " + cliente.getNombre() + " " + cliente.getApellido() +
                    " Telefono: " + cliente.getTelefono());
        }
    }
}
