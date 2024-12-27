package Principal;

import EntradaSalida.MyInput;

import GestionableConcesionario.GestionUsuarios;
import GestionableConcesionario.Concesionario;
import Concesionario.Cliente;
public class MenuUsuarios extends MenuPrincipal {

    private GestionUsuarios gestionUsuarios = (GestionUsuarios) getGestionable(1);

    public MenuUsuarios(Concesionario concesionario) {
        super(concesionario);
    }

    public void principal(GestionUsuarios gestionUsuarios){
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
                    altaCliente();
                    break;
                case 2:
                    gestionUsuarios.listarClientes();
                    break;
                case 3:
                    System.out.print("Ingrese el DNI del cliente: ");
                    String dni = MyInput.readString();
                    gestionUsuarios.listarClienteDni(dni);
                     break;
                case 4:
                    gestionUsuarios.listarClientesPublicidad();
                    break;
                default:
                    System.out.println("Opcion no Correcta");
            }
        }
    }

    public void mostrar_opciones(){
        System.out.println("Menu de Usuarios");
        System.out.println("-----------------");
        System.out.println("0. Salir del menu de usuarios");
        System.out.println("1. Añadir usuario");
        System.out.println("2. Listar usuarios");
        System.out.println("3. Listar usuario a partir de un dni");
        System.out.println("4. Listar usuarios que quieren publicidad");
    }
    public int elegir_opcion(){
        return MyInput.readInt();
    }

    // Metodo que pide al cliente la informacion y luego lo añadimos
    private void altaCliente() {
        System.out.println("=== Alta de Cliente ===");

        System.out.print("DNI del cliente: ");
        String dni = MyInput.readString();

        System.out.print("Nombre del cliente: ");
        String nombre = MyInput.readString();

        System.out.print("Apellido del cliente: ");
        String apellido = MyInput.readString();

        System.out.print("Teléfono del cliente: ");
        String telefono = MyInput.readString();

        System.out.print("¿Desea recibir publicidad? (S/N): ");
        String publicidadInput = MyInput.readString();
        boolean recibePublicidad = publicidadInput.equalsIgnoreCase("S");

        // Crear el cliente y llamar al metodo alta para que lo añada
        Cliente cliente = new Cliente(dni, nombre, apellido, telefono, recibePublicidad);
        gestionUsuarios.alta(cliente);
    }
}
