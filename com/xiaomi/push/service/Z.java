package com.xiaomi.push.service;

import android.content.Context;
import android.support.v4.g.c;
import java.util.ArrayList;
import java.util.List;
import kankan.wheel.widget.a;
import kankan.wheel.widget.l;

public class Z {
    public String a;
    public String b;
    public String c;
    public String d;
    public boolean e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public C k;
    public Context l;
    ab m = ab.unbind;
    private int n = 0;
    private List<aa> o = new ArrayList();
    private XMPushService p;
    private C1137b q = new C1137b(this);

    public Z(XMPushService xMPushService) {
        this.p = xMPushService;
        a(new ac(this));
    }

    public long a() {
        return 1000 * (((long) ((Math.random() * 20.0d) - 10.0d)) + ((long) ((this.n + 1) * 15)));
    }

    public String a(int i) {
        switch (i) {
            case l.a /*1*/:
                return "OPEN";
            case a.k /*2*/:
                return "CLOSE";
            case a.l /*3*/:
                return "KICK";
            default:
                return c.a;
        }
    }

    public void a(aa aaVar) {
        this.o.add(aaVar);
    }

    public void a(ab abVar, int i, int i2, String str, String str2) {
        boolean z = true;
        for (aa a : this.o) {
            a.a(this.m, abVar, i2);
        }
        if (this.m != abVar) {
            com.xiaomi.channel.a.b.c.a(String.format("update the client %7$s status. %1$s->%2$s %3$s %4$s %5$s %6$s", new Object[]{this.m, abVar, a(i), ad.a(i2), str, str2, this.h}));
            this.m = abVar;
        }
        if (this.k == null) {
            com.xiaomi.channel.a.b.c.c("status changed while the client dispatcher is missing");
        } else if (i == 2) {
            this.k.a(this.l, this, i2);
        } else if (i == 3) {
            this.k.a(this.l, this, str2, str);
        } else if (i == 1) {
            if (abVar != ab.binded) {
                z = false;
            }
            if (!z && "wait".equals(str2)) {
                this.n++;
            } else if (z) {
                this.n = 0;
            }
            this.k.a(this.l, this, z, i2, str);
        }
    }

    public void b(aa aaVar) {
        this.o.remove(aaVar);
    }
}
