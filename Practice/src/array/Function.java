package array;

public class Function {
    public static int max(int array[]) {

        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    public static int[] taoMang(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = (int) (Math.random() * 100);
        }
        return arr;
    }

    public static int[] show(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        return arr;
    }

    public static int min(int array[]) {

        int min = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }

    public static int[] daoNguoc(int[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            int tam = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = tam;
        }
        return arr;
    }

    public static int[] insert(int[] arr, int k) {
        int arrIndex = arr.length - 1;
        int tempIndex = arr.length;
        int[] tempArr = new int[tempIndex + 1];
        boolean inserted = false;

        for (int i = tempIndex; i >= 0; i--) {
            if (arrIndex > -1 && arr[arrIndex] > k) {
                tempArr[i] = arr[arrIndex--];
            } else {
                if (!inserted) {
                    tempArr[i] = k;
                    inserted = true;
                } else {
                    tempArr[i] = arr[arrIndex--];
                }
            }
        }
        return tempArr;
    }

    public static int[] add(int[] arr, int index, int num) {
        int[] array = new int[arr.length + 1];
        for (int i = 0; i < index; i++) {
            array[i] = arr[i];
            array[index] = num;
        }
        for (int i = index + 1; i < arr.length+1; i++) {
            array[i] = arr[i - 1];
        }
        return array;
    }

    public static int[] del(int[]arr, int index) {
        int[]array = new int[arr.length-1];
        for (int i = index; i <arr.length-1 ; i++) {
                arr[i] = arr[i+1];
        }
        for (int i = 0; i < arr.length-1; i++) {
            array[i]= arr[i];
        }
        return array;
    }
    public static int[][] mang2chieu(int width, int height) {
        int[][] arr = new int[width][height];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                arr[i][j] = (int)(Math.random()*100);
            }
            //width ngang, height doc
        }
        return arr;
    }
    public static void show2chieu(int [][]arr, int width, int height) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j <width ; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println(" ");
        }
    }
    public static int tongCot(int [][]arr,int num,int height) {
        int sum = 0;
        for (int i = 0; i < height; i++) {
            sum += arr[i][num];
        }
        return sum;
    }
    public static int max2chieu(int [][]arr){
        int max = arr[0][0];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length ; j++) {
                if (arr[i][j]>max)
                    max = arr[i][j];
            }
        }
        return max;
    }
    public static int tongCheoChinh(int[][]arr,int kt) {
        int sum = 0;
        for (int i = 0; i < kt; i++) {
            sum += arr[i][i];
        }
        return sum;
    }
    public static int demKtChuoi(String str, char c) {
        int count = 0;
        for (int i = 0; i <str.length() ; i++) {
            if(str.charAt(i)==c){
                count ++;
            }
        }
        return count;
    }
}

