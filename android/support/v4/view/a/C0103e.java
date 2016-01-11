package android.support.v4.view.a;

import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityRecord;

class C0103e {
    C0103e() {
    }

    public static int a(AccessibilityEvent accessibilityEvent) {
        return accessibilityEvent.getRecordCount();
    }

    public static Object a(AccessibilityEvent accessibilityEvent, int i) {
        return accessibilityEvent.getRecord(i);
    }

    public static void a(AccessibilityEvent accessibilityEvent, Object obj) {
        accessibilityEvent.appendRecord((AccessibilityRecord) obj);
    }

    public static void a(AccessibilityEvent accessibilityEvent, boolean z) {
        accessibilityEvent.setScrollable(z);
    }
}
