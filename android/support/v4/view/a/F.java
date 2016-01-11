package android.support.v4.view.a;

import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;

class F {
    F() {
    }

    public static Object a(View view, int i) {
        return AccessibilityNodeInfo.obtain(view, i);
    }

    public static void a(Object obj, int i) {
        ((AccessibilityNodeInfo) obj).setMovementGranularities(i);
    }

    public static void a(Object obj, View view, int i) {
        ((AccessibilityNodeInfo) obj).addChild(view, i);
    }

    public static void a(Object obj, boolean z) {
        ((AccessibilityNodeInfo) obj).setVisibleToUser(z);
    }

    public static boolean a(Object obj) {
        return ((AccessibilityNodeInfo) obj).isVisibleToUser();
    }

    public static boolean a(Object obj, int i, Bundle bundle) {
        return ((AccessibilityNodeInfo) obj).performAction(i, bundle);
    }

    public static int b(Object obj) {
        return ((AccessibilityNodeInfo) obj).getMovementGranularities();
    }

    public static Object b(Object obj, int i) {
        return ((AccessibilityNodeInfo) obj).findFocus(i);
    }

    public static void b(Object obj, View view, int i) {
        ((AccessibilityNodeInfo) obj).setSource(view, i);
    }

    public static void b(Object obj, boolean z) {
        ((AccessibilityNodeInfo) obj).setAccessibilityFocused(z);
    }

    public static Object c(Object obj, int i) {
        return ((AccessibilityNodeInfo) obj).focusSearch(i);
    }

    public static void c(Object obj, View view, int i) {
        ((AccessibilityNodeInfo) obj).setParent(view, i);
    }

    public static boolean c(Object obj) {
        return ((AccessibilityNodeInfo) obj).isAccessibilityFocused();
    }
}
