/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package problema2;
public class Main{
    public static void main(String[] args){
        ConversorExpresiones conversor=new ConversorExpresiones();
        String infija="(x-y)/(z+w)-(z+y)^x";
        String postfija=conversor.infijaAPostfija(infija);
        System.out.println("Expresión infija: " + infija);
        System.out.println("Expresión postfija: " + postfija);
    }
}
