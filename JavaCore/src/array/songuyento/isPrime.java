package array.songuyento;

public class isPrime {
    public static boolean isPrime(int n){
        if(n<2) {
            return false;
        } else if (n==2) {
            return true;
        } else if ((n%2)==0) {
            return false;
        } else {
            for (int i = 3; i< n-1 ; i++) {
                if ((n%i)==0) {
                    return false;
                }
            }
        }
        return true;
    }
}
