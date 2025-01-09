package Concesionario;




import java.io.Serializable;
/**
 * Clase que representa un coche dentro del concesionario.
 * Implementa la interfaz {@link Serializable} para permitir la serialización de sus objetos.
 */
public class Coches implements Serializable {
    private String idSeccion;
    private final String idCoche;
    private final int precio;
    private int stock;

    /**
     * Constructor de la clase Coches.
     * Inicializa un nuevo coche con los datos proporcionados.
     *
     * @param stock      El stock inicial del coche. Debe ser mayor o igual a 1.
     * @param precio     El precio del coche. Debe ser mayor o igual a 0.
     * @param idcoche    El identificador único del coche. Debe seguir un formato válido.
     * @param idSeccion  El identificador de la sección a la que pertenece el coche.
     */
    public Coches(int stock, int precio, String idcoche,String idSeccion) {
        this.idSeccion = idSeccion;
        this.stock = stock;
        this.precio = precio;
        this.idCoche = idcoche;

    }

    /**
     * Obtiene el identificador de la sección a la que pertenece el coche.
     *
     * @return El identificador de la sección.
     */
    public String getIdSeccion() {
        return idSeccion;
    }

    /**
     * Obtiene el identificador único del coche.
     *
     * @return El identificador del coche.
     */
    public String getIdCoche() {
        return idCoche;
    }

    /**
     * Obtiene el precio del coche.
     *
     * @return El precio del coche.
     */
    public int getPrecio() {
        return precio;
    }

    /**
     * Obtiene la cantidad de stock disponible del coche.
     *
     * @return El stock del coche.
     */
    public int getStock() {
        return stock;
    }

    /**
     * Establece una nueva cantidad de stock para el coche.
     *
     * @param stock La nueva cantidad de stock. Debe ser mayor o igual a 0.
     */
    public void setStock(int stock) {
        this.stock = stock;
    }
}
