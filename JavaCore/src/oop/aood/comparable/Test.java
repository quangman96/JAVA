package oop.aood.comparable;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        ComparableCircle[] circles = new ComparableCircle[3];
        circles[0] = new ComparableCircle(3.5);
        circles[1] = new ComparableCircle();
        circles[2] = new ComparableCircle(2.5,"Blue",false);

        System.out.println("After: ");
        for(ComparableCircle circle: circles) {
            System.out.println(circle);
        }
        Arrays.sort(circles);

        System.out.println("Before: ");
        for(ComparableCircle circle:circles) {
            System.out.println(circle);
        }
    }
}
