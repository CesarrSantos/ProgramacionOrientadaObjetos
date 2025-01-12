package Pruebas;

import Concesionario.Coches;
import Concesionario.Seccion;
import GestionableConcesionario.GestionSeccion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class GestionSeccionTest {
    GestionSeccion gestionSeccion;
    Seccion seccion1;
    Seccion seccion2;
    ArrayList<Coches> coches = new ArrayList<>();

    @BeforeEach
    void setUp() {
        gestionSeccion = new GestionSeccion();
        seccion1 = new Seccion("seccion1", "Seccion de prueba numero 1");
        seccion2 = new Seccion("seccion2", "Seccion de prueba numero 2");
        gestionSeccion.alta(seccion1);
        gestionSeccion.alta(seccion2);
        coches.add(new Coches(1, 1, "coche1-0000", "seccion1"));
        coches.add(new Coches(2, 2, "coche2-0000", "seccion1"));
    }

    @Test
    void buscar() {
        assertEquals(seccion1, gestionSeccion.buscar("seccion1"));
        assertEquals(seccion2, gestionSeccion.buscar("seccion2"));
        assertNull(gestionSeccion.buscar("seccion3"));
    }

    @Test
    void recuperar() {
        assertEquals(seccion2, gestionSeccion.recuperar(1));
        assertNull(gestionSeccion.recuperar(3));
    }

    @Test
    void numeroElementos() {
        assertEquals(2, gestionSeccion.numeroElementos());
        gestionSeccion.alta(new Seccion("seccion3", "Seccion de prueba numero 3"));
        assertEquals(3, gestionSeccion.numeroElementos());
    }

    @Test
    void cochesEnSeccion() {
        assertTrue(gestionSeccion.cochesEnSeccion("seccion1", coches));
        assertFalse(gestionSeccion.cochesEnSeccion("seccion2", coches));
    }

    @Test
    void existeSeccion() {
        assertTrue(gestionSeccion.existeSeccion("seccion2"));
        assertFalse(gestionSeccion.existeSeccion("seccion0"));
    }

    @Test
    void bajaSeccion() {
        gestionSeccion.bajaSeccion("seccion2", coches);
        assertFalse(gestionSeccion.existeSeccion("seccion2"));

        gestionSeccion.bajaSeccion("seccion1", coches);
        assertTrue(gestionSeccion.existeSeccion("seccion1"));
    }
}