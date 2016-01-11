package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;

public class bF {
    static final bH a;

    static {
        if (VERSION.SDK_INT >= 14) {
            a = new bG();
        } else {
            a = new bI();
        }
    }

    private bF() {
    }

    public static boolean a(ViewParent viewParent, View view, AccessibilityEvent accessibilityEvent) {
        return a.a(viewParent, view, accessibilityEvent);
    }
}
