package dulieugiaithuat;

import java.util.Arrays;

    public class ArrayList<E> {
    private int size = 0;
    private static final int maxSize = 10;
    private Object elements[];

    public ArrayList() {
        elements = new Object[maxSize];
    }

        private void ensureCapa() {
        int newSize = elements.length*2;
        elements = Arrays.copyOf(elements,newSize);
    }

    public void add(E e) {
        if (size == elements.length){
            ensureCapa();
        }
        elements[size++] = e;
    }

    public E get(int i){
        if (i>=size || i<0) {
            throw new IndexOutOfBoundsException("Index: "+ i+" ,size "+ i);
        }
        return (E) elements[i];
    }
}
