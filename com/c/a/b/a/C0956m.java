package com.c.a.b.a;

import com.c.a.C0993k;
import com.c.a.N;
import com.c.a.P;
import com.c.a.b.w;
import com.c.a.d.a;
import com.c.a.d.e;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kankan.wheel.widget.l;

public final class C0956m extends N<Object> {
    public static final P a = new C0957n();
    private final C0993k b;

    private C0956m(C0993k c0993k) {
        this.b = c0993k;
    }

    public void a(e eVar, Object obj) {
        if (obj == null) {
            eVar.f();
            return;
        }
        N a = this.b.a(obj.getClass());
        if (a instanceof C0956m) {
            eVar.d();
            eVar.e();
            return;
        }
        a.a(eVar, obj);
    }

    public Object b(a aVar) {
        switch (C0958o.a[aVar.f().ordinal()]) {
            case l.a /*1*/:
                List arrayList = new ArrayList();
                aVar.a();
                while (aVar.e()) {
                    arrayList.add(b(aVar));
                }
                aVar.b();
                return arrayList;
            case kankan.wheel.widget.a.k /*2*/:
                Map wVar = new w();
                aVar.c();
                while (aVar.e()) {
                    wVar.put(aVar.g(), b(aVar));
                }
                aVar.d();
                return wVar;
            case kankan.wheel.widget.a.l /*3*/:
                return aVar.h();
            case kankan.wheel.widget.a.aQ /*4*/:
                return Double.valueOf(aVar.k());
            case kankan.wheel.widget.a.X /*5*/:
                return Boolean.valueOf(aVar.i());
            case kankan.wheel.widget.a.bt /*6*/:
                aVar.j();
                return null;
            default:
                throw new IllegalStateException();
        }
    }
}
