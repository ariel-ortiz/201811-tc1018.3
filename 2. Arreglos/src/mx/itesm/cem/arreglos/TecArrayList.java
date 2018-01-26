package mx.itesm.cem.arreglos;

import java.util.AbstractList;

// Versión 1: Lista inmutable.
// Versión 2: Lista modificable.
// Versión 3: Lista modificable y de tamaño variable. 
public class TecArrayList<E> extends AbstractList<E> {
    
    private int capacity = 10;
    private int size = 0;
    private E[] data;
    
    @SuppressWarnings("unchecked")
    public TecArrayList(E... args) {
        data = (E[]) new Object[capacity];
        for (E element : args) {
            add(element);
        }
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException(index);
        }
        return data[index];
    }

    @Override
    public int size() {
        return size;
    }
    
    @Override
    public E set(int index, E element) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException(index);
        }
        E anterior = get(index);
        data[index] = element;
        return anterior;
    }
    
    @Override
    public void add(int index, E element) {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException(index);
        }
        if (capacity == size) {
            capacity *= 2;
            @SuppressWarnings("unchecked")
            E[] nuevo = (E[]) new Object[capacity];
            for (int i = 0; i < size; i++) {
                nuevo[i] = data[i];
            }
            data = nuevo;
        }
        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = element;
        size++;
        //System.out.printf("Size = %d, Capacity = %d%n", size, capacity);
    }

    @Override
    public E remove(int index) {
    	if (index < 0 || index >= size) {
    		throw new IndexOutOfBoundsException();
    	}
    	E anterior = data[index];
    	for (int i = index; i < size - 1; i++) {
    		data[i] = data[i + 1];
    	}
    	size--;
    	data[size] = null;
    	return anterior;
    }
}
