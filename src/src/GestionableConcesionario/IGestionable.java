package GestionableConcesionario;
import Concesionario.*;
import java.util.ArrayList;
import java.util.List;

public interface IGestionable <T>{
    public abstract void agregar(T objeto);

    //TODO Ver como implementar este metodo sin que sea publico
    //Quiza si puede ser publico?
    //private abstract boolean existe(String id);

    public abstract void detalles(String id);
}
