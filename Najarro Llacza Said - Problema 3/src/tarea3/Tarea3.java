package tarea3;

public class Tarea3 {

    public static void main(String[] args) {
        //int[] arreglo = new int[10];
        int[] arreglo ={1,2,3,4,5,6,19,20,36,100};
        
        Pila pila1 = new Pila();
        
        for(int i=0; i<10;i++){
            pila1.push(arreglo[i]);
        }
        
        pila1.mostrarPila();
    }
    
}
