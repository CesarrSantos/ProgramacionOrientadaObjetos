package Principal;

import EntradaSalida.MyInput;
import GestionableConcesionario.Concesionario;
import GestionableConcesionario.GestionUsuarios;
import GestionableConcesionario.GestionVentas;
import Concesionario.*;
import Mejoras.*;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class MenuVentas extends MenuPrincipal{

    private GestionVentas gestionVentas = (GestionVentas) getGestionable(0);
    private GestionUsuarios gestionUsuarios = (GestionUsuarios) getGestionable(1);
    private MenuUsuarios menuUsuarios; //Se usa despues para dar de alta clientes

    public MenuVentas(Concesionario concesionario) {
        super(concesionario);
        menuUsuarios = new MenuUsuarios(concesionario);
    }

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

    public void mostrar_opciones(){
            System.out.println("Menu de Ventas");
            System.out.println("-----------------");
            System.out.println("0. Salir del menu de usuarios");
            System.out.println("1. Registrar una venta");
            System.out.println("2. Mostrar informacion de una venta a base de su id");
            System.out.println("3. Mostrar informacion de todas las ventas de un cliente");
    }

    private void registrarVenta(){
        System.out.println("Introduce el id de la venta: ");
        String id = MyInput.readString();
        if(id.length() != 9){
            System.out.println("El id del venta no es valido");
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
        String s_fecha = MyInput.readString();
        LocalDate fecha;
        try {
            fecha = LocalDate.parse(s_fecha);
        }catch (DateTimeParseException e){
            System.out.println("La fecha no es valida");
            return;
        }

        System.out.println("Introduce la matricula de la venta: ");
        String matricula = MyInput.readString();

        System.out.println("Introduce el precio de la venta: ");
        int precio = MyInput.readInt();
        if(precio < 0){
            System.out.println("El precio de la venta no es valido");
            return;
        }

        Mejoras mejoras = decorarMejoras();
        gestionVentas.alta(new Venta(id, cliente, fecha, matricula, precio, mejoras));
    }

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

    private void mostrarInfoCliente(){
        System.out.println("Introduce el id del cliente: ");
        String id = MyInput.readString();
        Cliente cliente = gestionUsuarios.buscar(id);
        gestionVentas.listarVentas(cliente);
    }
}