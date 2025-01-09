package GestionableConcesionario;
import Concesionario.Venta;
import Concesionario.Cliente;

import java.util.List;

public interface IGestionableVentas extends  IGestionable<Venta, String, Integer>{
    Venta recuperar(Integer indice);

    int numeroElementos();

    List<Venta> listar();

    void listarVenta(String clave);
    void listarVentas(Cliente cliente);
}
