package mx.itesm.cem.arreglos;

import java.util.AbstractList;

// Versión 1: Lista inmutable.
// Versión 2: Lista modificable.
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
    
    @Override
    public E set(int index, E elemento) {
        E anterior = get(index);
        data[index] = elemento;
        return anterior;
    }

}
