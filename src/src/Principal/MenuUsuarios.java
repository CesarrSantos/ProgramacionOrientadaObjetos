package Principal;

import EntradaSalida.MyInput;

import GestionableConcesionario.GestionUsuarios;
import GestionableConcesionario.Concesionario;
import Concesionario.Cliente;
/**
 * Clase que representa el menú de gestión de usuarios en el concesionario.
 * Esta clase hereda de {@link MenuPrincipal} y permite registrar clientes,
 * listar clientes, buscar un cliente por su DNI y mostrar los clientes que
 * desean recibir publicidad.
 */
public class MenuUsuarios extends MenuPrincipal {

    private final GestionUsuarios gestionUsuarios = (GestionUsuarios) getGestionable(1);

    /**
     * Constructor de la clase MenuUsuarios.
     * Inicializa el menú de usuarios, que permite gestionar los datos de los clientes del concesionario.
     *
     * @param concesionario El concesionario sobre el que se gestionarán los usuarios.
     */
    public MenuUsuarios(Concesionario concesionario) {
        super(concesionario);
    }

    /**
     * Método principal que ejecuta el menú interactivo de gestión de usuarios.
     * Permite a los usuarios elegir entre diferentes opciones para gestionar los clientes.
     */
    @Override
    public void principal(){
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

    /**
     * Muestra las opciones del menú de usuarios.
     */
    public void mostrar_opciones(){
        System.out.println("Menu de Usuarios");
        System.out.println("-----------------");
        System.out.println("0. Salir del menu de usuarios");
        System.out.println("1. Añadir usuario");
        System.out.println("2. Listar usuarios");
        System.out.println("3. Listar usuario a partir de un dni");
        System.out.println("4. Listar usuarios que quieren publicidad");
    }

    /**
     * Solicita al usuario la información necesaria para registrar un nuevo cliente
     * y lo añade al sistema.
     *
     * @return El cliente recién creado y añadido al sistema, o null si el formato del DNI es incorrecto.
     */
    public Cliente altaCliente() {
        System.out.println("=== Alta de Cliente ===");

        System.out.print("DNI del cliente: ");
        String dni = MyInput.readString();
        if(!dni.matches("^[0-9]{8}[A-Z]$")){
            System.out.println("El dni no tiene formato correcto");
            return null;
        }

        System.out.print("Nombre del cliente: ");
        String nombre = MyInput.readString();

        System.out.print("Apellido del cliente: ");
        String apellido = MyInput.readString();

        System.out.print("Teléfono del cliente: ");
        String telefono = MyInput.readString();

        System.out.print("¿Desea recibir publicidad? (S/N): ");
        String publicidadInput = MyInput.readString();
        boolean recibePublicidad = publicidadInput.equalsIgnoreCase("S");

        // Crear el cliente y devolverlo
        Cliente cliente = new Cliente(dni, nombre, apellido, telefono, recibePublicidad);
        gestionUsuarios.alta(cliente);
        return cliente;
    }
}
