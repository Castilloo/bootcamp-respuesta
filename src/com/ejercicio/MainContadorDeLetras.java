package com.ejercicio;

import java.io.*;
import java.util.*;

public class MainContadorDeLetras {
    public static void main(String[] args) {
        /*
        * --------------------PUNTO 9----------------------
        * Esta aplicación cuenta el número de caracteres que tiene un archivo txt y genera un reporte del
        * total de caracteres y el conteo de cada letra encontrada, además si no existe el archivo se puede crear
        *
        * */
        Scanner sc = new Scanner(System.in);
        System.out.println("Escriba un nombre para el archivo txt: ");
        String fileName = sc.nextLine().trim() + ".txt";

        //Creamos el archivo en caso que no exista
        File fileCreated = checkAndCreateFile(fileName);

        //Texto leido guardado en un array de strings
        String textReaded = readText(fileCreated);
        String[] letras = textReaded.split("");

        //Capturamos cada string de letras sin espacios y saltos de linea en una lista y en un set
        ArrayList<String> list = new ArrayList<>();
        Set<String> set = new HashSet<>();
        convertToListOrSet(list, letras);
        convertToListOrSet(set, letras);

        /*
            Incluimos el set y la lista en el hashmap
            para mostrar la letra como clave y en el valor cuantas veces se repite ésta en el archivo
            Además formateamos el resultado como json
         */
        String newTextReaded = generateJsonWithHashMap(list, set);

        //Creamos el archivo
        createReportFile(fileName, newTextReaded);

    }

    static File checkAndCreateFile(String fileName) {
        //Creación del objeto file
        File file = new File(fileName);
        if(!file.exists()) { //revisar si el archivo existe, si no será creado
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("Error al crear fichero  -> "  + e.getMessage());
            }
        } else {
            System.out.println("-----------------------");
            System.out.println("EL ARCHIVO EXISTE!!");
            System.out.println("-----------------------");
        }

        return file;
    }

    static String readText(File fileName){
        String textInFile = "";
        //Leer archivo
        try {
            InputStream readedFile = new FileInputStream(fileName);
            BufferedInputStream bufferFile = new BufferedInputStream(readedFile);

            try {
                int data = bufferFile.read();
                while (data != -1) {
                    textInFile += (char) data;
                    data = bufferFile.read();
                }
                bufferFile.close();
            } catch (IOException e) {
                System.out.println("No se pudo leer archivo -> " + e.getMessage());
            }

        } catch (FileNotFoundException e) {
            System.out.println("Error en encontrar archivo -> " + e.getMessage());
        }
        return textInFile;
    }

    static <T extends Collection> T convertToListOrSet(T listOrSet, String[] arrayText){
        for (String at: arrayText) {
            listOrSet.add(at);
            if(at.equals(" ") || at.equals("\n") || at.equals("")) {
                listOrSet.remove(at);
            }
        }
        return listOrSet;
    }

    static String generateJsonWithHashMap(ArrayList<String> arraylist, Set<String> set){
        HashMap<String, Integer> result = new HashMap<>();
        for (String s: set) {
            Integer count = (int)arraylist.stream()
                    .filter(l -> l.equals(s))
                    .count();
            result.put(s, count);
        };
        String resultJsonFormat = "";
        for (Map.Entry<String, Integer> r: result.entrySet()) {
            String key = r.getKey();
            int value = r.getValue();
            resultJsonFormat += " " + key + " : " + value + "\n";
        }

        //Pegamos el resultado de las letras encontradas en el string newText
        String newText = "\n********************\n" +
                "Total de letras: " + arraylist.size() +
                ",\nLetras: {\n" + resultJsonFormat + "}" +
                "\n********************\n";
        return  newText;
    }

    static void createReportFile(String fileName, String newTextReaded){
        try {
            fileName = "Reporte_" + fileName;
            PrintStream outFile = new PrintStream(fileName);
            byte[] textReadedInBytes = newTextReaded.getBytes();
            outFile.write(textReadedInBytes);
            outFile.close();
            System.out.println("SE HA CREADO EL ARCHIVO: " + fileName);
        } catch(IOException e){
            System.out.println("Error al crear archivo de texto -> " + e.getMessage());
        }
    }
}
