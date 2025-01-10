package Mejoras;

/**
 * La clase DecoradorMejoras es una clase abstracta que extiende Mejoras.
 * Sirve como base para los decoradores que añaden funcionalidades adicionales a las mejoras.
 * Esta clase implementa el patrón de diseño Decorador, permitiendo modificar el comportamiento
 * de las mejoras sin modificar su clase original.
 */
public abstract class DecoradorMejoras extends Mejoras {
    private Mejoras mejoras;

    /**
     * Constructor que inicializa el decorador con una mejora base.
     *
     * @param mejoras La mejora a decorar.
     */
    public DecoradorMejoras(Mejoras mejoras){
        this.mejoras = mejoras;
    }

    /**
     * Obtiene el precio de la mejora decorada.
     *
     * @return El precio de la mejora decorada.
     */
    @Override
    public double getPrecio() {
        return mejoras.getPrecio();
    }

    /**
     * Obtiene la descripción de la mejora decorada.
     *
     * @return La descripción de la mejora decorada.
     */
    @Override
    public String getDescripcion() {
        return mejoras.getDescripcion();
    }
}

