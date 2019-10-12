package Coban;

import java.util.Scanner;

public class Thietkemenu {
    public static void main(String[] args) {
        int choice = -1;
        Scanner nhapdulieu = new Scanner(System.in);
        while(choice !=0) {
        System.out.println("Menu");
        System.out.println("1. Ve hinh tam giac");
        System.out.println("2. Ve hinh vuong");
        System.out.println("3. Ve hinh chu nhat");
        System.out.println("0. Exit");
        System.out.println("Enter you choice: ");
        choice = nhapdulieu.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Draw the triangle");
                System.out.println("******");
                System.out.println("*****");
                System.out.println("****");
                System.out.println("***");
                System.out.println("**");
                System.out.println("*");
                break;
            case 2:
                System.out.println("Draw the square");
                System.out.println("* * * * * *");
                System.out.println("* * * * * *");
                System.out.println("* * * * * *");
                System.out.println("* * * * * *");
                System.out.println("* * * * * *");
                System.out.println("* * * * * *");

                break;
            case 3:
                System.out.println("Draw the rectangle");
                System.out.println("* * * * * *");
                System.out.println("* * * * * *");
                System.out.println("* * * * * *");
                break;
            case 0:
                System.exit(0);
            default:
                System.out.println("No choice!");
        }
        }
    }
}
