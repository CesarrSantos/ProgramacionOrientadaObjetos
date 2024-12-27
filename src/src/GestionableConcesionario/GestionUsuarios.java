package GestionableConcesionario;


import Concesionario.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GestionUsuarios implements IGestionableCliente, Serializable {
    private final ArrayList<Cliente> clientes = new ArrayList<>();
    final Concesionario concesionario;


    public GestionUsuarios(Concesionario concesionario) {
        this.concesionario = concesionario;
    }

    @Override
    public void alta(Cliente cliente) {
        if (!existeCliente(cliente.getDni())) {
            clientes.add(cliente);
            System.out.println("Cliente añadido exitosamente.");
        } else {
            System.out.println("Ya existe un cliente con ese DNI.");
        }
    }

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

    @Override
    public Cliente recuperar(Integer indice) {
        if (indice >= 0 && indice < clientes.size()) {
            return clientes.get(indice);
        }
        System.out.println("Índice fuera de rango.");
        return null;
    }

    @Override
    public int numeroElementos() {
        return clientes.size();
    }

    @Override
    public List<Cliente> listar() {
        return new ArrayList<>(clientes);
    }

    @Override
    public void listarClientesPublicidad() {
        System.out.println("Clientes que quieren recibir publicidad:");
        boolean encontrado = false;
        for (Cliente cliente : clientes) {
            if (cliente.isRecibePublicidad()) {
                System.out.println(cliente.getNombre() + " " + cliente.getApellido());
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No hay clientes que reciban publicidad.");
        }
    }

    @Override
    public void listarClienteDni(String dni) {
        Cliente cliente = buscar(dni);
        if (cliente != null) {
            System.out.println("Cliente encontrado:");
            System.out.println("DNI: " + cliente.getDni());
            System.out.println("Nombre: " + cliente.getNombre());
            System.out.println("Apellido: " + cliente.getApellido());
            System.out.println("Recibe publicidad: " + (cliente.isRecibePublicidad() ? "Sí" : "No"));
        }
    }

    @Override
    public void listarClientes() {
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados.");
            return;
        }

        System.out.println("Lista de clientes:");
        for (Cliente cliente : clientes) {
            System.out.println("DNI: " + cliente.getDni());
            System.out.println("Nombre: " + cliente.getNombre() + " " + cliente.getApellido());
            System.out.println("---------------------");
        }
    }

    private boolean existeCliente(String dni) {
        return buscar(dni) != null;
    }
}
