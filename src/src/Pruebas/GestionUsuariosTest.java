package Pruebas;

import Concesionario.Cliente;
import GestionableConcesionario.GestionUsuarios;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GestionUsuariosTest {
    GestionUsuarios gestionUsuarios;
    Cliente cliente1, cliente2, cliente3;

    @BeforeEach
    void setUp() {
        gestionUsuarios = new GestionUsuarios();
        cliente1 = new Cliente("00000001A", "test1", "prueba1", "1", true);
        cliente2 = new Cliente("00000002B", "test2", "prueba2", "2", false);
        cliente3 = new Cliente("00000003C", "test3", "prueba3", "3", true);
        gestionUsuarios.alta(cliente1);
        gestionUsuarios.alta(cliente2);
    }

    @Test
    void buscar() {
        assertEquals(cliente1, gestionUsuarios.buscar("00000001A"));
        assertNull(gestionUsuarios.buscar("00000000Z"));
    }

    @Test
    void recuperar() {
        assertEquals(cliente2, gestionUsuarios.recuperar(1));
        assertNull(gestionUsuarios.recuperar(77));
    }

    @Test
    void numeroElementos() {
        assertEquals(2, gestionUsuarios.numeroElementos());
        gestionUsuarios.alta(cliente3);
        assertEquals(3, gestionUsuarios.numeroElementos());
    }
}