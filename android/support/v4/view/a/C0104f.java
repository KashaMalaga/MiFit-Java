package android.support.v4.view.a;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.os.Build.VERSION;
import android.view.accessibility.AccessibilityManager;
import java.util.List;

public class C0104f {
    private static final C0105j a;

    static {
        if (VERSION.SDK_INT >= 14) {
            a = new C0107g();
        } else {
            a = new C0106i();
        }
    }

    public static List<AccessibilityServiceInfo> a(AccessibilityManager accessibilityManager) {
        return a.a(accessibilityManager);
    }

    public static List<AccessibilityServiceInfo> a(AccessibilityManager accessibilityManager, int i) {
        return a.a(accessibilityManager, i);
    }

    public static boolean a(AccessibilityManager accessibilityManager, C0110k c0110k) {
        return a.a(accessibilityManager, c0110k);
    }

    public static boolean b(AccessibilityManager accessibilityManager) {
        return a.b(accessibilityManager);
    }

    public static boolean b(AccessibilityManager accessibilityManager, C0110k c0110k) {
        return a.b(accessibilityManager, c0110k);
    }
}
