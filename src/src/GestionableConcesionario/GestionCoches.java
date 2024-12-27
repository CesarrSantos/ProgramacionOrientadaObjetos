package GestionableConcesionario;

import Concesionario.Coches;
import Concesionario.Seccion;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GestionCoches implements IGestionableCoches, Serializable {

    private final ArrayList<Coches> coches = new ArrayList<>();
    private final Concesionario concesionario;

    public GestionCoches(Concesionario concesionario) {
        this.concesionario = concesionario;
    }

    public ArrayList<Coches> getCoches() {
            return coches;
        }

    public void agregar(Coches nuevoCoche) {
        coches.add(nuevoCoche);
    }

    public int verificarCoches(String idSeccion, String modelo, String idCoche, int stock, int precio) {
       if (!idCoche.matches("^[a-zA-Z0-9]+-[0-9]{4}$")) {
            return 1;
        }
       if (stock <= 0) {
            return 2;
       }

        if (existeSeccion(idSeccion)) {
            if (!existeCoche(idCoche)) {
                return 0;
            } else {
                return 3;
            }
        } else {
            return 4;
        }
    }

    private boolean existeSeccion(String idSeccion) {
        int seccionIndex = 0;
        IGestionable<?,?,?> gestionSeccion = concesionario.recuperar(seccionIndex);
        if (gestionSeccion instanceof GestionSeccion) {
            ArrayList<Seccion> secciones = ((GestionSeccion) gestionSeccion).getSecciones();
            for (Seccion seccion : secciones) {
                if (seccion.getIdSeccion().equals(idSeccion)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean existeCoche(String idCoche) {
        for (Coches coche : coches) {
            if (coche.getIdCoche().equals(idCoche)) {
                return true;
            }
        }
        return false;
    }


    //Implementaciones del IGestionable
    @Override
    public void alta(Coches elemento) {

    }

    @Override
    public Coches buscar(String clave) {
        for (Coches coche : coches) {
            if (coche.getIdCoche().equals(clave)) {
                return coche;
            }
        }
        return null;
    }

    public Coches buscar(String idSeccion, String idCoche) {
        for (Coches coche : coches) {
            if (coche.getIdSeccion().equals(idSeccion) && coche.getIdCoche().equals(idCoche)) {
                return coche;
            }
        }
        return null;
    }


    @Override
    public Coches recuperar(Integer indice) {
        return null;
    }

    @Override
    public int numeroElementos() {
        return 0;
    }

    @Override
    public List<Coches> listar() {
        return Collections.emptyList();
    }
}
