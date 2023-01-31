import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        try {
            // trae el archivo
            File file = new File("file.txt");

            // obtener datos
            Scanner input = new Scanner(file);
            Integer m1 = input.nextInt();
            Integer m2 = input.nextInt();
            Integer n = input.nextInt();
            String instruccion1 = input.next();
            String instruccion2 = input.next();
            String mensaje = input.next();

            // condiciones esperadas
            if((n >= 3 && n <= 5000) && (m1 >= 2 && m1 <= 50) && (m2 >= 2 && m2 <= 50)) {
                // general el mensage con la instruccion
                String resultado1 = validarCaracteres(instruccion1, mensaje);
                String resultado2 = validarCaracteres(instruccion2, mensaje);

                System.out.println(resultado1 + "\n" + resultado2);
            }
            else {
                System.out.println("Formato incorrecto");
            }
        } catch (FileNotFoundException e) {
            System.out.println("No se pudo encontrar el archivo.");
        }
    }

    private static String validarCaracteres(String instruccion, String mensaje) {
        int i = 0; // recore mensaje
        int j = 0; // recorre instruccion

        /*
           Si j llega al final de la instrucción, significa que la instrucción está escondida en
           el mensaje, y la función devuelve "SI". De lo contrario, la función devuelve "NO".
        */
        while (i < mensaje.length() && j < instruccion.length()) {
            if(mensaje.charAt(i) == instruccion.charAt(j)) {
                j++;
            }
            i++;
        }

        if (j == instruccion.length()) {
            return "SI";
        }
        return "NO";
    }
}