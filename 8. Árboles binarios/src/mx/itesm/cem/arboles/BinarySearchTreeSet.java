package mx.itesm.cem.arboles;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class BinarySearchTreeSet<E extends Comparable<E>>
        extends AbstractSet<E> {

    private static class Node<E> {
        private E data;
        private Node<E> izq;
        private Node<E> der;

        public Node(E data, Node<E> izq, Node<E> der) {
            this.data = data;
            this.izq = izq;
            this.der = der;
        }

        public Node(E data) {
            this(data, null, null);
        }
    }

    private Node<E> root = null;
    private int size = 0;

    @Override
    public Iterator<E> iterator() {
        // TODO Auto-generated method stub
        return null;
    }
    
    public List<E> preOrderList() {
        List<E> result = new LinkedList<>();
        preOrder(root, result);
        return result;
    }

    private void preOrder(Node<E> p, List<E> result) {
        if (p != null) {
            result.add(p.data);
            preOrder(p.izq, result);
            preOrder(p.der, result);
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean add(E element) {
        if (root == null) {
            root = new Node<>(element);
            size++;
            return true;
        } else {
            Node<E> p = root;
            while (true) {
                if (element.compareTo(p.data) == 0) {
                    return false;
                } else if (element.compareTo(p.data) < 0) {
                    if (p.izq == null) {
                        p.izq = new Node<>(element);
                        size++;
                        return true;
                    } else {
                        p = p.izq;
                    }
                } else { // element > p.data
                    if (p.der == null) {
                        p.der = new Node<>(element);
                        size++;
                        return true;
                    } else {
                        p = p.der;
                    }
                }
            }
        }
    }
}
