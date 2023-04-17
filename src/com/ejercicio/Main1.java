package com.ejercicio;

import java.io.*;
import java.util.*;

public class Main1 {
    public static void main(String[] args) {

        System.out.println("---------------PUNTO 1-------------------");
        //Crea un array unidimensional de Strings y recórrelo, mostrando únicamente sus valores.
        String clubes[] = {"Barcelona", "Real Madrid", "Liverpool", "Milan", "Arsenal", "Porto", "Bayern"};

        for (String club: clubes) {
            System.out.println(club);
        }

        System.out.println("");
        System.out.println("---------------PUNTO 2-------------------");
        //Crea un array bidimensional de enteros y recórrelo,
        // mostrando la posición y el valor de cada elemento en ambas dimensiones.
        int numbers[][] = { {2, 4}, {10, 8}, {5, 7}, {22, 87}, {24, 40} };

        for (int i = 0; i < numbers.length; i++){
            for (int j = 0; j < numbers[i].length; j++){
                System.out.println("Posición: " + "[" + i + ", " + j + "], Valor:" + numbers[i][j]);
            }
        }

        System.out.println("");
        System.out.println("---------------PUNTO 3-------------------");
        //Crea un "Vector" del tipo de dato que prefieras, y añádele 5 elementos.
        // Elimina el 2o y 3er elemento y muestra el resultado final.
        Vector<String> vectorNombres = new Vector<>(10, 10);
        vectorNombres.add("Juan");
        vectorNombres.add("Pedro");
        vectorNombres.add("Karen");
        vectorNombres.add("Jessica");
        vectorNombres.add("María");

        //Elimino segundo y tercer elemento
        vectorNombres.remove(1); //elimino Pedro - nombre 2
        vectorNombres.remove("Karen"); //Elimino Karen - nombre 3

        for (String nombre: vectorNombres) {
            System.out.println(nombre);
        }

        System.out.println("");
        System.out.println("---------------PUNTO 4-------------------");
        //Indica cuál es el problema de utilizar un Vector con la capacidad por defecto
        // si tuviésemos 1000 elementos para ser añadidos al mismo.
        System.out.println("Si usamos un vector de capacidad por defecto y le añadimos 1000 elementos de golpe " +
                "habría un uso de memoria excesivo en el ordenador, debido al procesamiento constante de creación de " +
                "un nuevo array, copiar y reasignamiento de valores en el nuevo array creado. Esto sucede desde una capacidad " +
                "inicial de un array de diez elementos hasta 1000 elementos.\n");

        System.out.println("---------------PUNTO 5-------------------");
        //Crea un ArrayList de tipo String, con 4 elementos. Cópialo en una LinkedList.
        // Recorre ambos mostrando únicamente el valor de cada elemento.
        List<String> languages = new ArrayList<>();
        languages.add("Spanish");
        languages.add("English");
        languages.add("French");
        languages.add("Portuguese");

        LinkedList<String> copyLang = new LinkedList<>();
        for (String language: languages) {
            copyLang.add(language);
        }

        for (int i = 0; i < 4; i++) {
            System.out.println("Índice " + i + ": ArrayList: " + languages.get(i) + ", " + "LinkedList: " + copyLang.get(i));
        }

        System.out.println("\n---------------PUNTO 6-------------------");
        //Crea un ArrayList de tipo int, y, utilizando un bucle rellénalo con elementos 1..10.
        // A continuación, con otro bucle, recórrelo y elimina los numeros pares.
        // Por último, vuelve a recorrerlo y muestra el ArrayList final.
        // Si te atreves, puedes hacerlo en menos pasos, siempre y cuando cumplas el primer "for" de relleno.

        List<Integer> numeros = new ArrayList<>();
        for (int i = 0; i <= 10; i++) numeros.add(i);

        int i = 0;
        while(i < numeros.size()){
            if(numeros.get(i) % 2 == 0) numeros.remove(i);
            else i++;
        }

        for (int valor : numeros) System.out.println(valor);

        System.out.println("\n---------------PUNTO 7-------------------");
        Scanner scan = new Scanner(System.in);
        float resultado;
        System.out.println("Ingrese un número entero");
        //float a = scan.nextInt();
        System.out.println("Ingrese otro número entero");
        //float b = scan.nextInt();

        /*if(b == 0){
            DividePorCero();
        } else {
            resultado = a / b;
            System.out.println(resultado);
        }*/

        System.out.println("\n---------------PUNTO 8-------------------");
        //Utilizando InputStream y PrintStream, crea una función que reciba dos parámetros: "fileIn" y "fileOut".
        // La tarea de la función será realizar la copia del fichero dado en el parámetro "fileIn" al fichero dado en "fileOut".
        String ficheroIn = "/etc/passwd";
        String ficheroOut = "copiaPaswd.txt";
        IOFunction(ficheroIn, ficheroOut);
    }

    //***************FUNCIONES*****************
    //---------------PUNTO 7-------------------
    public static void DividePorCero() throws ArithmeticException{
            System.out.println("Esto no puede hacerse");
            throw new ArithmeticException();
    }

    //---------------PUNTO 8-------------------
    public static void IOFunction(String fileIn, String fileOut){
        try {

            InputStream in = new FileInputStream(fileIn);
            byte datos [] = in.readAllBytes();
            in.close();

            PrintStream out = new PrintStream(fileOut);
            out.write(datos);
            out.close();

            System.out.println("Archivo " + fileOut + " creado!");
        } catch (IOException e){
            System.out.println("Error en proceso: " + e.getMessage());
        }
    }

}
