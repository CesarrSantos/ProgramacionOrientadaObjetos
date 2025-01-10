package Concesionario;

import Mejoras.Mejoras;

import java.io.Serializable;
import java.time.LocalDate;



/**
 * Clase que representa una venta realizada en el concesionario.
 * Implementa la interfaz {@link Serializable} para permitir la serialización de sus objetos.
 */
public class Venta implements Serializable {
    private final String identificadorVenta;
    private final Cliente cliente;
    private final LocalDate fecha;
    private final String matricula;
    private final Mejoras mejoras;
    private final int precio;

    /**
     * Constructor de la clase Venta.
     * Inicializa una nueva venta con los datos proporcionados.
     *
     * @param identificadorVenta El identificador único de la venta.
     * @param cliente            El cliente asociado a la venta.
     * @param fecha              La fecha en la que se realizó la venta.
     * @param matricula          La matrícula del coche vendido.
     * @param precio             El precio de la venta.
     * @param mejoras            Mejoras aplicadas
     */
    public Venta(String identificadorVenta, Cliente cliente, LocalDate fecha, String matricula, int precio, Mejoras mejoras) {
        this.identificadorVenta = identificadorVenta;
        this.cliente = cliente;
        this.fecha = fecha;
        this.matricula = matricula;
        this.precio = precio;
        this.mejoras = new Mejoras();
    }

    /**
     * Obtiene el identificador único de la venta.
     *
     * @return El identificador de la venta.
     */
    public String getIdentificadorVenta() {
        return identificadorVenta;
    }

    /**
     * Obtiene el cliente asociado a la venta.
     *
     * @return El cliente de la venta.
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * Obtiene la fecha en la que se realizó la venta.
     *
     * @return La fecha de la venta.
     */
    public LocalDate getFecha() {
        return fecha;
    }

    /**
     * Obtiene la matrícula del coche vendido en esta venta.
     *
     * @return La matrícula del coche.
     */
    public String getMatricula() {
        return matricula;
    }

}