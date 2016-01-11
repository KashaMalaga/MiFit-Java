package android.support.v4.view.a;

import android.view.accessibility.AccessibilityNodeInfo;

class G {
    G() {
    }

    public static String a(Object obj) {
        return ((AccessibilityNodeInfo) obj).getViewIdResourceName();
    }

    public static void a(Object obj, String str) {
        ((AccessibilityNodeInfo) obj).setViewIdResourceName(str);
    }
}
