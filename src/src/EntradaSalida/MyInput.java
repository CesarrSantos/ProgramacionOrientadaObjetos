package EntradaSalida;

import java.io.*;


/**
 * Clase con utilidades para la entrada de datos desde teclado y fichero
 * @author jvalvarez
 */
public class MyInput{
    // Lee una cadena de caracteres desde el teclado

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

    public static String readString(String filtro) throws InvalidCharacterException{
        String string = readString();
        for(char c: string.toCharArray()) {
            if(string.indexOf(c) != -1) {
                throw new InvalidCharacterException("Has introducido un carácter invalido. Por favor introduce caracteres solo dentro de los siguientes: \n" + filtro);
            }
        }
        return string;
    }
// Lee un dato tipo int  desde el teclado

    /**
     * Método que permite leer un número entero de simple precisión por teclado
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
// Lee un dato tipo double  desde el teclado

    /**
     * Método que permite leer número real por teclado.
     * @return retorna un número de doble precisión.
     */
    public static double readDouble() {
        try {
            return Double.parseDouble(readString());
        } catch (NumberFormatException ex) {
            System.out.println("La entrada no tiene formato de número. Inténtelo de nuevo");
            return  readDouble();
        }
    }



}