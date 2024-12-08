package Principal;

import Concesionario.Seccion;
import EntradaSalida.MyInput;
import GestionableConcesionario.Concesionario;
import GestionableConcesionario.GestionCoches;
import Concesionario.Coches;

public class MenuCoches extends MenuPrincipal{

    public static void gestionarCoches(GestionCoches gestionCoches){
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
                    String[] d1 = MenuCoches.getDatos(0b1111);
                    gestionCoches.agregar(gestionCoches.crear(d1));
                    break;
                case 2:
                    String[] d2 = MenuCoches.getDatos(0b1100);
                    gestionCoches.detalles(d2[3], d2[2]);
                    break;
                case 3:
                    gestionCoches.aumentarStock();
                    break;
                case 4:
                    String[] d3 = MenuCoches.getDatos(0b1000);
                    gestionCoches.detalles(d3[3]);
                    break;
                default:
                    System.out.println("Opcion no Correcta");
            }
        }
    }

    public static void mostrar_opciones(){
        System.out.println("Menu de coches");
        System.out.println("-----------------");
        System.out.println("0. Salir del menu de usuarios");
        System.out.println("1. Agregar un coche");
        System.out.println("2. Detalles especificos de un coche");
        System.out.println("3. Aumentar el stock");
        System.out.println("4. Mostrar todos los coches de una seccion");
    }
    public static int elegir_opcion(){
        return MyInput.readInt();
    }

    private static String[] getDatos(int arg){
        String[] datos = new String[4];
        String stock, precio, idCoche, idSeccion;

        if((arg & 1) == 1) {
            System.out.println("Stock del coche (debe ser mayor que 1):");
            do{
                stock = MyInput.readString("0123456789");
            }while(Integer.parseInt(stock) < 1);
            datos[0] = stock;
        }

        if((arg & 2) == 2) {
            System.out.println("Precio base del coche:");
            do{
                precio = MyInput.readString("0123456789");
            }while(Integer.parseInt(precio) < 0);
            datos[1] = precio;
        }

        if((arg & 4) == 4) {
            do {
                System.out.println("Modelo del coche:");
                String modelo = MyInput.readString();

                System.out.println("Año de fabricación:");
                String anio = MyInput.readString("0123456789");
                idCoche = modelo + "-" + anio;
            }while(!idCoche.matches("^[a-zA-Z0-9]+-[0-9]{4}$"));
            datos[2] = idCoche;
        }

        if((arg & 8) == 8) {
            System.out.println("Secciones disponibles:");
            for (Seccion seccion : Concesionario.getGestionSeccion().getSecciones()) {
                System.out.println("ID: " + seccion.getIdSeccion() + ", Descripción: " + seccion.getDescripcion());
            }
            System.out.println("ID de la sección:");
            idSeccion = MyInput.readString();
            datos[3] = idSeccion;
        }

        return datos;
    }
}

