package com.xiaomi.push.service;

import com.tencent.connect.common.Constants;
import com.xiaomi.channel.a.b.c;
import com.xiaomi.mipush.sdk.b;
import java.util.Collection;

public class K extends e {
    private XMPushService a;
    private byte[] b;
    private String c;
    private String e;
    private String f;

    public K(XMPushService xMPushService, String str, String str2, String str3, byte[] bArr) {
        super(9);
        this.a = xMPushService;
        this.c = str;
        this.b = bArr;
        this.e = str2;
        this.f = str3;
    }

    public void a() {
        H a;
        Collection c;
        Z z;
        H a2 = I.a(this.a);
        if (a2 == null) {
            try {
                a = I.a(this.a, this.c, this.e, this.f);
            } catch (Throwable e) {
                c.a(e);
                a = a2;
            } catch (Throwable e2) {
                c.a(e2);
            }
            if (a != null) {
                c.c("no account for mipush");
                L.a(this.a, b.d, "no account.");
            }
            c = X.a().c(Constants.VIA_SHARE_TYPE_TEXT);
            if (c.isEmpty()) {
                z = (Z) c.iterator().next();
            } else {
                z = a.a(this.a);
                this.a.a(z);
                X.a().a(z);
            }
            if (this.a.f()) {
                this.a.a(true);
                return;
            }
            try {
                if (z.m == ab.binded) {
                    this.a.a(this.c, this.b);
                    return;
                } else if (z.m == ab.unbind) {
                    XMPushService xMPushService = this.a;
                    XMPushService xMPushService2 = this.a;
                    xMPushService2.getClass();
                    xMPushService.a(new C1136a(xMPushService2, z));
                    return;
                } else {
                    return;
                }
            } catch (Exception e3) {
                c.a((Throwable) e3);
                this.a.b(10, e3);
                return;
            }
        }
        a = a2;
        if (a != null) {
            c = X.a().c(Constants.VIA_SHARE_TYPE_TEXT);
            if (c.isEmpty()) {
                z = (Z) c.iterator().next();
            } else {
                z = a.a(this.a);
                this.a.a(z);
                X.a().a(z);
            }
            if (this.a.f()) {
                this.a.a(true);
                return;
            } else if (z.m == ab.binded) {
                this.a.a(this.c, this.b);
                return;
            } else if (z.m == ab.unbind) {
                XMPushService xMPushService3 = this.a;
                XMPushService xMPushService22 = this.a;
                xMPushService22.getClass();
                xMPushService3.a(new C1136a(xMPushService22, z));
                return;
            } else {
                return;
            }
        }
        c.c("no account for mipush");
        L.a(this.a, b.d, "no account.");
    }

    public String b() {
        return "register app";
    }
}
