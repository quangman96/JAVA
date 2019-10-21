package oop.baitap1.hinhhoc;

public class Rengtangle {
    private double width = 0;
    private double height =0;

    public Rengtangle(double width, double height) {
        this.width = width;
        this.height =height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getArea(){
        return this.height * this.width;
    }
    public void draw() {
        System.out.println("This is Rectangle");
    }
}
