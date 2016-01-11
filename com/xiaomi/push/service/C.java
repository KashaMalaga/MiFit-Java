package com.xiaomi.push.service;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.connect.common.Constants;
import com.xiaomi.channel.a.b.c;
import com.xiaomi.f.c.b;
import com.xiaomi.f.c.d;
import com.xiaomi.f.c.e;
import com.xiaomi.f.c.g;
import java.util.Collection;
import java.util.Iterator;

public class C {
    private M a = new M();

    public static String a(String str) {
        return str + ".permission.MIPUSH_RECEIVE";
    }

    private static void a(Context context, Intent intent, String str) {
        if ("com.xiaomi.xmsf".equals(context.getPackageName())) {
            context.sendBroadcast(intent);
        } else {
            context.sendBroadcast(intent, a(str));
        }
    }

    Z a(e eVar) {
        Collection c = X.a().c(eVar.l());
        if (c.isEmpty()) {
            return null;
        }
        Iterator it = c.iterator();
        if (c.size() == 1) {
            return (Z) it.next();
        }
        CharSequence n = eVar.n();
        CharSequence m = eVar.m();
        while (it.hasNext()) {
            Z z = (Z) it.next();
            if (TextUtils.equals(n, z.b)) {
                return z;
            }
            if (TextUtils.equals(m, z.b)) {
                return z;
            }
        }
        return null;
    }

    public void a(Context context) {
        Intent intent = new Intent();
        intent.setAction("com.xiaomi.push.service_started");
        context.sendBroadcast(intent);
    }

    public void a(Context context, Z z, int i) {
        if (!Constants.VIA_SHARE_TYPE_TEXT.equalsIgnoreCase(z.h)) {
            Intent intent = new Intent();
            intent.setAction("com.xiaomi.push.channel_closed");
            intent.setPackage(z.a);
            intent.putExtra(ad.n, z.h);
            intent.putExtra("ext_reason", i);
            intent.putExtra(ad.m, z.b);
            intent.putExtra(ad.y, z.j);
            a(context, intent, z.a);
        }
    }

    public void a(Context context, Z z, String str, String str2) {
        if (Constants.VIA_SHARE_TYPE_TEXT.equalsIgnoreCase(z.h)) {
            c.c("mipush kicked by server");
            return;
        }
        Intent intent = new Intent();
        intent.setAction("com.xiaomi.push.kicked");
        intent.setPackage(z.a);
        intent.putExtra("ext_kick_type", str);
        intent.putExtra("ext_kick_reason", str2);
        intent.putExtra("ext_chid", z.h);
        intent.putExtra(ad.m, z.b);
        intent.putExtra(ad.y, z.j);
        a(context, intent, z.a);
    }

    public void a(Context context, Z z, boolean z2, int i, String str) {
        if (Constants.VIA_SHARE_TYPE_TEXT.equalsIgnoreCase(z.h)) {
            this.a.a(context, z, z2, i, str);
            return;
        }
        Intent intent = new Intent();
        intent.setAction("com.xiaomi.push.channel_opened");
        intent.setPackage(z.a);
        intent.putExtra("ext_succeeded", z2);
        if (!z2) {
            intent.putExtra("ext_reason", i);
        }
        if (!TextUtils.isEmpty(str)) {
            intent.putExtra("ext_reason_msg", str);
        }
        intent.putExtra("ext_chid", z.h);
        intent.putExtra(ad.m, z.b);
        intent.putExtra(ad.y, z.j);
        a(context, intent, z.a);
    }

    public void a(XMPushService xMPushService, String str, e eVar) {
        Z a = a(eVar);
        if (a == null) {
            c.c("error while notify channel closed! channel " + str + " not registered");
        } else if (Constants.VIA_SHARE_TYPE_TEXT.equalsIgnoreCase(str)) {
            this.a.a(xMPushService, eVar, a);
        } else {
            String str2;
            String str3 = a.a;
            if (eVar instanceof d) {
                str2 = "com.xiaomi.push.new_msg";
            } else if (eVar instanceof b) {
                str2 = "com.xiaomi.push.new_iq";
            } else if (eVar instanceof g) {
                str2 = "com.xiaomi.push.new_pres";
            } else {
                c.c("unknown packet type, drop it");
                return;
            }
            Intent intent = new Intent();
            intent.setAction(str2);
            intent.setPackage(str3);
            intent.putExtra("ext_chid", str);
            intent.putExtra("ext_packet", eVar.b());
            intent.putExtra(ad.y, a.j);
            intent.putExtra(ad.r, a.i);
            a((Context) xMPushService, intent, str3);
        }
    }
}
