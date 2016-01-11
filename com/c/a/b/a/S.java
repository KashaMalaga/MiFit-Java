package com.c.a.b.a;

import com.c.a.C0993k;
import com.c.a.N;
import com.c.a.P;
import com.c.a.c.a;

final class S implements P {
    S() {
    }

    public <T> N<T> a(C0993k c0993k, a<T> aVar) {
        Class rawType = aVar.getRawType();
        if (!Enum.class.isAssignableFrom(rawType) || rawType == Enum.class) {
            return null;
        }
        if (!rawType.isEnum()) {
            rawType = rawType.getSuperclass();
        }
        return new ag(rawType);
    }
}
