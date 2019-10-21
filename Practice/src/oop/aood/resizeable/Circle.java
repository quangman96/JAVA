package oop.aood.resizeable;

public class Circle implements Resizeable {
    private double radius = 1.0;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public void resize(double percent){
        this.radius *= (percent);
    }
    @Override
    public String toString(){
        return "The radius of this circle is " + this.radius;
    }
}

