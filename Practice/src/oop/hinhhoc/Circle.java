package oop.hinhhoc;

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

    public String draw(){
        return "Đây là hình tròn.";
    }
}
