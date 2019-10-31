package dulieugiaithuat;

public class LinkedListTest {
    public static void main(String[] args) {
        LinkedList list = new LinkedList(9);
        list.addFirst(11);
        list.addFirst(12);
        list.addFirst(13);

        list.add(4,9);
        list.add(4,8);
        list.printList();
    }
}
