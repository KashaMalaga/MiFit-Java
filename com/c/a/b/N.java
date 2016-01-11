package com.c.a.b;

import java.lang.reflect.Method;

final class N extends K {
    final /* synthetic */ Method a;
    final /* synthetic */ int b;

    N(Method method, int i) {
        this.a = method;
        this.b = i;
    }

    public <T> T a(Class<T> cls) {
        return this.a.invoke(null, new Object[]{cls, Integer.valueOf(this.b)});
    }
}
