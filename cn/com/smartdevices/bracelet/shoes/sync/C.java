package cn.com.smartdevices.bracelet.shoes.sync;

import android.content.Context;
import android.text.TextUtils;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.j.e;
import cn.com.smartdevices.bracelet.shoes.c;
import cn.com.smartdevices.bracelet.shoes.data.db.t;
import cn.com.smartdevices.bracelet.shoes.model.a;
import cn.com.smartdevices.bracelet.shoes.sync.b.h;
import cn.com.smartdevices.bracelet.shoes.sync.b.i;
import java.util.List;

class C {
    private C() {
    }

    private static void a(Context context, i iVar, h hVar, a aVar) {
        if (TextUtils.isEmpty(aVar.f())) {
            iVar.i = c.b(context, aVar.j());
        } else {
            iVar.i = aVar.f();
        }
        if (!TextUtils.isEmpty(aVar.n())) {
            iVar.g = aVar.n();
        }
        iVar.d = String.valueOf(aVar.o());
        iVar.c = aVar.c();
        C0596r.e(B.a, "syncShoesToServerSynced mac = " + aVar.j() + ",deviceId = " + iVar.i);
        if (iVar.o.isValid()) {
            C0641r.a(iVar, e.a(C0641r.c), null, aVar.h().toString(), new E(hVar, context, aVar));
        } else {
            hVar.a(false);
        }
    }

    private static void a(Context context, String str, i iVar, cn.com.smartdevices.bracelet.shoes.model.c cVar, h hVar) {
        if (iVar.o.isValid()) {
            C0641r.a(iVar, e.a(str), new D(hVar, iVar, context, cVar));
        } else {
            hVar.a(false);
        }
    }

    public static boolean a(Context context) {
        if (context == null) {
            throw new IllegalArgumentException();
        }
        List<a> g = t.g(context);
        if (g == null || g.size() <= 0) {
            C0596r.e(B.a, "sync to server no unsynced data");
            return true;
        }
        h hVar = new h();
        i iVar = new i(context);
        for (a a : g) {
            a(context, iVar, hVar, a);
        }
        return hVar.b();
    }

    public static boolean a(Context context, cn.com.smartdevices.bracelet.shoes.model.c cVar) {
        if (context == null || cVar == null || cVar.e()) {
            throw new IllegalArgumentException();
        }
        a d = t.d(context, cVar);
        if (d == null) {
            C0596r.e(B.a, "sync to server no unsynced data,indentity:" + cVar);
            return true;
        }
        h hVar = new h();
        a(context, new i(context), hVar, d);
        return hVar.b();
    }

    static boolean b(Context context, cn.com.smartdevices.bracelet.shoes.model.c cVar) {
        if (context == null || cVar == null || cVar.e()) {
            throw new IllegalArgumentException();
        }
        h hVar = new h();
        i iVar = new i(context);
        if (TextUtils.isEmpty(cVar.a())) {
            iVar.i = c.b(context, cVar.b());
        } else {
            iVar.i = cVar.a();
        }
        if (!TextUtils.isEmpty(cVar.d())) {
            iVar.g = cVar.d();
        }
        a(context, C0641r.b, iVar, cVar, hVar);
        return hVar.b();
    }
}
