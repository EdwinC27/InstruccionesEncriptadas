import com.sun.source.tree.IfTree;

public class Condiciones {
    public static void condicionesEsperadas(String[] args) {
        // condiciones definidas
        if ((Atributos.n >= 3 && Atributos.n <= 5000) && (Atributos.m1 >= 2 && Atributos.m1 <= 50) && (Atributos.m2 >= 2 && Atributos.m2 <= 50)) {
            if (hasDuplicateChar(Atributos.instruccion1) && hasDuplicateChar(Atributos.instruccion2)) {
                if (Atributos.m1 == Atributos.instruccion1.length() && Atributos.m2 == Atributos.instruccion2.length() && Atributos.n == Atributos.mensaje.length()) {
                    if(validarCaracteresEspeciales(Atributos.instruccion1) && validarCaracteresEspeciales(Atributos.instruccion2) && validarCaracteresEspeciales(Atributos.mensaje)) {
                        // general el mensage con la instruccion
                        Atributos.resultado1 = validarCaracteres(Atributos.instruccion1, Atributos.mensaje);
                        Atributos.resultado2 = validarCaracteres(Atributos.instruccion2, Atributos.mensaje);

                        if(!Atributos.resultado1.equals(Atributos.resultado2)) { // chechar si hay mas de 1 Si
                            OpcionesGuardado.opcGuardarArchivo(args);
                        }
                        else {
                            System.out.println("Hay 2 instrucciones en el mismo mensaje");
                        }
                    }

                    if(!validarCaracteresEspeciales(Atributos.instruccion1)) System.out.println("Instruccion 1 contiene caracteres especiales");
                    if(!validarCaracteresEspeciales(Atributos.instruccion2)) System.out.println("Instruccion 2 contiene caracteres especiales");
                    if(!validarCaracteresEspeciales(Atributos.mensaje)) System.out.println("Mensaje contiene caracteres especiales");
                }

                if (Atributos.m1 != Atributos.instruccion1.length()) System.out.println("Instruccion 1 no tiene el tamaño esperado");

                if (Atributos.m2 != Atributos.instruccion2.length()) System.out.println("Instruccion 2 no tiene el tamaño esperado");

                if (Atributos.n != Atributos.mensaje.length()) System.out.println("Mensaje Encriptado no tiene el tamaño esperado");

            } else System.out.println("Instrucciones con caracteres repetidos");

        } else System.out.println("Formato incorrecto en el archivo, por favor verificar archivo");

    }

    private static boolean hasDuplicateChar(String input) {
        for (int interacionInput = 0; interacionInput < input.length()-1; interacionInput++) {
            if (input.charAt(interacionInput) == input.charAt(interacionInput + 1)) return false;
        }
        return true;
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

    private static boolean validarCaracteresEspeciales(String mensaje) {
        String regex = "[^a-zA-Z0-9]";
        String validMessage = mensaje.replaceAll(regex, "");

        if (mensaje.equals(validMessage)) {
            return true;
        } else {
            return false;
        }
    }
}
