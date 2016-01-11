package com.g.a.a;

import b.a.bX;
import com.amap.api.location.LocationManagerProxy;
import com.g.a.A;
import com.g.a.p;
import java.util.HashMap;

class g extends A {
    final /* synthetic */ e a;
    private final /* synthetic */ String b;
    private final /* synthetic */ int c;

    g(e eVar, String str, int i) {
        this.a = eVar;
        this.b = str;
        this.c = i;
    }

    public void a() {
        d b = this.a.b.b(this.b);
        if (b != null) {
            long e = b.e();
            if (e <= 0) {
                bX.c(p.e, "level duration is 0");
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("level", this.b);
            hashMap.put(LocationManagerProxy.KEY_STATUS_CHANGED, Integer.valueOf(this.c));
            hashMap.put("duration", Long.valueOf(e));
            if (this.a.b.b != null) {
                hashMap.put("user_level", this.a.b.b);
            }
            this.a.a.a(this.a.x, "level", hashMap);
            return;
        }
        bX.e(p.e, String.format("finishLevel(or failLevel) called before startLevel", new Object[0]));
    }
}
