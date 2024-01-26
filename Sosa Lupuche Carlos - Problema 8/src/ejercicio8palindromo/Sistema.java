package ejercicio8palindromo;
import java.util.Scanner;
public class Sistema {
    Scanner entrada=new Scanner(System.in);
    Pila pila=new Pila();// Instancia de la clase Pila
    String palabra;// Variable para almacenar la frase
    char[] caracteres;// Arreglo para almacenar cada carácter de la frase
    int contador=0;// Contador para comparar caracteres en la verificación
    // Instancia de la clase ListaEnlazadaCircular
    ListaEnlazadaCircular ListaEnlazadaCircular=new ListaEnlazadaCircular();
    
    // Método para ingresar la frase en la pila y en la lista circular

    public void Ingreso(){
        System.out.println("Digite la frase que desea saber si es palindroma:");
        StringBuilder builder=new StringBuilder();
        while(true){
            String linea =entrada.nextLine();
            if(linea.isEmpty()){
                break;
            }
            builder.append(linea).append("\n");
        }
        palabra=builder.toString().trim();
        caracteres=palabra.toCharArray();
        //Colocando en la pila y en la lista circular por el final
        
        for(int i=0;i<caracteres.length;i++){
            if (caracteres[i] != ' ' ) {
                if(caracteres[i] != '\n'){
                    // Coloca el carácter en la pila
                    pila.push(caracteres[i]); 
                    // Coloca el carácter en la lista circular
                    ListaEnlazadaCircular.insertarFinal(caracteres[i]);
                }
            } 
            
        }
    }

    // Método para verificar si la frase es palíndroma
    public void verificarPalindromo(){
        //Sacando de la pila y en la lista circular por el inicio y comparando
        for(int i=0;i<pila.Longitud();i++){
            if(pila.pop()==ListaEnlazadaCircular.mostrarElementoInicial()){
                //Aumenta el contador cada vez que se que cumple la igualdad
                contador++;
            }
        }    
        // Verificar el resultado de la comparación
        if(contador==pila.Longitud()){
            System.out.println("La frase es palindroma");
        }
        else{
            System.out.println("La frase no es palindroma");

        }
    }  
}
