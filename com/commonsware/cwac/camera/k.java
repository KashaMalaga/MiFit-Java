package com.commonsware.cwac.camera;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import java.util.Locale;

public abstract class k {
    private static volatile k a = null;

    public static synchronized k a(Context context) {
        k kVar;
        synchronized (k.class) {
            if (a == null) {
                if ("motorola".equalsIgnoreCase(Build.MANUFACTURER) && "XT890_rtgb".equals(Build.PRODUCT)) {
                    a = new r();
                } else {
                    int b = b(context);
                    if (b != 0) {
                        a = new q().a(context.getResources().getXml(b));
                    } else {
                        a = new q();
                    }
                }
            }
            kVar = a;
        }
        return kVar;
    }

    private static String a(String str) {
        return str.replaceAll("[\\W]", "_").toLowerCase(Locale.US);
    }

    private static int b(Context context) {
        Resources resources = context.getResources();
        StringBuilder stringBuilder = new StringBuilder("cwac_camera_profile_");
        stringBuilder.append(a(Build.MANUFACTURER));
        int identifier = resources.getIdentifier(stringBuilder.toString(), "xml", context.getPackageName());
        stringBuilder.append("_");
        stringBuilder.append(a(Build.PRODUCT));
        int identifier2 = resources.getIdentifier(stringBuilder.toString(), "xml", context.getPackageName());
        return identifier2 == 0 ? identifier : identifier2;
    }

    private boolean i() {
        return System.getProperty("os.version").contains("cyanogenmod") || Build.HOST.contains("cyanogenmod");
    }

    public abstract boolean a();

    public abstract boolean a(boolean z);

    public abstract boolean b();

    public abstract int c();

    public abstract int d();

    public abstract int e();

    public abstract boolean f();

    public abstract int g();

    public abstract d h();
}
