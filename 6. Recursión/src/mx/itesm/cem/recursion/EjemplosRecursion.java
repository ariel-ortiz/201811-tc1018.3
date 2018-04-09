package mx.itesm.cem.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
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

	public static <T> List<T> reverse(List<T> lst) {
		if (lst.isEmpty()) {
			return new LinkedList<T>();
		} else {
			T primero = lst.get(0);
			List<T> resto = lst.subList(1, lst.size());
			List<T> reversoResto = reverse(resto);
			reversoResto.add(primero);
			return reversoResto;
		}
	}

	public static <T> List<T> duplicate(List<T> lst) {
		if (lst.isEmpty()) {
			return new LinkedList<T>();
		} else {
			T primero = lst.get(0);
			List<T> resto = lst.subList(1, lst.size());
			List<T> duplicaResto = duplicate(resto);
			duplicaResto.add(0, primero);
			duplicaResto.add(0, primero);
			return duplicaResto;
		}
	}

	public static int dotProduct(List<Integer> a,
			List<Integer> b) {
		if (a.isEmpty()) {
			return 0;
		} else {
			return a.get(0) * b.get(0)
					+ dotProduct(a.subList(1, a.size()),
							b.subList(1, b.size()));
		}
	}

	public static void main(String[] args) {
		//
		// System.out.println(factorial(0));
		// System.out.println(factorial(4));
		// System.out.println(factorial(5));
		//
		// System.out.println();
		//
		// List<Integer> lst = Arrays.asList(3, 5, 7, 1, 8,
		// 0, 2, 6,
		// 5);
		// System.out.println(lst);
		// System.out.println(quickSort(lst));
		//
		// System.out.println();
		//
		// hanoi(3, "A", "B", "C");
		//
		// List<String> s = Arrays.asList("a", "b", "c",
		// "d",
		// "e");
		// System.out.println(s);
		// System.out.println(reverse(s));
		// System.out.println(duplicate(s));
		// hanoi(64, "A", "B", "C");
		System.out.println(
				dotProduct(Arrays.asList(1, 3, 8, 2),
						Arrays.asList(3, 0, -1, 10)));
	}
}
