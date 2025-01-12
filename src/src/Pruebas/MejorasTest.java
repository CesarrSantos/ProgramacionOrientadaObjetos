package Pruebas;

import Mejoras.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MejorasTest {
    Mejoras mejoras;

    @BeforeEach
    void setUp() {
        mejoras = new Mejoras();
    }

    @Test
    void test() {
        assertEquals(1.10, new Cuero(mejoras).getPrecio());
        assertEquals(1.0 * 1.1 * 1.05, new Llantas(new Cuero(mejoras)).getPrecio());

        assertEquals("Mejoras del coche vendido: \n- GPS (Sistema de geolocalización y asistencia en ruta)\n", new Gps(mejoras).getDescripcion());
        assertEquals("Mejoras del coche vendido: \n- GPS (Sistema de geolocalización y asistencia en ruta)\n- Llantas de aleación\n", new Llantas(new Gps(mejoras)).getDescripcion());
        assertEquals("Mejoras del coche vendido: \n- Llantas de aleación\n- GPS (Sistema de geolocalización y asistencia en ruta)\n", new Gps(new Llantas(mejoras)).getDescripcion());
    }
}