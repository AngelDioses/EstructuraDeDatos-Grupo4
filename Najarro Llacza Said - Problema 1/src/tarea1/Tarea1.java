package tarea1;

public class Tarea1 {

    public static void main(String[] args) {
        Pila pila1 = new Pila();
        
        pila1.push("Hola,");pila1.push("esto");pila1.push("es");pila1.push("una");
        pila1.push("pila");pila1.push("de");pila1.push("cadena");pila1.push("de");
        pila1.push("caracteres.");pila1.push("Por");pila1.push("eso");pila1.push("el");
        pila1.push("ultimo");pila1.push("elemento");pila1.push("se");pila1.push("ve");
        pila1.push("primero");
        
        pila1.mostrarPila();
    }
    
}
