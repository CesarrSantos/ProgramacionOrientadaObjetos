package GestionableConcesionario;
import Concesionario.Coches;


public interface IGestionableCoches extends IGestionable<Coches, String, Integer> {
    //boolean cochesEnSeccion(String idSeccion);
    boolean existeCoche(String idCoche);
}