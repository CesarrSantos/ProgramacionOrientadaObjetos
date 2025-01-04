package GestionableConcesionario;

import Concesionario.*;

import java.util.ArrayList;

public interface IGestionableSeccion extends IGestionable<Seccion, String, Integer> {
    void mostrarSecciones();
    boolean cochesEnSeccion(String idSeccion, ArrayList<Coches> coches);
}
