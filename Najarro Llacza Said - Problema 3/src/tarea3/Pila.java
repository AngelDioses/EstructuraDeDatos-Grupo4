package tarea3;

public class Pila {

    public static class Nodo {

        int dato;
        Nodo siguiente;

        public Nodo(int dato) {
            this.dato = dato;
            siguiente = null;
        }

        public Nodo() {
            siguiente = null;
        }
    }

    Nodo tope;

    public Pila() {
        this.tope = null;
    }

    public void push(int dato) {
        Nodo nuevoNodo = new Nodo(dato);
        if (isEmpty()) {
            tope = nuevoNodo;
        } else {
            nuevoNodo.siguiente = tope;
            tope = nuevoNodo;
        }
    }

    public boolean isEmpty() {
        return tope == null;
    }

    public void mostrarPila() {
        if (isEmpty()) {
            System.out.println("No hay elementos");
        } else {
            Nodo nodi = new Nodo();
            nodi = tope;
            while (nodi != null) {
                System.out.println(nodi.dato);
                nodi = nodi.siguiente;
            }
        }
    }

}
