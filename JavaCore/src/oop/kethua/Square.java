package oop.kethua;

public class Square extends Shape implements Colorable{
    double side = 0;
    public Square(){}
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

    @Override
    public String toString() {
        return "A square with width: "+ getSide()+
                 " which is a subclass of: "
                +super.toString();
    }
    @Override
    public void howToColor() {
        System.out.println("Color all four sides");
    }
}

