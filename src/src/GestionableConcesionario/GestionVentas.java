package GestionableConcesionario;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Concesionario.Venta;
import Concesionario.Cliente;

public class GestionVentas implements IGestionableVentas{
    private ArrayList<Venta> ventas;

    @Override
    public void alta(Venta elemento) {
        ventas.add(elemento);
    }

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

    @Override
    public Venta recuperar(Integer indice) {
        return ventas.get(indice);
    }

    @Override
    public int numeroElementos() {
        return ventas.size();
    }

    @Override
    public List<Venta> listar() {
        return Collections.emptyList();
    }

    @Override
    public void listarVenta(String clave){
        Venta venta = buscar(clave);
        System.out.println(venta.getIdentificadorVenta());
    }

    @Override
    public void listarVentas(Cliente cliente){
        int cont = 0;
        for(Venta venta : ventas) {
            if(venta.getCliente().equals(cliente)){
                System.out.println(venta.getIdentificadorVenta());
                cont++;
            }
        }

        if(cont == 0){
            System.out.println("No se ha ninguna venta");
        }
    }
}
