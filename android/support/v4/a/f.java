package android.support.v4.a;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.pm.ResolveInfo;

class f {
    f() {
    }

    public static boolean a(AccessibilityServiceInfo accessibilityServiceInfo) {
        return accessibilityServiceInfo.getCanRetrieveWindowContent();
    }

    public static String b(AccessibilityServiceInfo accessibilityServiceInfo) {
        return accessibilityServiceInfo.getDescription();
    }

    public static String c(AccessibilityServiceInfo accessibilityServiceInfo) {
        return accessibilityServiceInfo.getId();
    }

    public static ResolveInfo d(AccessibilityServiceInfo accessibilityServiceInfo) {
        return accessibilityServiceInfo.getResolveInfo();
    }

    public static String e(AccessibilityServiceInfo accessibilityServiceInfo) {
        return accessibilityServiceInfo.getSettingsActivityName();
    }
}
