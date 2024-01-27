public class ListaEnlazada {
    Nodo cabeza; //Se accdede por el primer nodo
    int longitud = 0;
    public void insertaalinicio(int nuevodato){
        Nodo nuevonodo=new Nodo(nuevodato);
        nuevonodo.siguiente=cabeza;
        cabeza=nuevonodo;
        longitud++;
    }
    public void insertaalfinal(int nuevodato){
        Nodo nuevonodo=new Nodo(nuevodato);
        if(cabeza==null){
            cabeza=nuevonodo;
            longitud++;
            return ;
        }
        Nodo ultimo=cabeza;
        while (ultimo.siguiente!=null){
            ultimo=ultimo.siguiente;
        }
        ultimo.siguiente=nuevonodo;
        longitud++;
    }

    public boolean listaVacia(){
        return cabeza == null;
    }

    public boolean posicionErrada(int n){
        return !(n > 0 && n - 1 < longitud);
    }
    public void eliminarInicio(){
        if(!listaVacia()){
            Nodo eliminar = cabeza;
            cabeza = cabeza.siguiente;
            eliminar.siguiente = null;
            longitud--;
        }else{
            System.out.println("Lista vacia");
        }
    }

    public void eliminarFinal(){
        if(!listaVacia()){
            if(cabeza.siguiente == null){
                cabeza = null;
            }else{
                Nodo puntero = cabeza;
                while(puntero.siguiente.siguiente != null){
                    puntero = puntero.siguiente;
                }
                puntero.siguiente = null;

            }
            longitud--;
        }else{
            System.out.println("Lista vacia");
        }
    }
    public void imprime(){
        Nodo n=cabeza;
        while(n!=null){
            System.out.print(n.valor+" ");
            n=n.siguiente;
        }
        System.out.println();
    }

    public void imprimeReversa(){
        //Usaremos la pila como estructura auxiliar
        Pila pila = new Pila();

        //Pasamos los elementos de la lista a la pila
        Nodo temp = cabeza;
        while (temp != null){
            pila.push(temp.valor);
            temp = temp.siguiente;
        }
        /*Ahora mostraremos los elementos de la pila
        * Los elementos se mostraran en orden inverso
        * Esto debido a la caracteristica de la estructura pila*/
        while (!pila.isEmpty()){
            System.out.print(pila.pop() + " ");
        }
    }
}
