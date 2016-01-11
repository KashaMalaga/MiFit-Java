package com.xiaomi.push.service;

import cn.com.smartdevices.bracelet.F;
import cn.com.smartdevices.bracelet.lab.sportmode.GroupItemBaseInfo;
import com.huami.android.widget.share.m;
import com.xiaomi.account.openauth.h;
import com.xiaomi.channel.a.b.c;

public class C1150p {
    private static int e = m.n;
    private XMPushService a;
    private int b;
    private long c;
    private int d = 0;

    public C1150p(XMPushService xMPushService) {
        this.a = xMPushService;
        this.b = 10;
        this.c = 0;
    }

    private int b() {
        int i = 40;
        if (this.d > 13) {
            return m.n;
        }
        if (this.d > 7) {
            return 60;
        }
        if (this.d >= 1) {
            return 10;
        }
        if (this.c == 0) {
            return 0;
        }
        long currentTimeMillis = System.currentTimeMillis() - this.c;
        if (currentTimeMillis < F.a) {
            if (this.b >= e) {
                return this.b;
            }
            i = this.b;
            this.b = (int) (((double) this.b) * 1.5d);
            return i;
        } else if (currentTimeMillis < 900000) {
            if (this.b < 40) {
                i = this.b;
            }
            this.b = i;
            return this.b;
        } else if (currentTimeMillis < 1800000) {
            this.b = this.b < 20 ? this.b : 20;
            return this.b;
        } else {
            this.b = 10;
            return this.b;
        }
    }

    public void a() {
        this.c = System.currentTimeMillis();
        this.a.a(1);
        this.d = 0;
    }

    public void a(boolean z) {
        if (!this.a.c()) {
            c.b("should not reconnect as no client or network.");
        } else if (z) {
            this.a.a(1);
            XMPushService xMPushService = this.a;
            XMPushService xMPushService2 = this.a;
            xMPushService2.getClass();
            xMPushService.a(new C1138c(xMPushService2));
            this.d++;
        } else if (!this.a.b(1)) {
            int b = b();
            c.a("schedule reconnect in " + b + GroupItemBaseInfo.KEY_START_TIME);
            XMPushService xMPushService3 = this.a;
            XMPushService xMPushService4 = this.a;
            xMPushService4.getClass();
            xMPushService3.a(new C1138c(xMPushService4), (long) (b * h.E));
            this.d++;
        }
    }
}
