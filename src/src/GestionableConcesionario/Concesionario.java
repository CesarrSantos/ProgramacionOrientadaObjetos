package GestionableConcesionario;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;


public class Concesionario  implements Serializable{

    private final ArrayList<IGestionable<?,?,?>> g;
    public Concesionario(){
        g= new ArrayList<IGestionable<?,?,?>>();
    }

    public void agregar(IGestionable<?,?,?> ge){
        g.add(ge);
    }

    public IGestionable<?,?,?> recuperar(int indice){
        return g.get(indice);
    }

    public void guardarEstado(String archivo) {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                Files.newOutputStream(Paths.get(archivo)))) {
            oos.writeObject(this);
            System.out.println("Estado del concesionario guardado correctamente.");
        } catch (IOException e) {
            System.err.println("Error al guardar el estado: " + e.getMessage());
        }
    }

    public static Concesionario cargarEstado(String archivo) {
        try (ObjectInputStream ois = new ObjectInputStream(
                Files.newInputStream(Paths.get(archivo)))) {
            return (Concesionario) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al cargar el estado: " + e.getMessage());
            return null;
        }
    }
}

