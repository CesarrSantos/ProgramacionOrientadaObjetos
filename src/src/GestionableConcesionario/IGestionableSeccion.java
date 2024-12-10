package GestionableConcesionario;

import Concesionario.Seccion;

public interface IGestionableSeccion extends IGestionable<Seccion, String, Integer> {
    void mostrarSecciones();
    boolean cochesEnSeccion(String idSeccion);
}
