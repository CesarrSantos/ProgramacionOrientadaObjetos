package GestionableConcesionario;

import java.util.List;
import Concesionario.*;
public interface IGestionable <T>{


    void agregarCliente(GestionUsuarios gestionUsuarios);

    static void listarClientes(GestionUsuarios gestionUsuarios){
        gestionUsuarios.listarClientes(gestionUsuarios);
    }

    static void listarClientesPublicidad(GestionUsuarios gestionUsuarios){
        gestionUsuarios.listarClientes(gestionUsuarios);
    }
    static void listarClienteDni(GestionUsuarios gestionUsuarios){
        gestionUsuarios.listarClientes(gestionUsuarios);
    }

    List<Cliente> listar();
}
