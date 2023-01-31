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


        } catch (FileNotFoundException e) {
            System.out.println("No se pudo encontrar el archivo.");
        }
    }
}