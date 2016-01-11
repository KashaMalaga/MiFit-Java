package android.support.v4.view;

import android.os.Build.VERSION;

public class C0140ao {
    static final C0142as a;

    static {
        if (VERSION.SDK_INT >= 19) {
            a = new C0144ar();
        } else {
            a = new C0143aq();
        }
    }

    private C0140ao() {
    }

    public static void a(Object obj, boolean z) {
        a.a(obj, z);
    }

    public static boolean a(Object obj) {
        return a.a(obj);
    }
}
