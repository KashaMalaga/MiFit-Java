package com.xiaomi.f;

import android.os.SystemClock;
import cn.com.smartdevices.bracelet.F;
import cn.com.smartdevices.bracelet.chart.util.ChartData;
import com.d.a.a.C1012a;
import com.d.a.a.h;
import com.xiaomi.channel.a.b.c;
import com.xiaomi.e.a;
import com.xiaomi.f.c.e;
import com.xiaomi.f.c.g;
import com.xiaomi.g.i;
import com.xiaomi.network.f;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.Z;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;

public class A extends l {
    public Exception a = null;
    protected Socket b;
    String o = null;
    u p;
    s q;
    private String r = null;
    private String s = a.f;
    private String t;
    private XMPushService u;
    private volatile long v = 0;
    private volatile long w = 0;
    private final String x = "<pf><p>t:%1$d</p></pf>";
    private volatile long y = 0;
    private int z;

    public A(XMPushService xMPushService, o oVar) {
        super(xMPushService, oVar);
        this.u = xMPushService;
    }

    private void a(o oVar) {
        a(oVar.h(), oVar.g());
    }

    private void a(Exception exception) {
        if (SystemClock.elapsedRealtime() - this.y >= F.a) {
            this.z = 0;
        } else if (com.xiaomi.channel.a.d.a.d(this.u)) {
            this.z++;
            if (this.z >= 2) {
                String e = e();
                c.a("max short conn time reached, sink down current host:" + e);
                a(e, 0, exception);
                this.z = 0;
            }
        }
    }

