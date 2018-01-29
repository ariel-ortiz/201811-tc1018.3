package mx.itesm.cem.listasencadenadas;

public class Main {

    public static void main(String[] args) {
        TecLista<String> lst = new TecLista<>();
        System.out.println(lst.size());
        System.out.println(lst);
        lst.add("hola");
        lst.add("adios");
        lst.add("jajaja");
        System.out.println(lst);
        System.out.println(lst.size());
    }

}
