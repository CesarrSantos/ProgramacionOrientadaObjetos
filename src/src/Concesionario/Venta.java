package Concesionario;

import Mejoras.Mejoras;

import java.time.LocalDate;
import java.util.Date;


//IdentificadorVenta debe ser diferente

public class Venta {
    private String identificadorVenta;
    private Cliente cliente;
    private LocalDate fecha;
    private String matricula;
    private Mejoras mejoras;
    private int precio;


    public Venta(String identificadorVenta, Cliente cliente, LocalDate fecha, String matricula, int precio, Mejoras mejoras) {
        this.identificadorVenta = identificadorVenta;
        this.cliente = cliente;
        this.fecha = fecha;
        this.matricula = matricula;
        this.precio = precio;
        this.mejoras = new Mejoras();
    }

    //Decorar mejoras
    public String getIdentificadorVenta() {
        return identificadorVenta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public String getMatricula() {
        return matricula;
    }

    public int getPrecio() {
        return precio;
    }
}