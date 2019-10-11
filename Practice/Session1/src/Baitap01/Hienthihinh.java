package Baitap01;

import java.util.Scanner;

public class Hienthihinh {
    public static void main(String[] args) {
        int choice = -1;
        Scanner input = new Scanner(System.in);
        while (choice!=0){
            System.out.println("Menu");
            System.out.println("1. Ve hinh chu nhat");
            System.out.println("2. Ve hinh tam giac vuong 1");
            System.out.println("3. Ve hinh tam giac vuong 2");
            System.out.println("4. Ve hinh tam giac can");
            System.out.println("0. Exit");
            System.out.println("Enter you choice: ");
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Ve hinh chu nhat");
                    for(int i =0; i<5; i++) {
                        for(int j=0;j<6;j++){
                            System.out.println("*");
                        }
                    }
                break;
                case 2:
                    System.out.println("Ve hinh tam giac vuong 1");
                    for (int i=0; i<6; i++) {
                        for(int j=0; j<i;j++){
                            System.out.println("*");
                        }
                    }
                break;
                case 3:
                    System.out.println("Ve hinh tam giac vuong 2");
                    for (int i=7; i>0;i--) {
                        for(int j=1; j<=i;j++) {
                            System.out.println("*");
                        }
                    }
                break;
                case 4:
                    System.out.println("Ve hinh tam giac can");
                    int n = 5;
                    for(int i =0; i<=n; i++) {
                        for(int j=1; j<n+2-i; j++){
                            System.out.print("_");
                            for(int k= 1;k<=2*i-1;k++){
                                System.out.print("*");
                            }
                        }
                    }
                break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("No choice");
            }
        }
    }
}
