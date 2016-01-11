package cn.com.smartdevices.bracelet.gps.model;

public class m {
    public static final int a = 0;
    public static final int b = 1;
    public static final int c = 2;
    public float d;
    public long e;
    public long f;
    public int g = a;

    public m(long j, float f, long j2) {
        this.d = f;
        this.e = j2;
        this.f = j;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof m)) {
            return false;
        }
        return this.f == ((m) obj).f;
    }
}
