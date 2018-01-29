package mx.itesm.cem.listasencadenadas;

public class TecListaEnteros extends TecLista<Integer> {
    
    public int sum() {
        Node<Integer> p = start.next;
        int suma = 0;
        while (p != null) {
            suma += p.info;
            p = p.next;
        }
        return suma;
    }
}
