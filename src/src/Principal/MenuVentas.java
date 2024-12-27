package Principal;

import EntradaSalida.MyInput;
import GestionableConcesionario.Concesionario;
import GestionableConcesionario.GestionUsuarios;
import GestionableConcesionario.GestionVentas;
import Concesionario.*;
import java.util.Date;

public class MenuVentas extends MenuPrincipal{

    private GestionVentas gestionVentas = (GestionVentas) getGestionable(0);
    private GestionUsuarios gestionUsuarios = (GestionUsuarios) getGestionable(1);

    public MenuVentas(Concesionario concesionario) {
        super(concesionario);
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

        System.out.println("Introduce el id del cliente de la venta: ");
        String idCliente = MyInput.readString();
        Cliente cliente = gestionUsuarios.buscar(idCliente);

        System.out.println("Introduce la fecha de la venta: ");
        //Comprobar como se crea una fecha bien
        //Mirar metodos obsoletos de la clase
        Date fecha = new Date();

        System.out.println("Introduce la matricula de la venta: ");
        String matricula = MyInput.readString();

        System.out.println("Introduce el precio de la venta: ");
        int precio = MyInput.readInt();

        gestionVentas.alta(new Venta(id, cliente, fecha, matricula, precio));
    }

    private void mostrarInfoCliente(){
        System.out.println("Introduce el id del cliente: ");
        String id = MyInput.readString();
        Cliente cliente = gestionUsuarios.buscar(id);
        gestionVentas.listarVentas(cliente);
    }
}