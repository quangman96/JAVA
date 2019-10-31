package dulieugiaithuat;
import java.util.Iterator;
import java.util.Arrays;

public class MyList<E> {
    private int size = 0;
    static final int DEFAULT_CAPACITY = 10;
    private Object elements[];
    private int capacity, index;
    public MyList(){
        size = DEFAULT_CAPACITY;
        elements = new Object[size];
    }

    public MyList(int capacity){
//        this.capacity = capacity;
        size = capacity;
        elements = new Object[size];
    }

    private void ensureCapa(int a) {
        int newSize = elements.length+a;
        elements = Arrays.copyOf(elements,newSize);
    }

    public void setIndex(int index, E element){
        elements[index] = element;
    }

//    public void add(int index, E element){
//        if (size == elements.length){
//            ensureCapa();
//        }
//        elements[size++] = index;
//    }

    public void add(int index, E element) {
        ensureCapa(1);
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + " ,size " + index);
        }
//        Object[] temp = new Object[size + 1];
        for (int i = elements.length; i < index; i--) {
            elements[i] = elements[i-1];
        }
        elements[index] = element;
    }

    public E remove(int index) {
        E result = (E) elements[index];
        if (index>=size || index<0) {
            throw new IndexOutOfBoundsException("Index: "+ index+" ,size "+ index);
        }
        for (int i = index; i < elements.length -1 ; i++) {
            elements[i] = elements[i+1];
        }
        ensureCapa(-1);
        return result;
    }

    public int size(){
        return size;
    }

    public E clone(){
        E elementsClone = (E) elements;
        return elementsClone;
    }

    public boolean contains(E o){
        boolean check = false;
        for (int i = 0; i < elements.length; i++) {
            if(o.equals(elements[i])){
                check = true;
            }
        }
        return check;
    }

    public int indexOf(E o){
        int count = -1;
        for (int i = 0; i < elements.length ; i++) {
            if(elements[i] == o){
                count = i;
                break;
            }
        }
        return count;
    }

    public E get(int i){
        return (E) elements[i];
    }

    public void clear(){
        for(int i=0; i <elements.length; i++) {
            elements[i]=null;
        }
    }

    public String toString(){
        String result = "";
        for(int i= 0; i<elements.length;i++){
            result+=elements[i] + " ";
        }
        return result;
    }

}
