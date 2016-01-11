package com.c.a.b.a;

import com.c.a.C0993k;
import com.c.a.N;
import com.c.a.P;
import com.c.a.c.a;

final class X implements P {
    final /* synthetic */ Class a;
    final /* synthetic */ Class b;
    final /* synthetic */ N c;

    X(Class cls, Class cls2, N n) {
        this.a = cls;
        this.b = cls2;
        this.c = n;
    }

    public <T> N<T> a(C0993k c0993k, a<T> aVar) {
        Class rawType = aVar.getRawType();
        return (rawType == this.a || rawType == this.b) ? this.c : null;
    }

    public String toString() {
        return "Factory[type=" + this.a.getName() + "+" + this.b.getName() + ",adapter=" + this.c + "]";
    }
}
