package GestionableConcesionario;
import Concesionario.*;
import java.util.ArrayList;
import java.util.List;

public interface IGestionable <T>{

    List<Coches> coches = new ArrayList<>();


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

    //Gestion de Coches

    static void agregarCoche(GestionCoches gestionCoches) {
        gestionCoches.agregarCoche();
    }
    static void mostrarDetallesSeccion(GestionCoches gestionCoches) {
        gestionCoches.mostrarDetallesSeccion();
    }
    static void aumentarStock(GestionCoches gestionCoches) {
        gestionCoches.aumentarStock();
    }
    static void detalleEspecificosCoche(GestionCoches gestionCoches) {
        gestionCoches.detalleEspecificosCoche();
    }
}
