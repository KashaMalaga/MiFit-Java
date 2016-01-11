package com.xiaomi.mistatistic.sdk.b;

import com.xiaomi.mistatistic.sdk.c.b;
import com.xiaomi.mistatistic.sdk.c.c;
import com.xiaomi.mistatistic.sdk.c.d;
import com.xiaomi.mistatistic.sdk.c.g;
import com.xiaomi.mistatistic.sdk.c.h;
import com.xiaomi.mistatistic.sdk.c.i;

class z implements p {
    private b a;

    public z(b bVar) {
        this.a = bVar;
    }

    public void a() {
        i a = this.a.a();
        t tVar = new t();
        if ((this.a instanceof g) || (this.a instanceof h) || (this.a instanceof d) || (this.a instanceof c)) {
            tVar.a(a);
            return;
        }
        String str = a.c;
        String str2 = a.a;
        i a2 = tVar.a(str2, str);
        if (a2 == null || !a.d.equals(a2.d)) {
            tVar.a(a);
        } else {
            tVar.a(str, str2, a.e);
        }
    }
}
