package cn.com.smartdevices.bracelet.honor;

import android.content.Context;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.e.a;
import cn.com.smartdevices.bracelet.j.d;
import cn.com.smartdevices.bracelet.j.e;
import cn.com.smartdevices.bracelet.j.f;
import cn.com.smartdevices.bracelet.model.LoginData;
import com.d.a.a.O;
import com.d.a.a.S;
import com.d.a.a.h;
import com.tencent.connect.common.Constants;

public class D extends e {
    public static final String a = "huami.health.getMedalConfig.json";
    public static final String b = "huami.health.getUserMedals.json";
    public static final String c = "huami.health.updateUserMedal.json";
    private static final String d = "MedalWebAPI";

    public static void a(Context context, String str, boolean z, h hVar) {
        LoginData f = a.f(context);
        f.uid = 257106499;
        f.security = "523b576ecf9ccd743c0c055015132a77";
        O a = f.a(f);
        a.b("medal", str);
        String b = cn.com.smartdevices.bracelet.j.h.b("http://101.251.64.11:8001/huami.health.updateUserMedal.json", a.c(f.c));
        C0596r.e(d, "updateUserMedal url:" + b + " params:" + a + " isAsync:" + z);
        if (z) {
            d.a.c(b, a, (S) hVar);
        } else {
            d.b.c(b, a, (S) hVar);
        }
    }

    public static void a(Context context, boolean z, h hVar) {
        LoginData f = a.f(context);
        f.uid = 257106499;
        f.security = "523b576ecf9ccd743c0c055015132a77";
        O a = f.a(f);
        String b = cn.com.smartdevices.bracelet.j.h.b("http://101.251.64.11:8001/huami.health.getMedalConfig.json", a.c(f.c));
        C0596r.e(d, "queryMedalConfig url:" + b + " params:" + a + " isAsync:" + z);
        if (z) {
            d.a.c(b, a, (S) hVar);
        } else {
            d.b.c(b, a, (S) hVar);
        }
    }

    public static void b(Context context, boolean z, h hVar) {
        LoginData f = a.f(context);
        f.uid = 257106499;
        f.security = "523b576ecf9ccd743c0c055015132a77";
        O a = f.a(f);
        a.b(com.xiaomi.channel.relationservice.data.a.h, Constants.VIA_TO_TYPE_QQ_GROUP);
        String b = cn.com.smartdevices.bracelet.j.h.b("http://101.251.64.11:8001/huami.health.getUserMedals.json", a.c(f.c));
        C0596r.e(d, "queryMyMedal url:" + b + " params:" + a + " isAsync:" + z);
        if (z) {
            d.a.c(b, a, (S) hVar);
        } else {
            d.b.c(b, a, (S) hVar);
        }
    }
}
