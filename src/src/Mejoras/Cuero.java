package Mejoras;

public class Cuero extends DecoradorMejoras{
    public Cuero(Mejoras mejoras){
        super(mejoras);
    }

    @Override
    public double getPrecio() {
        return super.getPrecio() * 1.10;
    }

    @Override
    public String getDescripcion() {
        return super.getDescripcion() + "Tapicería de cuero ";
    }
}
