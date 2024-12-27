package Mejoras;

public class MejorasBase extends Mejoras {

    public MejorasBase(int precioBase) {
        super(precioBase);
    }

    @Override
    public double getPrecio() {
        return precioBase;
    }

    @Override
    public String getDescripcion() {
        return "Precio base del coche ";
    }
}
