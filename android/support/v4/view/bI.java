package android.support.v4.view;

import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;

class bI implements bH {
    bI() {
    }

    public boolean a(ViewParent viewParent, View view, AccessibilityEvent accessibilityEvent) {
        if (view == null) {
            return false;
        }
        ((AccessibilityManager) view.getContext().getSystemService("accessibility")).sendAccessibilityEvent(accessibilityEvent);
        return true;
    }
}
