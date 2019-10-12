package Array;
import java.util.Arrays;
import java.util.ArrayList;

public class Function {
    public static int max(int array[]){

        int max = array[0];
        for(int i=0; i<array.length;i++) {
            if(array[i]>max){
                max = array[i];
            }
        }
        return max;
    }
    public static int[] taoMang(int n) {
        int[]arr = new int[n];
        for(int i=0;i<n;i++) {
            arr[i] = (int)(Math.random()*100);
        }
        return arr;
    }
    public static void show(int[]arr){
        for(int value: arr) {
            System.out.print(value+ " ");
        }
    }
    public static int min(int array[]){

        int min = array[0];
        for(int i=0; i<array.length;i++) {
            if(array[i]<min){
                min = array[i];
            }
        }
        return min;
    }
    public static int[] daoNguoc(int[]arr) {
        for (int i=0;i<arr.length/2;i++){
            int tam = arr[i];
            arr[i] = arr[arr.length-1-i];
            arr[arr.length-1-i] = tam;
        }
        return arr;
    }
}
