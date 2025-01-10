package Mejoras;

/**
 * La clase Cuero es un decorador concreto que extiende DecoradorMejora}.
 * Añade la funcionalidad de tapicería de cuero a una mejora existente.
 * Esta clase modifica el precio y la descripción de la mejora original para incluir
 * el efecto de la tapicería de cuero.
 */
public class Cuero extends DecoradorMejoras{
    /**
     * Constructor que inicializa el decorador {@code Cuero} con una mejora base.
     *
     * @param mejoras La mejora a decorar con tapicería de cuero.
     */
    public Cuero(Mejoras mejoras){
        super(mejoras);
    }

    /**
     * Obtiene el precio de la mejora decorada, aplicando un incremento del 10% debido a la tapicería de cuero.
     *
     * @return El precio de la mejora con tapicería de cuero.
     */
    @Override
    public double getPrecio() {
        return super.getPrecio() * 1.10;
    }

    /**
     * Obtiene la descripción de la mejora decorada, añadiendo información sobre la tapicería de cuero.
     *
     * @return La descripción de la mejora con tapicería de cuero.
     */
    @Override
    public String getDescripcion() {
        return super.getDescripcion() + "Tapicería de cuero ";
    }
}
