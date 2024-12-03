package Concesionario;

import GestionableConcesionario.GestionUsuario;
import EntradaSalida.MyInput;

import java.util.ArrayList;
import java.util.List;

public class Cliente  implements GestionUsuario{
    private static List<Cliente> clientes = new ArrayList<>();



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
    //Getters y Setters of catan

    public String getDni() { return dni;}

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public boolean isRecibePublicidad() {
        return recibePublicidad;
    }

    public void setRecibePublicidad(boolean recibePublicidad) {
        this.recibePublicidad = recibePublicidad;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public static void agregarCliente() {
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
    }

    public static void listarClientes() {
        System.out.println("Lista de Clientes:");
        if (clientes.isEmpty()){
            System.out.println("No hay clientes");
        }else{
            for (Cliente cliente : clientes){
                System.out.println("-----------");
                System.out.println("DNI y Nomrbe del Cliente : "+cliente.getDni()+" "+cliente.getNombre());


            }
        }
    }

}
