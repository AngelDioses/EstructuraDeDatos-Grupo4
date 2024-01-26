package problema2;
public class ConversorExpresiones{
    private PilaCaracteres pilaOperadores; //instancia
    private String postfija; //para almacenar la expresión postfija

    public ConversorExpresiones(){ //constructor
        //inicializa la pila con capacidad de 100
        this.pilaOperadores=new PilaCaracteres(100);
        this.postfija = "";//inicializa la cadena como una cadena vacía
    }

    //método para verificar si un caracter es un operador
    private boolean verificarOperador(char c){
        return switch (c){
            case '+', '-', '*', '/', '^' -> true;
            default -> false;
        };
    }

    //método para obtener la precedencia de un operador
    private int precedencia(char operador){
        return switch (operador){
            case '^' -> 3;
            case '*', '/' -> 2;
            case '+', '-' -> 1;
            default -> 0;
        };
    }

    //método para convertir una expresión infija a postfija
    public String infijaAPostfija(String infija){
        for (int i=0; i<infija.length(); i++){ //recorre la infija
            char caracter=infija.charAt(i); //obtiene caracter actual
            if((caracter>='a'&&caracter<='z')||(caracter>='0'&&caracter<='9')){
                postfija+=caracter; //agrega operandos a la expresión postfija
            } else if(caracter=='('){ //si es un paréntesis abierto
                pilaOperadores.push(caracter); //lo añade a la pila
            } else if(caracter==')'){ //si es un paréntesis cerrado
            //desapila operadores hasta encontrar el paréntesis abierto que le corresponde
                while(!pilaOperadores.isEmpty()&&pilaOperadores.peek()!='('){
                    //agrega operadores desapilados a la postfija
                    postfija+=pilaOperadores.pop();
                }
                pilaOperadores.pop(); //elimina el paréntesis abierto
            } else if(verificarOperador(caracter)){//si es un operador,
                //desapila operadores con mayor o igual precedencia
                //luego añade el operador actual a la pila
                while(!pilaOperadores.isEmpty()&& 
                    precedencia(pilaOperadores.peek())>=precedencia(caracter)){
                    //añade operadores desapilados a la postfija
                    postfija+=pilaOperadores.pop();
                }
                pilaOperadores.push(caracter);//añade el operador actual a la pila
            }
        }
        //desapila cualquier operador restante y los añade a la postfija
        while (!pilaOperadores.isEmpty()){ //si no está vacío,
            postfija+=pilaOperadores.pop();//agrega el desapilado a la postfija
        }

        return postfija; //devuelve la expresión postfija resultante
    }
}
