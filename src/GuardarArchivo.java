import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class GuardarArchivo {
    public static void crearArchivo(String nombre) {
        try {
            File file = new File(nombre);
            // Si el archivo no existe es creado
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(Atributos.resultado1);
            bw.write("\n");
            bw.write(Atributos.resultado2);
            bw.close();
            System.out.println("Archivo creado");
        } catch (Exception e) {
            System.out.println("Error al crear el archivo");
        }
    }
}
