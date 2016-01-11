package android.support.v4.view.a;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener;
import java.util.List;

class C0111l {
    C0111l() {
    }

    public static Object a(C0108n c0108n) {
        return new C0112m(c0108n);
    }

    public static List<AccessibilityServiceInfo> a(AccessibilityManager accessibilityManager) {
        return accessibilityManager.getInstalledAccessibilityServiceList();
    }

    public static List<AccessibilityServiceInfo> a(AccessibilityManager accessibilityManager, int i) {
        return accessibilityManager.getEnabledAccessibilityServiceList(i);
    }

    public static boolean a(AccessibilityManager accessibilityManager, Object obj) {
        return accessibilityManager.addAccessibilityStateChangeListener((AccessibilityStateChangeListener) obj);
    }

    public static boolean b(AccessibilityManager accessibilityManager) {
        return accessibilityManager.isTouchExplorationEnabled();
    }

    public static boolean b(AccessibilityManager accessibilityManager, Object obj) {
        return accessibilityManager.removeAccessibilityStateChangeListener((AccessibilityStateChangeListener) obj);
    }
}
