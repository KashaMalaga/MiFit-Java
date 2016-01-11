package com.xiaomi.mistatistic.sdk;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.provider.Settings.Secure;
import cn.com.smartdevices.bracelet.ui.C0763dl;

public class a {
    private static boolean a = false;
    private static boolean b = false;
    private static Boolean c = null;
    private static boolean d = true;

    public static void a(boolean z) {
        a = z;
    }

    public static boolean a() {
        return a;
    }

    public static boolean a(Context context) {
        boolean z = false;
        if (!d) {
            return false;
        }
        if (c == null) {
            if (c(context) && d(context)) {
                if (!b(context)) {
                    z = true;
                }
                c = Boolean.valueOf(z);
            } else {
                c = Boolean.valueOf(false);
            }
        }
        return c.booleanValue();
    }

    public static void b() {
        b = true;
    }

    private static boolean b(Context context) {
        return Secure.getInt(context.getContentResolver(), "upload_log_pref", 0) > 0;
    }

    public static boolean c() {
        return b;
    }

    private static boolean c(Context context) {
        try {
            context.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 0);
            return true;
        } catch (NameNotFoundException e) {
            return false;
        }
    }

    public static void d() {
        d = false;
    }

    private static boolean d(Context context) {
        String packageName = context.getPackageName();
        return packageName.contains(C0763dl.b) || packageName.contains("xiaomi") || (context.getApplicationInfo().flags & 1) != 0;
    }
}
