package Mejoras;

import java.io.Serializable;

/**
 * La clase {@code Mejoras} representa las mejoras disponibles en el sistema.
 * Implementa la interfaz Serializable para permitir su serialización.
 * Esta clase contiene información sobre el precio multiplicador de la mejora y su descripción.
 */
public class Mejoras implements Serializable {
    private final double multiplicador_precio = 1.0;
    private final String descripcion = "";

    /**
     * Constructor por defecto que inicializa los atributos de la mejora con valores por defecto.
     */
    public Mejoras(){

    }
    /**
     * Obtiene el precio multiplicador de la mejora.
     *
     * @return El valor del precio multiplicador.
     */
    public double getPrecio(){
        return this.multiplicador_precio;
    }

    /**
     * Obtiene la descripción de la mejora.
     *
     * @return La descripción de la mejora.
     */
    public String getDescripcion(){
        return this.descripcion;
    }
}
