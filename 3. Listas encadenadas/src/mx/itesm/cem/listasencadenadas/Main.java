package mx.itesm.cem.listasencadenadas;

public class Main {

    public static void main(String[] args) {
        TecLista<String> lst = new TecLista<>();
        System.out.println(lst.size());
        System.out.println(lst);
        System.out.println(lst.remove());
        lst.add("hola");
        lst.add("adios");
        lst.add("jajaja");
        System.out.println(lst);
        System.out.println(lst.size());
        lst.dup();
        System.out.println(lst);
        System.out.println(lst.size());
        System.out.println(lst.remove());
        System.out.println(lst);
        System.out.println(lst.size());
        
        TecListaEnteros lst2 = new TecListaEnteros();
        lst2.add(4);
        lst2.add(8);
        lst2.add(15);
        lst2.add(16);
        lst2.add(23);
        lst2.add(42);
        System.out.println(lst2);
        System.out.println(lst2.sum());
    }
}
