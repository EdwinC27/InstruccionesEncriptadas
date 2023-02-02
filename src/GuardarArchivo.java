import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GuardarArchivo {
    public static void opcGuardarArchivo() {
        System.out.println("\nYa se genero la respuesta\n1- Guardar archivo por default\n2- Modificar ruta y nombre\nQue decea: ");
        Integer opcGuardar = Main.scanner.nextInt();

        try {
            // por defecto
            if (opcGuardar == 1) crearArchivo("respuesta.txt");

                // eligir ruta y nombre
            else if (opcGuardar == 2) {
                Main.scanner.nextLine(); // limpiar bufer

                System.out.println("Ingrese la ruta: ");
                String ruta = Main.scanner.nextLine();

                System.out.println("Ingrese el nombre: ");
                String nombre = Main.scanner.nextLine();

                // verificar si termina con .txt
                if (!nombre.contains(".txt")) nombre += ".txt";

                // enviar los datos para crear el archivo
                Main.file = new File(ruta, nombre);

                // A partir del objeto File creamos el fichero físicamente
                if (Main.file.createNewFile()) crearArchivo(String.valueOf(Main.file));

                else System.out.println("No ha podido ser creado el fichero");
            }
        } catch (IOException ex) {
            System.out.println("Error al crear el archivo en la ruta especificada");
        }
    }

    public static void crearArchivo(String file) {
        try(FileWriter fw = new FileWriter(file, true))
        {
            fw.write(Main.resultado1);
            fw.write("\n");
            fw.write(Main.resultado2);
            System.out.println("El fichero se ha creado correctamente");
        } catch (Exception e) {
            System.out.println("Error al agregar los datos");;
        }
    }
}
