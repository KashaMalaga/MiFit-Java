package android.support.v4.c;

import android.graphics.Bitmap;

class h {
    h() {
    }

    public static void a(Bitmap bitmap, boolean z) {
        bitmap.setHasMipMap(z);
    }

    public static boolean a(Bitmap bitmap) {
        return bitmap.hasMipMap();
    }
}