    private void a(String str, int i) {
        int i2;
        Exception exception;
        Throwable th;
        Object obj;
        Object obj2;
        Throwable th2;
        Object obj3 = null;
        this.a = null;
        ArrayList arrayList = new ArrayList();
        int intValue = c.d("get bucket for host : " + str).intValue();
        com.xiaomi.network.c b = b(str);
        c.a(Integer.valueOf(intValue));
        if (b != null) {
            arrayList = b.c();
        }
        if (arrayList.isEmpty()) {
            arrayList.add(str);
        }
        this.y = 0;
        StringBuilder stringBuilder = new StringBuilder();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String str2 = (String) it.next();
            long currentTimeMillis = System.currentTimeMillis();
            this.d++;
            try {
                c.a("begin to connect to " + str2);
                this.b = v();
                this.b.bind(null);
                this.b.connect(new InetSocketAddress(str2, i), C1012a.b);
                this.b.setTcpNoDelay(true);
                this.t = str2;
                y();
                try {
                    this.e = System.currentTimeMillis() - currentTimeMillis;
                    if (b != null) {
                        b.a(str2, this.e, 0);
                    }
                    this.y = SystemClock.elapsedRealtime();
                    c.a("connected to " + str2 + " in " + this.e);
                    obj3 = 1;
                    f.a().f();
                    if (obj3 == null) {
                        throw new D(stringBuilder.toString());
                    }
                    return;
                } catch (Exception e) {
                    i2 = 1;
                    exception = e;
                } catch (Exception e2) {
                    i2 = 1;
                    exception = e2;
                    if (b != null) {
                        try {
                            b.a(str2, System.currentTimeMillis() - currentTimeMillis, 0, exception);
                        } catch (Throwable th3) {
                            th = th3;
                        }
                    }
                    this.a = exception;
                    c.c("SMACK: Could not connect to:" + str2);
                    stringBuilder.append("SMACK: Could not connect to ").append(str2).append(" port:").append(i).append(" ").append(exception.getMessage()).append("\n");
                    if (obj == null) {
                        i.a(str2, this.a);
                        obj2 = obj;
                        obj3 = obj2;
                    }
                    obj2 = obj;
                    obj3 = obj2;
                } catch (Throwable th4) {
                    th = th4;
                    i2 = 1;
                }
            } catch (IOException e3) {
                exception = e3;
                obj = obj3;
                if (b != null) {
                    b.a(str2, System.currentTimeMillis() - currentTimeMillis, 0, exception);
                }
                this.a = exception;
                c.c("SMACK: Could not connect to:" + str2);
                stringBuilder.append("SMACK: Could not connect to ").append(str2).append(" port:").append(i).append(" ").append(exception.getMessage()).append("\n");
                if (obj == null) {
                    i.a(str2, this.a);
                    obj2 = obj;
                    obj3 = obj2;
                }
                obj2 = obj;
                obj3 = obj2;
            } catch (D e4) {
                exception = e4;
                obj = obj3;
                if (b != null) {
                    b.a(str2, System.currentTimeMillis() - currentTimeMillis, 0, exception);
                }
                this.a = exception;
                c.c("SMACK: Could not connect to:" + str2);
                stringBuilder.append("SMACK: Could not connect to ").append(str2).append(" port:").append(i).append(" ").append(exception.getMessage()).append("\n");
                if (obj == null) {
                    i.a(str2, this.a);
                    obj2 = obj;
                    obj3 = obj2;
                }
                obj2 = obj;
                obj3 = obj2;
            } catch (Throwable th5) {
                th2 = th5;
                this.a = new Exception("abnormal exception", th2);
                c.a(th2);
                if (obj3 != null) {
                    obj2 = obj3;
                } else {
                    i.a(str2, this.a);
                    obj2 = obj3;
                }
                obj3 = obj2;
            }
        }
        f.a().f();
        if (obj3 == null) {
            throw new D(stringBuilder.toString());
        }
        return;
        if (obj == null) {
            i.a(str2, this.a);
        }
        throw th;
    }

    private void a(String str, long j, Exception exception) {
        com.xiaomi.network.c a = f.a().a(o.d());
        if (a != null) {
            a.a(str, j, 0, exception);
            f.a().f();
        }
    }

    private synchronized void y() {
        z();
        this.p = new u(this);
        this.q = new s(this);
        if (this.m.i()) {
            a(this.h.c(), null);
            if (this.h.d() != null) {
                b(this.h.d(), null);
            }
        }
        this.p.c();
        this.q.b();
    }

    private void z() {
        try {
            this.i = new BufferedReader(new InputStreamReader(this.b.getInputStream(), h.DEFAULT_CHARSET), ChartData.d);
            this.j = new BufferedWriter(new OutputStreamWriter(this.b.getOutputStream(), h.DEFAULT_CHARSET));
            if (this.i != null && this.j != null) {
                b();
            }
        } catch (Throwable e) {
            throw new D("Error to init reader and writer", e);
        }
    }

    public String a() {
        return this.k;
    }

    public void a(int i, Exception exception) {
        this.u.a(new C(this, 2, i, exception));
    }

    public void a(e eVar) {
        if (this.p != null) {
            this.p.a(eVar);
            return;
        }
        throw new D("the writer is null.");
    }

    public void a(g gVar, int i, Exception exception) {
        b(gVar, i, exception);
        if (exception != null && this.y != 0) {
            a(exception);
        }
    }

    public synchronized void a(Z z) {
        new w().a(z, a(), this);
    }

    public void a(String str) {
        this.s = str;
    }

    public synchronized void a(String str, String str2) {
        e gVar = new g(com.xiaomi.f.c.i.unavailable);
        gVar.l(str);
        gVar.n(str2);
        if (this.p != null) {
            this.p.a(gVar);
        }
    }

    public void a(e[] eVarArr) {
        for (e a : eVarArr) {
            a(a);
        }
    }

    protected boolean a(Object obj) {
        return obj.equals(this.q);
    }

    public com.xiaomi.network.c b(String str) {
        return f.a().a(str);
    }

    protected synchronized void b(g gVar, int i, Exception exception) {
        if (o() != 2) {
            a(2, i, exception);
            this.k = a.f;
            if (this.q != null) {
                this.q.c();
                this.q.d();
                this.q = null;
            }
            if (this.p != null) {
                try {
                    this.p.b();
                } catch (Throwable e) {
                    c.a(e);
                }
                this.p.a();
                this.p = null;
            }
            try {
                this.b.close();
            } catch (Throwable th) {
            }
            if (this.i != null) {
                try {
                    this.i.close();
                } catch (Throwable th2) {
                }
                this.i = null;
            }
            if (this.j != null) {
                try {
                    this.j.close();
                } catch (Throwable th3) {
                }
                this.j = null;
            }
            this.v = 0;
            this.w = 0;
        }
    }

    public void c() {
        if (this.p != null) {
            this.p.d();
            this.u.a(new B(this, 13, System.currentTimeMillis()), 15000);
            return;
        }
        throw new D("the packetwriter is null.");
    }

    public String e() {
        return this.t;
    }

    public synchronized void t() {
        try {
            if (j() || i()) {
                c.a("WARNING: current xmpp has connected");
            } else {
                a(0, 0, null);
                a(this.m);
            }
        } catch (Throwable e) {
            throw new D(e);
        }
    }

    public String u() {
        String format = (this.w == 0 || this.v == 0) ? a.f : String.format("<pf><p>t:%1$d</p></pf>", new Object[]{Long.valueOf(this.w - this.v)});
        String c = i.c();
        c = c != null ? "<q>" + c + "</q>" : a.f;
        return String.format(this.s, new Object[]{format, c});
    }

    public Socket v() {
        return new Socket();
    }

    public void w() {
        this.v = SystemClock.uptimeMillis();
    }

    public void x() {
        this.w = SystemClock.uptimeMillis();
    }
}
