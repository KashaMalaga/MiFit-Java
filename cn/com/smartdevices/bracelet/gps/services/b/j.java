package cn.com.smartdevices.bracelet.gps.services.b;

import com.amap.api.maps.model.WeightedLatLng;

public class j {
    static final double a = 6378245.0d;
    static final double b = 0.006693421622965943d;

    public static void a(double d, double d2, double[] dArr) {
        if (a(d, d2)) {
            double b = b(d2 - 105.0d, d - 35.0d);
            double c = c(d2 - 105.0d, d - 35.0d);
            double d3 = 3.141592653589793d * (d / 180.0d);
            double sin = Math.sin(d3);
            sin = WeightedLatLng.DEFAULT_INTENSITY - (sin * (b * sin));
            double sqrt = Math.sqrt(sin);
            b = (b * 180.0d) / ((6335552.717000426d / (sin * sqrt)) * 3.141592653589793d);
            c = (c * 180.0d) / ((Math.cos(d3) * (a / sqrt)) * 3.141592653589793d);
            dArr[0] = b + d;
            dArr[1] = c + d2;
            return;
        }
        dArr[0] = d;
        dArr[1] = d2;
    }

    private static boolean a(double d, double d2) {
        return d2 < 72.004d || d2 > 137.8347d || d < 0.8293d || d > 55.8271d;
    }

    private static double b(double d, double d2) {
        return (((((((-100.0d + (2.0d * d)) + (3.0d * d2)) + ((0.2d * d2) * d2)) + ((0.1d * d) * d2)) + (0.2d * Math.sqrt(Math.abs(d)))) + ((2.0d * ((20.0d * Math.sin(3.141592653589793d * (6.0d * d))) + (20.0d * Math.sin(3.141592653589793d * (2.0d * d))))) / 3.0d)) + ((2.0d * ((20.0d * Math.sin(3.141592653589793d * d2)) + (40.0d * Math.sin(3.141592653589793d * (d2 / 3.0d))))) / 3.0d)) + ((2.0d * ((160.0d * Math.sin(3.141592653589793d * (d2 / 12.0d))) + (320.0d * Math.sin((3.141592653589793d * d2) / 30.0d)))) / 3.0d);
    }

    private static double c(double d, double d2) {
        return (((((((300.0d + d) + (2.0d * d2)) + ((0.1d * d) * d)) + ((0.1d * d) * d2)) + (0.1d * Math.sqrt(Math.abs(d)))) + ((2.0d * ((20.0d * Math.sin(3.141592653589793d * (6.0d * d))) + (20.0d * Math.sin(3.141592653589793d * (2.0d * d))))) / 3.0d)) + ((2.0d * ((20.0d * Math.sin(3.141592653589793d * d)) + (40.0d * Math.sin(3.141592653589793d * (d / 3.0d))))) / 3.0d)) + ((2.0d * ((150.0d * Math.sin(3.141592653589793d * (d / 12.0d))) + (300.0d * Math.sin(3.141592653589793d * (d / 30.0d))))) / 3.0d);
    }
}
