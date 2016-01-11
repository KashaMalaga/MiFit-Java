package cn.com.smartdevices.bracelet.shoes.sync;

import android.content.Context;
import android.text.TextUtils;
import cn.com.smartdevices.bracelet.j.e;
import cn.com.smartdevices.bracelet.shoes.d;
import cn.com.smartdevices.bracelet.shoes.model.c;
import cn.com.smartdevices.bracelet.shoes.sync.b.i;
import cn.com.smartdevices.bracelet.shoes.sync.c.a;

class x {
    private x() {
    }

    public static c a(Context context) {
        if (context == null) {
            throw new IllegalArgumentException();
        }
        A b = b(context);
        if (b == null || TextUtils.isEmpty(b.a)) {
            return null;
        }
        String a = a.a(b.a);
        return a.b(a) ? new c(a, b.b, b.a) : null;
    }

    private static z a(Context context, int i, int i2) {
        i iVar = new i(context);
        iVar.m = i;
        iVar.j = i2;
        iVar.h = com.xiaomi.e.a.f;
        z zVar = new z();
        zVar.f = iVar.h;
        if (iVar.o.isValid()) {
            C0641r.a(iVar, e.a(C0641r.f), new y(zVar, context, i));
        } else {
            zVar.c = false;
        }
        return zVar;
    }

    private static A b(Context context) {
        if (context == null) {
            throw new IllegalArgumentException();
        }
        z a = a(context, d.a, 1);
        return (!a.c || a.e.size() <= 0) ? null : (A) a.e.get(0);
    }
}
