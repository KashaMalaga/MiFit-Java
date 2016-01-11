package android.support.v4.view.a;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.view.accessibility.AccessibilityManager;
import java.util.List;

class C0107g extends C0106i {
    C0107g() {
    }

    public Object a(C0110k c0110k) {
        return C0111l.a(new C0109h(this, c0110k));
    }

    public List<AccessibilityServiceInfo> a(AccessibilityManager accessibilityManager) {
        return C0111l.a(accessibilityManager);
    }

    public List<AccessibilityServiceInfo> a(AccessibilityManager accessibilityManager, int i) {
        return C0111l.a(accessibilityManager, i);
    }

    public boolean a(AccessibilityManager accessibilityManager, C0110k c0110k) {
        return C0111l.a(accessibilityManager, c0110k.a);
    }

    public boolean b(AccessibilityManager accessibilityManager) {
        return C0111l.b(accessibilityManager);
    }

    public boolean b(AccessibilityManager accessibilityManager, C0110k c0110k) {
        return C0111l.b(accessibilityManager, c0110k.a);
    }
}
