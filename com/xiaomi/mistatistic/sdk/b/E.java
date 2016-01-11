package com.xiaomi.mistatistic.sdk.b;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.os.Process;
import android.text.TextUtils;
import com.xiaomi.e.a;

public class E {
    public static String a = null;

    public static int a(Context context, String str, int i) {
        return context.getSharedPreferences(a(context), 0).getInt(str, i);
    }

    public static long a(Context context, String str, long j) {
        return context.getSharedPreferences(a(context), 0).getLong(str, j);
    }

    public static String a(Context context) {
        if (!TextUtils.isEmpty(a)) {
            return a;
        }
        String b = b(context);
        if (TextUtils.equals(b, context.getPackageName())) {
            a = "mistat";
        } else {
            a = "mistat" + r.a(b);
        }
        return a;
    }

    public static String a(Context context, String str, String str2) {
        return context.getSharedPreferences(a(context), 0).getString(str, str2);
    }

    public static boolean a(Context context, String str) {
        return context.getSharedPreferences(a(context), 0).contains(str);
    }

    private static String b(Context context) {
        for (RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
            if (runningAppProcessInfo.pid == Process.myPid()) {
                return runningAppProcessInfo.processName;
            }
        }
        return a.f;
    }

    public static void b(Context context, String str, int i) {
        Editor edit = context.getSharedPreferences(a(context), 0).edit();
        edit.putInt(str, i);
        edit.commit();
    }

    public static void b(Context context, String str, long j) {
        Editor edit = context.getSharedPreferences(a(context), 0).edit();
        edit.putLong(str, j);
        edit.commit();
    }

    public static void b(Context context, String str, String str2) {
        Editor edit = context.getSharedPreferences(a(context), 0).edit();
        edit.putString(str, str2);
        edit.commit();
    }
}
