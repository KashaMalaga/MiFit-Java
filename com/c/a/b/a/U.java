package com.c.a.b.a;

import com.c.a.C0993k;
import com.c.a.N;
import com.c.a.P;
import com.c.a.c.a;

final class U implements P {
    final /* synthetic */ Class a;
    final /* synthetic */ N b;

    U(Class cls, N n) {
        this.a = cls;
        this.b = n;
    }

    public <T> N<T> a(C0993k c0993k, a<T> aVar) {
        return aVar.getRawType() == this.a ? this.b : null;
    }

    public String toString() {
        return "Factory[type=" + this.a.getName() + ",adapter=" + this.b + "]";
    }
}
