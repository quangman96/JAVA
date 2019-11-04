package array.songuyento;

import java.util.Scanner;

public class Snt20dautien {
    public static void main(String[] args) {
        int count = 0;
        int i = 2;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter num: ");
        int num = input.nextInt();
        while (count < num) {
            if (isPrime.isPrime(i)) {
                System.out.print(i + " ");
                count++;
            }
            i++;
        }
    }
}

