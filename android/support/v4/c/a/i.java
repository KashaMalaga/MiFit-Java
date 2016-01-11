package android.support.v4.c.a;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;

class i {
    i() {
    }

    public static void a(Drawable drawable, float f, float f2) {
        drawable.setHotspot(f, f2);
    }

    public static void a(Drawable drawable, int i) {
        drawable.setTint(i);
    }

    public static void a(Drawable drawable, int i, int i2, int i3, int i4) {
        drawable.setHotspotBounds(i, i2, i3, i4);
    }

    public static void a(Drawable drawable, ColorStateList colorStateList) {
        drawable.setTintList(colorStateList);
    }

    public static void a(Drawable drawable, Mode mode) {
        drawable.setTintMode(mode);
    }
}
