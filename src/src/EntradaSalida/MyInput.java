package EntradaSalida;

import java.io.*;

/**
 * Clase con utilidades para la entrada de datos desde teclado y fichero
 * @author jvalvarez
 */
public class MyInput{
    public static void limpiarPantalla(){
        for(int i = 0; i < 25; i++){
            System.out.println();
        }
    }

    /**
     * Metodo que permite leer una cadena de caracteres del teclado
     *
     * @return retorna una cadena de caracteres
     */
    public static String readString() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1);
        String string = "";
        try {
            string = br.readLine();
        } catch (IOException ex) {
            System.out.println(ex);
        }
        return string;
    }

    /**
     * Método que permite leer un número entero de simple precisión por teclado
     *
     * @return retorna un número entero de precisión simple
     */
    public static int readInt() {
        try {
            return Integer.parseInt(readString());
        } catch (NumberFormatException ex) {
            System.out.println("La entrada no tiene formato de número. Inténtelo de nuevo");
            return  readInt();
        }
    }



    public static <A> void serialize(A a, String nombreFichero) {
        System.out.println("Serializando...");
        try {
            FileOutputStream fos = new FileOutputStream(nombreFichero) ;
            ObjectOutputStream oos = new ObjectOutputStream(fos) ;
            oos.writeObject(a) ;
        } catch (Exception e) {
            System.err.println("Problem: "+e) ;
        }
    }

    public static <A> A deserialize(String nombreFichero) {
        System.out.println("DeSerializing...");
        try {
            FileInputStream fis = new FileInputStream(nombreFichero) ;
            ObjectInputStream iis = new ObjectInputStream(fis) ;
            return (A) iis.readObject() ;
        } catch (Exception e) {
            System.err.println("Problem: "+e) ;
        }
        return null ;
    }

}