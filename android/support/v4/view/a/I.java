package android.support.v4.view.a;

import android.view.accessibility.AccessibilityNodeInfo.CollectionInfo;

class I {
    I() {
    }

    static int a(Object obj) {
        return ((CollectionInfo) obj).getColumnCount();
    }

    static int b(Object obj) {
        return ((CollectionInfo) obj).getRowCount();
    }

    static boolean c(Object obj) {
        return ((CollectionInfo) obj).isHierarchical();
    }
}
