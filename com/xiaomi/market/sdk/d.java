package com.xiaomi.market.sdk;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;
import java.io.File;

public class d {
    private static final String a = "MarketUpdateAgent";
    private static Context b = null;
    private static boolean c = true;
    private static boolean d = false;
    private static boolean e = false;
    private static v f = null;
    private static B g = null;
    private static e h = null;
    private static final int i = 0;
    private static final int j = 1;

    public static int a() {
        return i;
    }

    public static void a(Context context) {
        if (context != null) {
            b = context;
            o.a();
            new y().execute(new Void[i]);
        }
    }

    public static void a(e eVar) {
        h = eVar;
    }

    public static void a(boolean z) {
        c = z;
    }

    static Context b() {
        return b;
    }

    static v b(Context context) {
        PackageInfo packageInfo;
        v a = v.a(context.getPackageName());
        PackageManager packageManager = context.getPackageManager();
        try {
            packageInfo = packageManager.getPackageInfo(a.a, 64);
        } catch (NameNotFoundException e) {
            Log.e(a, "get package info failed");
            packageInfo = null;
        }
        if (packageInfo == null || packageInfo.applicationInfo == null) {
            return null;
        }
        a.b = packageManager.getApplicationLabel(packageInfo.applicationInfo).toString();
        a.c = packageInfo.versionCode;
        a.d = packageInfo.versionName;
        a.e = g.a(String.valueOf(packageInfo.signatures[i].toChars()));
        a.f = packageInfo.applicationInfo.sourceDir;
        a.g = g.a(new File(a.f));
        return a;
    }

    public static void b(boolean z) {
        d = z;
    }
}
