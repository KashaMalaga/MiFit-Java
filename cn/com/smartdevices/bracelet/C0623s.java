package cn.com.smartdevices.bracelet;

import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.support.v4.view.a.C0113o;

public final class C0623s {
    private static final String a = "DeviceCompatibility";

    private C0623s() {
    }

    public static boolean a() {
        return VERSION.SDK_INT >= 21;
    }

    public static boolean a(Context context) {
        C0596r.e(a, "Is Support SmartLock?");
        boolean b = C0667t.b(context);
        C0596r.e(a, "Is Not MIUI : " + b);
        if (!b) {
            return false;
        }
        boolean z = (VERSION.SDK_INT >= 21 ? 1 : 0) & b;
        C0596r.e(a, "Is Lolipop(or above) : " + z);
        if (!z) {
            return false;
        }
        boolean a = C0623s.a(context, "com.google.android.gms", ".auth.trustagent.GoogleTrustAgentPersonalUnlockingSettings") & z;
        C0596r.e(a, "Is SmartLock Activity Is Exists : " + a);
        return a;
    }

    public static boolean a(Context context, String str, String str2) {
        Intent intent = new Intent();
        intent.setClassName(str, str + str2);
        return context.getPackageManager().resolveActivity(intent, C0113o.q) != null;
    }

    public static boolean b(Context context) {
        return C0667t.c(context) | C0623s.a(context);
    }
}
