package oop.kethua.point;

import java.util.Arrays;

public class Point2D {
    public float x = 0.0f;
    public float y = 0.0f;
//    private float[]arr = new float[2];

    public Point2D() {
    }

    public Point2D(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
    return x;
}

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setXY(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float[] getXY() {
        float[]arr = new float[]{this.x,this.y};
//        arr[0] = x;
//        arr[1] = y;
        return arr;
    }

    @Override
    public String toString() {
        return "Point 2D with x = "+getX()+
                "with y = "+getY()+ " have arr is: "+ Arrays.toString(getXY());
    }
}
