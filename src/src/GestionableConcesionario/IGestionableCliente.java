package GestionableConcesionario;
import Concesionario.Cliente;

import java.io.Serializable;


public interface IGestionableCliente extends IGestionable<Cliente, String, Integer> {
    void listarClientesPublicidad();
    void listarClienteDni(String dni);
    void listarClientes();
}
