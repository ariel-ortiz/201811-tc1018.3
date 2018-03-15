package mx.itesm.cem.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EjemplosRecursion {

    public static int factorial(int n) {
        if (n <= 0) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    public static <T extends Comparable<T>> List<T> quickSort(
            List<T> list) {
        if (list.isEmpty()) {
            return list;
        } else {
            List<T> menores = new ArrayList<>();
            List<T> mayoresOIguales = new ArrayList<>();
            T pivote = list.get(0);
            for (int i = 1; i < list.size(); i++) {
                T elemento = list.get(i);
                if (elemento.compareTo(pivote) < 0) {
                    menores.add(elemento);
                } else {
                    mayoresOIguales.add(elemento);
                }
            }
            menores = quickSort(menores);
            mayoresOIguales = quickSort(mayoresOIguales);
            menores.add(pivote);
            menores.addAll(mayoresOIguales);
            return menores;
        }
    }

    public static void hanoi(int n, String origen,
            String temp, String destino) {
        if (n == 1) {
            System.out.println("Mover disco " + n + " de "
                    + origen + " a " + destino);
        } else {
            hanoi(n - 1, origen, destino, temp);
            System.out.println("Mover disco " + n + " de "
                    + origen + " a " + destino);
            hanoi(n - 1, temp, origen, destino);
        }
    }

    public static void main(String[] args) {
        System.out.println(factorial(0));
        System.out.println(factorial(4));
        System.out.println(factorial(5));

        System.out.println();

        List<Integer> lst = Arrays.asList(3, 5, 7, 1, 8, 0,
                2, 6, 5);
        System.out.println(lst);
        System.out.println(quickSort(lst));
        
        System.out.println();
        
        hanoi(3, "A", "B", "C");
    }
}
