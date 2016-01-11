package com.xiaomi.f;

import android.text.TextUtils;
import cn.com.smartdevices.bracelet.shoes.sync.SyncShoesDataService;
import cn.com.smartdevices.bracelet.tencent.QQLogin;
import com.tencent.connect.common.Constants;
import com.xiaomi.channel.a.e.b;
import com.xiaomi.e.a;
import com.xiaomi.f.c.e;
import com.xiaomi.f.e.g;
import com.xiaomi.push.service.Z;
import java.util.HashMap;
import java.util.Map;

public class x extends e {
    final /* synthetic */ w c;

    public x(w wVar, Z z, String str, l lVar) {
        Object obj;
        this.c = wVar;
        Map hashMap = new HashMap();
        int k = lVar.k();
        hashMap.put("challenge", str);
        hashMap.put("token", z.c);
        hashMap.put("chid", z.h);
        hashMap.put(QQLogin.KEY_FROM, z.b);
        hashMap.put(SyncShoesDataService.d, k());
        hashMap.put("to", "xiaomi.com");
        if (z.e) {
            hashMap.put("kick", Constants.VIA_TO_TYPE_QQ_GROUP);
        } else {
            hashMap.put("kick", Constants.VIA_RESULT_SUCCESS);
        }
        if (lVar.m() > 0) {
            String format = String.format("conn:%1$d,t:%2$d", new Object[]{Integer.valueOf(k), Long.valueOf(lVar.m())});
            hashMap.put(Constants.PARAM_PLATFORM_ID, format);
            lVar.l();
            lVar.n();
            obj = format;
        } else {
            obj = null;
        }
        if (TextUtils.isEmpty(z.f)) {
            hashMap.put("client_attrs", a.f);
        } else {
            hashMap.put("client_attrs", z.f);
        }
        if (TextUtils.isEmpty(z.g)) {
            hashMap.put("cloud_attrs", a.f);
        } else {
            hashMap.put("cloud_attrs", z.g);
        }
        String a = (z.d.equals("XIAOMI-PASS") || z.d.equals("XMPUSH-PASS")) ? b.a(z.d, null, hashMap, z.i) : z.d.equals("XIAOMI-SASL") ? null : null;
        l(z.h);
        n(z.b);
        m("xiaomi.com");
        o(z.a);
        com.xiaomi.f.c.a aVar = new com.xiaomi.f.c.a("token", null, (String[]) null, (String[]) null);
        aVar.b(z.c);
        a(aVar);
        aVar = new com.xiaomi.f.c.a("kick", null, (String[]) null, (String[]) null);
        aVar.b(z.e ? Constants.VIA_TO_TYPE_QQ_GROUP : Constants.VIA_RESULT_SUCCESS);
        a(aVar);
        aVar = new com.xiaomi.f.c.a("sig", null, (String[]) null, (String[]) null);
        aVar.b(a);
        a(aVar);
        com.xiaomi.f.c.a aVar2 = new com.xiaomi.f.c.a("method", null, (String[]) null, (String[]) null);
        if (TextUtils.isEmpty(z.d)) {
            aVar2.b("XIAOMI-SASL");
        } else {
            aVar2.b(z.d);
        }
        a(aVar2);
        aVar2 = new com.xiaomi.f.c.a("client_attrs", null, (String[]) null, (String[]) null);
        aVar2.b(z.f == null ? a.f : g.a(z.f));
        a(aVar2);
        aVar2 = new com.xiaomi.f.c.a("cloud_attrs", null, (String[]) null, (String[]) null);
        aVar2.b(z.g == null ? a.f : g.a(z.g));
        a(aVar2);
        if (!TextUtils.isEmpty(obj)) {
            aVar2 = new com.xiaomi.f.c.a(Constants.PARAM_PLATFORM_ID, null, (String[]) null, (String[]) null);
            aVar2.b(obj);
            a(aVar2);
        }
    }

    public String c() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<bind ");
        if (k() != null) {
            stringBuilder.append("id=\"" + k() + "\" ");
        }
        if (m() != null) {
            stringBuilder.append("to=\"").append(g.a(m())).append("\" ");
        }
        if (n() != null) {
            stringBuilder.append("from=\"").append(g.a(n())).append("\" ");
        }
        if (l() != null) {
            stringBuilder.append("chid=\"").append(g.a(l())).append("\">");
        }
        if (q() != null) {
            for (com.xiaomi.f.c.a d : q()) {
                stringBuilder.append(d.d());
            }
        }
        stringBuilder.append("</bind>");
        return stringBuilder.toString();
    }
}
