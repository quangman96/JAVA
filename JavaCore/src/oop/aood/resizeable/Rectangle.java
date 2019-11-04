package oop.aood.resizeable;

public class Rectangle implements Resizeable {
    private double width = 1;
    private double height = 2;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public void resize(double percent){
        this.width *= percent;
        this.height *= percent;
    }
    @Override
    public String toString(){
        return "This rectangle have width = " + this.width + "\theight = " + this.height;
    }
}
