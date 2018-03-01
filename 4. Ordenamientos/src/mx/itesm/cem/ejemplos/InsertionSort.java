package mx.itesm.cem.ejemplos;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import mx.itesm.cem.pilas.Estudiante;

public class InsertionSort {

    public static <T extends Comparable<T>> List<T> sort(
            List<T> list) {
        List<T> copia = new LinkedList<>(list);
        List<T> resultado = new LinkedList<>();

        while (!copia.isEmpty()) {
            T elemento = copia.remove(0);
            int indice = 0;
            while (indice < resultado.size()
                    && elemento.compareTo(
                            resultado.get(indice)) >= 0) {
                indice++;
            }
            resultado.add(indice, elemento);
        }

        return resultado;
    }

    public static void main(String[] args) {
        List<String> ls = new ArrayList<>(
                List.of("x", "t", "a", "p", "c", "c", "a",
                        "z", "b", "x", "p"));
        System.out.println(ls);
        System.out.println(InsertionSort.sort(ls));

        List<Estudiante> le = new ArrayList<>(
                List.of(new Estudiante("123", "Juan"),
                        new Estudiante("123", "Abelardo"),
                        new Estudiante("121", "Montoya"),
                        new Estudiante("123", "Lucas")));
        System.out.println(le);
        System.out.println(sort(le));
    }
}
