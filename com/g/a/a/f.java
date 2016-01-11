package com.g.a.a;

import com.amap.api.location.LocationManagerProxy;
import com.g.a.A;
import java.util.HashMap;

class f extends A {
    final /* synthetic */ e a;
    private final /* synthetic */ String b;

    f(e eVar, String str) {
        this.a = eVar;
        this.b = str;
    }

    public void a() {
        this.a.b.a(this.b);
        HashMap hashMap = new HashMap();
        hashMap.put("level", this.b);
        hashMap.put(LocationManagerProxy.KEY_STATUS_CHANGED, Integer.valueOf(0));
        if (this.a.b.b != null) {
            hashMap.put("user_level", this.a.b.b);
        }
        this.a.a.a(this.a.x, "level", hashMap);
    }
}
