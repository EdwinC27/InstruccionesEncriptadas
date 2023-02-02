import java.io.FileNotFoundException;
import java.util.Scanner;

public class LeerArchivo {
    Scanner input = null;
    public void obtenerDatos() {
        try {
            input = new Scanner(Main.file);

            Main.m1 = input.nextInt();
            Main.m2 = input.nextInt();
            Main.n = input.nextInt();
            Main.instruccion1 = input.next();
            Main.instruccion2 = input.next();
            Main.mensaje = input.next();

            condicionesEsperadas();
        } catch (FileNotFoundException e) {
            System.out.println("Error al leer los datos");
        }
    }

    private static void condicionesEsperadas() {
        // condiciones definidas
        if((Main.n >= 3 && Main.n <= 5000) && (Main.m1 >= 2 && Main.m1 <= 50) && (Main.m2 >= 2 && Main.m2 <= 50)) {
            if(Main.m1 == Main.instruccion1.length() && Main.m2 == Main.instruccion2.length() && Main.n == Main.mensaje.length()) {
                // general el mensage con la instruccion
                Main.resultado1 = validarCaracteres(Main.instruccion1, Main.mensaje);
                Main.resultado2 = validarCaracteres(Main.instruccion2, Main.mensaje);

                GuardarArchivo guardarArchivo = new GuardarArchivo();
                guardarArchivo.opcGuardarArchivo();
            }

            if(Main.m1 != Main.instruccion1.length()) {
                System.out.println("Instruccion 1 no tiene el tamaño esperado");
            }
            if(Main.m2 != Main.instruccion2.length()) {
                System.out.println("Instruccion 2 no tiene el tamaño esperado");
            }
            if(Main.n != Main.mensaje.length()) {
                System.out.println("Mensaje Encriptado no tiene el tamaño esperado");
            }

        }
        else {
            System.out.println("Formato incorrecto");
        }
    }

    private static String validarCaracteres(String instruccion, String mensaje) {
        int recorerMensaje = 0;
        int recorrrInstruccion = 0;


        while (recorerMensaje < mensaje.length() && recorrrInstruccion < instruccion.length()) {
            if(mensaje.charAt(recorerMensaje) == instruccion.charAt(recorrrInstruccion)) {
                recorrrInstruccion++;
            }
            recorerMensaje++;
        }

        if (recorrrInstruccion == instruccion.length()) {
            return "SI";
        }
        return "NO";
    }
}
