package Principal;



import GestionableConcesionario.*;

public class Main {
    private static final String guardar = "concesionario.dat";
    public static void main(String[] args) {

        Concesionario concesionario = cargarOCrearConcesionario();
        MenuPrincipal menuPrincipal = new MenuPrincipal();

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("\nGuardando estado del concesionario...");
            concesionario.guardarEstado(guardar);
        }));

        menuPrincipal.principal(concesionario);
    }




        private static Concesionario cargarOCrearConcesionario() {
            Concesionario concesionario = Concesionario.cargarEstado(guardar);

            if (concesionario == null) {
                System.out.println("Creando nuevo concesionario...");
                concesionario = crearNuevoConcesionario();
            } else {
                System.out.println("Concesionario cargado correctamente.");
            }

            return concesionario;
        }

        private static Concesionario crearNuevoConcesionario() {
            Concesionario concesionario = new Concesionario();

            // Creacion
            GestionUsuarios gestionUsuarios = new GestionUsuarios(concesionario);
            GestionCoches gestionCoches = new GestionCoches(concesionario);
            GestionSeccion gestionSeccion = new GestionSeccion(concesionario);
            GestionVentas gestionVentas = new GestionVentas(concesionario);

            // añadir en orden
            concesionario.agregar(gestionSeccion);  // index 0
            concesionario.agregar(gestionUsuarios); // index 1
            concesionario.agregar(gestionCoches);   // index 2
            concesionario.agregar(gestionVentas);   // index 3
            return concesionario;
        }



}
