package oop.kethua;

public class Fan {
    public static final int slow = 1;
    private static final int medium = 2;
    public static final int fast = 3;

    private int speed = slow;
    private boolean on = false;
    private double radius = 5;
    private String color = "Blue";

    public Fan(){
    }


    public static int getMedium() {
        return medium;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
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
    public String toString() {
        String status = "The fan has color: "+this.color+", radius: "+this.radius+".";
        if(this.on){
            status += " Fan is on with speed: " + this.speed;
        }
        else{
            status += " Fan is off ";
        }
        return status;
    }
    }

