package thuattoantimkiem;

import array.Function;
import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class TuanTu {
    public static void main(String[] args) {
        int num,index;
        int arr[];

        Scanner input = new Scanner(System.in);
        System.out.print("Enter length: ");
        num = input.nextInt();
        arr = Function.show(Function.taoMang(num));
        System.out.println("");
        System.out.println("Enter index: ");
        index = input.nextInt();

        if (Function.tuyenTinh(arr, index)) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }

}
