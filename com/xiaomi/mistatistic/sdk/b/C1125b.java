package com.xiaomi.mistatistic.sdk.b;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.support.v4.view.a.C0113o;

public abstract class C1125b {
    private static Context a;
    private static String b;
    private static String c;
    private static String d;

    public static Context a() {
        return a;
    }

    public static void a(Context context, String str, String str2, String str3) {
        a = context.getApplicationContext();
        b = str;
        c = str2;
        d = str3;
    }

    public static String b() {
        return b;
    }

    public static String c() {
        return c;
    }

    public static String d() {
        return d;
    }

    public static String e() {
        try {
            PackageInfo packageInfo = a.getPackageManager().getPackageInfo(a.getPackageName(), C0113o.o);
            if (packageInfo != null) {
                return packageInfo.versionName;
            }
        } catch (NameNotFoundException e) {
        }
        return null;
    }
}
