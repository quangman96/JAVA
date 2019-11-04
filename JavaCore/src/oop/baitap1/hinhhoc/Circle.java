package oop.baitap1.hinhhoc;

public class Circle {
    private double radius = 0;

    public Circle(double radius){
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return  this.getRadius() * Math.PI;
    }

    public void draw(){
        System.out.println("This is Circle");
    }
}
