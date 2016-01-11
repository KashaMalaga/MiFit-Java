package android.support.v4.view.a;

import android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction;

class C {
    C() {
    }

    static int a(Object obj) {
        return ((AccessibilityAction) obj).getId();
    }

    static CharSequence b(Object obj) {
        return ((AccessibilityAction) obj).getLabel();
    }
}
