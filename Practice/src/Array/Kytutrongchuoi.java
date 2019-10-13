package Array;

import java.util.Scanner;

public class Kytutrongchuoi {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhap chuoi: ");
        String str = input.nextLine();
        System.out.println("Nhap ky tu: ");
        char c = input.next().charAt(0);
        int count = Function.demKtChuoi(str,c);
        System.out.println("So lan xuat hien: "+ count);
    }
}
