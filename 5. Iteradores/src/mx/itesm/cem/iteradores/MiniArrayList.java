package mx.itesm.cem.iteradores;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MiniArrayList<E> implements Iterable<E> {

    private class MiniArrayListIterator
            implements Iterator<E> {
        
        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < MiniArrayList.this.elems.length;
        }

        @Override
        public E next() {
            if(!hasNext()) {
                throw new NoSuchElementException();
            }
            E resultado = elems[index];
            index++;
            return resultado;
        }
    }

    private E[] elems;

    @SafeVarargs
    public MiniArrayList(E... args) {
        elems = args;
    }

    E get(int index) {
        if (index < 0 || index >= elems.length) {
            throw new IndexOutOfBoundsException();
        }
        return elems[index];
    }

    int size() {
        return elems.length;
    }

    @Override
    public Iterator<E> iterator() {
        return new MiniArrayListIterator();
    }

    public static void main(String[] args) {
        MiniArrayList<Integer> a = new MiniArrayList<>(4, 8,
                15, 16, 23, 42);
        
        for (Integer elemento: a) {
            System.out.println(elemento);
        }
    }
}
