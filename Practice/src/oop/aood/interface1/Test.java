package oop.aood.interface1;

import oop.kethua.Circle;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Comparator;

public class Test {
    public static void main(String[] args) {
        Circle[] circles = new Circle[3];
        circles[0] = new Circle(3.6);
        circles[1] = new Circle();
        circles[2] = new Circle(3.5,"Blue",false);

        System.out.println("Before: ");
        for (Circle circle: circles) {
            System.out.println(circle);
        }

        Comparator circleComparator = new CircleComparator();
        Arrays.sort(circles,circleComparator);

        System.out.println("After: ");
        for (Circle circle: circles){
            System.out.println(circle);
        }
    }
}
