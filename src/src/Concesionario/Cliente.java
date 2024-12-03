package Concesionario;

public class Cliente  {
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



}
