public class PilaArray {

    public int capacidad;
    public int[] arreglo;
    public int cima;

    public PilaArray(int capacidad) {
        this.capacidad = capacidad;
        this.arreglo = new int[capacidad];
        this.cima = -1;
    }

    public boolean isEmpty(){
        return cima == -1;
    }
    public void push(int valor){
        pilaLLena(); //Método que comprueba si la pila está llena
        cima++;
        arreglo[cima] = valor;
    }
    public int pop(){
        if(!isEmpty()){
            int eliminar = arreglo[cima];
            cima--;
            return eliminar;
        }else{
            System.out.println("Pila vacia");
            return -1;
        }
    }

    public int peek(){
        if(!isEmpty()){
            return arreglo[cima];
        }else{
            System.out.println("Pila vacia");
            return -1;
        }
    }

    public void pilaLLena(){
        if(cima == capacidad-1){
            /*Duplicamos la capacidad para el nuevo arreglo de nuestra pila
             * Se crea un nuevo arreglo con la nueva capacidad para la pila*/
            int nuevaCapacidad = 2 * this.capacidad;
            int[] nuevoArreglo = new int[nuevaCapacidad];

            //Copiamos los elementos a nuestro nuevo arreglo
            for (int i = 0; i < capacidad; i++){
                nuevoArreglo[i] = arreglo[i];
            }

            //Actualizamos la capacidad y el arreglo en nuestra pila
            this.capacidad = nuevaCapacidad;
            this.arreglo = nuevoArreglo;
        }
    }
}
