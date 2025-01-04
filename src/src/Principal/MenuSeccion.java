package Principal;

import EntradaSalida.MyInput;
import Concesionario.Seccion;
import GestionableConcesionario.Concesionario;
import GestionableConcesionario.GestionCoches;
import GestionableConcesionario.GestionSeccion;

public class MenuSeccion extends MenuPrincipal {

    private GestionSeccion gestionSeccion = (GestionSeccion) getGestionable(2);
    private GestionCoches gestionCoches = (GestionCoches) getGestionable(3);

    public MenuSeccion(Concesionario concesionario) {
        super(concesionario);
    }

    public void gestionarSeccion(GestionSeccion gestionSeccion) {
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

    public void mostrar_opciones() {
        System.out.println("Menú de Secciones");
        System.out.println("-----------------");
        System.out.println("0. Salir del menú de secciones");
        System.out.println("1. Añadir nueva sección");
        System.out.println("2. Baja de sección");
        System.out.println("3. Mostrar secciones");
    }

    public int elegir_opcion() {
        System.out.print("Elige una opción: ");
        return MyInput.readInt();
    }

    private void agregarSeccion() {
        System.out.println("=== Alta de Sección ===");

        System.out.print("ID de la Sección: ");
        String idSeccion = MyInput.readString();

        System.out.print("Descripción de la Sección: ");
        String descripcion = MyInput.readString();

        Seccion nuevaSeccion = new Seccion(idSeccion, descripcion);
        gestionSeccion.alta(nuevaSeccion);

    }

    private  void bajaSeccion() {
        System.out.println("=== Baja de Sección ===");

        System.out.print("ID de la Sección: ");
        String idSeccion = MyInput.readString();

        gestionSeccion.bajaSeccion(idSeccion, gestionCoches.getCoches());
    }
}
