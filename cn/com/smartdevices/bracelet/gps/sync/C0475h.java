package cn.com.smartdevices.bracelet.gps.sync;

import android.content.Context;
import android.support.v7.widget.af;
import android.text.TextUtils;
import cn.com.smartdevices.bracelet.C0595q;
import cn.com.smartdevices.bracelet.e.a;
import cn.com.smartdevices.bracelet.j.d;
import cn.com.smartdevices.bracelet.j.e;
import cn.com.smartdevices.bracelet.j.f;
import cn.com.smartdevices.bracelet.j.g;
import cn.com.smartdevices.bracelet.j.i;
import cn.com.smartdevices.bracelet.lab.sync.l;
import cn.com.smartdevices.bracelet.model.LoginData;
import com.d.a.a.O;
import com.d.a.a.S;
import com.d.a.a.h;
import com.sina.weibo.sdk.constant.WBPageConstants.ParamKey;
import com.tencent.open.SocialConstants;
import com.xiaomi.channel.gamesdk.b;
import com.xiaomi.market.sdk.o;
import org.apache.http.Header;

class C0475h extends e {
    public static final String a = "huami.sport.storeUserSportConfig.json";
    public static final String b = "huami.sport.getUserSportConfig.json";
    public static final String c = "huami.sport.storeSportSummary.json";
    public static final String d = "huami.sport.getSportSummary.json";
    public static final String e = "huami.sport.storeSportData.json";
    public static final String f = "huami.sport.getSportData.json";
    public static final String g = "huami.sport.storeSportContourTrackData.json";
    public static final String h = "huami.sport.getSportContourTrackData.json";
    public static final String i = "huami.sport.deleteSportData.json";
    public static final String j = "huami.sport.getSportTrackId.json";
    public static final String k = "huami.sport.multiGetSportSummary.json";
    public static final String l = "huami.sport.historystat.json";

    C0475h() {
    }

    public static void a(Context context, h hVar, long j) {
        LoginData f = a.f(context);
        if (f.isValid()) {
            O a = f.a(f);
            a.a(SocialConstants.PARAM_TYPE, 1);
            a.a(l.f, j);
            cn.com.smartdevices.bracelet.j.a.a(d.b, e.a(g.P), a, hVar);
            return;
        }
        f.getClass();
        hVar.onFailure(af.a, new Header[0], new byte[0], new Throwable());
    }

    public static void a(Context context, String str, h hVar) {
        LoginData f = a.f(context);
        if (f.isValid()) {
            O a = f.a(f);
            a.a(f.bc, str);
            cn.com.smartdevices.bracelet.j.a.b(d.b, e.a(g.P), a, hVar);
            return;
        }
        f.getClass();
        hVar.onFailure(af.a, new Header[0], new byte[0], new Throwable());
    }

    public static void a(i iVar, String str, h hVar) {
        if (iVar == null || str == null) {
            throw new IllegalArgumentException();
        }
        O a = f.a(iVar.o);
        a.a(cn.com.smartdevices.bracelet.shoes.sync.b.g.t, iVar.i);
        a.a(l.c, String.valueOf(iVar.m));
        a.a(o.L, String.valueOf(iVar.n));
        a.a(f.x, 1);
        if (iVar.j > 0) {
            a.a(ParamKey.COUNT, com.xiaomi.e.a.f + iVar.j);
            a.a(f.as, com.xiaomi.e.a.f + iVar.j);
        }
        if (!TextUtils.isEmpty(iVar.k)) {
            a.a(f.v, iVar.k);
        }
        if (!TextUtils.isEmpty(iVar.l)) {
            a.a(f.w, iVar.l);
        }
        if (!TextUtils.isEmpty(iVar.r)) {
            a.a(cn.com.smartdevices.bracelet.shoes.sync.b.g.a, iVar.r);
        }
        if (iVar.p > 0) {
            a.a(l.f, iVar.p);
        } else if (!TextUtils.isEmpty(iVar.q)) {
            a.a(l.f, iVar.q);
        }
        d.b.c(cn.com.smartdevices.bracelet.j.h.b(str, a.c(f.c)), a, (S) hVar);
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
            a.a(cn.com.smartdevices.bracelet.shoes.sync.b.g.a, iVar.r);
        }
        if (iVar.j >= 0) {
            a.a(ParamKey.COUNT, com.xiaomi.e.a.f + iVar.j);
        }
        a.a(cn.com.smartdevices.bracelet.shoes.sync.b.g.t, iVar.i);
        a.a(l.c, com.xiaomi.e.a.f + iVar.m);
        a.a(o.L, com.xiaomi.e.a.f + iVar.n);
        a.a(f.r, com.xiaomi.e.a.f + str2.length());
        a.a(cn.com.smartdevices.bracelet.shoes.sync.b.g.n, cn.com.smartdevices.bracelet.gps.e.b.e());
        d.b.c(cn.com.smartdevices.bracelet.j.h.b(str, a.c(f.c)), a, (S) hVar);
    }
}
