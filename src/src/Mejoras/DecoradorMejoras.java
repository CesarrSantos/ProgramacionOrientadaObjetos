package Mejoras;

public abstract class DecoradorMejoras extends Mejoras {
    private Mejoras mejoras;

    public DecoradorMejoras(Mejoras mejoras){
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
