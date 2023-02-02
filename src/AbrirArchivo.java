import java.io.File;
import java.io.FileNotFoundException;

public class AbrirArchivo {
    public void leerArchivo() throws FileNotFoundException {
        String nombre = "file.txt";

        System.out.println("1- Leer el archivo predeterminado\n2- Abrir otro archivo\nQue decea: ");
        int res = Main.scanner.nextInt();

        if (res == 2) {
            Main.scanner.nextLine(); // limpiar bufer
            System.out.println("Digite la ruta del archivo a abrir: ");
            nombre = Main.scanner.nextLine();
        }

        Main.file = new File(nombre);

        if(Main.file.exists()) {
            // se creo
            LeerArchivo leerArchivo = new LeerArchivo();
            leerArchivo.obtenerDatos();
        }
        else {
            // mandar a llamar otra funcion de otra case para mostrar "Archivo no encontrado"
            System.out.println("Archivo no encontrado");
        }
    }
}
