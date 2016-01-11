package cn.com.smartdevices.bracelet.gps.h;

public class i {
    private static final int a = 1000;
    private static final int b = 3600;

    private i() {
    }

    public static float a(float f) {
        return (1000.0f * f) / 3600.0f;
    }

    public static float b(float f) {
        return (3600.0f * f) / 1000.0f;
    }

    public static long c(float f) {
        return (long) (1000.0f * f);
    }
}
