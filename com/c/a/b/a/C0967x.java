package com.c.a.b.a;

import com.c.a.C0993k;
import com.c.a.N;
import com.c.a.c.a;
import com.c.a.d.e;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

final class C0967x<T> extends N<T> {
    private final C0993k a;
    private final N<T> b;
    private final Type c;

    C0967x(C0993k c0993k, N<T> n, Type type) {
        this.a = c0993k;
        this.b = n;
        this.c = type;
    }

    private Type a(Type type, Object obj) {
        return obj != null ? (type == Object.class || (type instanceof TypeVariable) || (type instanceof Class)) ? obj.getClass() : type : type;
    }

    public void a(e eVar, T t) {
        N n = this.b;
        Type a = a(this.c, (Object) t);
        if (a != this.c) {
            n = this.a.a(a.get(a));
            if ((n instanceof C0962r) && !(this.b instanceof C0962r)) {
                n = this.b;
            }
        }
        n.a(eVar, (Object) t);
    }

    public T b(com.c.a.d.a aVar) {
        return this.b.b(aVar);
    }
}
