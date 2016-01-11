package android.support.v4.view.a;

import android.view.accessibility.AccessibilityNodeInfo.RangeInfo;

class K {
    K() {
    }

    static float a(Object obj) {
        return ((RangeInfo) obj).getCurrent();
    }

    static float b(Object obj) {
        return ((RangeInfo) obj).getMax();
    }

    static float c(Object obj) {
        return ((RangeInfo) obj).getMin();
    }

    static int d(Object obj) {
        return ((RangeInfo) obj).getType();
    }
}
