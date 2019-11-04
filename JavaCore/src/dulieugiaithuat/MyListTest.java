package dulieugiaithuat;

public class MyListTest {
    public static void main(String[] args) {
    MyList<Integer> list = new MyList<Integer>(3);
    list.setIndex(0,333);
    list.setIndex(1,444);
    list.setIndex(2,555);
//    list.remove(2);
//    list.add(2,3);
//    list.remove(1);
        System.out.println(list.contains(444));;
        System.out.println(list.toString());;
    }
}

