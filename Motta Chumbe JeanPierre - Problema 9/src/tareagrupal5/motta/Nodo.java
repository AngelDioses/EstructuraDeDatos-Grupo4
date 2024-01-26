
package tareagrupal5.motta;

/**
 * Clase Nodo que representa un nodo en la pila.
 */
public class Nodo {
    Nodo siguiente;
    int m, n; 

    /**
     * Constructor de la clase Nodo.
     *
     * @param m el primer parámetro de la función de Ackermann
     * @param n el segundo parámetro de la función de Ackermann
     */

    public Nodo(int m, int n) {
        this.m = m;
        this.n = n;
        this.siguiente = null;
    }

}

