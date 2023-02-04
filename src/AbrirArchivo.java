import java.io.*;

public class AbrirArchivo {
    public void leerArchivo(String[] args)  {
        try {
            if (args.length == 2) { // mando a llamar por consola del SO
                Atributos.inputFileName = args[0];
                Atributos.outputFileName = args[1];

                try (BufferedReader reader = new BufferedReader(new FileReader(Atributos.inputFileName))) {
                    Atributos.file = new File(Atributos.inputFileName);
                } catch (IOException e) {
                    System.out.println("Error al leer el archivo");
                }

                if (Atributos.file.exists()) {
                    // se creo
                    LeerArchivo leerArchivo = new LeerArchivo();
                    leerArchivo.obtenerDatos(args);
                } else {
                    System.out.println("Archivo no encontrado");
                }

            } else if (args.length == 0) { // mando a llamar por consola del IDE

                String nombre = "file.txt";

                System.out.println("1- Leer el archivo predeterminado\n2- Abrir otro archivo\nQue decea: ");
                int res = Atributos.scanner.nextInt();

                if (res == 2) {
                    Atributos.scanner.nextLine(); // limpiar bufer
                    System.out.println("Digite la ruta del archivo a abrir: ");
                    nombre = Atributos.scanner.nextLine();
                }

                Atributos.file = new File(nombre);

                if (Atributos.file.exists()) {
                    // se creo
                    LeerArchivo leerArchivo = new LeerArchivo();
                    leerArchivo.obtenerDatos(args);
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
}
