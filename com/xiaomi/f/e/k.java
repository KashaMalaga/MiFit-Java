package com.xiaomi.f.e;

import com.xiaomi.channel.a.c.d;
import com.xiaomi.push.service.XMPushService;
import java.util.ArrayList;
import java.util.List;

final class k extends d {
    final /* synthetic */ XMPushService a;

    k(XMPushService xMPushService) {
        this.a = xMPushService;
    }

    public void b() {
        List arrayList;
        synchronized (i.c) {
            arrayList = new ArrayList(i.d);
            i.d.clear();
        }
        i.b(this.a, arrayList);
    }
}
