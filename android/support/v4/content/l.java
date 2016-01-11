package android.support.v4.content;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Build.VERSION;

public class l {
    public static final String a = "android.intent.action.EXTERNAL_APPLICATIONS_AVAILABLE";
    public static final String b = "android.intent.action.EXTERNAL_APPLICATIONS_UNAVAILABLE";
    public static final String c = "android.intent.extra.changed_package_list";
    public static final String d = "android.intent.extra.changed_uid_list";
    public static final String e = "android.intent.extra.HTML_TEXT";
    public static final int f = 16384;
    public static final int g = 32768;
    private static final m h;

    static {
        int i = VERSION.SDK_INT;
        if (i >= 15) {
            h = new p();
        } else if (i >= 11) {
            h = new o();
        } else {
            h = new n();
        }
    }

    private l() {
    }

    public static Intent a(ComponentName componentName) {
        return h.a(componentName);
    }

    public static Intent a(String str, String str2) {
        return h.a(str, str2);
    }

    public static Intent b(ComponentName componentName) {
        return h.b(componentName);
    }
}
