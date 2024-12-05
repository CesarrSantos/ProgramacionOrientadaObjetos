package GestionableConcesionario;

import Concesionario.Coches;
import Concesionario.Seccion;
import EntradaSalida.MyInput;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GestionCoches implements IGestionable<Coches>{

    private static List<Coches> coches = new ArrayList<>();
    public static List<Seccion> secciones = new ArrayList<>();


    public void agregarCoche() {
        System.out.println("ID de la sección:");
        String idSeccion = MyInput.readString();
        System.out.println("Modelo del coche:");
        String modelo = MyInput.readString();
        System.out.println("Año de fabricación:");
        String anio = MyInput.readString();

        // Validar formato de ID del coche
        String idCoche = modelo + "-" + anio;
        if (!idCoche.matches("^[a-zA-Z0-9]+-[0-9]{4}$")) {
            System.out.println("Error: El ID del coche debe tener el formato 'modelo-año' (ejemplo: yaris-2008).");
            return;
        }

        System.out.println("Precio base del coche:");
        int precio = MyInput.readInt();
        System.out.println("Stock del coche (debe ser mayor que 1):");
        int stock = MyInput.readInt();

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

    public void mostrarDetallesSeccion() {
        if (secciones.isEmpty()) {
            System.out.println("No hay secciones disponibles.");
            return;
        }
        System.out.println("Secciones disponibles:");
        for (Seccion seccion : secciones) {
            System.out.println("ID: " + seccion.getIdSeccion() + ", Descripción: " + seccion.getDescripcion());
        }
        System.out.println("ID de la sección:");
        String idSeccion = MyInput.readString();
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

    public void detalleEspecificosCoche() {
        System.out.println("ID de la sección:");
        String idSeccion = MyInput.readString();
        System.out.println("Modelo del Coche:");
        String idCoche = MyInput.readString();

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

    private boolean existeSeccion(String idSeccion){
        for (Seccion secciones : secciones) {
            if (secciones.getIdSeccion().equals(idSeccion)) {
                return true; // Devuelve true si encuentra la sección
            }
        }
        return false;
    }
    private boolean existeCoche(String idcoche){
        for (Coches coches : coches) {
            if (coches.getIdCoche().equals(idcoche)) {
                return true; // Devuelve true si encuentra el coche
            }
        }
        return false;
    }
    @Override
    public List<Coches> listar() {
        return Collections.emptyList();
    }


}
