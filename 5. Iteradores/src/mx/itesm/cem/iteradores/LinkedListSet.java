package mx.itesm.cem.iteradores;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

public class LinkedListSet<E> extends AbstractSet<E> {

    private static class Node<E> {
        public E info = null;
        public Node<E> next = null;
        public Node<E> prev = null;
    }

    private class LinkedListSetIterator
            implements Iterator<E> {

        private Node<E> current = sentinel; 
        
        @Override
        public boolean hasNext() {
            return current.next != sentinel;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            current = current.next;
            return current.info;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private int size = 0;
    private Node<E> sentinel;

    public LinkedListSet() {
        sentinel = new Node<>();
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
    }

    @Override
    public Iterator<E> iterator() {
        return new LinkedListSetIterator();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean add(E info) {
        if (contains(info)) {
            return false;
        }
        Node<E> newNode = new Node<>();
        newNode.info = info;

        newNode.next = sentinel;
        newNode.prev = sentinel.prev;

        sentinel.prev.next = newNode;
        sentinel.prev = newNode;

        size++;
        return true;
    }
    
    public static void main(String[] args) {
        Set<String> s = new LinkedListSet<>();
        s.add("A");
        s.add("B");
        System.out.println(s);
        s.add("A");
        System.out.println(s);
    }
}
