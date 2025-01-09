package GestionableConcesionario;

import java.io.Serializable;
import java.util.ArrayList;

public class Concesionario implements Serializable {

    private final ArrayList<IGestionable<?,?,?>> g;
    public Concesionario(){
        g= new ArrayList<>();
    }

    public void agregar(IGestionable<?,?,?> ge){
        g.add(ge);
    }

    public IGestionable<?,?,?> recuperar(int indice){
        return g.get(indice);
    }
}

