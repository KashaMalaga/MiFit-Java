package cn.com.smartdevices.bracelet.gps.sync;

import android.content.Context;
import cn.com.smartdevices.bracelet.gps.c.a.p;
import cn.com.smartdevices.bracelet.gps.c.a.t;
import cn.com.smartdevices.bracelet.gps.h.b;
import cn.com.smartdevices.bracelet.gps.model.n;
import cn.com.smartdevices.bracelet.gps.services.C0445d;
import cn.com.smartdevices.bracelet.gps.services.C0453l;
import cn.com.smartdevices.bracelet.gps.services.C0454m;
import java.util.ArrayList;
import java.util.List;
import kankan.wheel.widget.a;

class C0469a {
    C0469a() {
    }

    static C0471d a(int i, int i2, List<C0454m> list) {
        int i3;
        C0471d c0471d = new C0471d();
        byte[] bArr = i2 < a.aB ? new byte[(i2 * 6)] : new byte[3000];
        int i4 = 0;
        int i5 = 0;
        while (true) {
            Object obj;
            if (i4 <= 0 || i2 < a.aB || i4 % a.aB != 0) {
                obj = r1;
                i3 = i5;
            } else {
                i5++;
                c0471d.a.put(new n((byte[]) r1).c());
                if (i5 + 1 >= i) {
                    obj = new byte[((i2 - i4) * 6)];
                    i3 = i5;
                } else {
                    obj = new byte[3000];
                    i3 = i5;
                }
            }
            Object a = C0469a.a((C0454m) list.get(i4));
            System.arraycopy(a, 0, r2, (i4 % a.aB) * 6, a.length);
            i5 = i4 + 1;
            if (i5 >= i2) {
                break;
            }
            i4 = i5;
            i5 = i3;
            bArr = r2;
        }
        if (i3 < i) {
            c0471d.a.put(new n(r2).c());
            i3++;
        }
        c0471d.b = i3;
        return c0471d;
    }

    static boolean a(Context context, List<n> list) {
        if (context == null) {
            throw new IllegalArgumentException();
        } else if (list == null || list.size() <= 0) {
            return true;
        } else {
            int i = 0;
            List arrayList = new ArrayList(list.size());
            String str = com.xiaomi.e.a.f;
            List arrayList2 = new ArrayList();
            for (n nVar : list) {
                long f = nVar.f();
                arrayList2.add(Long.valueOf(f));
                int g = nVar.g();
                String e = nVar.e();
                C0453l c0453l = new C0453l(g, f);
                byte[] d = nVar.d();
                int length = d.length / 6;
                List arrayList3 = new ArrayList(length);
                int i2 = 0;
                for (i = 0; i < length; i++) {
                    short e2 = b.e(d, i2);
                    i2 += 2;
                    short e3 = b.e(d, i2);
                    i2 += 2;
                    short e4 = b.e(d, i2);
                    i2 += 2;
                    arrayList3.add(new C0454m(e2, e3, e4));
                }
                c0453l.b(e);
                c0453l.a(arrayList3);
                c0453l.c(t.STATE_SYNCED_FROM_SERVER.a());
                arrayList.add(c0453l);
                i = g;
            }
            boolean b = p.b(context, arrayList);
            new C0445d().b(context, i, arrayList2);
            return b;
        }
    }

    static byte[] a(C0454m c0454m) {
        byte[] bArr = new byte[6];
        b.a(bArr, c0454m.c(), 0);
        b.a(bArr, c0454m.d(), 2);
        b.a(bArr, c0454m.b(), 4);
        return bArr;
    }
}
