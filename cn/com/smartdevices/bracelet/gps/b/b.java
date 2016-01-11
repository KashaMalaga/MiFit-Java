package cn.com.smartdevices.bracelet.gps.b;

public final class b {
    private b() {
    }

    public static a a(int i) {
        if (i == 4) {
            return new d();
        }
        throw new IllegalArgumentException("Dont support sportType =" + i);
    }
}
