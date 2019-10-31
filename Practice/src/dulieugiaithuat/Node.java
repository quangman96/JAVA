package dulieugiaithuat;

public class Node {
    private Node next = null;
    private Object data;
    public Node(Object data){
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Object getData(){
        return data;
    }

    public void setData(){
        this.data = data;
    }
}
