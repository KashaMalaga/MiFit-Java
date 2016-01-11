package android.support.v4.c;

import android.graphics.Bitmap;
import android.os.Build.VERSION;

public class a {
    static final c a;

    static {
        int i = VERSION.SDK_INT;
        if (i >= 19) {
            a = new f();
        } else if (i >= 18) {
            a = new e();
        } else if (i >= 12) {
            a = new d();
        } else {
            a = new b();
        }
    }

    public static void a(Bitmap bitmap, boolean z) {
        a.a(bitmap, z);
    }

    public static boolean a(Bitmap bitmap) {
        return a.a(bitmap);
    }

    public static int b(Bitmap bitmap) {
        return a.b(bitmap);
    }
}
