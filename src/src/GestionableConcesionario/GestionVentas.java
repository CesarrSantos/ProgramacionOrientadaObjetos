package GestionableConcesionario;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import Concesionario.Venta;
import Concesionario.Cliente;

public class GestionVentas implements IGestionableVentas, Serializable {
    private ArrayList<Venta> ventas = new ArrayList<>();
    private Concesionario concesionario;
    private int indexCoches = 2;

    public GestionVentas(Concesionario concesionario) {
        this.concesionario = concesionario;
    }

    @Override
    public void alta(Venta venta) {
        if(!existeVenta(venta.getIdentificadorVenta())){
            ventas.add(venta);
            System.out.println("Venta añadida");
        }else{
            System.out.println("El venta ya existe");
        }

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
        return  new ArrayList<>(ventas);
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

    private boolean existeVenta(String idVenta) {
        return buscar(idVenta) != null;
    }
    public String obtenerVentaInfo(String clave) {
        Venta venta = buscar(clave);
        if (venta != null) {
            return venta.mostrarVenta().toString();
        }
        return "No se encontró una venta con ID " + clave;
    }


    public List<String> obtenerVentasPorCliente(Cliente cliente) {
        List<String> ventasInfo = new ArrayList<>();
        for (Venta venta : ventas) {
            if (venta.getCliente().equals(cliente)) {
                ventasInfo.add(venta.mostrarVenta());
            }
        }
        return ventasInfo;
    }
}
