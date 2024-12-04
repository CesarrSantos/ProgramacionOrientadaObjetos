package Mejoras;

public class Mejoras {
    private double multiplicador_precio = 1.0;
    private String descripcion = "";

    public Mejoras(){

    }

    public double getPrecio(){
        return this.multiplicador_precio;
    }

    public String getDescripcion(){
        return this.descripcion;
    }
}
