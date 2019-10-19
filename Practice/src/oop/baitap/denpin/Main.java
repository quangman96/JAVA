package oop.baitap.denpin;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int energy = 10;

        Battery battery = new Battery(energy);
        Lamp lamp1 = new Lamp("den1",false);
        Lamp lamp2 = new Lamp("den2", false);

        System.out.println("Menu");
        System.out.println("1. "+ lamp1.getName()+" turn on");
        System.out.println("2. "+ lamp2.getName()+" turn on");
        System.out.println("3. "+ lamp1.getName()+" turn off");
        System.out.println("4. "+ lamp2.getName()+" turn off");
        System.out.println("0. Exit");
        System.out.println("Enter your choice: ");

        Scanner input = new Scanner(System.in);
        while (battery.getEnergy() >= 0){
            int choice = input.nextInt();
            switch (choice){
                case 1:
                    lamp1.turnOn(battery);
                    break;
                case 2:
                    lamp2.turnOn(battery);
                    break;
                case 3:
                    lamp1.turnOff(battery);
                    break;
                case 4:
                    lamp2.turnOff(battery);
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("No choice!");
            }
        }
    }
}
