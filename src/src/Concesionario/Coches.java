package Concesionario;


//Idcoche debe tener cierto formato

public class Coches {
    private String idcoche;
    private int precio;
    private int stock;

    public Coches(int stock, int precio, String idcoche) {
        this.stock = stock;
        this.precio = precio;
        this.idcoche = idcoche;
    }
}
