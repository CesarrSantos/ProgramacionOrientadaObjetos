package Principal;


import EntradaSalida.MyInput;
import GestionableConcesionario.*;

public class Main {
    private static final String ruta = "Concesionario.dat";

    public static void main(String[] args) {
        Concesionario concesionario = crearConcesionario();

        MenuPrincipal menuPrincipal = new MenuPrincipal(concesionario);
        menuPrincipal.agregar_menu(new MenuVentas(concesionario));
        menuPrincipal.agregar_menu(new MenuUsuarios(concesionario));
        menuPrincipal.agregar_menu(new MenuSeccion(concesionario));
        menuPrincipal.agregar_menu(new MenuCoches(concesionario));
        menuPrincipal.principal();

        MyInput.serialize(concesionario, ruta);
    }

    public static Concesionario crearConcesionario(){
       Concesionario concesionario = MyInput.deserialize(ruta);

       if(concesionario == null){
           System.out.println("Creando nuevo concesionario...");
           concesionario = new Concesionario();
           concesionario.agregar(new GestionVentas());
           concesionario.agregar(new GestionUsuarios());
           concesionario.agregar(new GestionSeccion());
           concesionario.agregar(new GestionCoches());
       }else{
           System.out.println("Concesionario cargado");
       }

       return concesionario;
    }
}

