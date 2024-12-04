package Mejoras;

public class Llantas extends DecoradorMejoras{
    public Llantas(Mejoras mejoras){
        super(mejoras);
    }

    @Override
    public double getPrecio() {
        return super.getPrecio() * 1.05;
    }

    @Override
    public String getDescripcion() {
        return super.getDescripcion() + "Llantas de aleación ";
    }
}
