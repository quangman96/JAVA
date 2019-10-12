package Array;

import org.w3c.dom.ls.LSOutput;
import Array.Function;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class Giatrilonnhat {
    public static void main(String[] args) {
        int size;
        int[]array;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter length: ");
        size = input.nextInt();
        array = Function.taoMang(size);
//        System.out.println(Arrays.toString(Function.taoMang(size)));
        Function.show(array);
        System.out.println("Gia tri lon nhat la: "+ Function.max(array));
        System.out.println("Gia tri nho nhat la: "+ Function.min(array));

    }
}
