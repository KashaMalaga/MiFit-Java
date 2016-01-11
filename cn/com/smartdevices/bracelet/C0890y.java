package cn.com.smartdevices.bracelet;

import android.content.Context;
import com.xiaomi.hm.health.r;
import java.text.DecimalFormat;
import kankan.wheel.widget.a;
import kankan.wheel.widget.l;

public class C0890y {
    public static float a(Float f) {
        return C0890y.a(f, 0, 1);
    }

    public static float a(Float f, int i, int i2) {
        float floatValue = f.floatValue();
        switch (i) {
            case a.i /*0*/:
                switch (i2) {
                    case a.i /*0*/:
                        return f.floatValue();
                    case l.a /*1*/:
                        return C0890y.c(f);
                    default:
                        return floatValue;
                }
            case l.a /*1*/:
                switch (i2) {
                    case a.i /*0*/:
                        return C0890y.b(f);
                    case l.a /*1*/:
                        return f.floatValue();
                    default:
                        return floatValue;
                }
            default:
                return 0.0f;
        }
    }

    public static int a(int i) {
        return (int) Math.round(0.3937d * ((double) i));
    }

    public static String a(double d, int i) {
        String str = "####";
        if (i < 0) {
            throw new IllegalArgumentException("Accuracy must >= 0");
        }
        if (i > 0) {
            str = str + ".";
            int i2 = 0;
            while (i2 < i) {
                i2++;
                str = str + "#";
            }
        }
        return new DecimalFormat(str).format(d);
    }

    public static String[] a(Context context, Float f, int i) {
        return C0890y.a(context, f, 0, 1, i);
    }

    public static String[] a(Context context, Float f, int i, int i2, int i3) {
        String[] strArr = new String[2];
        float a = C0890y.a(f, i, i2);
        if (i == 0 && i2 == 1) {
            if (a >= Constant.aM) {
                strArr[0] = C0890y.a((double) (a / Constant.aM), i3);
                strArr[1] = context.getString(r.unit_mile);
            } else {
                strArr[0] = String.valueOf(Math.round(a));
                strArr[1] = context.getString(r.unit_foot);
            }
        }
        return strArr;
    }

    public static float b(Float f) {
        return (float) Math.round(0.3048d * ((double) f.floatValue()));
    }

    public static int b(int i) {
        return (int) Math.round(3.2808d * ((double) i));
    }

    public static float c(Float f) {
        return (float) Math.round(3.2808d * ((double) f.floatValue()));
    }

    public static int c(int i) {
        return (int) Math.round(0.6214d * ((double) i));
    }

    public static int d(int i) {
        return i * 12;
    }

    public static int e(int i) {
        return i * 5280;
    }
}
