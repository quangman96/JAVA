package Coban;

import java.util.Scanner;
public class Ptbacnhat {
    public static void main(String[] args) {
        System.out.println("Giai phuong trinh bac nhat");
        System.out.println("Cho phuong trinh a*x+b=0,nhap cac hang so");

        Scanner ingiatri = new Scanner(System.in);

        System.out.print("a: ");
        double a = ingiatri.nextDouble();
        System.out.print("b: ");
        double b = ingiatri.nextDouble();

        if(a!= 0) {
            double dapan = -b/a;
            System.out.printf("Ket qua la: %f!",dapan );
        } else if (b == 0) {
            System.out.println("Phuong trinh vo so nghiem");
        } else {
            System.out.println("Phuong trinh vo nghiem");
        }

    }
}
