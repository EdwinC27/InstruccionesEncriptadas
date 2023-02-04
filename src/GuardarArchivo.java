import java.io.FileWriter;

public class GuardarArchivo {
    public static void crearArchivo(String file) {
        try(FileWriter fw = new FileWriter(file, true))
        {
            fw.write(Atributos.resultado1);
            fw.write("\n");
            fw.write(Atributos.resultado2);
            System.out.println("El fichero se ha creado correctamente");
        } catch (Exception e) {
            System.out.println("Error al agregar los datos");
        }
    }
}
