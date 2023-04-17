package com.ejercicio;

//Escribe el código que devuelva una cadena al revés.
// Por ejemplo, la cadena "hola mundo", debe retornar "odnum aloh".
public class Main {
    public static void main(String[] args) {
        System.out.println(reverse("hola mundo"));
    }

    public static String reverse(String texto){
        int length = texto.length();
        char []arrayInvertido = new char[length];
        String textoInvertido = "";

        for (int i = 0; i < length; i++) {
            arrayInvertido[i] = texto.charAt(length - i - 1);
            textoInvertido = textoInvertido.concat(Character.toString(arrayInvertido[i]));
        }

        return textoInvertido;
    }
}
