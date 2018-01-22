package mx.itesm.cem.arreglos;

public class Main {
    
    public static int suma(TecArrayList<Integer> lista) {
        int resultado = 0;
        for (int i = 0; i < lista.size(); i++) {
            resultado += lista.get(i);
        }
        return resultado;
    }

    public static void main(String[] args) {
        TecArrayList<Integer> a = new TecArrayList<>(1, 2, 3, 4, 5,
                6, 7, 8, 9, 10, 11);
        int s = suma(a);
        System.out.println(s);
    }
}
