package cn.com.smartdevices.bracelet.view;

import java.math.BigDecimal;

public class C0849w {
    public static float a(float f, float f2) {
        return new BigDecimal(Float.toString(f)).add(new BigDecimal(Float.toString(f2))).floatValue();
    }

    public static float b(float f, float f2) {
        return new BigDecimal(Float.toString(f)).multiply(new BigDecimal(Float.toString(f2))).floatValue();
    }

    public static float c(float f, float f2) {
        return new BigDecimal(Float.toString(f)).divide(new BigDecimal(Float.toString(f2))).floatValue();
    }
}
