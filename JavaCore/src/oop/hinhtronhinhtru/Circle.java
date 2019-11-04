package oop.hinhtronhinhtru;

public class Circle {
    private double radius = 0;
    private String color = "Blue";

    public Circle() {
    }

    public Circle(double radius,String color) {
        this.color = color;
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getArea() {
        return radius * radius * Math.PI;
    }
    @Override
    public String toString() {
        return "This is a Circle, with radius is: "+ getRadius()+
                " ,with color is: "+ getColor()+
                " ,and Area is: "+getArea();
    }
}
