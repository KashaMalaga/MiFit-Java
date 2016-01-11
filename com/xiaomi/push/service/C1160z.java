package com.xiaomi.push.service;

import com.xiaomi.mipush.sdk.b;

class C1160z implements aa {
    final /* synthetic */ XMPushService a;

    C1160z(XMPushService xMPushService) {
        this.a = xMPushService;
    }

    public void a(ab abVar, ab abVar2, int i) {
        if (abVar2 == ab.binded) {
            L.a(this.a);
            L.b(this.a);
        } else if (abVar2 == ab.unbind) {
            L.a(this.a, b.b, " the push is not connected.");
        }
    }
}
