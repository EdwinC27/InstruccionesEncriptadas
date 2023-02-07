import java.io.*;
import java.util.Scanner;

public class LeerArchivo {
    static Scanner input = null;

    public static void leerArchivo(String[] args)  {
        try {
            if (args.length == 2) { // mando a llamar por consola del SO
                Atributos.inputFileName = args[0];
                Atributos.outputFileName = args[1];

                try (BufferedReader reader = new BufferedReader(new FileReader(Atributos.inputFileName))) {
                    Atributos.file = new File(Atributos.inputFileName);

                    if (Atributos.file.exists()) {
                        // se creo
                        obtenerDatos(args);
                    } else {
                        System.out.println("Archivo no encontrado");
                    }
                } catch (IOException e) {
                    System.out.println("Error al leer el archivo");
                }
            } else if (args.length == 0) { // mando a llamar por consola del IDE
                String nombre = "file.txt";

                System.out.println("1- Leer el archivo predeterminado\nOtro numero para digitar tu la ruta\nQue decea: ");
                int res = Atributos.scanner.nextInt();

                if (res != 1) {
                    Atributos.scanner.nextLine(); // limpiar bufer
                    System.out.println("Digite la ruta del archivo a abrir: ");
                    nombre = Atributos.scanner.nextLine();
                }

                Atributos.file = new File(nombre);

                if (Atributos.file.exists()) {
                    // se creo
                    obtenerDatos(args);
                } else {
                    System.out.println("Archivo no encontrado");
                }

            } else {
                System.out.println("El numero de parametros no coincide");
            }

        } catch (Exception e) {
            System.out.println("Error caracteres especiales");
        }
    }

    private static void obtenerDatos(String[] args) {
        try {
            input = new Scanner(Atributos.file);

            Atributos.m1 = input.nextInt();
            Atributos.m2 = input.nextInt();
            Atributos.n = input.nextInt();
            Atributos.instruccion1 = input.next();
            Atributos.instruccion2 = input.next();
            Atributos.mensaje = input.next();

            Condiciones.condicionesEsperadas(args);
        } catch (FileNotFoundException e) {
            System.out.println("Error al leer los datos, por favor verifique que sea el formato correcto");
        }
    }

}