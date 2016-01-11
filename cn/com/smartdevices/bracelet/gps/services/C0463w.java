package cn.com.smartdevices.bracelet.gps.services;

public enum C0463w {
    DEFAULT(-1),
    UNAVAILABLE(0),
    AVAILABLE(1);
    
    private int d;

    private C0463w(int i) {
        this.d = -1;
        this.d = i;
    }

    public static boolean a(int i) {
        return AVAILABLE.a() == i;
    }

    public static boolean b(int i) {
        return UNAVAILABLE.a() == i;
    }

    public int a() {
        return this.d;
    }
}
