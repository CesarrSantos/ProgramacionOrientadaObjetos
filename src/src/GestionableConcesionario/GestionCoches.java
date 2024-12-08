package GestionableConcesionario;

import Concesionario.Coches;
import Concesionario.Seccion;
import EntradaSalida.MyInput;

import java.util.ArrayList;
public class GestionCoches implements IGestionableCoches{

    private ArrayList<Coches> coches = new ArrayList<>();

    public ArrayList<Coches> getCoches() {
            return coches;
        }

    //@Override
    public void agregar(Coches coche) {
        System.out.println("ID de la sección:");
        String idSeccion = MyInput.readString();
        System.out.println("Modelo del coche:");
        String modelo = MyInput.readString();
        System.out.println("Año de fabricación:");
        String anio = MyInput.readString();

        String idCoche = modelo + "-" + anio;

        if (!idCoche.matches("^[a-zA-Z0-9]+-[0-9]{4}$")) {
            System.out.println("Error: El ID del coche debe tener el formato 'modelo-año' (ejemplo: yaris-2008).");
            return;
        }

        System.out.println("Precio base del coche:");
        int precio = MyInput.readInt();
        System.out.println("Stock del coche (debe ser mayor que 1):");
        int stock = MyInput.readInt();

        //do while?
        if (stock <= 0) {
            System.out.println("Error: El stock debe ser mayor que 0.");
            return;
        }

        if (existeSeccion(idSeccion)) {
            if (!existeCoche(idCoche)) {
                Coches nuevoCoche = new Coches(stock, precio, idCoche, idSeccion);
                coches.add(nuevoCoche);
                System.out.println("Coche añadido correctamente.");
            } else {
                System.out.println("Ya existe un coche con el ID: " + idCoche);
            }
        } else {
            System.out.println("La sección con ID: " + idSeccion + " no existe.");
        }
    }

    //Muestra los detalles de la seccion
    public void detalles(String idSeccion) {
        if (Concesionario.getGestionSeccion().getSecciones().isEmpty()) {
            System.out.println("No hay secciones disponibles.");
            return;
        }

        boolean encontrado = false;
        for (Coches coche : coches) {
            if (coche.getIdSeccion().equals(idSeccion)) {
                System.out.println("ID del coche: " + coche.getIdCoche());
                System.out.println("Precio del coche: " + coche.getPrecio());
                System.out.println("Stock del coche: " + coche.getStock());
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("No hay coches en la sección con ID: " + idSeccion);
        }
    }

    public void aumentarStock() {
        System.out.println("ID de la sección:");
        String idSeccion = MyInput.readString();
        System.out.println("ID del coche:");
        String idCoche = MyInput.readString();

        //TODO reordenar
        if (existeSeccion(idSeccion)) {
            if (existeCoche(idCoche)) {
                System.out.println("Cantidad de coches que quieres añadir:");
                int cantidad = MyInput.readInt();

                for (Coches coche : coches) {
                    if (coche.getIdSeccion().equals(idSeccion) && coche.getIdCoche().equals(idCoche)) {
                        coche.setStock(coche.getStock() + cantidad);
                        System.out.println("Stock actualizado. Nuevo stock: " + coche.getStock());
                        return;
                    }
                }
            } else {
                System.out.println("No existe un coche con el ID: " + idCoche);
            }
        } else {
            System.out.println("La sección con ID: " + idSeccion + " no existe.");
        }
    }

    //Muestra los detalles del coche
    public void detalles(String idSeccion, String idCoche) {
        // Verificar si la sección existe
        if (!existeSeccion(idSeccion)) {
            System.out.println("Error: La sección con ID '" + idSeccion + "' no existe.");
            return;
        }

        // Verificar si el coche existe
        if (!existeCoche(idCoche)) {
            System.out.println("Error: El coche con ID '" + idCoche + "' no existe.");
            return;
        }

        // Buscar y mostrar detalles del coche específico
        for (Coches coche : coches) {
            if (coche.getIdSeccion().equals(idSeccion) && coche.getIdCoche().equals(idCoche)) {
                System.out.println("Detalles del coche:");
                System.out.println("ID del coche: " + coche.getIdCoche());
                System.out.println("Precio: " + coche.getPrecio());
                System.out.println("Stock disponible: " + coche.getStock());
                return;
            }
        }

        // Si llega aquí, significa que no encontró el coche en la sección especificada
        System.out.println("El coche con ID '" + idCoche + "' no pertenece a la sección con ID '" + idSeccion + "'.");
    }

    private boolean existeSeccion(String idSeccion) {
            ArrayList<Seccion> secciones = Concesionario.getGestionSeccion().getSecciones();
            for (Seccion seccion : secciones) {
                if (seccion.getIdSeccion().equals(idSeccion)) {
                    return true;
                }
            }
            return false;
        }

    private boolean existeCoche(String idCoche) {
        for (Coches coche : coches) {
            if (coche.getIdCoche().equals(idCoche)) {
                return true;
            }
        }
        return false;
    }

    public Coches crear(String[] datos) {
        int stock = Integer.parseInt(datos[0]), precio = Integer.parseInt(datos[1]);
        String idCoche = datos[2], idSeccion = datos[3];
        if (!existeSeccion(idSeccion)) {
            System.out.println("La sección con ID: " + idSeccion + " no existe.");
            return null;
        }
        if (existeCoche(idCoche)) {
            System.out.println("Ya existe un coche con el ID: " + idCoche);
            return null;
        }

        return new Coches(stock, precio, idCoche, idSeccion);
    }
}
