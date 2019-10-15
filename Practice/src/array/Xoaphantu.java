package array;

//import commons.apache.org library:Javadocs;
import java.util.Scanner;

public class Xoaphantu {
    public static void main(String[] args) {
        int leng;
        int arr[];
        int index;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter length: ");
        leng = input.nextInt();
        arr = Function.taoMang(leng);
        Function.show(arr);

        System.out.println("Enter index: ");
        index = input.nextInt();

        arr = Function.del(arr,index);
        Function.show(arr);
    }
}
