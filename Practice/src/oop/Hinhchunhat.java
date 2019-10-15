package oop;

import java.util.Scanner;

public class Hinhchunhat {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter width: ");
        double width = input.nextDouble();
        System.out.println("Enter height: ");
        double height = input.nextDouble();

        Rectangle hcn = new Rectangle(width,height);

        System.out.println("Your rectangle \n"+ hcn.display());
        System.out.println("Perimeter is: "+ hcn.getPerimeter());
        System.out.println("Area is: "+ hcn.getArea());

    }
}
