package GestionableConcesionario;


import EntradaSalida.MyInput;
import Concesionario.Cliente;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class GestionUsuarios implements IGestionable<Cliente> {
    private static List<Cliente> clientes = new ArrayList<>();

    public void agregarCliente(GestionUsuarios gestionUsuarios) {
        System.out.println("DNI Cliente:");
        String dni = MyInput.readString();
        System.out.println("Nombre Cliente:");
        String nombre =MyInput.readString();
        System.out.println("Apellido Cliente:");
        String apellido =MyInput.readString();
        System.out.println("Telefono Cliente:");
        String telefono = MyInput.readString();
        System.out.println("Desea recibe Publicidad:(S para aceptar)");
        String recibePublicidadEntrada = MyInput.readString();

        boolean recibePublicidad= recibePublicidadEntrada.equalsIgnoreCase("s");

        Cliente nuevoCliente = new Cliente(dni,nombre,apellido,telefono,recibePublicidad);
        clientes.add(nuevoCliente);
        System.out.println("Cliente añadido exitosamente.");
    }

    public static void listarClientesPublicidad(GestionUsuarios gestionUsuarios) {
        System.out.println("Lista de Clientes que quieren pubicidad:  (Nombre y apellido)");
        if (clientes.isEmpty()){
            System.out.println("No hay clientes");
        }else {
            for (Cliente cliente : clientes) {
                if (cliente.isRecibePublicidad()) {
                    System.out.println("-----------");
                    System.out.println(cliente.getNombre() + " " + cliente.getApellido());
                }
            }
        }
    }

    public static void listarClienteDni(GestionUsuarios gestionUsuarios,String dni) {
        System.out.println("Lista de Clientes que quieren pubicidad:  (Nombre y apellido)");
        if (clientes.isEmpty()){
            System.out.println("No hay clientes");
        }else {
            for (Cliente cliente : clientes) {
                if (cliente.getDni().equals(dni)) {
                    System.out.println("-----------");
                    System.out.println(cliente.getNombre() + " " + cliente.getApellido());
                }
            }
        }
    }



    public void listarClientes(GestionUsuarios gestionUsuarios){
        System.out.println("Lista de Clientes (Nombre y apellido):");
        if (clientes.isEmpty()){
            System.out.println("No hay clientes");
        }else{
            for (Cliente cliente : clientes){
                System.out.println("-----------");
                System.out.println(cliente.getNombre()+" "+cliente.getApellido());


            }
        }
    }

    @Override
    public List<Cliente> listar() {
        return Collections.emptyList();
    }
}
