package cn.com.smartdevices.bracelet.b;

public final class b {
    private b() {
    }

    public static a a(int i) {
        if (i == 1) {
            return new d();
        }
        if (i == 2) {
            return new e();
        }
        throw new IllegalArgumentException("Dont support sportType =" + i);
    }
}
