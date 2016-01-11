package com.c.a.b;

import java.lang.reflect.Method;

final class L extends K {
    final /* synthetic */ Method a;
    final /* synthetic */ Object b;

    L(Method method, Object obj) {
        this.a = method;
        this.b = obj;
    }

    public <T> T a(Class<T> cls) {
        return this.a.invoke(this.b, new Object[]{cls});
    }
}
