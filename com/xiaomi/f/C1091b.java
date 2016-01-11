package com.xiaomi.f;

import com.xiaomi.c.a.C1070b;
import com.xiaomi.c.a.C1076h;
import com.xiaomi.c.a.C1079j;
import com.xiaomi.c.a.L;
import com.xiaomi.c.a.Q;
import com.xiaomi.channel.a.b.c;
import com.xiaomi.f.c.e;
import com.xiaomi.f.c.g;
import com.xiaomi.f.c.k;
import com.xiaomi.f.c.l;
import com.xiaomi.g.i;
import com.xiaomi.market.sdk.o;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.Z;
import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.net.URI;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kankan.wheel.widget.a;

public class C1091b extends l {
    private Object A = new Object();
    protected String a = null;
    protected String b = null;
    private L o;
    private final C1090a p;
    private boolean q = false;
    private boolean r = false;
    private boolean s = true;
    private boolean t = false;
    private boolean u = false;
    private ExecutorService v;
    private PipedWriter w;
    private Thread x;
    private k y;
    private String z = null;

    public C1091b(XMPushService xMPushService, C1090a c1090a) {
        super(xMPushService, c1090a);
        this.p = c1090a;
    }

    public void a() {
        if (j()) {
            c.c("SMACK-BOSH: Already connected to a server.");
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.u = false;
        this.b = null;
        this.a = null;
        try {
            a(0, 0, null);
            URI c = this.p.c();
            c.b("SMACK-BOSH: connecting using uri:" + c.toString());
            this.o = L.a(Q.a(c, this.p.e()).a(), this.n.getApplicationContext());
            this.v = Executors.newSingleThreadExecutor(new e(this));
            this.o.a(new C1092c());
            this.y = new k(this);
            this.o.a(this.y);
            if (this.p.i()) {
                b();
                if (this.s) {
                    if (this.h.c() != null) {
                        a(this.h.c(), null);
                    }
                    if (this.h.d() != null) {
                        b(this.h.d(), null);
                    }
                }
            }
            this.o.a(C1079j.a().a(C1076h.a("xm", o.x), "102").a());
            synchronized (this.A) {
                if (!j()) {
                    try {
                        this.A.wait((long) (v.b() * 6));
                    } catch (InterruptedException e) {
                    }
                }
            }
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            if (j()) {
                this.p.a().a(this.p.b(), currentTimeMillis2, 0);
                return;
            }
            this.u = true;
            i.a(this.p.b(), new D("BOSH connection timeout"));
            String str = "Timeout reached for the connection to " + this.p.b() + a.ci + g() + ".";
            this.p.a().a(this.p.b(), currentTimeMillis2, 0, null);
            throw new D(str, new k(l.r, str));
        } catch (Throwable e2) {
            i.a(this.p.b(), (Exception) e2);
            throw new D("Can't connect to " + d(), e2);
        }
    }

    protected void a(C1079j c1079j) {
        if (!j()) {
            throw new C1070b("Not connected to a server!");
        } else if (c1079j == null) {
            throw new NullPointerException("Body mustn't be null!");
        } else {
            if (this.b != null) {
                c1079j = c1079j.b().a(C1076h.a("xm", "sid"), this.b).a();
            }
            this.o.a(c1079j);
        }
    }

    public void a(e eVar) {
        if (this.u) {
            throw new D("try send packet while the connection is done.");
        }
        try {
            a(C1079j.a().a(eVar.c()).a());
            c(eVar);
        } catch (Throwable e) {
            throw new D(e);
        }
    }

    public void a(g gVar, int i, Exception exception) {
        if (o() != 2) {
            b(gVar, i, exception);
            this.g.clear();
            this.f.clear();
            this.t = false;
            this.s = true;
        }
    }

    public synchronized void a(Z z) {
        new w().a(z, this.k, this);
    }

    protected void a(Exception exception) {
        this.n.a(new j(this, 2, exception));
    }

    public synchronized void a(String str, String str2) {
        e gVar = new g(com.xiaomi.f.c.i.unavailable);
        gVar.l(str);
        gVar.n(str2);
        a(gVar);
    }

    public void a(e[] eVarArr) {
        int i = 0;
        if (this.u) {
            throw new D("try send packet while connection is done.");
        }
        int length;
        StringBuilder stringBuilder = new StringBuilder();
        for (e eVar : eVarArr) {
            if (eVar == null) {
                throw new NullPointerException("Packet is null.");
            }
            stringBuilder.append(eVar.c());
        }
        try {
            a(C1079j.a().a(stringBuilder.toString()).a());
            length = eVarArr.length;
            while (i < length) {
                c(eVarArr[i]);
                i++;
            }
        } catch (Throwable e) {
            throw new D(e);
        }
    }

    protected boolean a(Object obj) {
        return obj.equals(this.y);
    }

    protected void b() {
        this.j = new f(this);
        try {
            this.w = new PipedWriter();
            this.i = new PipedReader(this.w);
        } catch (IOException e) {
        }
        super.b();
        this.o.a(new g(this));
        this.o.a(new h(this));
        this.x = new i(this);
        this.x.setDaemon(true);
        this.x.start();
    }

    protected void b(e eVar) {
        if (eVar != null) {
            this.v.submit(new C1093d(this, eVar));
        }
    }

    protected void b(g gVar, int i, Exception exception) {
        this.a = null;
        this.b = null;
        this.u = true;
        this.q = false;
        a(2, i, exception);
        this.s = false;
        this.k = com.xiaomi.e.a.f;
        try {
            this.o.b(C1079j.a().a("xmpp", "xm").a());
            Thread.sleep(150);
        } catch (Exception e) {
        }
        if (this.o != null) {
            this.o.a();
            this.o = null;
        }
        if (this.w != null) {
            try {
                this.w.close();
            } catch (Throwable th) {
            }
            this.i = null;
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
        if (this.v != null) {
            this.v.shutdown();
        }
        for (p a : h()) {
            try {
                a.a(i, exception);
            } catch (Throwable e2) {
                c.a("SMACK-BOSH: Error while shut down connection", e2);
            }
        }
        this.x = null;
    }

    public void c() {
        if (j()) {
            c.b("SMACK-BOSH: scheduling empty request for ping");
            if (this.o != null) {
                this.o.b();
            }
        }
    }
}
