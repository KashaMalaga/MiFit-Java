package cn.com.smartdevices.bracelet.gps.services.b;

import android.util.Log;

public class i {
    public static void a() {
        double[] a = a(40.0281251176918d, 40.0236676297618d, 116.316918850185d, 116.310224006707d, 936, 1080);
        Log.i("bao", "scacleX = " + a[0] + ",scacleY = " + a[1]);
        int[] a2 = a(40.0256676297618d, 116.313918850185d, 116.310224006707d, 40.0281251176918d, a[0], a[1]);
        Log.i("bao", "X = " + a2[0] + ",Y = " + a2[1]);
    }

    public static double[] a(double d, double d2, double d3, double d4, int i, int i2) {
        if (i2 <= 0 || i <= 0) {
            throw new IllegalArgumentException();
        }
        return new double[]{((d3 - d4) * 3600.0d) / ((double) i2), ((d - d2) * 3600.0d) / ((double) i)};
    }

    public static int[] a(double d, double d2, double d3, double d4, double d5, double d6) {
        if (d5 <= 0.0d || d6 <= 0.0d) {
            throw new IllegalArgumentException();
        }
        return new int[]{(int) (((d2 - d3) * 3600.0d) / d5), (int) (((d4 - d) * 3600.0d) / d6)};
    }
}
