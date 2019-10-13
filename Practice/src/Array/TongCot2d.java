package Array;

import java.util.Scanner;

public class TongCot2d {
    public static void main(String[] args) {
        int sum = 0,width,height,num;
        int [][]arr;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter width: ");
        width = input.nextInt();
        System.out.println("Enter height: ");
        height = input.nextInt();
        arr =Function.mang2chieu(width,height);
        Function.show2chieu(arr,width,height);
        System.out.println("Nhap cot muon tinh tong: ");
        num = input.nextInt()-1;;
        sum = Function.tongCot(arr,num,width);
        System.out.println("Tong cua cot: "+(num+1)+" la: "+sum);
    }
}
