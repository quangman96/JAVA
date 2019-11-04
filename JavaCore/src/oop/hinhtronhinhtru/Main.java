package oop.hinhtronhinhtru;

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(5,"Blue");
        Cylinder cylinder = new Cylinder(3,4,"Red");

        System.out.println(circle.toString());
        System.out.println(cylinder.toString());
    }

}
