package GestionableConcesionario;

import Concesionario.Coches;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GestionCoches implements IGestionableCoches {
    private ArrayList<Coches> coches = new ArrayList<>();

    @Override
    public void alta(Coches coche) {
        coches.add(coche);
        System.out.println("Coche añadido exitosamente.");
    }

    @Override
    public Coches buscar(String idCoche) {
        for (Coches coche : coches) {
            if (coche.getIdCoche().equals(idCoche)) {
                return coche;
            }
        }
        return null; // No encontrado
    }

    @Override
    public Coches recuperar(Integer indice) {
        return null;
    }

    @Override
    public int numeroElementos() {
        return coches.size();
    }



    @Override
    public List<Coches> listar() {
        return new ArrayList<>(coches); // Devuelve una copia de la lista
    }


    @Override
    public boolean cochesEnSeccion(String idSeccion) {
        ArrayList<Coches> coches = Concesionario.getGestionCoches().getCoches();
        for (Coches coche : coches) {
            if (coche.getIdSeccion().equals(idSeccion)) {
                return true;
            }
        }
        return false;
    }

    // Metodo para devolver la lista de coches
    public ArrayList<Coches> getCoches() {
        return coches;
    }

    @Override
    public boolean existeCoche(String idCoche) {
        return buscar(idCoche) != null;
    }
}

