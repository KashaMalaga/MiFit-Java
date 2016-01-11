package com.xiaomi.g;

import com.xiaomi.f.l;
import com.xiaomi.h.a.C1095b;
import com.xiaomi.h.a.C1100g;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.Z;
import com.xiaomi.push.service.aa;
import com.xiaomi.push.service.ab;

class a implements aa {
    private XMPushService a;
    private Z b;
    private l c;
    private ab d;
    private int e;
    private boolean f = false;

    a(XMPushService xMPushService, Z z) {
        this.a = xMPushService;
        this.d = ab.binding;
        this.b = z;
    }

    private void b() {
        this.b.b((aa) this);
    }

    private void c() {
        b();
        if (this.f && this.e != 11) {
            C1100g e = g.a().e();
            switch (b.a[this.d.ordinal()]) {
                case kankan.wheel.widget.l.a /*1*/:
                    if (this.e != 17) {
                        if (this.e != 21) {
                            try {
                                e b = d.b(g.b().c());
                                e.b = b.a.a();
                                e.c(b.b);
                                break;
                            } catch (NullPointerException e2) {
                                e = null;
                                break;
                            }
                        }
                        e.b = C1095b.BIND_TIMEOUT.a();
                        break;
                    }
                    e.b = C1095b.BIND_TCP_READ_TIMEOUT.a();
                    break;
                case kankan.wheel.widget.a.l /*3*/:
                    e.b = C1095b.BIND_SUCCESS.a();
                    break;
            }
            if (e != null) {
                e.b(this.c.e());
                e.d(this.b.b);
                e.c = 1;
                try {
                    e.a((byte) Integer.parseInt(this.b.h));
                } catch (NumberFormatException e3) {
                }
                g.a().a(e);
            }
        }
    }

    void a() {
        this.b.a((aa) this);
        this.c = this.a.h();
    }

    public void a(ab abVar, ab abVar2, int i) {
        if (!this.f && abVar == ab.binding) {
            this.d = abVar2;
            this.e = i;
            this.f = true;
        }
        this.a.a(new c(this, 4));
    }
}
