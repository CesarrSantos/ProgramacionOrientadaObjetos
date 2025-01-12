package Mejoras;

/**
 * La clase Gps es un decorador concreto que extiende DecoradorMejoras.
 * Añade la funcionalidad de un sistema GPS a una mejora existente.
 * Esta clase modifica el precio y la descripción de la mejora original para incluir
 * el efecto de un GPS, con sistema de geolocalización y asistencia en ruta.
 */
public class Gps extends DecoradorMejoras{
    /**
     * Constructor que inicializa el decorador {@code Gps} con una mejora base.
     *
     * @param mejoras La mejora a decorar con GPS.
     */
    public Gps(Mejoras mejoras){
        super(mejoras);
    }

    /**
     * Obtiene el precio de la mejora decorada, aplicando un incremento del 1% debido al GPS.
     *
     * @return El precio de la mejora con GPS.
     */
    @Override
    public double getPrecio() {
        return super.getPrecio() * 1.01;
    }

    /**
     * Obtiene la descripción de la mejora decorada, añadiendo información sobre el GPS
     * y su funcionalidad de geolocalización y asistencia en ruta.
     *
     * @return La descripción de la mejora con GPS.
     */
    @Override
    public String getDescripcion() {
        return super.getDescripcion() + "- GPS (Sistema de geolocalización y asistencia en ruta)\n";
    }
}
