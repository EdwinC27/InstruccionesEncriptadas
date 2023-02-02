import java.io.*;
import java.util.Scanner;

public class Main {
    static File file;
    static Scanner scanner = new Scanner(System.in);
    static String resultado1;
    static String resultado2;
    static Integer m1;
    static Integer m2;
    static Integer n;
    static String instruccion1;
    static String instruccion2;
    static String mensaje;


    public static void main(String[] args) {
        try {
            AbrirArchivo abrirArchivo = new AbrirArchivo();
            abrirArchivo.leerArchivo();

        } catch (Exception e) {
            System.out.println("No se encontro el archivo");
        }
    }
}
