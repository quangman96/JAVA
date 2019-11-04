package thuattoantimkiem;

import array.Function;

import java.util.Scanner;

public class NhiPhan{
    public static void main(String[] args) {
        int num,index;
        int arr[],arr1[];

        Scanner input = new Scanner(System.in);
        System.out.print("Enter length: ");
        num = input.nextInt();
        arr = Function.show(Function.taoMang(num));
        System.out.println("");
        arr1 = Function.show(Function.sortASC(arr));
        System.out.println("");

        System.out.println("Enter index: ");
        index = input.nextInt();

        if (Function.nhiPhan(arr1, index)) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
    }

