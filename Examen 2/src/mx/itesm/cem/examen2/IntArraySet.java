package mx.itesm.cem.examen2;

import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class IntArraySet extends AbstractSet<Integer> {

    private class IntArraySetIterator
            implements Iterator<Integer> {

        private int current = 0;
        private int toBeProcessed = size;
        
        @Override
        public boolean hasNext() {
            return toBeProcessed > 0;
        }

        @Override
        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            while (!values[current]) {
                current++;
            }
            int result = current;
            current++;
            toBeProcessed--;
            return result;
        }
    }

    private boolean[] values;
    private int size;

    public IntArraySet(int n) {
        values = new boolean[n];
        size = 0;
    }

    public IntArraySet(int n, Collection<Integer> coll) {
        this(n);
        addAll(coll);
    }

    @Override
    public boolean add(Integer item) {
        Objects.nonNull(item);
        if (item < 0 || item >= values.length) {
            throw new IllegalArgumentException();
        }
        if (values[item]) {
            return false;
        }
        values[item] = true;
        size++;
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean remove(Object item) {
        Objects.nonNull(item);
        int index = (int) item;
        if (index < 0 || index >= values.length
                || !values[index]) {
            return false;
        }
        values[index] = false;
        size--;
        return true;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new IntArraySetIterator();
    }
}
