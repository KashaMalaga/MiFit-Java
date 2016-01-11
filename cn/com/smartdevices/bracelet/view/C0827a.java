package cn.com.smartdevices.bracelet.view;

import com.tencent.connect.common.Constants;
import java.math.BigDecimal;

public class C0827a {
    public static float a(float f, float f2) {
        return new BigDecimal(Float.toString(f)).add(new BigDecimal(Float.toString(f2))).floatValue();
    }

    public static float a(float f, float f2, int i) {
        if (i < 0) {
            i = 0;
        }
        return new BigDecimal(Float.toString(f)).divide(new BigDecimal(Float.toString(f2)), i, 4).floatValue();
    }

    public static float a(float f, int i) {
        if (i < 0) {
            i = 0;
        }
        return new BigDecimal(Float.toString(f)).divide(new BigDecimal(Constants.VIA_TO_TYPE_QQ_GROUP), i, 4).floatValue();
    }

    public static float b(float f, float f2) {
        return new BigDecimal(Float.toString(f)).subtract(new BigDecimal(Float.toString(f2))).floatValue();
    }

    public static float c(float f, float f2) {
        return new BigDecimal(Float.toString(f)).multiply(new BigDecimal(Float.toString(f2))).floatValue();
    }
}
