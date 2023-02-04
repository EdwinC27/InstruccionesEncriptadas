import java.io.File;
import java.io.IOException;

public class OpcionesGuardado {
    GuardarArchivo guardarArchivo = new GuardarArchivo();

    public void opcGuardarArchivo(String[] args) {
         if (args.length == 2) guardarArchivo.crearArchivo(Atributos.outputFileName);

         else {
            System.out.println("\nYa se genero la respuesta\n1- Guardar archivo por default\n2- Modificar ruta y nombre\nQue decea: ");
            Integer opcGuardar = Atributos.scanner.nextInt();

            try {
                // por defecto
                if (opcGuardar == 1) guardarArchivo.crearArchivo("respuesta.txt");

                    // eligir ruta y nombre
                else if (opcGuardar == 2) {
                    Atributos.scanner.nextLine(); // limpiar bufer

                    System.out.println("Ingrese la ruta: ");
                    String ruta = Atributos.scanner.nextLine();

                    System.out.println("Ingrese el nombre: ");
                    String nombre = Atributos.scanner.nextLine();

                    // verificar si termina con .txt
                    if (!nombre.contains(".txt")) nombre += ".txt";

                    Atributos.file = new File(ruta, nombre);

                    if (Atributos.file.createNewFile()) guardarArchivo.crearArchivo(String.valueOf(Atributos.file));

                    else System.out.println("No ha podido ser creado el fichero");
                }
            } catch (IOException ex) {
                System.out.println("Error al crear el archivo en la ruta especificada");
            }
        }
    }
}
