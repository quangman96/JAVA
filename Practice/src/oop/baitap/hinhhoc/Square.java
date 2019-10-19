package oop.baitap.hinhhoc;

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
        System.out.println("This is Square");
    }

}
