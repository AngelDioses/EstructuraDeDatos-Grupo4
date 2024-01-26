package ejercicio8palindromo;

//Creacion de la clase Pila 
public class Pila {
    Nodo tope;// Representa el nodo en la cima de la pila
    int longitud=0;// Almacena la longitud de la pila
    
    public Pila() { // Constructor de la clase Pila
     this.tope = null;
    }
    // Método para inserción de datos
    public void push(char dato) {
        // Crear un nuevo nodo con el dato proporcionado
        Nodo nuevoNodo = new Nodo(dato);
        // Establecer el siguiente del nuevo nodo al nodo actual en la cima (tope)
        nuevoNodo.siguiente = tope;
        // Actualizar la cima (tope) para que ahora sea el nuevo nodo
        tope = nuevoNodo;
        // Incrementar la longitud de la pila
        longitud++;
    }
    // Método que retorna el elemento que esta en el tope de la pila. 
    public char pop() {
        //Si la pila esta vacia ocurre una excepcion
        if (isEmpty()) {
            throw new IllegalStateException("La pila está vacía");
        }
        //Se guarda el dato del nodo de la cima de la pila
        char datoExtraido = tope.dato;
        // Actualizar la cima de la pila para apuntar al siguiente nodo
        tope = tope.siguiente;
        // Devolver el dato extraído
        return datoExtraido;
    }
    // Método para verificar si la pila está vacía
    public boolean isEmpty() {
        return tope == null;
    }
    // Método que retorna la longitud de la pila
    public int Longitud(){
        return longitud;
    }
}