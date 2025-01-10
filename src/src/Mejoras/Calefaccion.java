package Mejoras;

/**
 * La clase Calefaccion es un decorador concreto que extiende  DecoradorMejoras.
 * Añade una funcionalidad adicional de calefacción a una mejora existente.
 * Esta clase modifica el precio y la descripción de la mejora original para incluir
 * el efecto de la calefacción en los asientos y el volante.
 */
public class Calefaccion extends DecoradorMejoras{
    /**
     * Constructor que inicializa el decorador {@code Calefaccion} con una mejora base.
     *
     * @param mejoras La mejora a decorar con calefacción.
     */
    public Calefaccion(Mejoras mejoras){
        super(mejoras);
    }

    /**
     * Obtiene el precio de la mejora decorada, aplicando un incremento del 5% debido a la calefacción.
     *
     * @return El precio de la mejora con calefacción.
     */
    @Override
    public double getPrecio() {
        return super.getPrecio() * 1.05;
    }

    /**
     * Obtiene la descripción de la mejora decorada, añadiendo información sobre la calefacción
     * en los asientos y el volante.
     *
     * @return La descripción de la mejora con calefacción.
     */
    @Override
    public String getDescripcion() {
        return super.getDescripcion() + "Calefacción en los asientos y el volante ";
    }
}
