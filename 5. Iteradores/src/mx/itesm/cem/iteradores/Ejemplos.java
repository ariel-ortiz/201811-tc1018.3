package mx.itesm.cem.iteradores;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Ejemplos {

    public static void main(String[] args) {
        // Crear una colección (inmutable)
        List<String> lst = Arrays.asList("manzana", "pera",
                "guayaba", "piña", "melón", "sandía",
                "naranja", "mango");

        // 1. Visitar todos los elementos de lst
        // usando un iterador explícito.
        Iterator<String> iterador = lst.iterator();
        while (iterador.hasNext()) {
            String elemento = iterador.next();
            System.out.println(elemento);
        }
        
        System.out.println();
        
        // 2. Visitar todos los elementos de lst
        // usando un for "mejorado".
        for (String elemento: lst) {
            System.out.println(elemento);
        }
    }
}
