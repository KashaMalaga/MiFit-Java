package android.support.v4.view.a;

import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction;
import android.view.accessibility.AccessibilityNodeInfo.CollectionInfo;
import android.view.accessibility.AccessibilityNodeInfo.CollectionItemInfo;
import java.util.List;

class B {
    B() {
    }

    public static Object a(int i, int i2, int i3, int i4, boolean z, boolean z2) {
        return CollectionItemInfo.obtain(i, i2, i3, i4, z, z2);
    }

    public static Object a(int i, int i2, boolean z, int i3) {
        return CollectionInfo.obtain(i, i2, z, i3);
    }

    static List<Object> a(Object obj) {
        return ((AccessibilityNodeInfo) obj).getActionList();
    }

    static void a(Object obj, int i, CharSequence charSequence) {
        ((AccessibilityNodeInfo) obj).addAction(new AccessibilityAction(i, charSequence));
    }
}
