package Concesionario;


import java.io.Serializable;

public class Seccion implements Serializable {
    private String idSeccion;
    private String descripcion;

    public Seccion(String idSeccion,String descripcion) {
        this.idSeccion = idSeccion;
        this.descripcion = descripcion;
    }

    public Seccion() {
    }

    public String getIdSeccion() {
        return idSeccion;
    }

    public void setIdSeccion(String idSeccion) {
        this.idSeccion = idSeccion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
