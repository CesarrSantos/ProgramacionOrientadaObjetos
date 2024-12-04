package Mejoras;

public class Gps extends DecoradorMejoras{
    public Gps(Mejoras mejoras){
        super(mejoras);
    }

    @Override
    public double getPrecio() {
        return super.getPrecio() * 1.01;
    }

    @Override
    public String getDescripcion() {
        return super.getDescripcion() + "GPS (Sistema de geolocalización y asistencia en ruta) ";
    }
}
