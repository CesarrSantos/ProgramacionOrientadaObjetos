package Mejoras;

public abstract class Mejoras {
    protected int precioBase;

    public Mejoras(int precioBase) {
        this.precioBase = precioBase;
    }

    public abstract double getPrecio(); // Returns the price of the upgrade
    public abstract String getDescripcion(); // Returns the description of the upgrade
}