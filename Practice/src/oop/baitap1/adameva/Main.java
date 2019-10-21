package oop.baitap1.adameva;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        String adam = "Adam";
//        String eve = "eva";
//        int adamweight = 70;
//        int evaweight = 50;
//        int appleweight = 15;
//
        Scanner input = new Scanner(System.in);
        Human adam = new Human("adam",70);
        Human eva = new Human("eva", 50);
        Apple apple = new Apple(15);

        System.out.println("Menu");
        System.out.println("1. "+ adam.getName()+" Eat");
        System.out.println("2. "+ eva.getName()+" Eat");
        System.out.println("0. Exit");
        System.out.println("Enter your choice: ");

        while (apple.getWeight() >= 0){

            int choice = input.nextInt();
            switch (choice){
                case 1:
                    adam.eat(apple);
                    break;
                case 2:
                    eva.eat(apple);
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("No choice!");
            }
        }
    }
}
