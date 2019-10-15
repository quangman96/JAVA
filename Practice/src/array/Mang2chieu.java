package array;

import java.util.Scanner;

public class Mang2chieu {
    public static void main(String[] args) {
        int width;
        int height;
        int [][]arr;
        int max;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter width: ");
        width = input.nextInt();
        System.out.println("Enter height: ");
        height = input.nextInt();
        arr = Function.mang2chieu(height,width);
        Function.show2chieu(arr,width,height);

        max = Function.max2chieu(arr);
        System.out.println("max 2d la: " +max);
    }
}
