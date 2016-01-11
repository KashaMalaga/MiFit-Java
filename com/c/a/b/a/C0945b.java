package com.c.a.b.a;

import com.c.a.C0993k;
import com.c.a.N;
import com.c.a.P;
import com.c.a.b.C0971b;
import com.c.a.c.a;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;

final class C0945b implements P {
    C0945b() {
    }

    public <T> N<T> a(C0993k c0993k, a<T> aVar) {
        Type type = aVar.getType();
        if (!(type instanceof GenericArrayType) && (!(type instanceof Class) || !((Class) type).isArray())) {
            return null;
        }
        type = C0971b.g(type);
        return new C0944a(c0993k, c0993k.a(a.get(type)), C0971b.e(type));
    }
}
