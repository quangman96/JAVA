package oop.kethua.triangle;

public class Shape {
    private String color = "Blue";

    public Shape() {
    }

    public Shape(String color) {
    this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "This is shape with color: " +getColor();
    }
}
