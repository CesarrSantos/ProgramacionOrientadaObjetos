package GestionableConcesionario;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import Concesionario.Venta;
import Concesionario.Cliente;

/**
 * Clase GestionVentas que implementa la interfaz IGestionableVentas y Serializable.
 * Se encarga de gestionar una lista de ventas, proporcionando operaciones para alta,
 * búsqueda, recuperación, y listado de ventas.
 */
public class GestionVentas implements IGestionableVentas, Serializable {
    private final ArrayList<Venta> ventas;

    /**
     * Constructor de la clase que inicializa la lista de ventas.
     */
    public GestionVentas(){
        ventas = new ArrayList<Venta>();
    }

    /**
     * Agrega una nueva venta a la lista.
     *
     * @param elemento la venta que se desea añadir.
     */
    @Override
    public void alta(Venta elemento) {
        ventas.add(elemento);
    }

    /**
     * Busca una venta en la lista por su identificador único.
     *
     * @param clave el identificador de la venta que se desea buscar.
     * @return la venta encontrada, o {@code null} si no se encuentra.
     */
    @Override
    public Venta buscar(String clave) {
        for(Venta venta : ventas) {
            if (venta.getIdentificadorVenta().equals(clave)){
                return venta;
            }
        }
        System.out.println("No se ha encontrado la venta");
        return null;
    }

    /**
     * Recupera una venta de la lista según su índice.
     *
     * @param indice el índice de la venta a recuperar.
     * @return la venta en la posición especificada.
     */
    @Override
    public Venta recuperar(Integer indice) {
        return ventas.get(indice);
    }

    /**
     * Devuelve el número de ventas gestionadas.
     *
     * @return el tamaño de la lista de ventas.
     */
    @Override
    public int numeroElementos() {
        return ventas.size();
    }

    /**
     * Devuelve la lista de todas las ventas gestionadas.
     *
     * @return una lista de ventas.
     */
    @Override
    public List<Venta> listar() {
        return ventas;
    }

    /**
     * Lista una venta específica basada en su identificador único.
     *
     * @param clave el identificador de la venta que se desea listar.
     */
    @Override
    public void listarVenta(String clave){
        Venta venta = buscar(clave);

        if(venta == null){
            return;
        }

        System.out.println(venta.getIdentificadorVenta() + venta.getCliente() + venta.getFecha() + venta.getMatricula());
    }

    /**
     * Lista todas las ventas realizadas por un cliente específico.
     *
     * @param cliente el cliente cuyas ventas se desean listar.
     */
    @Override
    public void listarVentas(Cliente cliente){
        int cont = 0;
        for(Venta venta : ventas) {
            if(venta.getCliente().equals(cliente)){
                System.out.println(venta.getIdentificadorVenta() + venta.getCliente() + venta.getFecha() + venta.getMatricula() + venta.getMejoras().getDescripcion() + venta.getIdentificadorVenta() + venta.getCliente() + venta.getFecha());
                cont++;
            }
        }

        if(cont == 0){
            System.out.println("No se ha ninguna venta");
        }
    }
}
