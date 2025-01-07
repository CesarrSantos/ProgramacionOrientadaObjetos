package GestionableConcesionario;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Concesionario.Venta;
import Concesionario.Cliente;

public class GestionVentas implements IGestionableVentas, Serializable {
    private ArrayList<Venta> ventas;

    public GestionVentas(){
        ventas = new ArrayList<Venta>();
    }

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
        return ventas;
    }

    @Override
    public void listarVenta(String clave){
        Venta venta = buscar(clave);

        if(venta == null){
            return;
        }

        System.out.println(venta.getIdentificadorVenta() + venta.getCliente() + venta.getFecha() + venta.getMatricula());
    }

    @Override
    public void listarVentas(Cliente cliente){
        int cont = 0;
        for(Venta venta : ventas) {
            if(venta.getCliente().equals(cliente)){
                System.out.println(venta.getIdentificadorVenta() + venta.getCliente() + venta.getFecha() + venta.getMatricula());
                cont++;
            }
        }

        if(cont == 0){
            System.out.println("No se ha ninguna venta");
        }
    }
}
