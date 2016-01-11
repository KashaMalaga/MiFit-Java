package com.c.a.b.a;

import com.c.a.C0993k;
import com.c.a.N;
import com.c.a.P;
import com.c.a.b.C0971b;
import com.c.a.b.C0975f;
import com.c.a.c.a;
import java.lang.reflect.Type;
import java.util.Collection;

public final class C0946c implements P {
    private final C0975f a;

    public C0946c(C0975f c0975f) {
        this.a = c0975f;
    }

    public <T> N<T> a(C0993k c0993k, a<T> aVar) {
        Type type = aVar.getType();
        Class rawType = aVar.getRawType();
        if (!Collection.class.isAssignableFrom(rawType)) {
            return null;
        }
        Type a = C0971b.a(type, rawType);
        return new C0947d(c0993k, a, c0993k.a(a.get(a)), this.a.a((a) aVar));
    }
}
