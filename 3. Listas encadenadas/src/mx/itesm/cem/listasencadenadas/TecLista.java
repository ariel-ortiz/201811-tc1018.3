package mx.itesm.cem.listasencadenadas;

public class TecLista<E> {
    
    private static class Node<E> {
        public E info;
        public Node<E> next;
        public Node(E info, Node<E> next) {
            this.info = info;
            this.next = next;
        }
        public Node(E info) {
            this(info, null);
        }
    }
    
    private Node<E> start = new Node<>(null);
    
    public void add(E info) {
        Node<E> nuevo = new Node<>(info, start.next);
        start.next = nuevo;
    }
    
    @Override
    public String toString() {
        String resultado = "";
        Node<E> nodo = start.next;
        while (nodo != null) {
            resultado += nodo.info + " ";
            nodo = nodo.next;
        }
        return "[" + resultado + "]";
    }
}
