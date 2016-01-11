package com.xiaomi.mistatistic.sdk.b;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.xiaomi.e.a;
import com.xiaomi.mipush.sdk.f;
import com.xiaomi.mistatistic.sdk.c.g;
import com.xiaomi.mistatistic.sdk.c.h;

public class J {
    private static J a;
    private static long c = 30000;
    private Handler b = new K(this, Looper.getMainLooper());

    private J() {
    }

    public static J a() {
        if (a == null) {
            a = new J();
        }
        return a;
    }

    private String a(String str, String str2) {
        return TextUtils.isEmpty(str) ? str2 : f.i + str2;
    }

    private void a(Context context, long j, long j2) {
        String b = C.b(context.getApplicationContext());
        if (TextUtils.isEmpty(b)) {
            b = "NULL";
        }
        y.a(new h(j, j2, b));
        E.b(context.getApplicationContext(), "session_begin", 0);
        E.b(C1125b.a(), "last_deactivate", 0);
    }

    private void b(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            y.a(new g(str));
            E.b(context, "pv_path", a.f);
        }
    }

    public void a(Context context, String str) {
        this.b.removeMessages(31415927);
        m.a().a(new C1126c(this, context, str));
    }

    public void b() {
        m.a().a(new C1127d(this));
        this.b.sendEmptyMessageDelayed(31415927, c);
    }
}
