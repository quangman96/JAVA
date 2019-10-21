package oop.aood.resizeable;

public class Square implements Resizeable{
    private double side = 1;

    public Square(double side) {
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    @Override
    public void resize(double percent){
        this.side *= percent;
    }
    @Override
    public String toString(){
        return "The side of this square is " + this.side;
    }
}
