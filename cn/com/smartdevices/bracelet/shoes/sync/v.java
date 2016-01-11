package cn.com.smartdevices.bracelet.shoes.sync;

import android.content.Context;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.shoes.d;
import cn.com.smartdevices.bracelet.shoes.model.c;
import cn.com.smartdevices.bracelet.shoes.sync.a.a;
import cn.com.smartdevices.bracelet.shoes.sync.a.b;
import cn.com.smartdevices.bracelet.shoes.sync.b.h;

class v {
    private v() {
    }

    public static boolean a(Context context, c cVar) {
        if (context == null || cVar == null || cVar.e()) {
            throw new IllegalArgumentException();
        }
        h hVar = new h();
        b a = a.a(context, cVar);
        if (a == null) {
            C0596r.d(B.a, "system device info is empty.indentity:" + cVar);
            return false;
        }
        a.a(context, a, d.a, new w(hVar, context));
        return hVar.b();
    }
}
