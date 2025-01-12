package Principal;

import EntradaSalida.MyInput;
import Concesionario.Seccion;
import GestionableConcesionario.Concesionario;
import GestionableConcesionario.GestionCoches;
import GestionableConcesionario.GestionSeccion;

/**
 * Clase que representa el menú de gestión de secciones en el concesionario.
 * Esta clase hereda de {@link MenuPrincipal} y permite gestionar las secciones,
 * incluyendo la adición, baja y visualización de secciones existentes.
 */
public class MenuSeccion extends MenuPrincipal {
    private final GestionSeccion gestionSeccion = (GestionSeccion) getGestionable(2);
    private final GestionCoches gestionCoches = (GestionCoches) getGestionable(3);

    /**
     * Constructor de la clase MenuSeccion.
     *
     * @param concesionario El concesionario sobre el que se gestionarán las secciones.
     */
    public MenuSeccion(Concesionario concesionario) {
        super(concesionario);
    }

    /**
     * Método principal que ejecuta el menú interactivo de gestión de secciones.
     * Permite a los usuarios elegir entre diferentes opciones para gestionar las secciones.
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
                    agregarSeccion();
                    break;
                case 2:
                    bajaSeccion();
                    break;
                case 3:
                    gestionSeccion.mostrarSecciones();
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    /**
     * Muestra las opciones del menú de secciones.
     */
    @Override
    public void mostrar_opciones() {
        System.out.println("Menú de Secciones");
        System.out.println("-----------------");
        System.out.println("0. Salir del menú de secciones");
        System.out.println("1. Añadir nueva sección");
        System.out.println("2. Baja de sección");
        System.out.println("3. Mostrar secciones");
    }

    /**
     * Permite agregar una nueva sección al concesionario.
     * Solicita al usuario el ID y la descripción de la nueva sección,
     * y la registra en el sistema.
     */
    private void agregarSeccion() {
        System.out.println("=== Alta de Sección ===");

        System.out.print("ID de la Sección: ");
        String idSeccion = MyInput.readString();

        System.out.print("Descripción de la Sección: ");
        String descripcion = MyInput.readString();

        Seccion nuevaSeccion = new Seccion(idSeccion, descripcion);
        gestionSeccion.alta(nuevaSeccion);

    }

    /**
     * Permite dar de baja una sección del concesionario.
     * Solicita al usuario el ID de la sección a eliminar y, si es posible,
     * la elimina del sistema. Si hay coches asociados a la sección, se gestionan adecuadamente.
     */
    private void bajaSeccion() {
        System.out.println("=== Baja de Sección ===");

        System.out.print("ID de la Sección: ");
        String idSeccion = MyInput.readString();

        gestionSeccion.bajaSeccion(idSeccion, gestionCoches.getCoches());
    }
}
