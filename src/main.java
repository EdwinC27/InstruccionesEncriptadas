import java.io.*;
import java.util.Scanner;

public class main {
    static File file;
    static Scanner scanner = new Scanner(System.in);
    static String resultado1;
    static String resultado2;

    public static void main(String[] args) {
        try {
            abrirArchivo();

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
                resultado1 = validarCaracteres(instruccion1, mensaje);
                resultado2 = validarCaracteres(instruccion2, mensaje);

                opcGuardarArchivo();
            }
            else {
                System.out.println("Formato incorrecto");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Ocurrio un error con el archivo.");
        }
    }

    private static void abrirArchivo() {
        String nombre = "file.txt";

        System.out.println("1- Leer el archivo predeterminado\n2- Abrir otro archivo\nQue decea: ");
        int res = scanner.nextInt();

        if(res == 2) {
            scanner.nextLine(); // limpiar bufer
            System.out.println("Digite la ruta del archivo a abrir: ");
            nombre = scanner.nextLine();
        }

        file = new File(nombre);
    }

    private static void opcGuardarArchivo() {
        System.out.println("\nYa se genero la respuesta\n1- Guardar archivo por default\n2- Modificar ruta y nombre\nQue decea: ");
        Integer opcGuardar = scanner.nextInt();

        try {
            // por defecto
            if(opcGuardar == 1) crearArchivo("respuesta.txt");

            else if(opcGuardar == 2) { // elegir ruta y nombre
                scanner.nextLine(); // limpiar bufer

                System.out.println("Ingrese la ruta: ");
                String ruta = scanner.nextLine();

                System.out.println("Ingrese el nombre: ");
                String nombre = scanner.nextLine();

                // verificar si termina con .txt
                int len = nombre.length();
                String lastFour = nombre.substring(len-4, len);

                if(!lastFour.equals(".txt")) nombre += ".txt";

                file = new File (ruta,nombre);

                // A partir del objeto File creamos el fichero físicamente
                if (file.createNewFile()) crearArchivo(String.valueOf(file));
                else System.out.println("No ha podido ser creado el fichero");
            }
        } catch (Exception e) {
            System.out.println("Error al crear el archivo");
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

    private static void crearArchivo(String file) {
        try(FileWriter fw = new FileWriter(file, true))
        {
            fw.write(resultado1);
            fw.write("\n");
            fw.write(resultado2);
            System.out.println("El fichero se ha creado correctamente");
        } catch (Exception e) {
            System.out.println("Error al agregar los datos");;
        }
    }
}
