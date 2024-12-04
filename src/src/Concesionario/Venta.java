package Concesionario;

import Mejoras.Mejoras;

import java.util.Date;


//IdentificadorVenta debe ser diferente

public class Venta {
    private String identificadorVenta;
    private Cliente cliente;
    private Date fecha;
    private String matricula;
    private Mejoras Mejora;
    private int precio;


    public Venta(String identificadorVenta, Cliente cliente, Date fecha, String matricula, int precio) {
        this.identificadorVenta = identificadorVenta;
        this.cliente = cliente;
        this.fecha = fecha;
        this.matricula = matricula;
        this.precio = precio;
    }

    //Decorar mejoras



}