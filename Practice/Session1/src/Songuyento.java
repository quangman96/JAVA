import java.util.Scanner;
public class Songuyento {
    public static void main(String[] args) {
        Scanner nhapdulieu = new Scanner(System.in);
        System.out.println("Nhap vao so can kiem tra: ");
        int n = nhapdulieu.nextInt();
        boolean check;
        if(n < 2) {
            check = false;
        } else if (n == 2) {
            check = true;
        } else if (n%2==0) {
            check = false;
        } else {
            for (int i = 3; i< n-1; i++) {
                if (n%i == 0) {
                    check = false;
                }
            }
        }
        check = true;
        if (check)
            System.out.println(n +" la so nguyen to");
        else
            System.out.println(n+" khong phai la so nguyen to");
    }
}
