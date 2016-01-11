package com.xiaomi.g;

import android.support.v4.view.C0151az;
import com.xiaomi.channel.a.b.c;
import com.xiaomi.channel.a.e.a;
import com.xiaomi.h.a.C1095b;
import com.xiaomi.h.a.C1100g;
import com.xiaomi.h.a.S;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.Z;
import org.apache.thrift.b;

public class i {
    private static final int a = C1095b.PING_RTT.a();

    public static void a() {
        a(0, a);
    }

    public static synchronized void a(int i, int i2) {
        synchronized (i.class) {
            if (i2 < C0151az.r) {
                j.a.put(Integer.valueOf((i << 24) | i2), Long.valueOf(System.currentTimeMillis()));
            } else {
                c.c("stats key should less than 16777215");
            }
        }
    }

    public static void a(int i, int i2, int i3, String str) {
        g.a().a(i, i2, i3, str);
    }

    public static synchronized void a(int i, int i2, String str) {
        synchronized (i.class) {
            long currentTimeMillis = System.currentTimeMillis();
            int i3 = (i << 24) | i2;
            if (j.a.containsKey(Integer.valueOf(i3))) {
                g.a().a(i, i2, (int) (currentTimeMillis - ((Long) j.a.get(Integer.valueOf(i3))).longValue()), str);
                j.a.remove(Integer.valueOf(i2));
            } else {
                c.c("stats key not found");
            }
        }
    }

    public static void a(XMPushService xMPushService, Z z) {
        new a(xMPushService, z).a();
    }

    public static void a(String str, Exception exception) {
        try {
            e a = d.a(exception);
            C1100g e = g.a().e();
            e.a(a.a.a());
            e.c(a.b);
            e.b(str);
            g.a().a(e);
        } catch (NullPointerException e2) {
        }
    }

    public static boolean a(int i, int i2, int i3, String str, String str2) {
        return g.a().a(i, i2, i3, str, str2);
    }

    public static void b() {
        a(0, a, null);
    }

    public static void b(String str, Exception exception) {
        try {
            e c = d.c(exception);
            C1100g e = g.a().e();
            e.a(c.a.a());
            e.c(c.b);
            e.b(str);
            g.a().a(e);
        } catch (NullPointerException e2) {
        }
    }

    public static String c() {
        b d = g.a().d();
        if (d == null) {
            return null;
        }
        byte[] a = S.a(d);
        if (a == null) {
            return null;
        }
        String str = new String(a.a(a));
        c.a("stat encoded size = " + str.length());
        c.b(str);
        return str;
    }
}
