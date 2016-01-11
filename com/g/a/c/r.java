package com.g.a.c;

import android.util.Log;

public class r {
    public static void a(String str, String str2) {
        if (u.v) {
            Log.i(str, str2);
        }
    }

    public static void a(String str, String str2, Exception exception) {
        if (u.v) {
            Log.i(str, exception.toString() + ":  [" + str2 + "]");
        }
    }

    public static void b(String str, String str2) {
        if (u.v) {
            Log.e(str, str2);
        }
    }

    public static void b(String str, String str2, Exception exception) {
        if (u.v) {
            Log.e(str, exception.toString() + ":  [" + str2 + "]");
            for (StackTraceElement stackTraceElement : exception.getStackTrace()) {
                Log.e(str, "        at\t " + stackTraceElement.toString());
            }
        }
    }

    public static void c(String str, String str2) {
        if (u.v) {
            Log.d(str, str2);
        }
    }

    public static void c(String str, String str2, Exception exception) {
        if (u.v) {
            Log.d(str, exception.toString() + ":  [" + str2 + "]");
        }
    }

    public static void d(String str, String str2) {
        if (u.v) {
            Log.v(str, str2);
        }
    }

    public static void d(String str, String str2, Exception exception) {
        if (u.v) {
            Log.v(str, exception.toString() + ":  [" + str2 + "]");
        }
    }

    public static void e(String str, String str2) {
        if (u.v) {
            Log.w(str, str2);
        }
    }

    public static void e(String str, String str2, Exception exception) {
        if (u.v) {
            Log.w(str, exception.toString() + ":  [" + str2 + "]");
            for (StackTraceElement stackTraceElement : exception.getStackTrace()) {
                Log.w(str, "        at\t " + stackTraceElement.toString());
            }
        }
    }
}
