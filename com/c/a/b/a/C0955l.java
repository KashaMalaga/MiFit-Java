package com.c.a.b.a;

import com.c.a.C;
import com.c.a.C0993k;
import com.c.a.G;
import com.c.a.N;
import com.c.a.b.E;
import com.c.a.b.u;
import com.c.a.d.a;
import com.c.a.d.d;
import com.c.a.d.e;
import com.c.a.w;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

final class C0955l<K, V> extends N<Map<K, V>> {
    final /* synthetic */ C0954k a;
    private final N<K> b;
    private final N<V> c;
    private final E<? extends Map<K, V>> d;

    public C0955l(C0954k c0954k, C0993k c0993k, Type type, N<K> n, Type type2, N<V> n2, E<? extends Map<K, V>> e) {
        this.a = c0954k;
        this.b = new C0967x(c0993k, n, type);
        this.c = new C0967x(c0993k, n2, type2);
        this.d = e;
    }

    private String b(w wVar) {
        if (wVar.r()) {
            C v = wVar.v();
            if (v.y()) {
                return String.valueOf(v.c());
            }
            if (v.b()) {
                return Boolean.toString(v.n());
            }
            if (v.z()) {
                return v.d();
            }
            throw new AssertionError();
        } else if (wVar.s()) {
            return "null";
        } else {
            throw new AssertionError();
        }
    }

    public Map<K, V> a(a aVar) {
        d f = aVar.f();
        if (f == d.NULL) {
            aVar.j();
            return null;
        }
        Map<K, V> map = (Map) this.d.a();
        Object b;
        if (f == d.BEGIN_ARRAY) {
            aVar.a();
            while (aVar.e()) {
                aVar.a();
                b = this.b.b(aVar);
                if (map.put(b, this.c.b(aVar)) != null) {
                    throw new G("duplicate key: " + b);
                }
                aVar.b();
            }
            aVar.b();
            return map;
        }
        aVar.c();
        while (aVar.e()) {
            u.a.a(aVar);
            b = this.b.b(aVar);
            if (map.put(b, this.c.b(aVar)) != null) {
                throw new G("duplicate key: " + b);
            }
        }
        aVar.d();
        return map;
    }

    public void a(e eVar, Map<K, V> map) {
        int i = 0;
        if (map == null) {
            eVar.f();
        } else if (this.a.b) {
            List arrayList = new ArrayList(map.size());
            List arrayList2 = new ArrayList(map.size());
            int i2 = 0;
            for (Entry entry : map.entrySet()) {
                w b = this.b.b(entry.getKey());
                arrayList.add(b);
                arrayList2.add(entry.getValue());
                int i3 = (b.p() || b.q()) ? 1 : 0;
                i2 = i3 | i2;
            }
            if (i2 != 0) {
                eVar.b();
                while (i < arrayList.size()) {
                    eVar.b();
                    com.c.a.b.G.a((w) arrayList.get(i), eVar);
                    this.c.a(eVar, arrayList2.get(i));
                    eVar.c();
                    i++;
                }
                eVar.c();
                return;
            }
            eVar.d();
            while (i < arrayList.size()) {
                eVar.a(b((w) arrayList.get(i)));
                this.c.a(eVar, arrayList2.get(i));
                i++;
            }
            eVar.e();
        } else {
            eVar.d();
            for (Entry entry2 : map.entrySet()) {
                eVar.a(String.valueOf(entry2.getKey()));
                this.c.a(eVar, entry2.getValue());
            }
            eVar.e();
        }
    }

    public /* synthetic */ Object b(a aVar) {
        return a(aVar);
    }
}
