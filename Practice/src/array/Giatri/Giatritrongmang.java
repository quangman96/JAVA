package array.Giatri;

import java.util.Scanner;

public class Giatritrongmang {
    public static void main(String[] args) {
        String[] students = {"Christian", "Michael", "Camila", "Sienna", "Tanya", "Connor", "Zachariah", "Mallory", "Zoe", "Emily"};
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name student: ");
        String input = scanner.nextLine();
        String aindex;
        for(int i=0; i<students.length; i++) {
            if(students[i].equals(input)){
                aindex = " "+i;
//                System.out.println(index);
            }
//                System.out.println(index);
        }
//        System.out.println(aindex);
    }
}

