package com.c.a;

import com.c.a.d.a;
import com.c.a.d.e;

class q<T> extends N<T> {
    private N<T> a;

    q() {
    }

    public void a(N<T> n) {
        if (this.a != null) {
            throw new AssertionError();
        }
        this.a = n;
    }

    public void a(e eVar, T t) {
        if (this.a == null) {
            throw new IllegalStateException();
        }
        this.a.a(eVar, (Object) t);
    }

    public T b(a aVar) {
        if (this.a != null) {
            return this.a.b(aVar);
        }
        throw new IllegalStateException();
    }
}
