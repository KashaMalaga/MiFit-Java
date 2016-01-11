package com.c.b;

import com.c.b.a.c;
import com.c.b.c.b;
import com.c.b.g.d;
import com.c.b.g.f;
import com.c.b.g.i;
import com.c.b.g.k;
import com.c.b.g.n;
import com.c.b.g.t;
import java.util.Map;
import kankan.wheel.widget.a;

public final class l implements w {
    public b a(String str, a aVar, int i, int i2) {
        return a(str, aVar, i, i2, null);
    }

    public b a(String str, a aVar, int i, int i2, Map<g, ?> map) {
        w kVar;
        switch (m.a[aVar.ordinal()]) {
            case kankan.wheel.widget.l.a /*1*/:
                kVar = new k();
                break;
            case a.k /*2*/:
                kVar = new i();
                break;
            case a.l /*3*/:
                kVar = new t();
                break;
            case a.aQ /*4*/:
                kVar = new com.c.b.i.b();
                break;
            case a.X /*5*/:
                kVar = new f();
                break;
            case a.bt /*6*/:
                kVar = new d();
                break;
            case a.bc /*7*/:
                kVar = new n();
                break;
            case a.ba /*8*/:
                kVar = new com.c.b.h.d();
                break;
            case a.bo /*9*/:
                kVar = new com.c.b.g.b();
                break;
            case a.bd /*10*/:
                kVar = new com.c.b.d.b();
                break;
            case a.aW /*11*/:
                kVar = new c();
                break;
            default:
                throw new IllegalArgumentException("No encoder available for format " + aVar);
        }
        return kVar.a(str, aVar, i, i2, map);
    }
}
