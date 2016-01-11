package android.support.v4.a;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.pm.ResolveInfo;

class b extends d {
    b() {
    }

    public boolean a(AccessibilityServiceInfo accessibilityServiceInfo) {
        return f.a(accessibilityServiceInfo);
    }

    public String b(AccessibilityServiceInfo accessibilityServiceInfo) {
        return f.b(accessibilityServiceInfo);
    }

    public String c(AccessibilityServiceInfo accessibilityServiceInfo) {
        return f.c(accessibilityServiceInfo);
    }

    public ResolveInfo d(AccessibilityServiceInfo accessibilityServiceInfo) {
        return f.d(accessibilityServiceInfo);
    }

    public String e(AccessibilityServiceInfo accessibilityServiceInfo) {
        return f.e(accessibilityServiceInfo);
    }

    public int f(AccessibilityServiceInfo accessibilityServiceInfo) {
        return a(accessibilityServiceInfo) ? 1 : 0;
    }
}
