package Array.Nhietdo;

import java.util.Scanner;

public class Nhietdo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double doC;
        double doF;
        int check;

        do {
        System.out.println("1. C -> F");
        System.out.println("2. F -> C");
        System.out.println("0. Exit");
        System.out.println("Enter you choice: ");
        check = input.nextInt();
            switch (check) {
                case 1:
                    System.out.println("Enter doC: ");
                    doC = input.nextDouble();
                    System.out.println("DoF la: "+ Chuyendoi.doCdoF(doC));
                break;
                case 2:
                    System.out.println("Enter doF: ");
                    doF = input.nextDouble();
                    System.out.println("DoC la: "+ Chuyendoi.doFdoC(doF));
                break;
                case 0:
                    System.exit(0);
                }
            } while (check != 0);
        }
    }

