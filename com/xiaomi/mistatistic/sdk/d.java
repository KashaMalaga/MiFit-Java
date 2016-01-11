package com.xiaomi.mistatistic.sdk;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.mistatistic.sdk.b.A;
import com.xiaomi.mistatistic.sdk.b.C1125b;
import com.xiaomi.mistatistic.sdk.b.C1128e;
import com.xiaomi.mistatistic.sdk.b.F;
import com.xiaomi.mistatistic.sdk.b.J;
import com.xiaomi.mistatistic.sdk.b.a.a;
import com.xiaomi.mistatistic.sdk.b.m;
import com.xiaomi.mistatistic.sdk.b.r;
import com.xiaomi.mistatistic.sdk.b.t;
import com.xiaomi.mistatistic.sdk.b.y;
import com.xiaomi.mistatistic.sdk.c.c;
import com.xiaomi.mistatistic.sdk.c.e;
import com.xiaomi.mistatistic.sdk.c.f;
import java.util.Map;

public abstract class d {
    public static final int a = 0;
    public static final int b = 1;
    public static final int c = 2;
    public static final int d = 3;
    public static final int e = 4;
    public static final int f = 5;
    public static final long g = 60000;
    public static final long h = 86400000;
    private static boolean i = false;
    private static final String j = "default_category";

    public static final String a(Context context) {
        return r.a(context);
    }

    public static final void a() {
        A.a();
    }

    public static final void a(int i, long j) {
        f();
        if (i != e || (j >= g && j <= h)) {
            C1128e.a().a(i, j);
            return;
        }
        throw new IllegalArgumentException("interval should be set between 5 minutes and 1 day");
    }

    public static final void a(Activity activity, String str) {
        f();
        J.a().a((Context) activity, str);
        m.a().a(new a());
    }

    public static final void a(Context context, String str) {
        f();
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("pageName should't be null");
        }
        J.a().a(context, str);
        m.a().a(new a());
    }

    public static final void a(Context context, String str, String str2, String str3) {
        a(context, str, str2, str3, true);
    }

    public static final void a(Context context, String str, String str2, String str3, boolean z) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException("appID or appKey is empty.");
        }
        Context applicationContext = context.getApplicationContext();
        if (TextUtils.isEmpty(str3)) {
            str3 = "mistats_default";
        }
        C1125b.a(applicationContext, str, str2, str3);
        t.a();
        new r().a();
        C1128e.a().b();
        i = true;
        if (z) {
            e.a();
        }
    }

    public static final void a(String str, String str2) {
        a(str, str2, null);
    }

    public static final void a(String str, String str2, long j) {
        a(str, str2, j, null);
    }

    public static final void a(String str, String str2, long j, Map map) {
        f();
        b(str, str2);
        y.a(new c(TextUtils.isEmpty(str) ? j : str, str2, j, map));
    }

    public static final void a(String str, String str2, String str3) {
        f();
        b(str, str2);
        if (TextUtils.isEmpty(str)) {
            str = j;
        }
        y.a(new f(str, str2, str3));
    }

    public static final void a(String str, String str2, Map map) {
        f();
        b(str, str2);
        if (TextUtils.isEmpty(str)) {
            str = j;
        }
        y.a(new com.xiaomi.mistatistic.sdk.c.d(str, str2, map));
    }

    public static void a(boolean z) {
        if (!d()) {
            f.a(false);
        }
        f.a(z ? c : d);
    }

    public static final void b() {
        f();
        J.a().b();
    }

    private static void b(String str, String str2) {
        if (!TextUtils.isEmpty(str) && str.startsWith("mistat_")) {
            throw new IllegalArgumentException("category cannot start with mistat_");
        } else if (!TextUtils.isEmpty(str2) && str2.startsWith("mistat_")) {
            throw new IllegalArgumentException("key cannot start with mistat_");
        }
    }

    public static final void b(String str, String str2, long j) {
        f();
        b(str, str2);
        if (TextUtils.isEmpty(str)) {
            str = j;
        }
        y.a(new e(str, str2, j));
    }

    private static boolean b(Context context) {
        try {
            return (context.getApplicationInfo().flags & c) != 0;
        } catch (Exception e) {
            return false;
        }
    }

    public static final void c() {
        f();
        new F().a();
    }

    public static boolean d() {
        return f.d() != b;
    }

    public static boolean e() {
        return f.d() == c;
    }

    private static void f() {
        if (!i) {
            throw new IllegalStateException("not initialized, do you forget to call initialize when application started?");
        }
    }

    private static void g() {
        new A().a("log event without pageStart/pageEnd, ignore.");
        if (b(C1125b.a())) {
            throw new RuntimeException("record pageStart/pageEnd before recording events.");
        }
    }
}
