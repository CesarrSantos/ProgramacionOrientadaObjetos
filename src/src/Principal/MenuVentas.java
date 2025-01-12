package Principal;

import EntradaSalida.MyInput;
import GestionableConcesionario.*;
import Concesionario.*;
import Mejoras.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

/**
 * Clase que representa el menú de gestión de ventas en el concesionario.
 * Esta clase hereda de {@link MenuPrincipal} y permite registrar ventas,
 * consultar ventas por ID y mostrar información sobre las ventas de un cliente.
 */
public class MenuVentas extends MenuPrincipal{
    private final GestionVentas gestionVentas = (GestionVentas) getGestionable(0);
    private final GestionUsuarios gestionUsuarios = (GestionUsuarios) getGestionable(1);
    private final GestionCoches gestionCoches = (GestionCoches) getGestionable(3);
    private final MenuUsuarios menuUsuarios; //Se usa despues para dar de alta clientes

    /**
     * Constructor de la clase MenuVentas.
     * Inicializa el menú de usuarios que se utilizará para dar de alta a nuevos clientes.
     *
     * @param concesionario El concesionario sobre el que se gestionarán las ventas.
     */
    public MenuVentas(Concesionario concesionario) {
        super(concesionario);
        menuUsuarios = new MenuUsuarios(concesionario);
    }

    /**
     * Método principal que ejecuta el menú interactivo de gestión de ventas.
     * Permite a los usuarios elegir entre diferentes opciones para gestionar las ventas.
     */
    @Override
    public  void principal(){
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
                    registrarVenta();
                    break;
                case 2:
                    System.out.println("Introduzca el id de la venta: ");
                    String id = MyInput.readString();
                    gestionVentas.listarVenta(id);
                    break;
                case 3:
                    mostrarInfoCliente();
                    break;
                default:
                    System.out.println("Opcion no Correcta");
            }
        }
    }

    /**
     * Muestra las opciones del menú de ventas.
     */
    @Override
    public void mostrar_opciones(){
            System.out.println("Menu de Ventas");
            System.out.println("-----------------");
            System.out.println("0. Salir del menu de usuarios");
            System.out.println("1. Registrar una venta");
            System.out.println("2. Mostrar informacion de una venta a base de su id");
            System.out.println("3. Mostrar informacion de todas las ventas de un cliente");
    }

    /**
     * Solicita al usuario los datos necesarios para registrar una nueva venta.
     * Registra la venta en el sistema, verificando que los datos sean correctos y validando la existencia
     * del cliente asociado. Si el cliente no existe, ofrece la opción de crear uno nuevo.
     */
    private void registrarVenta(){
        System.out.println("Introduzca el id de la venta: ");
        String id = MyInput.readString();
        if(id.length() != 9){
            System.out.println("El id del venta no es valido (ej:V00000001)");
            return;
        }

        Coches coche = seleccionarCoche();
        if(coche == null){
            System.out.println("El coche seleccionado no existe. No es posible realizar la venta");
            return;
        }

        if(coche.getStock() <= 0){
            System.out.println("El coche seleccionado esta agotado. No es posible realizar la venta actualmente");
            return;
        }

        System.out.println("Introduzca el id del cliente de la venta: ");
        String idCliente = MyInput.readString();
        Cliente cliente = gestionUsuarios.buscar(idCliente);
        if(cliente == null){
            System.out.println("El cliente seleccionado no existe");
            System.out.print("Desea crear el cliente? (S/N): ");
            String respuesta = MyInput.readString();
            if(respuesta.equalsIgnoreCase("S")){
                cliente = menuUsuarios.altaCliente();
                //Segundo check por si falla algo al crear el cliente en el momento
                if(cliente == null){
                    System.out.println("Ha habido un problema registrando al nuevo cliente.");
                    return;
                }
            }else {
                return;
            }
        }

        System.out.println("Introduzca la fecha de la venta (AAAA-MM-DD): ");
        String s_fecha = MyInput.readString();
        LocalDate fecha;
        try {
            fecha = LocalDate.parse(s_fecha);
        }catch (DateTimeParseException e){
            System.out.println("La fecha no es valida");
            return;
        }

        System.out.println("Introduzca la matricula de la venta: ");
        String matricula = MyInput.readString();

        int precio = coche.getPrecio();
        coche.setStock(coche.getStock() - 1);

        Mejoras mejoras = decorarMejoras();
        precio = (int) (precio * mejoras.getPrecio());
        gestionVentas.alta(new Venta(id, cliente, fecha, matricula, precio, mejoras));
    }

    /**
     * Permite al usuario seleccionar un coche para asignar a la venta que esta siendo registrada
     *
     * @return el coche seleccionado, o {@code null} si no se encuentra.
     */
    private Coches seleccionarCoche() {
        System.out.println("Introduce el ID de la sección del coche: ");
        String idSeccion = MyInput.readString();

        System.out.println("Introduce el ID del coche: ");
        String idCoche = MyInput.readString();

        Coches coche = gestionCoches.buscar(idSeccion, idCoche);
        if (coche == null || coche.getStock() == 0) {
            System.out.println("Coche no encontrado o sin stock.");
            return null;
        }
        return coche;
    }

    /**
     * Permite decorar una venta con las mejoras adicionales, como calefacción, cuero, GPS y llantas.
     * El usuario puede elegir si desea agregar cada mejora.
     *
     * @return Las mejoras decoradas para la venta.
     */
    private Mejoras decorarMejoras(){
        Mejoras mejoras = new Mejoras();

        System.out.print("¿Quiere añadir calefaccion a los asientos del coche? (S/N): ");
        if(MyInput.readString().equals("s")){
            mejoras = new Calefaccion(mejoras);
        }

        System.out.print("¿Quiere añadir cuero a los asientos del coche? (S/N): ");
        if(MyInput.readString().equals("s")){
            mejoras = new Cuero(mejoras);
        }

        System.out.print("¿Quiere añadir gps al coche? (S/N): ");
        if(MyInput.readString().equals("s")){
            mejoras = new Gps(mejoras);
        }

        System.out.print("¿Quiere añadir llantas de aleación al coche? (S/N): ");
        if(MyInput.readString().equals("s")){
            mejoras = new Llantas(mejoras);
        }

        return mejoras;
    }

    /**
     * Muestra la información de todas las ventas asociadas a un cliente específico.
     * Solicita al usuario el ID del cliente y, si el cliente existe, muestra todas sus ventas.
     */
    private void mostrarInfoCliente(){
        System.out.println("Introduzca el id del cliente: ");
        String id = MyInput.readString();
        Cliente cliente = gestionUsuarios.buscar(id);
        gestionVentas.listarVentas(cliente);
    }
}