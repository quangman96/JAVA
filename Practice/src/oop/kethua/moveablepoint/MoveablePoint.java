package oop.kethua.moveablepoint;

import java.util.Arrays;

public class MoveablePoint extends Point{
    private float xSpeed = 0.0f;
    private float ySpeed = 0.0f;

    public MoveablePoint() {
    }

    public MoveablePoint(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public MoveablePoint(float x, float y, float xSpeed, float ySpeed) {
        super(x, y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float getxSpeed() {
        return xSpeed;
    }

    public void setxSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public float getySpeed() {
        return ySpeed;
    }

    public void setySpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }

    public void setSpeed(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float[] getSpeed(){
        float[]arr = new float[]{this.xSpeed,this.ySpeed};
        return arr;
    }

    @Override
    public String toString() {
        return "x: "+super.getX()+ " ,y: "+super.getY()+" ,xy: "+ Arrays.toString(getXY())+" ,speed= "+ Arrays.toString(getSpeed());
    }

//    public float[] move() {
////        float[] arr = new float[]{(setX(getX()+this.xSpeed)),(setY(getY()+this.ySpeed))};
////        arr[0] = setX(getX()+this.xSpeed);
////        arr[1] = setY(getY()+this.ySpeed);
////        return arr;
//    }


}
