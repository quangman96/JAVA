package dulieugiaithuat;

//import org.w3c.dom.Node;

//import java.util.LinkedList;

public class MyLinkedList<E> {
    private Node head;
    private int numNodes;

    public MyLinkedList() {
    }

    public void ensureCapacity(int minCapacity) {
        this.numNodes += minCapacity;
    }

    public void add(int index, E element){
        if((index>=0)&&(index<=numNodes)){
            int count = 0;
            Node get = head;
            while (count<index){
                count++;
                get = get.getNext();
            }
            Node newNode = new Node(element);
            newNode.setNext(get.getNext());
            get.setNext(newNode);
            ensureCapacity(1);
        }
    }


    public void addFirst(E e) {
        Node newNode = new Node(e);
        newNode.setNext(this.head);
        this.head = newNode;
        ensureCapacity(1);
    }

    public void addLast(E e) {
        Node newNode = new Node(e);
        Node get = this.head;
        while (get.getNext() == null) {
            get = get.getNext();
        }
        get.setNext(newNode);
        ensureCapacity(1);
    }
}

//    public E remove(int index){
//
//    }
//
//    public boolean remove(Object E){}
//}
