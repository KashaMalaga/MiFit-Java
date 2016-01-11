package cn.com.smartdevices.bracelet.lab.sync;

import android.text.TextUtils;
import cn.com.smartdevices.bracelet.C0595q;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.j.d;
import cn.com.smartdevices.bracelet.j.e;
import cn.com.smartdevices.bracelet.j.f;
import cn.com.smartdevices.bracelet.j.i;
import cn.com.smartdevices.bracelet.shoes.sync.b.g;
import com.d.a.a.O;
import com.d.a.a.h;
import com.sina.weibo.sdk.constant.WBPageConstants.ParamKey;
import com.tencent.open.SocialConstants;
import com.xiaomi.channel.gamesdk.b;
import com.xiaomi.e.a;
import com.xiaomi.market.sdk.o;

class c extends e {
    public static final String a = "huami.health.fetchInitSportData.json";
    public static final String b = "huami.health.storeSportData.json";

    c() {
    }

    public static void a(i iVar, String str, h hVar) {
        if (iVar == null || str == null) {
            throw new IllegalArgumentException();
        }
        O a = f.a(iVar.o);
        a.a(g.t, iVar.i);
        a.a(l.c, String.valueOf(iVar.m));
        a.a(o.L, String.valueOf(iVar.n));
        a.a(f.x, 1);
        if (iVar.j > 0) {
            a.a(ParamKey.COUNT, a.f + iVar.j);
            a.a(f.as, a.f + iVar.j);
        }
        if (!TextUtils.isEmpty(iVar.k)) {
            a.a(f.v, iVar.k);
        }
        if (!TextUtils.isEmpty(iVar.l)) {
            a.a(f.w, iVar.l);
        }
        if (!TextUtils.isEmpty(iVar.r)) {
            a.a(g.a, iVar.r);
        }
        if (iVar.p > 0) {
            a.a(l.f, iVar.p);
        } else if (!TextUtils.isEmpty(iVar.q)) {
            a.a(l.f, iVar.q);
        }
        cn.com.smartdevices.bracelet.j.a.b(d.b, str, a, hVar);
    }

    public static void a(i iVar, String str, String str2, String str3, h hVar) {
        if (iVar == null || str == null) {
            throw new IllegalArgumentException();
        }
        O a = f.a(iVar.o);
        if (C0595q.a(iVar.m)) {
            if (TextUtils.isEmpty(str2)) {
                a.a(b.b, "\"\"");
            } else {
                a.a(b.b, str2);
            }
            if (TextUtils.isEmpty(str3)) {
                a.a(SocialConstants.PARAM_SUMMARY, "\"\"");
            } else {
                a.a(SocialConstants.PARAM_SUMMARY, str3);
            }
        } else {
            a.a(f.s, str2);
        }
        if (iVar.p > 0) {
            a.a(l.f, iVar.p);
        }
        if (!TextUtils.isEmpty(iVar.r)) {
            a.a(g.a, iVar.r);
        }
        if (iVar.j >= 0) {
            a.a(ParamKey.COUNT, a.f + iVar.j);
        }
        a.a(g.t, iVar.i);
        a.a(l.c, a.f + iVar.m);
        a.a(o.L, a.f + iVar.n);
        a.a(f.r, a.f + str2.length());
        a.a(g.n, Keeper.readUUID());
        cn.com.smartdevices.bracelet.j.a.b(d.b, str, a, hVar);
    }
}
