package Mejoras;

/**
 * La clase Llantas es un decorador concreto que extiende DecoradorMejoras.
 * Añade la funcionalidad de llantas de aleación a una mejora existente.
 * Esta clase modifica el precio y la descripción de la mejora original para incluir
 * el efecto de las llantas de aleación.
 */
public class Llantas extends DecoradorMejoras{
    /**
     * Constructor que inicializa el decorador {@code Llantas} con una mejora base.
     *
     * @param mejoras La mejora a decorar con llantas de aleación.
     */
    public Llantas(Mejoras mejoras){
        super(mejoras);
    }
    /**
     * Obtiene el precio de la mejora decorada, aplicando un incremento del 5% debido a las llantas de aleación.
     *
     * @return El precio de la mejora con llantas de aleación.
     */
    @Override
    public double getPrecio() {
        return super.getPrecio() * 1.05;
    }
    /**
     * Obtiene la descripción de la mejora decorada, añadiendo información sobre las llantas de aleación.
     *
     * @return La descripción de la mejora con llantas de aleación.
     */
    @Override
    public String getDescripcion() {
        return super.getDescripcion() + "Llantas de aleación ";
    }
}
