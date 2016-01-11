package com.f.a.c;

import android.util.Log;
import com.f.a.b.g;

public final class f {
    private static final String a = "%1$s\n%2$s";
    private static volatile boolean b = false;
    private static volatile boolean c = true;

    private f() {
    }

    @Deprecated
    public static void a() {
        b(true);
    }

    private static void a(int i, Throwable th, String str, Object... objArr) {
        if (c) {
            String format = objArr.length > 0 ? String.format(str, objArr) : str;
            if (th != null) {
                if (format == null) {
                    format = th.getMessage();
                }
                String stackTraceString = Log.getStackTraceString(th);
                format = String.format(a, new Object[]{format, stackTraceString});
            }
            Log.println(i, g.a, format);
        }
    }

    public static void a(String str, Object... objArr) {
        if (b) {
            a(3, null, str, objArr);
        }
    }

    public static void a(Throwable th) {
        a(6, th, null, new Object[0]);
    }

    public static void a(Throwable th, String str, Object... objArr) {
        a(6, th, str, objArr);
    }

    public static void a(boolean z) {
        b = z;
    }

    @Deprecated
    public static void b() {
        b(false);
    }

    public static void b(String str, Object... objArr) {
        a(4, null, str, objArr);
    }

    public static void b(boolean z) {
        c = z;
    }

    public static void c(String str, Object... objArr) {
        a(5, null, str, objArr);
    }

    public static void d(String str, Object... objArr) {
        a(6, null, str, objArr);
    }
}
