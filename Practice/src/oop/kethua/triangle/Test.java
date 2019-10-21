package oop.kethua.triangle;

public class Test {
    public static void main(String[] args) {
        Shape shape = new Shape("Blue");
        Triangle triangle = new Triangle(2,3,4);

        System.out.println(shape.toString());
        System.out.println(triangle.toString());
    }
}
