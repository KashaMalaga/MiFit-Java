package com.activeandroid.d;

import android.util.Log;
import kankan.wheel.widget.a;

public final class b {
    private static String a = "ActiveAndroid";
    private static boolean b = false;

    private b() {
    }

    public static int a(String str) {
        return b ? Log.v(a, str) : 0;
    }

    public static int a(String str, String str2) {
        return b ? Log.v(str, str2) : 0;
    }

    public static int a(String str, String str2, Throwable th) {
        return b ? Log.v(str, str2, th) : 0;
    }

    public static int a(String str, Throwable th) {
        return b ? Log.v(a, str, th) : 0;
    }

    public static int a(String str, Object... objArr) {
        return b ? Log.v(a.ah, String.format(str, objArr)) : 0;
    }

    public static void a(boolean z) {
        b = z;
    }

    public static boolean a() {
        return b;
    }

    public static int b(String str) {
        return b ? Log.d(a, str) : 0;
    }

    public static int b(String str, String str2) {
        return b ? Log.d(str, str2) : 0;
    }

    public static int b(String str, String str2, Throwable th) {
        return b ? Log.d(str, str2, th) : 0;
    }

    public static int b(String str, Throwable th) {
        return b ? Log.d(a, str, th) : 0;
    }

    public static boolean b() {
        return b;
    }

    public static int c(String str) {
        return b ? Log.i(a, str) : 0;
    }

    public static int c(String str, String str2) {
        return b ? Log.i(str, str2) : 0;
    }

    public static int c(String str, String str2, Throwable th) {
        return b ? Log.i(str, str2, th) : 0;
    }

    public static int c(String str, Throwable th) {
        return b ? Log.i(a, str, th) : 0;
    }

    public static int d(String str) {
        return b ? Log.w(a, str) : 0;
    }

    public static int d(String str, String str2) {
        return b ? Log.w(str, str2) : 0;
    }

    public static int d(String str, String str2, Throwable th) {
        return b ? Log.w(str, str2, th) : 0;
    }

    public static int d(String str, Throwable th) {
        return b ? Log.w(a, str, th) : 0;
    }

    public static int e(String str) {
        return b ? Log.e(a, str) : 0;
    }

    public static int e(String str, String str2) {
        return b ? Log.e(str, str2) : 0;
    }

    public static int e(String str, String str2, Throwable th) {
        return b ? Log.e(str, str2, th) : 0;
    }

    public static int e(String str, Throwable th) {
        return b ? Log.e(a, str, th) : 0;
    }
}
