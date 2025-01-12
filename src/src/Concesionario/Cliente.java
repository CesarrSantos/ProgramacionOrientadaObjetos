package Concesionario;

import java.io.Serializable;

/**
 * Clase que representa un cliente del concesionario.
 * Implementa la interfaz {@link Serializable} para permitir la serialización de sus objetos.
 */
public class Cliente implements Serializable {
    private final String dni;
    private final String nombre;
    private final String apellido;
    private final String telefono;
    private final boolean recibePublicidad;

    /**
     * Constructor de la clase Cliente.
     * Inicializa un nuevo cliente con los datos proporcionados.
     *
     * @param dni              El DNI del cliente. Debe ser único y seguir el formato correcto.
     * @param nombre           El nombre del cliente.
     * @param apellido         El apellido del cliente.
     * @param telefono         El número de teléfono del cliente.
     * @param recibePublicidad Indica si el cliente desea recibir publicidad (true) o no (false).
     */
    public Cliente(String dni, String nombre, String apellido,String telefono, boolean recibePublicidad) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.recibePublicidad = recibePublicidad;
    }

    /**
     * Obtiene el DNI del cliente.
     *
     * @return El DNI del cliente.
     */
    public String getDni() {
        return dni;
    }

    /**
     * Indica si el cliente desea recibir publicidad.
     *
     * @return {@code true} si el cliente desea recibir publicidad; {@code false} en caso contrario.
     */
    public boolean isRecibePublicidad() {
        return recibePublicidad;
    }

    /**
     * Obtiene el apellido del cliente.
     *
     * @return El apellido del cliente.
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Obtiene el nombre del cliente.
     *
     * @return El nombre del cliente.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene el telefono del cliente.
     *
     * @return El telefono del cliente.
     */
    public String getTelefono() {
        return telefono;
    }
}
