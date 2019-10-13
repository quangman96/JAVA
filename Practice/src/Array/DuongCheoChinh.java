package Array;

import java.util.Scanner;

public class DuongCheoChinh {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int arr[][], num;
        System.out.println("Enter kich thuoc: ");
        num = input.nextInt();
        arr = Function.mang2chieu(num,num);
        Function.show2chieu(arr,num,num);
        System.out.print("Tong cheo chinh la: "+Function.tongCheoChinh(arr,num));
    }
}
