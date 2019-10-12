package Array.Nhietdo;

public class Chuyendoi {
    public static double doCdoF(double doC) {
        double doF = (9/5)* doC +32;
        return doF;
    }
    public static double doFdoC(double doF) {
        double doC =(5/9)* (doF - 32);
        return doC;
    }
}
