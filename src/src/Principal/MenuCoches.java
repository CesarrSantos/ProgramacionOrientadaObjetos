package Principal;

import EntradaSalida.MyInput;
import Concesionario.Coches;
import GestionableConcesionario.GestionCoches;
import GestionableConcesionario.Concesionario;

public class MenuCoches extends MenuPrincipal {


    private final GestionCoches gc;
    public MenuCoches(Concesionario c){
        gc= (GestionCoches) c.recuperar(2);
    }

    public void gestionarCoches() {
        int opcion;
        boolean salir = true;
        while (salir) {
            mostrar_opciones();
            opcion = elegir_opcion();
            switch (opcion) {
                case 0:
                    salir = false;
                    break;
                case 1:
                    altaCoche();
                    break;
                case 2:
                    detallesCoche();
                    break;
                case 3:
                    aumentarStock();
                    break;
                case 4:
                    mostrarCochesPorSeccion();
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    public void mostrar_opciones() {
        System.out.println("Menú de coches");
        System.out.println("-----------------");
        System.out.println("0. Salir del menú de coches");
        System.out.println("1. Agregar un coche");
        System.out.println("2. Detalles específicos de un coche");
        System.out.println("3. Aumentar el stock");
        System.out.println("4. Mostrar todos los coches de una sección");
    }

    public int elegir_opcion() {
        System.out.print("Elige una opción: ");
        return MyInput.readInt();
    }

    private void altaCoche() {
        System.out.println("ID de la sección:");
        String idSeccion = MyInput.readString();
        System.out.println("Modelo del coche:");
        String modelo = MyInput.readString();
        System.out.println("Año de fabricación:");
        String anio = MyInput.readString();
        String idCoche = modelo + "-" + anio;

        System.out.println("Precio base del coche:");
        int precio = MyInput.readInt();
        System.out.println("Stock del coche (debe ser mayor que 1):");
        int stock = MyInput.readInt();
        switch (gc.verificarCoches(idSeccion,modelo,idCoche,stock,precio)) {
            case 1:
                System.out.println("Error: El ID del coche debe tener el formato 'modelo-año' (ejemplo: yaris-2008).");
                break;
            case 2:
                System.out.println("Error: El stock debe ser mayor que 0.");
                break;
            case 3:
                System.out.println("Ya existe un coche con el ID: " + idCoche);
                break;
            case 4:
                System.out.println("La sección con ID: " + idSeccion + " no existe.");
                break;
            case 0:
                Coches nuevoCoche = new Coches(stock, precio, idCoche, idSeccion);
                gc.agregar(nuevoCoche);
                break;
            default:
                System.out.println("Error en : verificar coches");
        }

    }

    private void detallesCoche() {
        System.out.println("=== Detalles del Coche ===");

        System.out.print("ID del Coche: ");
        String idCoche = MyInput.readString();
        Coches coche = gc.buscar(idCoche);

        System.out.println("[DEBUG] Resultado de buscar: " + (coche != null ? coche.getIdCoche() : "null"));

        if (coche != null) {
            System.out.println("Detalles del Coche:");
            System.out.println("ID: " + coche.getIdCoche());
            System.out.println("Sección: " + coche.getIdSeccion());
            System.out.println("Precio: " + coche.getPrecio());
            System.out.println("Stock: " + coche.getStock());
        } else {
            System.out.println("No se encontró el coche con ID: " + idCoche);
        }
    }

    private void aumentarStock() {
        System.out.println("=== Aumentar Stock ===");

        System.out.print("ID del Coche: ");
        String idCoche = MyInput.readString();
        Coches coche = gc.buscar(idCoche);
        if (coche != null) {
            System.out.print("Cantidad a aumentar: ");
            int cantidad = MyInput.readInt();
            coche.setStock(coche.getStock() + cantidad);
            System.out.println("Stock actualizado exitosamente.");
        } else {
            System.out.println("No se encontró el coche con ID: " + idCoche);
        }
    }

    private void mostrarCochesPorSeccion() {
        System.out.println("=== Mostrar Coches por Sección ===");

        System.out.print("ID de la Sección: ");
        String idSeccion = MyInput.readString();
        for (Coches coche : gc.getCoches()) {
            if (coche.getIdSeccion().equals(idSeccion)) {
                System.out.println("ID Coche: " + coche.getIdCoche() +
                        ", Precio: " + coche.getPrecio() +
                        ", Stock: " + coche.getStock());
            }
        }
    }
}
