package com.edmodo.cropper.a;

import android.content.Context;
import android.util.Pair;
import android.util.TypedValue;
import cn.com.smartdevices.bracelet.weight.aA;
import com.edmodo.cropper.cropwindow.CropOverlayView;
import com.edmodo.cropper.cropwindow.b.c;
import kankan.wheel.widget.a;
import kankan.wheel.widget.l;

public class b {
    private static final int a = 24;

    public static float a(Context context) {
        return TypedValue.applyDimension(1, aA.h, context.getResources().getDisplayMetrics());
    }

    public static Pair<Float, Float> a(c cVar, float f, float f2, float f3, float f4, float f5, float f6) {
        float f7 = 0.0f;
        if (cVar == null) {
            return null;
        }
        float f8;
        switch (c.a[cVar.ordinal()]) {
            case l.a /*1*/:
                f8 = f3 - f;
                f7 = f4 - f2;
                break;
            case a.k /*2*/:
                f8 = f5 - f;
                f7 = f4 - f2;
                break;
            case a.l /*3*/:
                f8 = f3 - f;
                f7 = f6 - f2;
                break;
            case a.aQ /*4*/:
                f8 = f5 - f;
                f7 = f6 - f2;
                break;
            case a.X /*5*/:
                f8 = f3 - f;
                break;
            case a.bt /*6*/:
                f8 = 0.0f;
                f7 = f4 - f2;
                break;
            case a.bc /*7*/:
                f8 = f5 - f;
                break;
            case a.ba /*8*/:
                f8 = 0.0f;
                f7 = f6 - f2;
                break;
            case a.bo /*9*/:
                f8 = ((f5 + f3) / 2.0f) - f;
                f7 = ((f4 + f6) / 2.0f) - f2;
                break;
            default:
                f8 = 0.0f;
                break;
        }
        return new Pair(Float.valueOf(f8), Float.valueOf(f7));
    }

    public static c a(float f, float f2, float f3, float f4, float f5, float f6, float f7) {
        return a(f, f2, f3, f4, f7) ? c.TOP_LEFT : a(f, f2, f5, f4, f7) ? c.TOP_RIGHT : a(f, f2, f3, f6, f7) ? c.BOTTOM_LEFT : a(f, f2, f5, f6, f7) ? c.BOTTOM_RIGHT : (c(f, f2, f3, f4, f5, f6) && a()) ? c.CENTER : a(f, f2, f3, f5, f4, f7) ? c.TOP : a(f, f2, f3, f5, f6, f7) ? c.BOTTOM : b(f, f2, f3, f4, f6, f7) ? c.LEFT : b(f, f2, f5, f4, f6, f7) ? c.RIGHT : (!c(f, f2, f3, f4, f5, f6) || a()) ? null : c.CENTER;
    }

    private static boolean a() {
        return !CropOverlayView.b();
    }

    private static boolean a(float f, float f2, float f3, float f4, float f5) {
        return Math.abs(f - f3) <= f5 && Math.abs(f2 - f4) <= f5;
    }

    private static boolean a(float f, float f2, float f3, float f4, float f5, float f6) {
        return f > f3 && f < f4 && Math.abs(f2 - f5) <= f6;
    }

    private static boolean b(float f, float f2, float f3, float f4, float f5, float f6) {
        return Math.abs(f - f3) <= f6 && f2 > f4 && f2 < f5;
    }

    private static boolean c(float f, float f2, float f3, float f4, float f5, float f6) {
        return f > f3 && f < f5 && f2 > f4 && f2 < f6;
    }
}
