package Mejoras;

public abstract class DecoradorMejoras extends Mejoras {
    protected Mejoras mejoras;

    public DecoradorMejoras(Mejoras mejoras) {
        super(mejoras.precioBase);
        this.mejoras = mejoras;
    }

    @Override
    public double getPrecio() {
        return mejoras.getPrecio();
    }

    @Override
    public String getDescripcion() {
        return mejoras.getDescripcion();
    }
}
