package cn.com.smartdevices.bracelet.gps.sync;

import android.content.Context;
import android.text.TextUtils;
import cn.com.smartdevices.bracelet.C0595q;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.gps.c.a.p;
import cn.com.smartdevices.bracelet.gps.model.k;
import cn.com.smartdevices.bracelet.gps.model.n;
import cn.com.smartdevices.bracelet.gps.services.C0466z;
import cn.com.smartdevices.bracelet.j.e;
import cn.com.smartdevices.bracelet.j.i;
import com.xiaomi.mipush.sdk.f;
import java.util.ArrayList;
import java.util.List;

class F {
    private F() {
    }

    static C0482p a(Context context, int i, String str, String str2) {
        if (context == null || !C0595q.a(i)) {
            throw new IllegalArgumentException();
        }
        C0482p c0482p = new C0482p(i);
        i iVar = new i(context, i);
        if (TextUtils.isEmpty(str2)) {
            iVar.l = new k().b();
        } else {
            iVar.l = str2;
        }
        if (!TextUtils.isEmpty(str)) {
            iVar.k = str;
        }
        if (iVar.o.isValid()) {
            C0475h.a(iVar, e.a(C0475h.d), new G(i, c0482p, context));
        } else {
            c0482p.a = false;
        }
        return c0482p;
    }

    static C0482p a(Context context, List<Long> list, int i) {
        if (context == null || list == null) {
            throw new IllegalArgumentException();
        } else if (list.size() <= 0) {
            return new C0482p();
        } else {
            i iVar = new i(context, i);
            StringBuilder stringBuilder = new StringBuilder();
            if (list.size() == 1) {
                iVar.p = ((Long) list.get(0)).longValue();
            } else {
                for (Long longValue : list) {
                    stringBuilder.append(longValue.longValue()).append(f.i);
                }
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                iVar.q = stringBuilder.toString();
            }
            C0482p c0482p = new C0482p();
            if (iVar.o.isValid()) {
                C0475h.a(iVar, e.a(C0475h.k), new I(i, c0482p, context));
                return c0482p;
            }
            c0482p.a = false;
            return c0482p;
        }
    }

    static List<Long> a(Context context, long j, long j2, int i, int i2) {
        if (context == null) {
            throw new IllegalArgumentException();
        }
        i iVar = new i(context, i);
        if (j > 0) {
            iVar.k = String.valueOf(j);
        }
        if (j2 > 0) {
            iVar.l = String.valueOf(j2);
        }
        if (i2 > 0) {
            iVar.j = i2;
        }
        Object arrayList = new ArrayList();
        C0480n c0480n = new C0480n();
        if (iVar.o.isValid()) {
            C0475h.a(iVar, e.a(C0475h.j), new J(i, c0480n, context, arrayList));
        }
        return arrayList;
    }

    static boolean a(Context context, int i, List<Long> list) {
        if (context == null || !C0595q.a(i)) {
            throw new IllegalArgumentException();
        }
        List a = p.a(context, i);
        List h = p.h(context);
        if (a != null) {
            if (h != null && h.size() > 0) {
                a.addAll(h);
            }
            h = a;
        }
        if (r0 == null || r0.size() <= 0) {
            C0596r.e("Sync", "deleteTargetTrackIdListIfNeeded no data");
            return (list == null || list.size() <= 0) ? true : b(context, i, list);
        } else if (list == null) {
            return b(context, i, r0);
        } else {
            for (Long l : r0) {
                if (!list.contains(l)) {
                    list.add(l);
                }
            }
            return b(context, i, list);
        }
    }

    static boolean a(Context context, C0466z c0466z) {
        if (context == null || c0466z == null || !C0595q.a(c0466z.v())) {
            throw new IllegalArgumentException();
        }
        long G = c0466z.G();
        i iVar = new i(context, c0466z.v());
        iVar.p = G;
        iVar.j = c0466z.r();
        iVar.r = c0466z.j();
        C0480n c0480n = new C0480n();
        n a = C0481o.a(c0466z);
        if (!iVar.o.isValid()) {
            return false;
        }
        C0475h.a(iVar, e.a(C0475h.c), a.c(), a.e(), new H(c0480n, G, context, c0466z));
        return c0480n.a;
    }

    private static boolean b(Context context, int i, List<Long> list) {
        if (context == null || !C0595q.a(i) || list == null || list.size() <= 0) {
            throw new IllegalArgumentException();
        }
        i iVar = new i(context, i);
        StringBuilder stringBuilder = new StringBuilder();
        if (list.size() == 1) {
            iVar.p = ((Long) list.get(0)).longValue();
        } else {
            for (Long longValue : list) {
                stringBuilder.append(longValue.longValue()).append(f.i);
            }
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            iVar.q = stringBuilder.toString();
        }
        C0480n c0480n = new C0480n();
        if (!iVar.o.isValid()) {
            return false;
        }
        C0475h.a(iVar, e.a(C0475h.i), new K(i, c0480n, context, list));
        p.c(context, i, (List) list);
        return c0480n.a;
    }
}
