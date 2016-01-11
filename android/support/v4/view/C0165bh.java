package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

public class C0165bh {
    public static final int a = 0;
    public static final int b = 1;
    static final C0166bl c;

    static {
        int i = VERSION.SDK_INT;
        if (i >= 21) {
            c = new C0171bi();
        } else if (i >= 18) {
            c = new C0170bm();
        } else if (i >= 14) {
            c = new C0169bk();
        } else if (i >= 11) {
            c = new C0168bj();
        } else {
            c = new C0167bn();
        }
    }

    private C0165bh() {
    }

    public static int a(ViewGroup viewGroup) {
        return c.b(viewGroup);
    }

    public static void a(ViewGroup viewGroup, int i) {
        c.a(viewGroup, i);
    }

    public static void a(ViewGroup viewGroup, boolean z) {
        c.b(viewGroup, z);
    }

    public static boolean a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return c.a(viewGroup, view, accessibilityEvent);
    }

    public static void b(ViewGroup viewGroup, boolean z) {
        c.a(viewGroup, z);
    }

    public static boolean b(ViewGroup viewGroup) {
        return c.a(viewGroup);
    }
}
