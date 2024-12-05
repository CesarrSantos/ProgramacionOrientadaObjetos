package GestionableConcesionario;

import java.util.List;

public interface IGestionable <T>{

    //Gestion de Clientes
    static void agregarCliente(GestionUsuarios gestionUsuarios) {
        gestionUsuarios.agregarCliente(gestionUsuarios);
    }

    static void listarClientes(GestionUsuarios gestionUsuarios){
        gestionUsuarios.listarClientes(gestionUsuarios);
    }

    static void listarClientesPublicidad(GestionUsuarios gestionUsuarios){
        gestionUsuarios.listarClientes(gestionUsuarios);
    }
    static void listarClienteDni(GestionUsuarios gestionUsuarios){
        gestionUsuarios.listarClientes(gestionUsuarios);
    }

    List<T> listar();

    //Gestion de Secciones

    static void agregarSeccion(GestionSeccion gestionSeccion) {
        gestionSeccion.agregarSeccion(gestionSeccion);
    }
    static void mostrarSecciones(GestionSeccion gestionSeccion){
        gestionSeccion.mostrarSecciones(gestionSeccion);
    }

    static void bajaSeccion(GestionSeccion gestionSeccion){
        gestionSeccion.bajaSeccion(gestionSeccion);
    }
}
