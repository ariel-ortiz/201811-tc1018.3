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
    
    // Complejidad O(N)
    public int size() {
        int contador = 0;
        Node<E> p = start.next;
        while (p != null) {
            contador++;
            p = p.next;
        }
        return contador;
    }
    
    @Override
    public String toString() {
        StringBuilder resultado = new StringBuilder("["); 
        Node<E> nodo = start.next;
        while (nodo != null) {
            resultado.append(nodo.info);
            if (nodo.next != null) {
                resultado.append(", ");
            }
            nodo = nodo.next;
        }
        resultado.append("]");
        return resultado.toString();
    }
}
