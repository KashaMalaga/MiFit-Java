package android.support.v4.view;

import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

class aV {
    aV() {
    }

    public static void a(View view, AccessibilityEvent accessibilityEvent) {
        view.onPopulateAccessibilityEvent(accessibilityEvent);
    }

    public static void a(View view, Object obj) {
        view.setAccessibilityDelegate((AccessibilityDelegate) obj);
    }

    public static boolean a(View view, int i) {
        return view.canScrollHorizontally(i);
    }

    public static void b(View view, AccessibilityEvent accessibilityEvent) {
        view.onInitializeAccessibilityEvent(accessibilityEvent);
    }

    public static void b(View view, Object obj) {
        view.onInitializeAccessibilityNodeInfo((AccessibilityNodeInfo) obj);
    }

    public static boolean b(View view, int i) {
        return view.canScrollVertically(i);
    }
}
