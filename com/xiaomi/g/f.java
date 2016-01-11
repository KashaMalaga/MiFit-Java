package com.xiaomi.g;

import com.xiaomi.channel.a.b.c;
import com.xiaomi.f.l;
import com.xiaomi.f.p;
import com.xiaomi.h.a.C1095b;
import com.xiaomi.push.service.XMPushService;

public class f implements p {
    XMPushService a;
    private int b;
    private Exception c;

    f(XMPushService xMPushService) {
        this.a = xMPushService;
    }

    public void a() {
        l h = this.a.h();
        if (h != null) {
            i.a(0, C1095b.CONN_SUCCESS.a(), h.e());
        } else {
            c.a("STATS: current connection should not be null");
        }
    }

    public void a(int i, Exception exception) {
        if (this.b == 0 && this.c == null) {
            this.b = i;
            this.c = exception;
            l h = this.a.h();
            if (h != null) {
                i.b(h.e(), exception);
            } else {
                c.a("STATS: current connection should not be null");
            }
        }
    }

    public void a(Exception exception) {
    }

    public void b() {
        this.b = 0;
        this.c = null;
        i.a(0, C1095b.CONN_SUCCESS.a());
    }

    Exception c() {
        return this.c;
    }
}
