package com.huami.android.widget.share;

import android.content.Context;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.e.a;
import cn.com.smartdevices.bracelet.j.d;
import cn.com.smartdevices.bracelet.j.e;
import cn.com.smartdevices.bracelet.j.f;
import com.d.a.a.O;
import com.d.a.a.S;
import com.d.a.a.h;

public class v extends e {
    public static final String a = "huami.health.getAllSharedTimes.json";
    public static final String b = "huami.health.updateSharedTimes.json";
    private static final String c = "ShareWebAPI";

    public static void a(Context context, String str, boolean z, h hVar) {
        O a = f.a(a.f(context));
        a.a("shared", str);
        String b = cn.com.smartdevices.bracelet.j.h.b("http://101.251.64.11:8001/huami.health.updateSharedTimes.json", a.c(f.c));
        C0596r.e(c, "updateSharedTimes url:" + b + " params:" + a + " isAsync:" + z + " shared:" + str);
        if (z) {
            d.a.c(b, a, (S) hVar);
        } else {
            d.b.c(b, a, (S) hVar);
        }
    }

    public static void a(Context context, boolean z, h hVar) {
        O a = f.a(a.f(context));
        String b = cn.com.smartdevices.bracelet.j.h.b("http://101.251.64.11:8001/huami.health.getAllSharedTimes.json", a.c(f.c));
        C0596r.e(c, "getAllSharedTimes url:" + b + " params:" + a + " isAsync:" + z);
        if (z) {
            d.a.c(b, a, (S) hVar);
        } else {
            d.b.c(b, a, (S) hVar);
        }
    }
}
