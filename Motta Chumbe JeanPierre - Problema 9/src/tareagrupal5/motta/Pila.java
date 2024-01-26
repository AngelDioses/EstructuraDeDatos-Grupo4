package tareagrupal5.motta;

/**
 * Clase Pila que representa una pila de nodos.
 */
public class Pila {

    Nodo tope;

    /**
     * Constructor de la clase Pila.
     */
    Pila() {
        this.tope = null;
    }

    /**
     * Método para insertar un nodo en la pila.
     *
     * @param m el primer parámetro de la función de Ackermann
     * @param n el segundo parámetro de la función de Ackermann
     */
    public void push(int m, int n) {
        Nodo nuevo = new Nodo(m, n);

        if (listaVacia()) {
            tope = nuevo;
            return;
        }
        nuevo.siguiente = tope;
        tope = nuevo;

    }

    /**
     * Método para eliminar el nodo en la cima de la pila.
     */
    public void pop() {
        if (listaVacia()) {
            throw new IllegalArgumentException("Lista vacia");

        }

        tope = tope.siguiente;

    }

    /**
     * Verifica si la pila esta vacia
     */
    public boolean listaVacia() {
        return tope == null;
    }

    /**
     * Calcula el valor de la función de Ackermann para los parámetros dados. La
     * función de Ackermann es una función matemática recursiva que se utiliza
     * para probar las propiedades computacionales de un sistema informático.
     *
     * @param m el primer parámetro de la función de Ackermann
     * @param n el segundo parámetro de la función de Ackermann
     * @return el resultado de la función de Ackermann para los parámetros dados
     * @throws IllegalArgumentException si m o n son negativos
     */
    public int funcionAckerman(int m, int n) {

        if (m < 0 || n < 0) {
            throw new IllegalArgumentException("Los valores son incorrectos");
        }
        push(m, n); // Guardamos en la pila el nodo con el contenido especificado de m y n para
        // poder iniciar la iteracion
        while (tope != null) {
            /**
             * Dentro del bucle creamos un nodo temporal con los datos del tope y
             * almacenamos los datos antes de borrarlo
             * Esto es para eliminar los nodos una vez lo hayamos utilizado para crear un
             * "stop" en el bucle una vez este vacia la pila
             * ,pero guardando la informacion antes.
             */
            Nodo temporal = tope;
            m = temporal.m;
            n = temporal.n;
            pop();

            // Casos base
            if (m == 0) { // 1era condicion de funcion Ackerman
                n = n + 1;
            }
            if (n == 0) { // Si se cumple que n sea 0, insertamos un nodo con los datos especificados

                push(m - 1, 1);

            }
            /**
             * Esta parte es importante , ya que ademas de insertar dos nodos, debemos
             * establecer un 'flag' para avisar que el nodo en el que nos encontramos
             * sea el de la doble recursion . Esto para simular que ya hemos pasado por los
             * nodos y encontramos el dato que queremos para la recursion dentro de
             * la otra recursion.
             */
            if (m > 0 && n > 0) {
                push(m - 1, -1); // insertamos el nodo con doble recursion, pero con el 'flag' o aviso del "-1"
                push(m, n - 1); // insertamos el nodo en el que se esta realizando la recursion dentro del nodo
                // anterior
                continue; // volvemos al inicio del bucle

            }
            /*
             * Esta condición se encarga de manejar el caso de la doble recursión en la
             * función de Ackermann.
             * Cuando se llega a un nodo con un 'flag' de -1 (indicando una doble
             * recursión), actualizamos el valor de 'n' en el nodo
             * con el valor actual de 'n' y almacenamos los valores de 'm' y 'n' del nodo en
             * las variables locales 'm' y 'n'.
             * Esto nos permite mantener un seguimiento de los valores de 'm' y 'n' a medida
             * que procesamos la pila y
             * finalmente asignar la solución cuando se eliminan todos los nodos.
             */
            if (tope != null && tope.n == -1) { // Si se llega a la doble recursión
                tope.n = n; // Actualizamos el valor de 'n' en el nodo con el valor actual de 'n'
                m = tope.m; // Almacenamos los valores de 'm' y 'n' del nodo en las variables locales 'm' y
                            // 'n'
                n = tope.n;
            }

        }
        return n; // Si no hay elementos en la pila, entonces se retorna el resultado

    }

}
