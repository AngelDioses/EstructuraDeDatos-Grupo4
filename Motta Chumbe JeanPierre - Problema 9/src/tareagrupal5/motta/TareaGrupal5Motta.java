package tareagrupal5.motta;

/**
 *
 * Clase Main, punto de entrada del programa
 */
public class TareaGrupal5Motta {

    /**
     *
     * Crea una instancia de la clase Pila y llama al método funcionAckerman con
     * los argumentos 2 y 1. El resultado del método funcionAckerman se imprime
     * en la consola.
     *
     * @param args Los argumentos de línea de comandos pasados al programa.
     */
    public static void main(String[] args) {
        Pila pila = new Pila();

        System.out.println(pila.funcionAckerman(2, 2));
    }

}
