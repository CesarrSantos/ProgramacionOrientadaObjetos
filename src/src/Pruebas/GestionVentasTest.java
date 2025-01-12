package Pruebas;

import Concesionario.Cliente;
import Concesionario.Venta;
import GestionableConcesionario.GestionVentas;
import Mejoras.Mejoras;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class GestionVentasTest {
    GestionVentas gestionVentas = new GestionVentas();
    Venta venta1, venta2;
    Cliente cliente;

    @BeforeEach
    void setUp() {
        gestionVentas = new GestionVentas();
        cliente = new Cliente("cliente1", "test", "test", "1", true);
        venta1 = new Venta("venta0001", cliente, LocalDate.parse("2025-01-12"), "1111AAA", 1, new Mejoras());
        venta2 = new Venta("venta0002", cliente, LocalDate.parse("2025-01-12"), "2222AAA", 2, new Mejoras());
        gestionVentas.alta(venta1);
        gestionVentas.alta(venta2);
    }

    @Test
    void buscar() {
        assertEquals(venta1, gestionVentas.buscar("venta0001"));
        assertNull(gestionVentas.buscar("venta0000"));
    }

    @Test
    void recuperar() {
        assertEquals(venta2, gestionVentas.recuperar(1));
        assertNull(gestionVentas.recuperar(2));
    }

    @Test
    void numeroElementos() {
        assertEquals(2, gestionVentas.numeroElementos());
        gestionVentas.alta(new Venta("venta0003", cliente, LocalDate.parse("2025-01-12"), "3333AAA", 3, new Mejoras()));
        assertEquals(3, gestionVentas.numeroElementos());
    }

    @Test
    void listar() {
        ArrayList<Venta> ventas = new ArrayList<>();
        ventas.add(venta1);
        ventas.add(venta2);
        assertEquals(ventas, gestionVentas.listar());
    }
}