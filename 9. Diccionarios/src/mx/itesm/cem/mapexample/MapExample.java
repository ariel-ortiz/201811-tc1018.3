package mx.itesm.cem.mapexample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MapExample {

    public static void main(String[] args) {
        Map<String, String> dic = new LinkedHashMap<>();
        dic.put("pollito", "chicken");
        dic.put("gallina", "hen");
        dic.put("lápiz", "pencil");
        dic.put("pluma", "pen");
        dic.put("ventana", "window");
        dic.put("techo", "ceiling");
        dic.put("piso", "floor");
        for (String key : dic.keySet()) {
            System.out.println(key + ": " + dic.get(key));
        }

        String cadena = "esta es una prueba";
        Map<Character, Integer> frecuencias = new LinkedHashMap<>();
        for (char c : cadena.toCharArray()) {
            if (frecuencias.containsKey(c)) {
                frecuencias.put(c, frecuencias.get(c) + 1);
            } else {
                frecuencias.put(c, 1);
            }
        }
        System.out.println(frecuencias);

        Map<String, List<String>> otro = new HashMap<>();
        otro.put("A", Arrays.asList("B"));
        otro.put("B", Arrays.asList("A", "C"));
        otro.put("C", Arrays.asList("A", "D"));
        otro.put("D", Arrays.asList());
        System.out.println(otro);

        List<String> lst = new ArrayList<>(Arrays.asList(
                "tontin", "gruñón", "dormilón", "doc",
                "estornudón", "feliz", "tímido"));
        // lst.sort((a, b) -> a.compareTo(b));
        //lst.sort((a, b) -> -a.compareTo(b));
        lst.sort((a, b) -> Integer.compare(a.length(), b.length()));
        System.out.println(lst);
    }

}
