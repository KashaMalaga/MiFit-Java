package android.support.v4.view.a;

import android.view.accessibility.AccessibilityRecord;

class af {
    af() {
    }

    public static int a(Object obj) {
        return ((AccessibilityRecord) obj).getMaxScrollX();
    }

    public static void a(Object obj, int i) {
        ((AccessibilityRecord) obj).setMaxScrollX(i);
    }

    public static int b(Object obj) {
        return ((AccessibilityRecord) obj).getMaxScrollY();
    }

    public static void b(Object obj, int i) {
        ((AccessibilityRecord) obj).setMaxScrollY(i);
    }
}
