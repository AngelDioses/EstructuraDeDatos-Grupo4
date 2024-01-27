public class Pila {

    public Nodo cabeza = null;
    public int longitud = 0;

    public void push(int valor){
        Nodo nuevoNodo = new Nodo(valor);
        if(cabeza != null){
            nuevoNodo.siguiente = cabeza;
            cabeza = nuevoNodo;
        }else {
            cabeza = nuevoNodo;
        }
        longitud++;
    }
    public int peek(){ //Cima - Obtener
        if(cabeza == null){
            return 0;
        }else{
            return cabeza.valor;
        }
    }

    public int pop(){ //Desapilar
        if(cabeza != null){
            Nodo eliminar = cabeza;
            cabeza = cabeza.siguiente;
            eliminar.siguiente = null;
            return eliminar.valor;
        }
        longitud--;
        return 0;
    }

    public boolean isEmpty(){
        return cabeza == null;
    }

    public int longitud(){
        return longitud;
    }


}
