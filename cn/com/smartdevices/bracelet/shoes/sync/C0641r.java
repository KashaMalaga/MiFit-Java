package cn.com.smartdevices.bracelet.shoes.sync;

import android.text.TextUtils;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.j.d;
import cn.com.smartdevices.bracelet.j.e;
import cn.com.smartdevices.bracelet.j.f;
import cn.com.smartdevices.bracelet.shoes.b.c;
import cn.com.smartdevices.bracelet.shoes.sync.b.g;
import cn.com.smartdevices.bracelet.shoes.sync.b.i;
import com.d.a.a.O;
import com.d.a.a.S;
import com.d.a.a.h;
import com.huami.android.zxing.CaptureActivity;
import com.sina.weibo.sdk.constant.WBPageConstants.ParamKey;
import com.tencent.open.SocialConstants;
import com.xiaomi.channel.gamesdk.b;
import com.xiaomi.e.a;
import com.xiaomi.market.sdk.o;

class C0641r extends e {
    public static final String a = "huami.shoes.getsupportlist.json";
    public static final String b = "huami.device.getusage.json";
    public static final String c = "huami.device.updateusage.json";
    public static final String d = "huami.user.getdata.json";
    public static final String e = "huami.user.setdata.json";
    public static final String f = "huami.device.getlatestdeviceid.json";
    public static final String g = "huami.user.getdiffuuid.json";
    public static final String h = "huami.user.batchgetdata.json";

    C0641r() {
    }

    public static void a(i iVar, String str, h hVar) {
        if (iVar == null || str == null) {
            throw new IllegalArgumentException();
        }
        O a = f.a(iVar.o);
        a.a(g.t, iVar.i);
        a.a(o.L, String.valueOf(iVar.n));
        a.a(SocialConstants.PARAM_TYPE, String.valueOf(iVar.m));
        a.a(g.n, c.h());
        if (!TextUtils.isEmpty(iVar.k)) {
            a.a(g.h, iVar.k);
        }
        if (!TextUtils.isEmpty(iVar.l)) {
            a.a(g.i, iVar.l);
        }
        if (iVar.j > 0) {
            a.a(ParamKey.COUNT, iVar.j);
        }
        if (!TextUtils.isEmpty(iVar.f)) {
            a.a(g.o, iVar.f);
        }
        if (!TextUtils.isEmpty(iVar.g)) {
            a.a(g.p, iVar.g);
        }
        if (!TextUtils.isEmpty(iVar.h)) {
            a.a(g.s, iVar.h);
        }
        a.a(g.m, iVar.e);
        String b = cn.com.smartdevices.bracelet.j.h.b(str, a.c(f.c));
        C0596r.e(B.a, "\n syncSportDataFromServer url = " + b + ",hm = " + a);
        d.b.c(b, a, (S) hVar);
    }

    public static void a(i iVar, String str, String str2, String str3, h hVar) {
        if (iVar == null || str == null) {
            throw new IllegalArgumentException();
        }
        O a = f.a(iVar.o);
        a.a(SocialConstants.PARAM_TYPE, a.f + iVar.m);
        a.a(g.t, iVar.i);
        a.a(o.L, a.f + iVar.n);
        a.a(g.n, c.h());
        if (!TextUtils.isEmpty(iVar.c)) {
            a.a(CaptureActivity.n, iVar.c);
        }
        if (!TextUtils.isEmpty(iVar.d)) {
            a.a(g.k, iVar.d);
        }
        if (!TextUtils.isEmpty(iVar.r)) {
            a.a(g.a, iVar.r);
        }
        if (TextUtils.isEmpty(str3)) {
            a.a(SocialConstants.PARAM_SUMMARY, a.f);
        } else {
            a.a(SocialConstants.PARAM_SUMMARY, str3);
        }
        if (TextUtils.isEmpty(str2)) {
            a.a(b.b, a.f);
        } else {
            a.a(b.b, str2);
        }
        if (!TextUtils.isEmpty(g.d)) {
            a.a(g.d, a.f);
        }
        if (!TextUtils.isEmpty(iVar.g)) {
            a.a(g.p, iVar.g);
        }
        C0596r.e(B.a, "\n syncSportDataToServerSynced url = " + str + ",hm = " + a);
        d.b.c(cn.com.smartdevices.bracelet.j.h.b(str, a.c(f.c)), a, (S) hVar);
    }
}
