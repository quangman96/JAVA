package coban;

import java.util.Scanner;

public class Uocchunglonnhat {
    public static void main(String[] args) {
        int a,b;
        Scanner nhapdulieu = new Scanner(System.in);
        System.out.println("Enter a: ");
        a = nhapdulieu.nextInt();
        System.out.println("Enter b: ");
        b = nhapdulieu.nextInt();

        a = Math.abs(a);
        b = Math.abs(b);

        if (a==0 || b==0)
            System.out.println("Khong co uoc chung");

        while (a!=b) {
            if(a>b)
                a = a - b;
            else
                b = b - a;
        }
        System.out.println("UCLN: "+a);
    }
}
