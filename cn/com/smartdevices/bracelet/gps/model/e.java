package cn.com.smartdevices.bracelet.gps.model;

public class e {
    public static final int a = -1;
    public static final int b = 0;
    public static final int c = 1;
    public static final int d = 2;
    public static final int e = 3;
    public static final int f = 4;

    private e() {
    }

    public static boolean a(int i) {
        return i == c || i == e;
    }

    public static boolean b(int i) {
        return i == f || i == d;
    }

    public static boolean c(int i) {
        return i <= f && i >= a;
    }
}
