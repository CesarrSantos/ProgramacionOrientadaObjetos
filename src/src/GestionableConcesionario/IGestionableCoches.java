package GestionableConcesionario;
import Concesionario.Coches;

import java.util.List;


public interface IGestionableCoches extends IGestionable<Coches, String, Integer> {
    Coches recuperar(Integer indice);

    int numeroElementos();

    List<Coches> listar();

    boolean cochesEnSeccion(String idSeccion);

    boolean existeCoche(String idCoche);
}