import java.util.Scanner;

public class Kiemtranamnhuan {
    public static void main(String[] args) {
        Scanner nhapdulieu = new Scanner(System.in);
        System.out.println("Nhap vao nam can check: ");
        int y = nhapdulieu.nextInt();
        boolean check;

        if((y%4==0) && (y%100!=0)){
            check = true;
        }
        else if ((y%100==0)&&(y%400==0)) {
            check = true;
        }
        else {
            check = false;
        }

        if(check)
            System.out.println("Nam "+y+" la nam nhuan");
        else
            System.out.println("Nam "+y+" khong phai la nam nhuan");
    }
}
