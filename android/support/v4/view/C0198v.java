package android.support.v4.view;

import android.graphics.Rect;
import android.os.Build.VERSION;

public class C0198v {
    static final C0199w a;
    public static final int b = 8388608;
    public static final int c = 8388611;
    public static final int d = 8388613;
    public static final int e = 8388615;

    static {
        if (VERSION.SDK_INT >= 17) {
            a = new C0201y();
        } else {
            a = new C0200x();
        }
    }

    public static int a(int i, int i2) {
        return a.a(i, i2);
    }

    public static void a(int i, int i2, int i3, Rect rect, int i4, int i5, Rect rect2, int i6) {
        a.a(i, i2, i3, rect, i4, i5, rect2, i6);
    }

    public static void a(int i, int i2, int i3, Rect rect, Rect rect2, int i4) {
        a.a(i, i2, i3, rect, rect2, i4);
    }

    public static void a(int i, Rect rect, Rect rect2, int i2) {
        a.a(i, rect, rect2, i2);
    }
}
