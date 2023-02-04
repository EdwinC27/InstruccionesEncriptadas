import java.io.FileNotFoundException;
import java.util.Scanner;

public class LeerArchivo {
    Scanner input = null;
    public void obtenerDatos(String[] args) {
        try {
            input = new Scanner(Atributos.file);

            Atributos.m1 = input.nextInt();
            Atributos.m2 = input.nextInt();
            Atributos.n = input.nextInt();
            Atributos.instruccion1 = input.next();
            Atributos.instruccion2 = input.next();
            Atributos.mensaje = input.next();

            Condiciones condiciones = new Condiciones();
            condiciones.condicionesEsperadas(args);
        } catch (FileNotFoundException e) {
            System.out.println("Error al leer los datos, por favor verifique que sea el formato correcto");
        }
    }
}