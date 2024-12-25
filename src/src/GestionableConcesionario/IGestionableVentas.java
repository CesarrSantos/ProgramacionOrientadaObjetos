package GestionableConcesionario;
import Concesionario.Venta;
import Concesionario.Cliente;

public interface IGestionableVentas extends  IGestionable<Venta, String, Integer>{
    public void listarVenta(String clave);
    public void listarVentas(Cliente cliente);
}
