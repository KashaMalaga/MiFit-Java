package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.ViewConfiguration;

public class aZ {
    static final C0158be a;

    static {
        if (VERSION.SDK_INT >= 14) {
            a = new C0162bd();
        } else if (VERSION.SDK_INT >= 11) {
            a = new C0161bc();
        } else if (VERSION.SDK_INT >= 8) {
            a = new C0160bb();
        } else {
            a = new C0159ba();
        }
    }

    public static int a(ViewConfiguration viewConfiguration) {
        return a.a(viewConfiguration);
    }

    public static boolean b(ViewConfiguration viewConfiguration) {
        return a.b(viewConfiguration);
    }
}
