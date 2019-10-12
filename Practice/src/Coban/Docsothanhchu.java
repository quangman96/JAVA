package Coban;

import java.util.Scanner;

public class Docsothanhchu {
    public static void main(String[] args) {
        System.out.println("Enter a number: ");
        Scanner nhapdulieu = new Scanner(System.in);
        int number = nhapdulieu.nextInt();

        String letter = "";
        if(number>=0 && number<11) {
            switch (number) {
                case 0:
                    letter ="zero";
                    break;
                case 1:
                    letter ="one";
                    break;
                case 2:
                    letter ="two";
                    break;
                case 3:
                    letter ="three";
                    break;
                case 4:
                    letter ="four";
                    break;
                case 5:
                    letter ="five";
                    break;
                case 6:
                    letter ="six";
                    break;
                case 7:
                    letter ="seven";
                    break;
                case 8:
                    letter ="eight";
                    break;
                case 9:
                    letter ="nine";
                    break;
                case 10:
                    letter ="ten";
                    break;
//                default:
//                    letter = "";
            }
            System.out.println(letter);
        }
    }
}
