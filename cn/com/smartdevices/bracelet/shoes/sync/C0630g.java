package cn.com.smartdevices.bracelet.shoes.sync;

import android.content.Context;
import android.text.TextUtils;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.shoes.data.db.t;
import cn.com.smartdevices.bracelet.shoes.model.a;
import cn.com.smartdevices.bracelet.shoes.model.c;
import cn.com.smartdevices.bracelet.shoes.model.g;
import com.xiaomi.hm.health.dataprocess.SportDay;

final class C0630g {
    private static final String a = "SDP";

    private C0630g() {
    }

    private static g a(Context context, String str, c cVar) {
        return (TextUtils.isEmpty(str) || !(cVar == null || cVar.equals(C0635l.a(context).b()))) ? null : C0635l.a(context).g();
    }

    private static void a(String str, a aVar, a aVar2) {
        if (aVar != null) {
            C0596r.d(a, str + ",ddate:" + aVar.s() + ",cug:" + aVar.d() + ",bug:" + aVar.r() + ",mac = " + aVar.j());
        }
        if (aVar2 != null) {
            C0596r.d(a, str + ",sdate:" + aVar2.s() + ",bug:" + aVar2.r() + ",cug:" + aVar2.d() + ",mac = " + aVar2.j());
        } else {
            C0596r.d(a, str + ",server shoes is empty");
        }
    }

    public static boolean a(Context context, c cVar, a aVar) {
        if (context != null) {
            return (cVar == null || cVar.e()) ? false : C0630g.a(context, cVar, C0630g.a(context, new SportDay().getKey(), cVar), aVar);
        } else {
            throw new IllegalArgumentException();
        }
    }

    static boolean a(Context context, c cVar, g gVar, a aVar) {
        if (cVar == null || cVar.e()) {
            C0596r.d(a, "mac is empty");
            return false;
        }
        a c = t.c(context, cVar);
        if (c == null && aVar == null) {
            C0596r.d(a, "dest shoes && src shoes is empty,mac = " + cVar);
            return false;
        }
        C0630g.a("Input:", c, aVar);
        if (c == null) {
            c = aVar;
        } else if (aVar != null) {
            c.a(aVar.r(), aVar.s());
        }
        C0630g.b(context, cVar, c);
        if (gVar != null && gVar.b >= 0) {
            c.d(gVar.b);
        }
        C0630g.a("Output:", c, aVar);
        boolean a = t.a(context, c);
        if (a) {
            return a;
        }
        C0596r.d(a, "Failed to merge my shoes srcshoes:" + aVar + ",mac:" + cVar);
        return a;
    }

    private static boolean b(Context context, c cVar, a aVar) {
        boolean z;
        String str = com.xiaomi.e.a.f;
        String key = new SportDay().addDay(-1).getKey();
        if (TextUtils.isEmpty(aVar.s())) {
            z = true;
        } else {
            String key2 = SportDay.fromString(aVar.s()).addDay(1).getKey();
            String str2 = key2;
            z = key2.compareTo(key) <= 0;
            str = str2;
        }
        C0596r.e(a, "fdate = " + str + ",tDate = " + key + ",isUpdateUg ?= " + z + ",mac:" + cVar);
        if (!z) {
            return false;
        }
        String[] c = t.c(context, cVar, str, key);
        if (c == null) {
            C0596r.d(a, "no data.fdate:" + str + ",tdate:" + key + ",latestDate:" + key + ",ugdate:" + aVar.r());
            return false;
        }
        int intValue = Integer.valueOf(c[0]).intValue();
        key2 = c[1];
        aVar.a(Math.max(0, intValue) + aVar.r(), key2);
        C0596r.d(a, "plusdis:" + intValue + ",fdate:" + str + ",tdate:" + key + ",newBugDate:" + key2);
        return true;
    }
}
