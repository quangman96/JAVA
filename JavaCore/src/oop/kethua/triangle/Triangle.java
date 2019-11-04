package oop.kethua.triangle;

public class Triangle extends Shape {
    private float side1 = 1.0f;
    private float side2 = 1.0f;
    private float side3 = 1.0f;

    public Triangle() {
    }

    public Triangle(float side1, float side2, float side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public Triangle(float side1, float side2, float side3, String color) {
        super(color);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }
    public double getPrimeter() {
        return ((this.side1+this.side2+this.side3)/2)*2;
    }

    public float getHalfPrimeter() {
        return (this.side1+this.side2+this.side3)/2;
    }
    public double getArea() {
        float p = getHalfPrimeter();
        return Math.sqrt(p*(p-side1)*(p-side2)*(p-side3));
    }

    @Override
    public String toString() {
        return "This is Triangle with side1: "+this.side1 +
                " side2: " +this.side2+ " side3: "+ this.side3+
                " ,Primeter: " + getPrimeter()+
                " ,Area: " +getArea()+
                " ,color is: " + super.getColor();
    }
}
