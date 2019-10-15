package coban;

import java.util.Scanner;
public class Songaytrongthang {
    public static void main(String[] args) {
        Scanner indulieu = new Scanner(System.in);

        System.out.println("Muon xem thang may ?: ");
        int month = indulieu.nextInt();

        String ngay;

        switch(month) {
            case 2:
                ngay = "28 hoac 29";
                break;
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                ngay = "31";
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                ngay = "30";
                break;
            default:
                ngay = "";
        }
        if (ngay != "")
            System.out.printf("Thang '%d' co %s day", month,ngay);
        else System.out.println("Du lieu nhap loi");

    }
}
