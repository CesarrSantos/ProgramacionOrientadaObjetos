package Pruebas;

import Concesionario.Coches;
import GestionableConcesionario.GestionCoches;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GestionCochesTest {

    GestionCoches gestionCoches;
    Coches coche1, coche2, coche3;

    @BeforeEach
    void setUp() {
        gestionCoches = new GestionCoches();
        coche1 = new Coches(1, 1, "coche1-0000", "seccion1");
        coche2 = new Coches(2, 2, "coche2-0000", "seccion1");
        coche3 = new Coches(3, 3, "coche3-0000", "seccion3");
        gestionCoches.alta(coche1);
        gestionCoches.alta(coche2);
        gestionCoches.alta(coche3);
    }

    @Test
    void buscar() {
        assertEquals(gestionCoches.buscar("coche1-0000"), coche1);
        assertNull(gestionCoches.buscar("coche4-0000"));
    }

    @Test
    void recuperar() {
        assertEquals(gestionCoches.recuperar(2), coche3);
        assertNull(gestionCoches.recuperar(12));
    }

    @Test
    void cochesEnSeccion() {
        assertTrue(gestionCoches.cochesEnSeccion("seccion1"));
        assertFalse(gestionCoches.cochesEnSeccion("seccion2"));
        assertTrue(gestionCoches.cochesEnSeccion("seccion3"));
    }

    @Test
    void existeCoche() {
        assertTrue(gestionCoches.existeCoche("coche2-0000"));
        assertFalse(gestionCoches.existeCoche("coche4-0000"));
    }
}