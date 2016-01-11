package android.support.v4.view.a;

import android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener;

final class C0112m implements AccessibilityStateChangeListener {
    final /* synthetic */ C0108n a;

    C0112m(C0108n c0108n) {
        this.a = c0108n;
    }

    public void onAccessibilityStateChanged(boolean z) {
        this.a.a(z);
    }
}
