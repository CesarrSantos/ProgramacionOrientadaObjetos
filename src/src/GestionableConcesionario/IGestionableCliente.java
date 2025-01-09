package GestionableConcesionario;
import Concesionario.Cliente;

import java.util.List;


public interface IGestionableCliente extends IGestionable<Cliente, String, Integer> {
    Cliente recuperar(Integer indice);

    int numeroElementos();

    List<Cliente> listar();

    void listarClientesPublicidad();
    void listarClienteDni(String dni);
    void listarClientes();
}
