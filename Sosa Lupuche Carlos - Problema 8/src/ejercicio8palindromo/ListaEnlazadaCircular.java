package ejercicio8palindromo;


public class ListaEnlazadaCircular {
    Nodo inicio;
    // Constructor de la clase ListaEnlazadaCircular
    public ListaEnlazadaCircular() {
     this.inicio = null;
    }
    // Método para insertar al final
    public void insertarFinal(char dato) {
        // Crear un nuevo nodo con el dato proporcionado
        Nodo nuevo = new Nodo(dato);
        // Si la lista está vacía, el nuevo nodo será el inicio y se enlazará a sí mismo
        if (inicio == null) {
            inicio = nuevo;
            inicio.siguiente = inicio;
        } else {
            // Si la lista no está vacía, recorrerla para encontrar el último nodo
            Nodo temp = inicio;
            while (temp.siguiente != inicio) {
                temp = temp.siguiente;
            }
            // Enlazar el nuevo nodo al final y hacer que apunte al inicio 
            temp.siguiente = nuevo;
            nuevo.siguiente = inicio;
        }
    }
    // Método para mostrar el elemento en el inicio de la lista
    //y mover el puntero al siguiente nodo
    public char mostrarElementoInicial() {
        char retornado = 0;
        // Si la lista está vacía, imprime un mensaje
        if (inicio == null) {
            System.out.println("Lista vacía");
        } else {
            retornado = inicio.dato;// Obtiene el dato del nodo en el inicio

            // Mueve el puntero al siguiente nodo 
            inicio = inicio.siguiente;
        }
        return retornado;// Retorna el dato del nodo en el inicio
    }
}
