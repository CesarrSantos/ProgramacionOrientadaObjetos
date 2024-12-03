package Concesionario;

import GestionableConcesionario.GestionUsuario;
import EntradaSalida.MyInput;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Cliente  implements GestionUsuario{
    private List<Cliente> clientes = new ArrayList<>();
    private String dni;
    private String nombre;
    private String apellido;
    private String telefono;
    private boolean recibePublicidad;

    public Cliente(String dni, String nombre, String apellido,String telefono, boolean recibePublicidad) {
        this.dni =dni;
        this.nombre=nombre;
        this.apellido=apellido;
        this.telefono=telefono;
        this.recibePublicidad=recibePublicidad;
    }

    public String getDni() { return dni;}


    @Override
    public void agregarCliente(Cliente cliente) {
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

    }

    @Override
    public void listarClientes() {
        System.out.println("Lsita de Clientes:");
        if (clientes.isEmpty()){
            System.out.println("No hay clientes");
        }else{
            for (Cliente cliente : clientes){
                System.out.println(cliente);
            }
        }
    }

}
