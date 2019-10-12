package Array;

import java.util.Scanner;

public class GopMang {
    public static void main(String[] args) {
        int leng1,leng2,leng3;
        int arr1[],arr2[],arr3[];
        Scanner input = new Scanner(System.in);
        System.out.println("Enter arr1 length: ");
        leng1 = input.nextInt();
        System.out.println("Enter arr2 length: ");
        leng2 = input.nextInt();

        arr1 = Function.taoMang(leng1);
        System.out.println("Mang 1: ");
        Function.show(arr1);
        arr2 = Function.taoMang(leng2);
        System.out.println("\n"+"Mang 2: ");
        Function.show(arr2);
        leng3 = arr1.length + arr2.length;

        arr3 = new int[leng3];
        for (int i = 0; i < arr1.length; i++) {
            arr3[i]=arr1[i];
        }
        for (int i = arr1.length; i <arr3.length ; i++) {
            arr3[i] = arr2[i-arr1.length];
        }
        System.out.println("\n"+"Gop mang: ");
        Function.show(arr3);
    }

}
