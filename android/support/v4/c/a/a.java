package android.support.v4.c.a;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;

public class a {
    static final c a;

    static {
        int i = VERSION.SDK_INT;
        if (i >= 21) {
            a = new f();
        } else if (i >= 19) {
            a = new e();
        } else if (i >= 11) {
            a = new d();
        } else {
            a = new b();
        }
    }

    public static void a(Drawable drawable) {
        a.a(drawable);
    }

    public static void a(Drawable drawable, float f, float f2) {
        a.a(drawable, f, f2);
    }

    public static void a(Drawable drawable, int i) {
        a.a(drawable, i);
    }

    public static void a(Drawable drawable, int i, int i2, int i3, int i4) {
        a.a(drawable, i, i2, i3, i4);
    }

    public static void a(Drawable drawable, ColorStateList colorStateList) {
        a.a(drawable, colorStateList);
    }

    public static void a(Drawable drawable, Mode mode) {
        a.a(drawable, mode);
    }

    public static void a(Drawable drawable, boolean z) {
        a.a(drawable, z);
    }

    public static boolean b(Drawable drawable) {
        return a.b(drawable);
    }
}
