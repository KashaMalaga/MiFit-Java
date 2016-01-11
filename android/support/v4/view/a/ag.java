package android.support.v4.view.a;

import android.view.View;
import android.view.accessibility.AccessibilityRecord;

class ag {
    ag() {
    }

    public static void a(Object obj, View view, int i) {
        ((AccessibilityRecord) obj).setSource(view, i);
    }
}
