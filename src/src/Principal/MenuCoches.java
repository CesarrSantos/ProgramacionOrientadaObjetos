package Principal;

import EntradaSalida.MyInput;
import Concesionario.Coches;
import GestionableConcesionario.GestionCoches;
import GestionableConcesionario.Concesionario;
import GestionableConcesionario.GestionSeccion;

/**
 * Clase que representa el menú de gestión de coches en el concesionario.
 * Esta clase hereda de {@link MenuPrincipal} y permite gestionar los coches,
 * incluyendo alta, visualización de detalles, aumento de stock y filtrado por sección.
 */
public class MenuCoches extends MenuPrincipal {
    private final GestionSeccion gestionSeccion = (GestionSeccion) getGestionable(2);
    private final GestionCoches gestionCoches = (GestionCoches) getGestionable(3);

    /**
     * Constructor de la clase MenuCoches.
     *
     * @param concesionario El concesionario sobre el que se gestionarán los coches.
     */
    public MenuCoches(Concesionario concesionario) {
        super(concesionario);
    }

    /**
     * Método principal que ejecuta el menú interactivo de gestión de coches.
     * Permite a los usuarios elegir entre diferentes opciones para gestionar los coches.
     */
    @Override
    public void principal() {
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

    /**
     * Muestra las opciones del menú de coches.
     */
    @Override
    public void mostrar_opciones() {
        System.out.println("Menú de coches");
        System.out.println("-----------------");
        System.out.println("0. Salir del menú de coches");
        System.out.println("1. Agregar un coche");
        System.out.println("2. Detalles específicos de un coche");
        System.out.println("3. Aumentar el stock");
        System.out.println("4. Mostrar todos los coches de una sección");
    }

    /**
     * Permite agregar un nuevo coche al concesionario.
     * Solicita al usuario los datos del coche, realiza las validaciones necesarias
     * y, si todo es correcto, registra el coche en el sistema.
     */
    private void altaCoche() {
        System.out.println("=== Alta del Coche ===");

        System.out.print("Introduzca el ID de sección del coche: ");
        String idSeccion = MyInput.readString();
        if(!gestionSeccion.existeSeccion(idSeccion)) {
            System.out.println("La sección no existe.");
            return;
        }

        System.out.print("Introduzca el ID del Coche: ");
        String idCoche = MyInput.readString();
        if(!idCoche.matches("^[a-zA-Z0-9]+-[0-9]{4}$")){
            System.out.println("El ID del Coche no sigue el formato correcto (ej: yaris-2008)");
            return;
        }

        System.out.print("Introduzca el precio del coche: ");
        int precio = MyInput.readInt();
        if(precio < 0){
            System.out.println("El precio debe ser mayor a 0");
            return;
        }

        System.out.print("Stock del coche: ");
        int stock = MyInput.readInt();
        if(stock < 1){
            System.out.println("El stock debe ser mayor a 1");
            return;
        }

        Coches coche = new Coches(stock, precio, idCoche, idSeccion);
        gestionCoches.alta(coche);
    }

    /**
     * Muestra los detalles de un coche específico.
     * Solicita al usuario el ID del coche y, si se encuentra, muestra su información detallada.
     */
    private void detallesCoche() {
        System.out.println("=== Detalles del Coche ===");

        System.out.print("Introduzca el ID del Coche: ");
        String idCoche = MyInput.readString();

        Coches coche = gestionCoches.buscar(idCoche);
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

    /**
     * Permite aumentar el stock de un coche existente.
     * Solicita al usuario el ID del coche y la cantidad a aumentar, y actualiza el stock.
     */
    private void aumentarStock() {
        System.out.println("=== Aumentar Stock ===");

        System.out.print("Introduzca el ID del Coche: ");
        String idCoche = MyInput.readString();

        Coches coche = gestionCoches.buscar(idCoche);
        if (coche != null) {
            System.out.print("Introduzca la cantidad de stock a aumentar: ");
            int cantidad = MyInput.readInt();
            coche.setStock(coche.getStock() + cantidad);
            System.out.println("Stock actualizado exitosamente.");
        } else {
            System.out.println("No se encontró el coche con ID: " + idCoche);
        }
    }

    /**
     * Muestra todos los coches de una sección específica.
     * Solicita al usuario el ID de la sección y muestra todos los coches que pertenecen a esa sección.
     */
    private void mostrarCochesPorSeccion() {
        System.out.println("=== Mostrar Coches por Sección ===");

        System.out.print("ID de la Sección: ");
        String idSeccion = MyInput.readString();

        for (Coches coche : gestionCoches.getCoches()) {
            if (coche.getIdSeccion().equals(idSeccion)) {
                System.out.println("ID Coche: " + coche.getIdCoche() +
                                   ", Precio: " + coche.getPrecio() +
                                   ", Stock: " + coche.getStock());
            }
        }
    }
}
