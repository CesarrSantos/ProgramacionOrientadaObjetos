package Principal;

import EntradaSalida.MyInput;
import Concesionario.Coches;
import GestionableConcesionario.GestionCoches;
import GestionableConcesionario.Concesionario;
import GestionableConcesionario.GestionSeccion;

public class MenuCoches extends MenuPrincipal {

    private GestionSeccion gestionSeccion = (GestionSeccion) getGestionable(2);
    private GestionCoches gestionCoches = (GestionCoches) getGestionable(3);

    public MenuCoches(Concesionario concesionario) {
        super(concesionario);
    }

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
        System.out.println("=== Alta del Coche ===");

        System.out.print("ID Sección del coche: ");
        String idSeccion = MyInput.readString();
        if(!gestionSeccion.existeSeccion(idSeccion)) {
            System.out.println("La Seccion no existe");
            return;
        }

        System.out.print("ID del Coche: ");
        String idCoche = MyInput.readString();
        if(!idCoche.matches("^[a-zA-Z0-9]+-[0-9]{4}$")){
            System.out.println("El ID del Coche es invalido");
            return;
        }


        System.out.print("Precio del coche: ");
        int precio = MyInput.readInt();
        if(precio < 0){
            System.out.println("Precio debe ser mayor a 0");
            return;
        }

        System.out.print("Stock del coche: ");
        int stock = MyInput.readInt();
        if(stock < 1){
            System.out.println("Stock debe ser mayor a 1");
            return;
        }

        // Crear el coche y añadirlo
        Coches coche = new Coches(stock, precio, idCoche, idSeccion);
        gestionCoches.alta(coche);
    }

    private void detallesCoche() {
        System.out.println("=== Detalles del Coche ===");

        System.out.print("ID del Coche: ");
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

    private void aumentarStock() {
        System.out.println("=== Aumentar Stock ===");

        System.out.print("ID del Coche: ");
        String idCoche = MyInput.readString();

        Coches coche = gestionCoches.buscar(idCoche);
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

        for (Coches coche : gestionCoches.getCoches()) {
            if (coche.getIdSeccion().equals(idSeccion)) {
                System.out.println("ID Coche: " + coche.getIdCoche() +
                        ", Precio: " + coche.getPrecio() +
                        ", Stock: " + coche.getStock());
            }
        }
    }
}
