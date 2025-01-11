package Principal;

import EntradaSalida.MyInput;
import GestionableConcesionario.Concesionario;
import GestionableConcesionario.GestionCoches;
import GestionableConcesionario.GestionUsuarios;
import GestionableConcesionario.GestionVentas;
import Concesionario.*;
import Mejoras.*;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Date;
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
                    MyInput.limpiarPantalla();
                    registrarVenta();
                    break;
                case 2:
                    System.out.println("Introduce el id de la venta: ");
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
        System.out.println("Introduce el id de la venta: ");
        String id = MyInput.readString();
        if(id.length() != 9){
            System.out.println("El id del venta no es valido");
            return;
        }

        Coches coche = seleccionarCoche();
        if(coche == null){
            System.out.println("No existe el coche. No es posible realizar la venta");
            return;
        }

        if(coche.getStock() <= 0){
            System.out.println("No queda stock. No es posible realizar la venta");
            return;
        }

        System.out.println("Introduce el id del cliente de la venta: ");
        String idCliente = MyInput.readString();
        Cliente cliente = gestionUsuarios.buscar(idCliente);
        if(cliente == null){
            System.out.println("El cliente no existe");
            System.out.println("Desea crear el cliente? (S/N)");
            String respuesta = MyInput.readString();
            if(respuesta.equalsIgnoreCase("S")){
                cliente = menuUsuarios.altaCliente();
            }else {
                return;
            }
        }

        System.out.println("Introduce la fecha de la venta: ");
        Date date = new Date();
        String s_fecha = String.valueOf(date.getTime());
        LocalDate fecha;
        try {
            fecha = LocalDate.parse(s_fecha);
        }catch (DateTimeParseException e){
            System.out.println("La fecha no es valida");
            return;
        }

        System.out.println("Introduce la matricula de la venta: ");
        String matricula = MyInput.readString();

        int precio = coche.getPrecio();
        coche.setStock(coche.getStock() - 1);

        Mejoras mejoras = decorarMejoras();
        precio = (int) (precio * mejoras.getPrecio());
        gestionVentas.alta(new Venta(id, cliente, fecha, matricula, precio, mejoras));
    }

    //TODO JAVADOC AQUI NO OLVIDAR IMPORTANTE
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

        System.out.println("Quieres calefaccion?");
        if(MyInput.readString().equals("s")){
            mejoras = new Calefaccion(mejoras);
        }

        System.out.println("Quieres cuero?");
        if(MyInput.readString().equals("s")){
            mejoras = new Cuero(mejoras);
        }

        System.out.println("Quieres gps?");
        if(MyInput.readString().equals("s")){
            mejoras = new Gps(mejoras);
        }

        System.out.println("Quieres llantas?");
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
        System.out.println("Introduce el id del cliente: ");
        String id = MyInput.readString();
        Cliente cliente = gestionUsuarios.buscar(id);
        gestionVentas.listarVentas(cliente);
    }
}