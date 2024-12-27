package GestionableConcesionario;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Concesionario.Coches;
import Concesionario.Seccion;

public class GestionSeccion implements IGestionableSeccion {
    private ArrayList<Seccion> secciones = new ArrayList<>();

    @Override
    public void alta(Seccion seccion) {
        if (!existeSeccion(seccion.getIdSeccion())) {
            secciones.add(seccion);
            System.out.println("Sección añadida correctamente.");
        } else {
            System.out.println("Ya existe una sección con ID " + seccion.getIdSeccion());
        }
    }

    @Override
    public Seccion buscar(String idSeccion) {
        for (Seccion seccion : secciones) {
            if (seccion.getIdSeccion().equals(idSeccion)) {
                return seccion;
            }
        }
        return null;
    }

    @Override
    public Seccion recuperar(Integer indice) {
        if (indice >= 0 && indice < secciones.size()) {
            return secciones.get(indice);
        }
        return null;
    }

    @Override
    public int numeroElementos() {
        return secciones.size();
    }

    @Override
    public List<Seccion> listar() {
        return new ArrayList<>(secciones);
    }

    @Override
    public void mostrarSecciones() {
        if (secciones.isEmpty()) {
            System.out.println("No hay secciones disponibles.");
        } else {
            for (Seccion seccion : secciones) {
                System.out.println("ID: " + seccion.getIdSeccion() + ", Descripción: " + seccion.getDescripcion());
            }
        }
    }


    public boolean cochesEnSeccion(String idSeccion) {return true;}
//   @Override
//    public boolean cochesEnSeccion(String idSeccion, ArrayList<Coches> coches) {
//        for (Coches coche : coches) {
//            if (coche.getIdSeccion().equals(idSeccion)) {
//                return true;
//            }
//        }
//        return false;
//    }

    private boolean existeSeccion(String idSeccion) {
        return buscar(idSeccion) != null;
    }

    public void bajaSeccion(String idSeccion) {
        if (cochesEnSeccion(idSeccion)) {
            System.out.println("No se puede eliminar la sección porque contiene coches.");
            return;
        }
        if (secciones.removeIf(seccion -> seccion.getIdSeccion().equals(idSeccion))) {
            System.out.println("Sección eliminada correctamente.");
        } else {
            System.out.println("No se encontró una sección con ID " + idSeccion);
        }
    }
}
