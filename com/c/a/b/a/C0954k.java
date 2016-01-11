package com.c.a.b.a;

import com.c.a.C0993k;
import com.c.a.N;
import com.c.a.P;
import com.c.a.b.C0971b;
import com.c.a.b.C0975f;
import com.c.a.b.E;
import com.c.a.c.a;
import java.lang.reflect.Type;
import java.util.Map;

public final class C0954k implements P {
    private final C0975f a;
    private final boolean b;

    public C0954k(C0975f c0975f, boolean z) {
        this.a = c0975f;
        this.b = z;
    }

    private N<?> a(C0993k c0993k, Type type) {
        return (type == Boolean.TYPE || type == Boolean.class) ? C0968y.f : c0993k.a(a.get(type));
    }

    public <T> N<T> a(C0993k c0993k, a<T> aVar) {
        Type type = aVar.getType();
        if (!Map.class.isAssignableFrom(aVar.getRawType())) {
            return null;
        }
        Type[] b = C0971b.b(type, C0971b.e(type));
        N a = a(c0993k, b[0]);
        N a2 = c0993k.a(a.get(b[1]));
        E a3 = this.a.a((a) aVar);
        return new C0955l(this, c0993k, b[0], a, b[1], a2, a3);
    }
}
