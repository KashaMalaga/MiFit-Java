package com.c.a.b.a;

import com.c.a.C0993k;
import com.c.a.N;
import com.c.a.P;
import com.c.a.c.a;

final class Y implements P {
    final /* synthetic */ Class a;
    final /* synthetic */ N b;

    Y(Class cls, N n) {
        this.a = cls;
        this.b = n;
    }

    public <T> N<T> a(C0993k c0993k, a<T> aVar) {
        return this.a.isAssignableFrom(aVar.getRawType()) ? this.b : null;
    }

    public String toString() {
        return "Factory[typeHierarchy=" + this.a.getName() + ",adapter=" + this.b + "]";
    }
}
