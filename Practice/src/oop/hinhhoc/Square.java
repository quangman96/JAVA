package oop.hinhhoc;

public class Square {
    double side = 0;

    public  Square(double side) {
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    public double getArea(){
        return Math.pow(this.side, 2);
    }
    public void draw(){
        for (int i = 0; i < side; i++) {
            for (int j = 0; j < side; j++) {
                System.out.print("*");
            }
            System.out.print("\n");
        }
    }

}
