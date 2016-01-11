package com.xiaomi.push.service;

import com.tencent.connect.common.Constants;
import com.xiaomi.channel.a.b.c;
import com.xiaomi.h.a.C1112s;

final class P extends e {
    final /* synthetic */ XMPushService a;
    final /* synthetic */ C1112s b;

    P(int i, XMPushService xMPushService, C1112s c1112s) {
        this.a = xMPushService;
        this.b = c1112s;
        super(i);
    }

    public void a() {
        try {
            C1112s a = M.e(this.a, this.b);
            a.m().a("message_obsleted", Constants.VIA_TO_TYPE_QQ_GROUP);
            this.a.b(a);
        } catch (Exception e) {
            c.a((Throwable) e);
            this.a.b(10, e);
        }
    }

    public String b() {
        return "send ack message for obsleted message.";
    }
}
