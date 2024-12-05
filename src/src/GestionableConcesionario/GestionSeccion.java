package GestionableConcesionario;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import Concesionario.*;
import EntradaSalida.MyInput;

public class GestionSeccion implements IGestionable<Seccion> {

    private static List<Seccion> secciones = new ArrayList<>();
    private static List<Coches> coches = new ArrayList<>();

    public void agregarSeccion(GestionSeccion gestionSeccion) {
        System.out.println("Nombre de la seccion:");
        String idSeccion = MyInput.readString();
        System.out.println("Descripcion de la seccion:");
        String decripcion =MyInput.readString();

        if (existeSeccion(idSeccion)) {
            System.out.println("Ya exsiste una seccion con el id: " + idSeccion);
        }else {
            secciones.add(new Seccion(idSeccion, decripcion));
            System.out.println("Seccion añadida exitosamente.");
        }

    }
    public void mostrarSecciones(GestionSeccion gestionSeccion) {
        for (Seccion secciones : secciones) {
            System.out.println("Nombre de la seccion: "+secciones.getIdSeccion() +" descripcion de la seccion: "+secciones.getDescripcion() );
        }

    }

    public void bajaSeccion(GestionSeccion gestionSeccion) {
        System.out.println("Introduce el ID de la sección a eliminar:");
        String idSeccion = MyInput.readString();

        if (!existeSeccion(idSeccion)) {
            System.out.println("No existe una sección con el ID: " + idSeccion);
            return;
        }

        if (cochesEnSeccion(idSeccion)) {
            System.out.println("No se puede eliminar la sección porque contiene coches.");
            return;
        }

        secciones.removeIf(seccion -> seccion.getIdSeccion().equals(idSeccion));
        System.out.println("Sección eliminada exitosamente.");

    }

    private boolean existeSeccion(String idSeccion){
        for (Seccion secciones : secciones) {
            return secciones.getIdSeccion().equals(idSeccion);
        }
        return false;
    }

    private boolean cochesEnSeccion(String idSeccion){
        for (Coches coche : coches) {
            if (coche.getIdSeccion().equals(idSeccion)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Seccion> listar() {
        return secciones;
    }
}
