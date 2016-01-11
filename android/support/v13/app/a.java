package android.support.v13.app;

import android.app.Fragment;
import android.os.Build.VERSION;

public class a {
    static final c a;

    static {
        if (VERSION.SDK_INT >= 15) {
            a = new e();
        } else if (VERSION.SDK_INT >= 14) {
            a = new d();
        } else {
            a = new b();
        }
    }

    public static void a(Fragment fragment, boolean z) {
        a.a(fragment, z);
    }

    public static void b(Fragment fragment, boolean z) {
        a.b(fragment, z);
    }
}
