package com.xiaomi.g;

import android.text.TextUtils;
import android.util.Base64;
import com.xiaomi.account.openauth.h;
import com.xiaomi.channel.a.b.c;
import com.xiaomi.channel.a.d.a;
import com.xiaomi.f.A;
import com.xiaomi.f.C1091b;
import com.xiaomi.h.a.C1100g;
import com.xiaomi.h.a.C1102i;
import com.xiaomi.push.service.G;
import com.xiaomi.push.service.XMPushService;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import org.apache.thrift.protocol.f;
import org.apache.thrift.protocol.l;
import org.apache.thrift.transport.b;
import org.apache.thrift.transport.d;

public class g {
    private String a;
    private boolean b = false;
    private int c;
    private long d;
    private f e;
    private LinkedList<C1100g> f = new LinkedList();

    public static g a() {
        return h.a;
    }

    private void a(int i, int i2, int i3, String str, String str2, long j) {
        a(j);
        C1100g c1100g = new C1100g();
        c1100g.a = (byte) i;
        c1100g.b = i2;
        c1100g.c = i3;
        c1100g.d = str2;
        c1100g.e = str;
        c1100g.i = ((int) System.currentTimeMillis()) / h.E;
        this.f.addLast(c1100g);
        c.b(String.format(Locale.US, "add stats: chid = %s, type =%d, value = %d, connpt = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str2}));
    }

    private void a(long j) {
        while (this.f.size() > 100) {
            this.f.removeFirst();
        }
    }

    static f b() {
        return h.a.e;
    }

    private C1102i b(int i) {
        List arrayList = new ArrayList();
        C1102i c1102i = new C1102i(this.a, arrayList);
        if (!a.e(this.e.a)) {
            c1102i.a(G.d(this.e.a));
        }
        d bVar = new b(i);
        f a = new l.a().a(bVar);
        try {
            c1102i.b(a);
        } catch (org.apache.thrift.f e) {
        }
        while (true) {
            C1100g c1100g = (C1100g) this.f.peekFirst();
            if (c1100g == null) {
                break;
            }
            try {
                c1100g.b(a);
                if (bVar.a_() > i) {
                    break;
                }
                arrayList.add(c1100g);
                this.f.removeFirst();
            } catch (org.apache.thrift.f e2) {
            }
        }
        c.a("stat approximate size = " + bVar.a_());
        return c1102i;
    }

    private void f() {
        if (this.d == 0) {
            this.d = System.currentTimeMillis();
        }
    }

    private void g() {
        if (this.b && System.currentTimeMillis() - this.d > ((long) this.c)) {
            this.b = false;
            this.d = 0;
        }
    }

    public void a(int i) {
        int i2 = 604800000;
        if (i > 0) {
            this.b = true;
            int i3 = i * h.E;
            if (i3 <= 604800000) {
                i2 = i3;
            }
            if (this.c != i2) {
                this.c = i2;
                f();
            }
        }
    }

    public synchronized void a(int i, int i2, int i3, String str) {
        if (this.a == null) {
            c.b(String.format(Locale.US, "StatsHandler.add() Should initialized before add", new Object[0]));
        } else {
            Object f = a.f(this.e.a);
            if (!TextUtils.isEmpty(f)) {
                a(i, i2, i3, str, f, System.currentTimeMillis());
            }
        }
    }

    synchronized void a(C1100g c1100g) {
        a(System.currentTimeMillis());
        this.f.addLast(c1100g);
    }

    public synchronized void a(XMPushService xMPushService, A a, C1091b c1091b) {
        this.e = new f(xMPushService);
        this.a = com.xiaomi.e.a.f;
        if (a != null) {
            a.a(this.e);
        }
        if (c1091b != null) {
            c1091b.a(this.e);
        }
    }

    boolean a(int i, int i2, int i3, String str, String str2) {
        boolean z = false;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("chid = ").append(i);
        stringBuilder.append("key = ").append(i2);
        stringBuilder.append("host = ").append(str);
        stringBuilder.append("val = ").append(i3);
        stringBuilder.append("salt = ").append("XIAOMI_STATS");
        String substring = str2.substring(str2.length() - 4);
        stringBuilder.append(substring);
        String str3 = com.xiaomi.e.a.f;
        try {
            return (Base64.encodeToString(MessageDigest.getInstance("MD5").digest(stringBuilder.toString().getBytes()), 8).substring(0, 12) + substring).equals(str2);
        } catch (NoSuchAlgorithmException e) {
            return z;
        }
    }

    boolean c() {
        g();
        return this.b && !this.f.isEmpty();
    }

    synchronized C1102i d() {
        C1102i c1102i;
        c1102i = null;
        if (c()) {
            c1102i = b(750);
        }
        return c1102i;
    }

    C1100g e() {
        C1100g c1100g = new C1100g();
        c1100g.a(a.f(this.e.a));
        c1100g.a = (byte) 0;
        c1100g.c = 1;
        c1100g.b((int) (System.currentTimeMillis() / 1000));
        return c1100g;
    }
}
