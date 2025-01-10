package GestionableConcesionario;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import Concesionario.Coches;
import Concesionario.Seccion;

/**
 * Clase GestionSeccion que implementa la interfaz IGestionableSeccion y Serializable.
 * Se encarga de gestionar una lista de secciones, proporcionando operaciones para alta,
 * búsqueda, recuperación, listado y eliminación de secciones.
 */
public class GestionSeccion implements IGestionableSeccion, Serializable {
    private final ArrayList<Seccion> secciones = new ArrayList<>();

    /**
     * Agrega una sección a la lista si no existe previamente.
     *
     * @param seccion la sección que se desea añadir.
     */
    @Override
    public void alta(Seccion seccion) {
        if (!existeSeccion(seccion.getIdSeccion())) {
            secciones.add(seccion);
            System.out.println("Sección añadida correctamente.");
        } else {
            System.out.println("Ya existe una sección con ID " + seccion.getIdSeccion());
        }
    }

    /**
     * Busca una sección en la lista por su identificador único.
     *
     * @param idSeccion el identificador de la sección que se desea buscar.
     * @return la sección encontrada, o {@code null} si no se encuentra.
     */
    @Override
    public Seccion buscar(String idSeccion) {
        for (Seccion seccion : secciones) {
            if (seccion.getIdSeccion().equals(idSeccion)) {
                return seccion;
            }
        }
        return null;
    }

    /**
     * Recupera una sección de la lista según su índice.
     *
     * @param indice el índice de la sección a recuperar.
     * @return la sección en la posición especificada, o {@code null} si el índice es inválido.
     */
    @Override
    public Seccion recuperar(Integer indice) {
        if (indice >= 0 && indice < secciones.size()) {
            return secciones.get(indice);
        }
        return null;
    }

    /**
     * Devuelve el número de secciones gestionadas.
     *
     * @return el número de elementos en la lista.
     */
    @Override
    public int numeroElementos() {
        return secciones.size();
    }

    /**
     * Devuelve una lista con todas las secciones gestionadas.
     *
     * @return una copia de la lista de secciones.
     */
    @Override
    public List<Seccion> listar() {
        return new ArrayList<>(secciones);
    }

    /**
     * Muestra todas las secciones en la lista con su ID y descripción.
     * Si no hay secciones, muestra un mensaje indicando que la lista está vacía.
     */
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

    /**
     * Verifica si existen coches asociados a una sección específica.
     *
     * @param idSeccion el identificador de la sección.
     * @param coches la lista de coches a verificar.
     * @return {@code true} si hay coches en la sección, {@code false} en caso contrario.
     */
    @Override
    public boolean cochesEnSeccion(String idSeccion, ArrayList<Coches> coches) {
        for (Coches coche : coches) {
            if (coche.getIdSeccion().equals(idSeccion)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Verifica si existe una sección con un identificador específico.
     *
     * @param idSeccion el identificador de la sección.
     * @return {@code true} si la sección existe, {@code false} en caso contrario.
     */
    public boolean existeSeccion(String idSeccion) {
        return buscar(idSeccion) != null;
    }

    /**
     * Elimina una sección de la lista si no tiene coches asociados.
     *
     * @param idSeccion el identificador de la sección que se desea eliminar.
     * @param coches la lista de coches para verificar asociaciones.
     */
    public void bajaSeccion(String idSeccion, ArrayList<Coches> coches) {
        if (cochesEnSeccion(idSeccion, coches)) {
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
