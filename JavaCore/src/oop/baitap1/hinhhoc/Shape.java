package oop.baitap1.hinhhoc;

public class Shape {
    private Square square;
    private Rengtangle rengtangle;
    private Circle circle;


    public Shape(Square square, Rengtangle rectangle, Circle circle) {
        this.square = square;
        this.rengtangle = rectangle;
        this.circle = circle;
    }



    public Rengtangle getRectangle() {
        return rengtangle;
    }

    public void setRectangle(Rengtangle rectangle) {
        this.rengtangle = rectangle;
    }

    public Square getSquare() {
        return square;
    }

    public void setSquare(Square square) {
        this.square = square;
    }

    public Circle getCircle() {
        return circle;
    }

    public void setCircle(Circle circle) {
        this.circle = circle;
    }

    public void draw(){
        square.draw();
        rengtangle.draw();
        circle.draw();
    }

    public double area(){
        return square.getArea()+rengtangle.getArea()+circle.getArea();
    }

}
