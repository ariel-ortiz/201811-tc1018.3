package mx.itesm.cem.listasencadenadas;

public class TecLista<E> {
    
    protected static class Node<E> {
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
    
    protected Node<E> start = new Node<>(null);
    protected int size = 0;
    
    public void add(E info) {
        Node<E> nuevo = new Node<>(info, start.next);
        start.next = nuevo;
        size++;
    }
    
    // Complejidad O(1)
    public int size() {
        return size;
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
    
    public E remove() {
        if (size == 0) {
            return null;
        }
        E resultado = start.next.info;
        start.next = start.next.next;
        size--;
        return resultado;
    }
    
    public void dup() {
        Node<E> p = start.next;
        while (p != null) {
            Node<E> q = new Node<>(p.info, p.next);
            size++;
            p.next = q;
            p = p.next.next;
        }
    }
    
    public boolean removeAll(E element) {
        Node<E> p = start;
        boolean resultado = false;
        while (p.next != null) {
            if (element.equals(p.next.info)) {
                resultado = true;
                size--;
                p.next = p.next.next;
            } else {
                p = p.next;
            }
        }
        return resultado;
    }
    
    public void clear() {
        size = 0;
        start.next = null;
    }
}
