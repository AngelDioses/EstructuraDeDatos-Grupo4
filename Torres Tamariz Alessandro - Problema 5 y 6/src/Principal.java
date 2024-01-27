public class Principal {

    public static void main(String[] args) {

        PilaArray pila = new PilaArray(5); //Se inicializa la pila con un tamaño de 5

        for(int i=1; i<6; i++){ //Se añaden más elementos para expandir la pila
            pila.push(i);
        }

        for(int i=6; i<12; i++){ //Se añaden más elementos para expandir la pila
            pila.push(i);
        }

        while(!pila.isEmpty()){ //Se deberian mostrar todos los elementos
            System.out.print(pila.pop() + " ");
        }
    }

    /*
        PilaArray pila = new PilaArray(5); //Se inicializa con 5
        for(int i=1; i<6; i++){ //Se añaden mas elementos para expandir la pila
            pila.push(i);
        }
        for(int i=6; i<12; i++){
            pila.push(i);
        }
        while(!pila.isEmpty()){ //Se deberian mostrar todos los elementos
            System.out.print(pila.pop() + " ");
        }
    * */

    /*
    * ListaEnlazada lista = new ListaEnlazada();

        for(int i=1; i<6; i++){ //Insertamos 5 elementos a la lista
            lista.insertaalfinal(i);
        }

        lista.imprime(); //Imprimimos los nodos de la lista
        lista.imprimeReversa(); //Utilizamos el metodo para imprimir los nodos de la lista en orden inverso
        * */
}
