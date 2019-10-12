package Coban;

import java.util.Scanner;

public class Tinhlaichovay {
    public static void main(String[] args) {
        double money = 1.0;
        int month = 1;
        double rate = 1.0;

        Scanner input = new Scanner(System.in);
        System.out.println("Nhap so tien: ");
        money = input.nextDouble();
        System.out.println("Nhap so thang: ");
        month = input.nextInt();
        System.out.println("Nhap lai suat: ");
        rate = input.nextDouble();

        double total = 0;
        for (int i = 0; i<month; i++) {
            total = money * (rate/100)/12 * month;
        }
        System.out.println("Tong tien nhan dc: "+total);
    }
}
