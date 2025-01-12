package Concesionario;

import java.io.Serializable;

/**
 * Clase que representa una sección dentro del concesionario.
 * Implementa la interfaz {@link Serializable} para permitir la serialización de sus objetos.
 */
public class Seccion implements Serializable {
    private final String idSeccion;
    private final String descripcion;

    /**
     * Constructor de la clase Seccion.
     * Inicializa una nueva sección con los datos proporcionados.
     *
     * @param idSeccion   El identificador único de la sección.
     * @param descripcion La descripción de la sección.
     */
    public Seccion(String idSeccion,String descripcion) {
        this.idSeccion = idSeccion;
        this.descripcion = descripcion;
    }

    /**
     * Obtiene el identificador único de la sección.
     *
     * @return El identificador de la sección.
     */
    public String getIdSeccion() {
        return idSeccion;
    }

    /**
     * Obtiene la descripción de la sección.
     *
     * @return La descripción de la sección.
     */
    public String getDescripcion() {
        return descripcion;
    }

}
