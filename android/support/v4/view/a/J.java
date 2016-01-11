package android.support.v4.view.a;

import android.view.accessibility.AccessibilityNodeInfo.CollectionItemInfo;

class J {
    J() {
    }

    static int a(Object obj) {
        return ((CollectionItemInfo) obj).getColumnIndex();
    }

    static int b(Object obj) {
        return ((CollectionItemInfo) obj).getColumnSpan();
    }

    static int c(Object obj) {
        return ((CollectionItemInfo) obj).getRowIndex();
    }

    static int d(Object obj) {
        return ((CollectionItemInfo) obj).getRowSpan();
    }

    static boolean e(Object obj) {
        return ((CollectionItemInfo) obj).isHeading();
    }
}
