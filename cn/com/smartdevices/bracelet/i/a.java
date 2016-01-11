package cn.com.smartdevices.bracelet.i;

public class a extends Exception {
    public static final int a = 0;
    public static final int b = 1;
    public static final int c = 17;
    public static final int d = 2;
    public static final int e = 3;
    public static final int f = 4;
    public static final int g = 5;
    public static final int h = 6;
    private int i;

    public a(int i) {
        super(com.xiaomi.e.a.f + i);
        this.i = i;
    }

    public a(int i, String str) {
        super(com.xiaomi.e.a.f + i + ", " + str);
        this.i = i;
    }

    public a(int i, String str, Throwable th) {
        super(com.xiaomi.e.a.f + i + ", " + str, th);
        this.i = i;
    }

    public a(int i, Throwable th) {
        super(com.xiaomi.e.a.f + i, th);
        this.i = i;
    }

    public int a() {
        return this.i;
    }
}
