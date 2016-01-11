package android.support.v4.c.a;

import android.graphics.drawable.Drawable;

class h {
    h() {
    }

    public static void a(Drawable drawable, boolean z) {
        drawable.setAutoMirrored(z);
    }

    public static boolean a(Drawable drawable) {
        return drawable.isAutoMirrored();
    }
}
