package android.support.v4.a;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.pm.ResolveInfo;
import android.os.Build.VERSION;

public class a {
    public static final int a = 1;
    public static final int b = 2;
    public static final int c = 4;
    public static final int d = 8;
    public static final int e = 32;
    public static final int f = -1;
    public static final int g = 1;
    public static final int h = 2;
    public static final int i = 4;
    public static final int j = 8;
    public static final int k = 16;
    public static final int l = 32;
    private static final e m;

    static {
        if (VERSION.SDK_INT >= 18) {
            m = new c();
        } else if (VERSION.SDK_INT >= 14) {
            m = new b();
        } else {
            m = new d();
        }
    }

    private a() {
    }

    public static String a(int i) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        while (i > 0) {
            int numberOfTrailingZeros = g << Integer.numberOfTrailingZeros(i);
            i &= numberOfTrailingZeros ^ f;
            if (stringBuilder.length() > g) {
                stringBuilder.append(", ");
            }
            switch (numberOfTrailingZeros) {
                case g /*1*/:
                    stringBuilder.append("FEEDBACK_SPOKEN");
                    break;
                case h /*2*/:
                    stringBuilder.append("FEEDBACK_HAPTIC");
                    break;
                case i /*4*/:
                    stringBuilder.append("FEEDBACK_AUDIBLE");
                    break;
                case j /*8*/:
                    stringBuilder.append("FEEDBACK_VISUAL");
                    break;
                case k /*16*/:
                    stringBuilder.append("FEEDBACK_GENERIC");
                    break;
                default:
                    break;
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public static String a(AccessibilityServiceInfo accessibilityServiceInfo) {
        return m.c(accessibilityServiceInfo);
    }

    public static ResolveInfo b(AccessibilityServiceInfo accessibilityServiceInfo) {
        return m.d(accessibilityServiceInfo);
    }

    public static String b(int i) {
        switch (i) {
            case g /*1*/:
                return "DEFAULT";
            case h /*2*/:
                return "FLAG_INCLUDE_NOT_IMPORTANT_VIEWS";
            case i /*4*/:
                return "FLAG_REQUEST_TOUCH_EXPLORATION_MODE";
            case j /*8*/:
                return "FLAG_REQUEST_ENHANCED_WEB_ACCESSIBILITY";
            case k /*16*/:
                return "FLAG_REPORT_VIEW_IDS";
            case l /*32*/:
                return "FLAG_REQUEST_FILTER_KEY_EVENTS";
            default:
                return null;
        }
    }

    public static String c(int i) {
        switch (i) {
            case g /*1*/:
                return "CAPABILITY_CAN_RETRIEVE_WINDOW_CONTENT";
            case h /*2*/:
                return "CAPABILITY_CAN_REQUEST_TOUCH_EXPLORATION";
            case i /*4*/:
                return "CAPABILITY_CAN_REQUEST_ENHANCED_WEB_ACCESSIBILITY";
            case j /*8*/:
                return "CAPABILITY_CAN_FILTER_KEY_EVENTS";
            default:
                return "UNKNOWN";
        }
    }

    public static String c(AccessibilityServiceInfo accessibilityServiceInfo) {
        return m.e(accessibilityServiceInfo);
    }

    public static boolean d(AccessibilityServiceInfo accessibilityServiceInfo) {
        return m.a(accessibilityServiceInfo);
    }

    public static String e(AccessibilityServiceInfo accessibilityServiceInfo) {
        return m.b(accessibilityServiceInfo);
    }

    public static int f(AccessibilityServiceInfo accessibilityServiceInfo) {
        return m.f(accessibilityServiceInfo);
    }
}
