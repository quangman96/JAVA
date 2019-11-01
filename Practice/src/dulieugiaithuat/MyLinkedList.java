package dulieugiaithuat;

//import org.w3c.dom.Node;

//import java.util.LinkedList;

public class MyLinkedList<E> {
    private Node head;
    private Node tail;
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
        if (get.getNext() == null) {
            get = get.getNext();
        }
        get.setNext(newNode);
        ensureCapacity(1);
    }
//        if((index<0) || (index >=numNodes)) return null;
//        else if(index == 0) {
////            Node first = this.head;
//            Node temp = this.head;
//            head = head.getNext();
//            ensureCapacity(-1);
//            return (E) temp;
//        }
////        last
//        else if (index == numNodes-1){
//            Node current = head;
//            for (int i = 0; i < numNodes-2; i++) {
//                current = current.getNext();
//            }
//            Node temp1 = tail;
//            tail = current;
////            tail.setNext(tail.getNext()) = null;
//            ensureCapacity(-1);
//            return (E) temp1;
//        }
    public E remove(int index){
        if ((index>=0) && (index<numNodes)){
            int count = 0;
            Node get = this.head;
            while (count<index){
                count ++;
                get = get.getNext();
            }
            Node nodeRemove = get.getNext();
            get.setNext(nodeRemove.getNext());
            ensureCapacity(-1);
            return (E)nodeRemove.getData();
            }
            return null;
    }
}
//
//    public boolean remove(Object E){}
//}
