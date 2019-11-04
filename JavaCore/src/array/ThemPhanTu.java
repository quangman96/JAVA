package array;

import java.util.Scanner;

public class ThemPhanTu {
    public static void main(String[] args) {
        int num;
        int[] myArr;
        int index;
        int value;

        Scanner input = new Scanner(System.in);
        System.out.println("Enter length: ");
        num = input.nextInt();
        myArr=Function.show(Function.taoMang(num));
        System.out.println("Enter index: ");
        index = input.nextInt();
        if (index < 0 || index > myArr.length) {
            System.out.println("khong chen dc");
        } else {
            System.out.println("Enter value: ");
            value = input.nextInt();
            myArr = Function.add(myArr,index,value);
            Function.show(myArr);
        }
    }
}
