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
        assertEquals(1.115, new Llantas(new Cuero(mejoras)).getPrecio());

        assertEquals("GPS (Sistema de geolocalización y asistencia en ruta) ", new Gps(mejoras).getDescripcion());
        assertEquals("Llantas de aleación GPS (Sistema de geolocalización y asistencia en ruta) ", new Llantas(new Gps(mejoras)).getDescripcion());
        assertEquals("GPS (Sistema de geolocalización y asistencia en ruta) Llantas de aleación GPS ", new Gps(new Llantas(mejoras)).getDescripcion());
    }
}