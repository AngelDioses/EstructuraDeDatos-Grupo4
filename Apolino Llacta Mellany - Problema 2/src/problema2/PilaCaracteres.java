package problema2;
public class PilaCaracteres{
    private char[] elementos; //array para almacenar los elementos de la pila
    private int tope;

    public PilaCaracteres(int capacidad){ //constructor
        elementos = new char[capacidad];//inicializa el array con la capacidad dada
        tope=-1; //establece el tope en -1 (pila vacía)
    }

    public void push(char elemento){ //agrega un nuevo elemento a la pila
        if(isEmpty()){ //verifica si la pila está vacía
            tope=0;  //inicializa tope en 0
        }
        elementos[++tope]=elemento; //agrega elemento e incrementa el tope
    }

    public char pop(){//extrae y devuelve el elemento en la parte superior de la pila
        if(isEmpty()){//verifica si la pila está vacía
            throw new IllegalStateException("La pila está vacía");
        }
        //decrementa tope y devuelve el elemento en la posición actual de tope
        return elementos[tope--]; 
    }

    public char peek(){//obtiene el elemento en la parte superior de la pila sin extraerlo
        if(isEmpty()){//verifica si la pila está vacía
            throw new IllegalStateException("La pila está vacía");
        }
        return elementos[tope]; //devuelve el elemento en la posición actual de tope
    }

    public boolean isEmpty(){ //verifica si la pila está vacía
        return tope==-1;  //devuelve true si tope es -1 (la pila está vacía)
    }
}
