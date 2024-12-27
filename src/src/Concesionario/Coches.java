package Concesionario;


//Idcoche debe tener cierto formato

import java.io.Serializable;

public class Coches implements Serializable {
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

    public void setIdSeccion(String idSeccion) {
        this.idSeccion = idSeccion;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
