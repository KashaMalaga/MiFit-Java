package com.b;

import android.content.Context;
import android.util.Log;
import com.xiaomi.e.a;

public final class L {
    private static String a = a.f;

    protected static void a(String str) {
        if (!str.equals("GPS_SATELLITE")) {
        }
    }

    protected static boolean a(Context context) {
        if (context != null) {
            a = context.getPackageName();
            return true;
        }
        Log.d(a, "Error: No SD Card!");
        return false;
    }
}
