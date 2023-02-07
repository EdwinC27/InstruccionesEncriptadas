public class Main {
    public static void main(String[] args) {
        try {
            LeerArchivo.leerArchivo(args);

        } catch (Exception e) {
            System.out.println("No se encontro el archivo");
        }
    }
}
