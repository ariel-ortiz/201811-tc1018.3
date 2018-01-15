package mx.itesm.cem.arreglos;

import java.util.AbstractList;

// Versión 1: Lista inmutable.
public class TecArrayList<E> extends AbstractList<E> {
    
    private E[] data;
    
    public TecArrayList(@SuppressWarnings("unchecked") E... args) {
        data = args;
    }

    @Override
    public E get(int index) {
        return data[index];
    }

    @Override
    public int size() {
        return data.length;
    }

}
