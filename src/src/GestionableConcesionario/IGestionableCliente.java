package GestionableConcesionario;
import Concesionario.Cliente;


public interface IGestionableCliente extends IGestionable<Cliente, String, Integer> {
    void listarClientesPublicidad();
    void listarClienteDni(String dni);
    void listarClientes();
}
