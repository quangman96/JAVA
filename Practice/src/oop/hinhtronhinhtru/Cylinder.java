package oop.hinhtronhinhtru;

public class Cylinder extends Circle {
    private double height = 0;
    public Cylinder() {
    }

    public Cylinder(double height){
        this.height = height;
    }

    public Cylinder(double height, double radius, String color) {
        super(radius, color);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getVolume () {
        return Math.PI *getRadius()*getRadius()*getHeight();
    }

    @Override
    public String toString() {
        return "This is a Cylinder, with radius is: "+ getRadius()+
                " ,with color is: "+ getColor()+
                " ,with area is: "+ getArea()+
                " ,and volume is: "+getVolume()+
                super.toString();
    }
}
