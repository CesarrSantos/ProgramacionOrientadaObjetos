package GestionableConcesionario;


import EntradaSalida.MyInput;
import Concesionario.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GestionUsuarios implements IGestionableCliente, Serializable {
    private ArrayList<Cliente> clientes = new ArrayList<>();

    @Override
    public void alta(Cliente cliente) {
        clientes.add(cliente);
        System.out.println("Cliente añadido exitosamente.");
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
        return Collections.emptyList();
    }

    @Override
    public void listarClientesPublicidad() {
        System.out.println("Clientes que quieren recibir publicidad:");
        for (Cliente cliente : clientes) {
            if (cliente.isRecibePublicidad()) {
                System.out.println(cliente.getNombre() + " " + cliente.getApellido());
            }
        }
    }

    @Override
    public void listarClienteDni(String dni) {
        Cliente cliente = buscar(dni);
        if (cliente != null) {
            System.out.println("Cliente encontrado: " + cliente.getNombre() + " " + cliente.getApellido());
        }
    }

    @Override
    public void listarClientes() {
        System.out.println("Lista de clientes:");
        for (Cliente cliente : clientes) {
            System.out.println(cliente.getNombre() + " " + cliente.getApellido());
        }
    }
}
