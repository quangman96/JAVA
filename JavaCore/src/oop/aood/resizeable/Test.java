package oop.aood.resizeable;

public class Test {
    public static void main(String[] args) {
        Circle[] circles = new Circle[2];
        Rectangle[] rectangles = new Rectangle[2];
        Square[] squares = new Square[2];

        System.out.println("Before: ");
        for (int i = 0; i < 2; i++) {
            circles[i] = new Circle((int)(Math.random()*10)+1);
            rectangles[i] = new Rectangle((int)(Math.random()*10+1),(int)(Math.random()*10)+1);
            squares[i] = new Square((int)(Math.random()*10)+1);

            System.out.println(circles[i].toString());
            System.out.println(rectangles[i].toString());
            System.out.println(squares[i].toString());
        }

        System.out.println("After: ");
        for (int i = 0; i < 2; i++) {
            circles[i].resize((int)(Math.random()*3)+2);
            rectangles[i].resize((int)(Math.random()*3)+2);
            squares[i].resize((int)(Math.random()*3)+2);

            System.out.println(circles[i].toString());
            System.out.println(rectangles[i].toString());
            System.out.println(squares[i].toString());

        }


    }
}
