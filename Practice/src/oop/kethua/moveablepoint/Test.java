package oop.kethua.moveablepoint;

public class Test {
    public static void main(String[] args) {
        Point point = new Point(3,4);
        MoveablePoint moveablePoint = new MoveablePoint(3,4,2,3);

        System.out.println(point.toString());
        System.out.println(moveablePoint.toString());
    }
}
