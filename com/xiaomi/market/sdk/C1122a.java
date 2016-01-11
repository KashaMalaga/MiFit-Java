package com.xiaomi.market.sdk;

import android.util.Log;

public class C1122a {
    private static final String a = "MarketPatcher";
    private static final String b = "sdk_patcher_jni";

    public static int a(String str, String str2, String str3) {
        return new C1122a().b(str, str2, str3);
    }

    public static boolean a() {
        try {
            System.loadLibrary(b);
            return true;
        } catch (Throwable th) {
            Log.e(a, "load patcher library failed : " + th.toString());
            return false;
        }
    }

    public native int b(String str, String str2, String str3);
}
