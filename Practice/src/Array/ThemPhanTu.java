package Array;

import java.util.Scanner;

public class ThemPhanTu {
    public static void main(String[] args) {
        int num;
        int[]arr;
        int index;
        int value;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter length: ");
        num = input.nextInt();
        arr=Function.show(Function.taoMang(num));
        System.out.println("Enter index: ");
        index = input.nextInt();
        System.out.println("Enter value: ");
        value = input.nextInt();
        arr = Function.add(arr,index,value);
        Function.show(arr);

    }
}
