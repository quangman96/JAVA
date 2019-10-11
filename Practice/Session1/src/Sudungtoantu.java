import java.util.Scanner;
public class Sudungtoantu {
    public static void main(String[] args) {
        float width;
        float height;

        Scanner man = new Scanner(System.in);
        System.out.println();
        System.out.println("Enter width: ");
        width = man.nextFloat();
        System.out.println("Enter height: ");
        height = man.nextFloat();

        float area = width * height;
        System.out.println("Area is: "+ area);
    }
}
