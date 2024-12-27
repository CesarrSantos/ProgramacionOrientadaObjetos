package Concesionario;

import Mejoras.Mejoras;

import java.io.Serializable;
import java.util.Date;
import java.util.List;




public class Venta implements Serializable {
    private String identificadorVenta;
    private Cliente cliente;
    private Date fecha;
    private String matricula;
    private int precio;
    private List<Mejoras> mejorasAplicadas;


    public Venta(String identificadorVenta, Cliente cliente, Date fecha, String matricula, int precio,List<Mejoras> mejorasAplicadas) {
        this.identificadorVenta = identificadorVenta;
        this.cliente = cliente;
        this.fecha = fecha;
        this.matricula = matricula;
        this.precio = precio;
        this.mejorasAplicadas = mejorasAplicadas;
    }

    public String mostrarVenta() {
        StringBuilder ventaInfo = new StringBuilder();
        ventaInfo.append("ID de la venta: ").append(identificadorVenta).append("\n");
        ventaInfo.append("Cliente: ").append(cliente.getNombre()).append(" ").append(cliente.getApellido()).append("\n");
        ventaInfo.append("Fecha: ").append(fecha).append("\n");
        ventaInfo.append("Matrícula: ").append(matricula).append("\n");
        ventaInfo.append("Precio sin IVA: ").append(precio).append("€\n");
        ventaInfo.append("Precio con IVA (21%): ").append((int) (precio * 1.21)).append("€\n");

        ventaInfo.append("Mejoras aplicadas:\n");
        if (mejorasAplicadas.isEmpty()) {
            ventaInfo.append("- Ninguna mejora aplicada\n");
        }else {
            for (Mejoras mejora : mejorasAplicadas) {
                ventaInfo.append(mejora.getDescripcion()).append(" - Precio adicional: ").append((int) mejora.getPrecio()).append("\n");
            }
        }
        return ventaInfo.toString();
    }
    //Decorar mejoras
    public String getIdentificadorVenta() {
        return identificadorVenta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Date getFecha() {
        return fecha;
    }

    public String getMatricula() {
        return matricula;
    }

    public int getPrecio() {
        return precio;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
}