package android.support.v4.view.a;

import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeInfo.CollectionInfo;
import android.view.accessibility.AccessibilityNodeInfo.CollectionItemInfo;

class H {
    H() {
    }

    static int a(Object obj) {
        return ((AccessibilityNodeInfo) obj).getLiveRegion();
    }

    public static Object a(int i, int i2, int i3, int i4, boolean z) {
        return CollectionItemInfo.obtain(i, i2, i3, i4, z);
    }

    public static Object a(int i, int i2, boolean z, int i3) {
        return CollectionInfo.obtain(i, i2, z);
    }

    static void a(Object obj, int i) {
        ((AccessibilityNodeInfo) obj).setLiveRegion(i);
    }

    public static void a(Object obj, Object obj2) {
        ((AccessibilityNodeInfo) obj).setCollectionInfo((CollectionInfo) obj2);
    }

    static Object b(Object obj) {
        return ((AccessibilityNodeInfo) obj).getCollectionInfo();
    }

    public static void b(Object obj, Object obj2) {
        ((AccessibilityNodeInfo) obj).setCollectionItemInfo((CollectionItemInfo) obj2);
    }

    static Object c(Object obj) {
        return ((AccessibilityNodeInfo) obj).getCollectionItemInfo();
    }

    static Object d(Object obj) {
        return ((AccessibilityNodeInfo) obj).getRangeInfo();
    }
}
