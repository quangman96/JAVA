package oop.kethua;

public class TestInterface {
    public static void main(String[] args) {
//        Circle[] circles = new Circle[2];
//        Rectangle[] rectangles = new Rectangle[2];
//        Square[] squares = new Square[2];

        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle();
        shapes[1] = new Rectangle();
        shapes[2] = new Square();

        for(Shape a:shapes) {
            System.out.println(a);
            if (a instanceof Colorable) {
                ((Colorable) a).howToColor();
            }
        }
    }

}
