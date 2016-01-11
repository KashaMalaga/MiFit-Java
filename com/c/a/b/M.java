package com.c.a.b;

import java.lang.reflect.Method;

final class M extends K {
    final /* synthetic */ Method a;

    M(Method method) {
        this.a = method;
    }

    public <T> T a(Class<T> cls) {
        return this.a.invoke(null, new Object[]{cls, Object.class});
    }
}
