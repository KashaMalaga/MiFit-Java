package com.xiaomi.f;

import android.support.v4.g.c;
import android.util.Pair;
import com.xiaomi.f.a.a;
import com.xiaomi.f.c.e;
import com.xiaomi.f.c.g;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.Z;
import com.xiaomi.push.service.ad;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class l {
    private static final AtomicInteger a = new AtomicInteger(0);
    public static boolean c;
    private LinkedList<Pair<Integer, Long>> b = new LinkedList();
    protected int d = 0;
    protected long e = -1;
    protected final Map<r, m> f = new ConcurrentHashMap();
    protected final Map<r, m> g = new ConcurrentHashMap();
    protected a h = null;
    protected Reader i;
    protected Writer j;
    protected String k = com.xiaomi.e.a.f;
    protected final int l = a.getAndIncrement();
    protected o m;
    protected XMPushService n;
    private final Collection<p> o = new CopyOnWriteArrayList();
    private int p = 2;
    private long q = 0;

    static {
        c = false;
        try {
            c = Boolean.getBoolean("smack.debugEnabled");
        } catch (Exception e) {
        }
        v.a();
    }

    protected l(XMPushService xMPushService, o oVar) {
        this.m = oVar;
        this.n = xMPushService;
    }

    private String a(int i) {
        return i == 1 ? "connected" : i == 0 ? "connecting" : i == 2 ? "disconnected" : c.a;
    }

    private void b(int i) {
        synchronized (this.b) {
            if (i == 1) {
                this.b.clear();
            } else {
                this.b.add(new Pair(Integer.valueOf(i), Long.valueOf(System.currentTimeMillis())));
                if (this.b.size() > 6) {
                    this.b.remove(0);
                }
            }
        }
    }

    public void a(int i, int i2, Exception exception) {
        if (i != this.p) {
            com.xiaomi.channel.a.b.c.a(String.format("update the connection status. %1$s -> %2$s : %3$s ", new Object[]{a(this.p), a(i), ad.a(i2)}));
        }
        if (com.xiaomi.channel.a.d.a.d(this.n)) {
            b(i);
        }
        if (i == 1) {
            this.n.a(10);
            if (this.p != 0) {
                com.xiaomi.channel.a.b.c.a("try set connected while not connecting.");
            }
            this.p = i;
            for (p a : this.o) {
                a.a();
            }
        } else if (i == 0) {
            this.n.i();
            if (this.p != 2) {
                com.xiaomi.channel.a.b.c.a("try set connecting while not disconnected.");
            }
            this.p = i;
            for (p a2 : this.o) {
                a2.b();
            }
        } else if (i == 2) {
            this.n.a(10);
            if (this.p == 0) {
                for (p a22 : this.o) {
                    a22.a(exception == null ? new CancellationException("disconnect while connecting") : exception);
                }
            } else if (this.p == 1) {
                for (p a222 : this.o) {
                    a222.a(i2, exception);
                }
            }
            this.p = i;
        }
    }

    public abstract void a(e eVar);

    public abstract void a(g gVar, int i, Exception exception);

    public void a(p pVar) {
        if (pVar != null && !this.o.contains(pVar)) {
            this.o.add(pVar);
        }
    }

    public void a(r rVar, com.xiaomi.f.b.a aVar) {
        if (rVar == null) {
            throw new NullPointerException("Packet listener is null.");
        }
        this.f.put(rVar, new m(rVar, aVar));
    }

    public abstract void a(Z z);

    public void a(Object obj, String str) {
        this.n.a(new n(this, 7, obj, str));
    }

    public abstract void a(String str, String str2);

    public abstract void a(e[] eVarArr);

    public boolean a(long j) {
        return this.q >= j;
    }

    protected abstract boolean a(Object obj);

    protected void b() {
        Class cls = null;
        if (this.i != null && this.j != null && this.m.i()) {
            if (this.h == null) {
                String property;
                try {
                    property = System.getProperty("smack.debuggerClass");
                } catch (Throwable th) {
                    Object obj = cls;
                }
                if (property != null) {
                    try {
                        cls = Class.forName(property);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                if (cls == null) {
                    this.h = new com.xiaomi.d.a.a(this, this.j, this.i);
                    this.i = this.h.a();
                    this.j = this.h.b();
                    return;
                }
                try {
                    this.h = (a) cls.getConstructor(new Class[]{l.class, Writer.class, Reader.class}).newInstance(new Object[]{this, this.j, this.i});
                    this.i = this.h.a();
                    this.j = this.h.b();
                    return;
                } catch (Throwable e2) {
                    throw new IllegalArgumentException("Can't initialize the configured debugger!", e2);
                }
            }
            this.i = this.h.a(this.i);
            this.j = this.h.a(this.j);
        }
    }

    public void b(p pVar) {
        this.o.remove(pVar);
    }

    public void b(r rVar, com.xiaomi.f.b.a aVar) {
        if (rVar == null) {
            throw new NullPointerException("Packet listener is null.");
        }
        this.g.put(rVar, new m(rVar, aVar));
    }

    public abstract void c();

    protected void c(e eVar) {
        for (m a : this.g.values()) {
            a.a(eVar);
        }
    }

    public String d() {
        return this.m.e();
    }

    public String e() {
        return this.m.h();
    }

    public String f() {
        return this.m.f();
    }

    public int g() {
        return this.m.g();
    }

    public Collection<p> h() {
        return this.o;
    }

    public boolean i() {
        return this.p == 0;
    }

    public boolean j() {
        return this.p == 1;
    }

    public int k() {
        return this.d;
    }

    public void l() {
        this.d = 0;
    }

    public long m() {
        return this.e;
    }

    public void n() {
        this.e = -1;
    }

    public int o() {
        return this.p;
    }

    public void p() {
        this.q = System.currentTimeMillis();
    }

    public boolean q() {
        return System.currentTimeMillis() - this.q < ((long) v.c());
    }

    public boolean r() {
        boolean z;
        synchronized (this.b) {
            Collection arrayList = new ArrayList();
            Iterator it = this.b.iterator();
            while (it.hasNext()) {
                Pair pair = (Pair) it.next();
                if (System.currentTimeMillis() - ((Long) pair.second).longValue() < 1800000) {
                    arrayList.add(pair);
                }
            }
            this.b.clear();
            this.b.addAll(arrayList);
            z = this.b.size() >= 6;
        }
        return z;
    }

    public void s() {
        synchronized (this.b) {
            this.b.clear();
        }
    }
}
