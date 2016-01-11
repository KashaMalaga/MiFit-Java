package com.huami.android.bitmapfun;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy.Builder;
import android.os.StrictMode.VmPolicy;

public class E {
    private E() {
    }

    @TargetApi(11)
    public static void a(Class cls) {
        if (b()) {
            Builder penaltyLog = new Builder().detectAll().penaltyLog();
            VmPolicy.Builder penaltyLog2 = new VmPolicy.Builder().detectAll().penaltyLog();
            if (c()) {
                penaltyLog.penaltyFlashScreen();
                penaltyLog2.setClassInstanceLimit(cls, 1);
            }
            StrictMode.setThreadPolicy(penaltyLog.build());
            StrictMode.setVmPolicy(penaltyLog2.build());
        }
    }

    public static boolean a() {
        return VERSION.SDK_INT >= 8;
    }

    public static boolean b() {
        return VERSION.SDK_INT >= 9;
    }

    public static boolean c() {
        return VERSION.SDK_INT >= 11;
    }

    public static boolean d() {
        return VERSION.SDK_INT >= 12;
    }

    public static boolean e() {
        return VERSION.SDK_INT >= 16;
    }

    public static boolean f() {
        return VERSION.SDK_INT >= 19;
    }
}
