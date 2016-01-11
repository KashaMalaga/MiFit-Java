package cn.com.smartdevices.bracelet.gps.sync;

import android.content.Context;
import cn.com.smartdevices.bracelet.C0595q;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.gps.c.a.p;
import cn.com.smartdevices.bracelet.gps.services.C0453l;
import cn.com.smartdevices.bracelet.j.e;
import cn.com.smartdevices.bracelet.j.i;
import com.xiaomi.mipush.sdk.f;
import java.util.ArrayList;
import java.util.List;

public class w {
    private w() {
    }

    static boolean a(Context context, int i) {
        List<C0453l> f = p.f(context, i);
        if (f == null) {
            C0596r.e("Sync", "syncIntegralTrackToServer  !isNeedToSync sql error");
            return false;
        } else if (f.size() <= 0) {
            C0596r.e("Sync", "syncIntegralTrackToServer  !isNeedToSync no data");
            return true;
        } else {
            i iVar = new i(context, i);
            if (!iVar.o.isValid()) {
                return false;
            }
            C0480n c0480n = new C0480n();
            for (C0453l c0453l : f) {
                long i2 = c0453l.i();
                List e = c0453l.e();
                if (e != null) {
                    int size = e.size();
                    if (size <= 0) {
                        p.e(context, i2, i);
                    } else {
                        C0596r.e("Sync", "syncContourTrackToServer  trackId = " + i2);
                        C0471d a = C0469a.a(c0453l.c(), size, e);
                        iVar.p = i2;
                        iVar.j = a.b;
                        C0475h.a(iVar, e.a(C0475h.g), a.a.toString(), c0453l.b(), new x(c0480n, context, i2, i));
                    }
                }
            }
            return c0480n.a;
        }
    }

    public static boolean a(Context context, int i, long j) {
        if (context == null || !C0595q.a(i) || j <= 0) {
            throw new IllegalArgumentException();
        }
        List arrayList = new ArrayList(1);
        arrayList.add(Long.valueOf(j));
        return b(context, i, arrayList);
    }

    static boolean a(Context context, int i, List<Long> list) {
        if (context != null && C0595q.a(i)) {
            return list == null ? false : b(context, i, (List) list);
        } else {
            throw new IllegalArgumentException();
        }
    }

    private static boolean a(Context context, List<Long> list, int i) {
        if (context == null || list == null || list.size() <= 0 || !C0595q.a(i)) {
            throw new IllegalArgumentException();
        }
        i iVar = new i(context, i);
        if (!iVar.o.isValid()) {
            return false;
        }
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
        C0475h.a(iVar, e.a(C0475h.h), new y(i, c0480n, context));
        return c0480n.a;
    }

    static boolean b(Context context, int i, long j) {
        if (context == null || !C0595q.a(i)) {
            throw new IllegalArgumentException();
        }
        List arrayList = new ArrayList(1);
        arrayList.add(Long.valueOf(j));
        arrayList = p.b(context, i, arrayList);
        if (arrayList != null && arrayList.size() > 0) {
            return a(context, i);
        }
        C0596r.e("Sync", "syncContourTrackToServer  !isNeedToSync");
        return true;
    }

    static boolean b(Context context, int i, List<Long> list) {
        int size = list.size();
        if (size <= 0) {
            return true;
        }
        int i2 = 0;
        boolean z = true;
        while (i2 < size) {
            z &= a(context, i2 + 5 >= size + -1 ? list.subList(i2, size) : list.subList(i2, i2 + 5), i);
            i2 += 5;
        }
        return z;
    }
}
