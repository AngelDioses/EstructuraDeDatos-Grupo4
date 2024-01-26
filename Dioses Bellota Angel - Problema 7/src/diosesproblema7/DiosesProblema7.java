
package diosesproblema7;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author angel
 */
/**
 * Clase Problema7DiosesBellotaAngel que implementa un programa para gestionar pilas de enteros.
 * @author angel
 */
public class DiosesProblema7 {

    /**
     * Constructor por defecto.
     */
    public DiosesProblema7() {
        // Constructor por defecto
    }

    /**
     * Método principal que sirve como punto de entrada del programa.
     * @param args Los argumentos de la línea de comandos (no se utilizan).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Crear un array de pilas para almacenar enteros
        Stack<Integer>[] pilas = new Stack[5];
        for (int i = 0; i < 5; i++) {
            pilas[i] = new Stack<>();
        }

        /**
         * Bucle principal para la interacción del usuario.
         * Solicita al usuario que ingrese un par de enteros (i, j).
         * Si i es 0, se sale del bucle.
         * Si el valor absoluto de i está en el rango permitido (1-5), realiza operaciones según el signo de i.
         * Si i es positivo, agrega j a la pila correspondiente.
         * Si i es negativo, verifica y quita j de la pila correspondiente.
         * Si el elemento no está en la pila, muestra un mensaje de error.
         * Si el valor de i está fuera del rango permitido, muestra un mensaje de error.
         */
        while (true) {
            try {
                System.out.println("Ingrese un par de enteros (i, j):");

                // Leer el primer entero proporcionado por el usuario
                int i = scanner.nextInt();

                // Verificar si se debe salir del bucle
                if (i == 0) {
                    break;
                }

                // Leer el segundo entero proporcionado por el usuario
                int j = scanner.nextInt();

                // Calcular el valor absoluto de i
                int absI = Math.abs(i);

                // Verificar si el valor absoluto de i está en el rango permitido
                if (absI >= 1 && absI <= 5) {
                    // Realizar operaciones según el signo de i
                    if (i > 0) {
                        // Si i es positivo, agregar j a la pila correspondiente
                        pilas[absI - 1].push(j);
                    } else {
                        // Si i es negativo, verificar y quitar j de la pila correspondiente
                        if (!pilas[absI - 1].isEmpty() && pilas[absI - 1].peek() == j) {
                            pilas[absI - 1].pop();
                        } else {
                            // Mostrar mensaje de error si el elemento no está en la pila
                            System.out.println("El elemento " + j + " no se encuentra en la pila P" + absI);
                        }
                    }
                } else {
                    // Mostrar mensaje de error si el valor de i está fuera del rango permitido
                    System.out.println("El valor de i debe estar entre -5 y 5, excluyendo 0.");
                }
            } catch (InputMismatchException e) {
                // Manejar la excepción (por ejemplo, mostrar un mensaje de error)
                System.out.println("Entrada no válida. Por favor, ingrese números enteros.");
                // Consumir la entrada incorrecta para evitar un bucle infinito
                scanner.next();
            }
        }

        /**
         * Mostrar el contenido de cada pila después de las operaciones.
         */
        for (int i = 0; i < 5; i++) {
            System.out.println("Contenido de la pila P" + (i + 1) + ": " + pilas[i]);
        }
    }
}