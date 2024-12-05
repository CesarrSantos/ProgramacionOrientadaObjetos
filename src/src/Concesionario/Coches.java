package Concesionario;


//Idcoche debe tener cierto formato

public class Coches {
    private String idSeccion;
    private String idCoche;
    private int precio;
    private int stock;

    public Coches(int stock, int precio, String idcoche,String idSeccion) {
        this.idSeccion = idSeccion;
        this.stock = stock;
        this.precio = precio;
        this.idCoche = idcoche;
    }
    public String getIdSeccion() {
        return idSeccion;
    }

    public String getIdCoche() {
        return idCoche;
    }

    public int getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }
}
