package Mejoras;

public class Calefaccion extends DecoradorMejoras{
    public Calefaccion(Mejoras mejoras){
        super(mejoras);
    }

    @Override
    public double getPrecio() {
        return super.getPrecio() * 1.05;
    }

    @Override
    public String getDescripcion() {
        return super.getDescripcion() + " Calefacción en los asientos y el volante  ";
    }
}
