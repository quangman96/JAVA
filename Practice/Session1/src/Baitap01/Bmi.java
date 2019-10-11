package Baitap01;

import java.util.Scanner;

public class Bmi {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double bmi, weight, height;

        System.out.println("Enter weight: ");
        weight = input.nextDouble();
        System.out.println("Enter height: ");
        height = input.nextDouble();

        bmi = weight/(Math.pow(height,2));

        if(bmi<18.5)
            System.out.println("Underweight");
        else if (bmi<25)
            System.out.println("Normal");
        else if (bmi <30)
            System.out.println("Overweight");
        else System.out.println("Obese");
//        System.out.printf("%-20s%s", "bmi", "Interpretation\n");
//
//        if (bmi < 18)
//            System.out.printf("%-20.2f%s", bmi, "Underweight");
//        else if (bmi < 25.0)
//            System.out.printf("%-20.2f%s", bmi, "Normal");
//        else if (bmi < 30.0)
//            System.out.printf("%-20.2f%s", bmi, "Overweight");
//        else
//            System.out.printf("%-20.2f%s", bmi, "Obese");
    }
}
