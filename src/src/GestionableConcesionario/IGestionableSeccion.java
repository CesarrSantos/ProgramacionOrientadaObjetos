package GestionableConcesionario;

import Concesionario.*;

import java.util.ArrayList;
import java.util.List;

public interface IGestionableSeccion extends IGestionable<Seccion, String, Integer> {
    Seccion recuperar(Integer indice);

    int numeroElementos();

    List<Seccion> listar();

    void mostrarSecciones();
    boolean cochesEnSeccion(String idSeccion, ArrayList<Coches> coches);
}
