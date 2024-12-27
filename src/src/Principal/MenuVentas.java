package Principal;

import EntradaSalida.MyInput;
import GestionableConcesionario.Concesionario;
import GestionableConcesionario.GestionCoches;
import GestionableConcesionario.GestionUsuarios;
import GestionableConcesionario.GestionVentas;
import Mejoras.*;
import Concesionario.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

public class MenuVentas extends MenuPrincipal{

    private final GestionVentas gv;
    private final GestionUsuarios gu;
    private final GestionCoches gc;
    private final Concesionario c;
    private static final String regexMatricula = "^[0-9]{4}[A-Z]{3}$";
    private static final String regexId = "^V[0-9]{8}$";
    private List<Mejoras> ultimasMejorasAplicadas = new ArrayList<>();

    public MenuVentas(Concesionario c){
        this.c=c;
        gv = (GestionVentas) c.recuperar(3);
        gu= (GestionUsuarios) c.recuperar(1);
        gc= (GestionCoches) c.recuperar(2);
    }

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
                    registrarVenta();
                    break;
                case 2:
                    System.out.println("Introduce el ID de la venta: ");
                    String idVenta = MyInput.readString();
                    System.out.println(gv.obtenerVentaInfo(idVenta));
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
        System.out.println("Introduce el id de la venta:  ejemplo: V00000001 ");
        String idVenta = MyInput.readString();
        if (Pattern.matches(regexId,idVenta)){
            System.out.println("ID válido: " + idVenta);
        } else {
            System.out.println("Matrícula no válida. Debe seguir el formato: 1234ABC");
            return;  // Termina el proceso si el ID no es válida
        }

        Coches coche = seleccionarCoche();
        if (coche == null) {
            System.out.println("No se pudo registrar la venta. No hay coches disponibles.");
            return;
        }
        Cliente cliente = seleccionarCliente();

        System.out.println("Introduce la matrícula del coche: ");
        String matricula = MyInput.readString();

        if (Pattern.matches(regexMatricula,matricula)){
            System.out.println("Matrícula válida: " + matricula);
        } else {
            System.out.println("Matrícula no válida. Debe seguir el formato: 1234ABC");
            return;  // Termina el proceso si la matrícula no es válida
        }

        int precioBase = coche.getPrecio();
        int precioFinal = aplicarMejoras(precioBase);


        Venta venta = new Venta(idVenta, cliente, new Date(), matricula, precioFinal,new ArrayList<>(ultimasMejorasAplicadas));
        gv.alta(venta);

        coche.setStock(coche.getStock() - 1);
        System.out.println("Venta registrada con éxito. El stock de coches se ha actualizado.");
    }

    private Coches seleccionarCoche() {
        System.out.println("Introduce el ID de la sección del coche: ");
        String idSeccion = MyInput.readString();

        System.out.println("Introduce el ID del coche: ");
        String idCoche = MyInput.readString();

        Coches coche = gc.buscar(idSeccion, idCoche);
        if (coche == null || coche.getStock() == 0) {
            System.out.println("Coche no encontrado o sin stock.");
            return null;
        }
        return coche;
    }
    private Cliente seleccionarCliente() {
        System.out.println("Introduce el DNI/NIF del cliente: ");
        String dni = MyInput.readString();

        Cliente cliente = gu.buscar(dni);
        if (cliente == null) {
            MenuUsuarios menuUsuarios =new MenuUsuarios(c);
            menuUsuarios.altaCliente();
        }
        return cliente;
    }

    private int aplicarMejoras(int precioBase) {

        int precioFinal = precioBase;
        List<Mejoras> mejorasAplicadas = new ArrayList<>();
        boolean continuar = true;

        while (continuar) {
            System.out.println("Seleccione las mejoras que desea aplicar:");
            System.out.println("1. Calefacción en los asientos y el volante (5% de aumento)");
            System.out.println("2. Cuero (10% de aumento)");
            System.out.println("3. GPS (1% de aumento)");
            System.out.println("4. Llantas (5% de aumento)");
            System.out.println("5. Terminar selección de mejoras");
            int opcion = MyInput.readInt();

            switch (opcion) {
                case 1:
                    //TLDR te permite verificar si existe una mejora X dentro de el ArrayList
                    if (mejorasAplicadas.stream().noneMatch(m -> m instanceof Calefaccion)) {
                        Mejoras calefaccion = new Calefaccion(new MejorasBase(precioBase));
                        mejorasAplicadas.add(calefaccion);
                        System.out.println("Mejora aplicada: Calefacción en los asientos y el volante");
                    } else {
                        System.out.println("Ya has seleccionado esta mejora.");
                    }
                    break;

                case 2:
                    if (mejorasAplicadas.stream().noneMatch(m -> m instanceof Cuero)) {
                        Mejoras cuero = new Cuero(new MejorasBase(precioBase));
                        mejorasAplicadas.add(cuero);
                        System.out.println("Mejora aplicada: Cuero");
                    } else {
                        System.out.println("Ya has seleccionado esta mejora.");
                    }
                    break;

                case 3:
                    if (mejorasAplicadas.stream().noneMatch(m -> m instanceof Gps)) {
                        Mejoras gps = new Gps(new MejorasBase(precioBase));
                        mejorasAplicadas.add(gps);
                        System.out.println("Mejora aplicada: GPS");
                    } else {
                        System.out.println("Ya has seleccionado esta mejora.");
                    }
                    break;

                case 4:
                    if (mejorasAplicadas.stream().noneMatch(m -> m instanceof Llantas)) {
                        Mejoras llantas = new Llantas(new MejorasBase(precioBase));
                        mejorasAplicadas.add(llantas);
                        System.out.println("Mejora aplicada: Llantas de aleación");
                    } else {
                        System.out.println("Ya has seleccionado esta mejora.");
                    }
                    break;

                case 5:
                    continuar = false;
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        }

        // Calcular el precio final con las mejoras aplicadas
        for (Mejoras mejora : mejorasAplicadas) {
            precioFinal = (int) mejora.getPrecio();
        }



        // Mostrar las mejoras aplicadas
        System.out.println("Mejoras aplicadas:");
        for (Mejoras mejora : mejorasAplicadas) {
            System.out.println(mejora.getDescripcion());
        }
        this.ultimasMejorasAplicadas = new ArrayList<>(mejorasAplicadas);
        return precioFinal;
    }

    private void mostrarInfoCliente(){
        System.out.println("Introduce el id del cliente: ");
        String id = MyInput.readString();
        Cliente cliente = gu.buscar(id);

        if (cliente == null) {
            return;
        }
        List<String> ventasInfo = gv.obtenerVentasPorCliente(cliente);
        for (String info : ventasInfo) {
            System.out.println(info);
        }
    }
}