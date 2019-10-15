package oop;

import java.util.Scanner;

public class Account {
    public static void main(String[] args) {
        double a,b,c;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a: ");
         a = input.nextDouble();
        System.out.print("Enter b: ");
         b = input.nextDouble();
        System.out.print("Enter c: ");
         c = input.nextDouble();

         QuadraticEquation account = new QuadraticEquation();
         account.setA(a);
         account.setB(b);
         account.setC(c);

         double delta = account.getDiscriminant();
        System.out.println("Delta is: "+ delta);

        double r1 = account.getRoot1();
        double r2 = account.getRoot2();

        if(delta == 0) {
            System.out.print("Pt co 1 nghiem: "+ r1);
        }
        else if (delta >= 0) {
            System.out.println("Pt co 2 nghiem: \n" + r1+ "\n" + r2);
        }
        else {
            System.out.println("Pt vo nghiem.");
        }
    }
}
