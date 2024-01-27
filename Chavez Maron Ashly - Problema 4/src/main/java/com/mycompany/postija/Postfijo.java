package com.mycompany.postija;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Postfijo {

    public static String convertirPostfijo(String expresion) {
        StringBuilder salida = new StringBuilder();
        Stack<Character> pila = new Stack<>();

        // Definir la precedencia de los operadores
        Map<Character, Integer> precedencia = new HashMap<>();
        precedencia.put('+', 1);
        precedencia.put('-', 1);
        precedencia.put('*', 2);
        precedencia.put('/', 2);
        precedencia.put('^', 3);

        // Convertir la expresión en un array de caracteres
        char[] caracteres = expresion.toCharArray();

        // Iterar sobre cada caracter en la expresión 
        for (int i = 0; i < caracteres.length; i++) {
            char caracter = caracteres[i];

            // Si es un dígito o una variable, agregarlo directamente a la salida
            if (Character.isLetterOrDigit(caracter)) {
                salida.append(caracter);
            } // Si es parentesis de apertura
            else if (caracter == '(') {
                pila.push(caracter);
            } else if (caracter == ')') {//Si es parentesis de cierre
                // Retira el contenido de la pila y añade a la salida hasta encontrar el paréntesis de apertura
                while (!pila.isEmpty() && pila.peek() != '(') {
                    salida.append(pila.pop());
                }
                pila.pop(); // Eliminar el paréntesis de apertura de la pila
            } else {
                //Cuando es un operador
                while (!pila.isEmpty() && precedencia.getOrDefault(pila.peek(), 0) >= precedencia.get(caracter)) {
                    salida.append(pila.pop());
                }
                pila.push(caracter);
            }
        }

        // Sacar los operadores restantes de la pila y añadirlos a la salida
        while (!pila.isEmpty()) {
            salida.append(pila.pop());
        }

        // Retornar la expresión posfija 
        return salida.toString();
    }

    public static double evaluarPostfijo(String expresion, Map<Character, Double> valores) {
        Stack<Double> pila = new Stack<>();

        // Convertir la expresión posfija en un array de caracteres
        char[] caracteres = expresion.toCharArray();

        // Iterar sobre cada caracter de la expresión posfija
        for (int i = 0; i < caracteres.length; i++) {
            char caracter = caracteres[i];

            // Si es un dígito, agregarlo a la pila como un valor
            if (Character.isDigit(caracter)) {
                pila.push((double) Character.getNumericValue(caracter));
            } else if (Character.isLetter(caracter)) {
                // Si es una variable, obtener su valor del mapa y agregarlo a la pila
                if (valores.containsKey(caracter)) {
                    pila.push(valores.get(caracter));
                }
            } else {
                // Si es un operador, realizar la operación con los valores en la pila
                double num2 = pila.pop();
                double num1 = pila.pop();
                double resultado = realizarOp(num1, num2, caracter);
                pila.push(resultado);
            }
        }

        // El resultado estará en la cima de la pila
        return pila.pop();
    }

    private static double realizarOp(double num1, double num2, char op) {
        switch (op) {
            case '+' -> {
                return num1 + num2;
            }
            case '-' -> {
                return num1 - num2;
            }
            case '*' -> {
                return num1 * num2;
            }
            case '/' -> {
                return num1 / num2;
            }
            case '^' -> {
                return Math.pow(num1, num2);
            }
            default -> {
                System.out.println("Operador no válido: " + op);
                return 0;
            }
        }
    }

    public static void main(String[] args) {
        String expresion = "x*y-(z+w)/(z+y)^x";
        System.out.println("Expresión: " + expresion);
        String expresionPos = convertirPostfijo(expresion);
        System.out.println("Expresión Posfija: " + expresionPos);
        Map<Character, Double> valores = new HashMap<>();
        valores.put('x', 2.0);
        valores.put('y', 3.0);
        valores.put('z', 4.0);
        valores.put('w', 1.0);
        double resultado = evaluarPostfijo(expresionPos, valores);
        System.out.println("Resultado de la expresión posfija: " + resultado);
    }
}
