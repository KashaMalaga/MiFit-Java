package com.c.a;

import com.c.a.b.C0970a;
import com.c.a.c.a;

class M implements P {
    private final a<?> a;
    private final boolean b;
    private final Class<?> c;
    private final E<?> d;
    private final v<?> e;

    private M(Object obj, a<?> aVar, boolean z, Class<?> cls) {
        this.d = obj instanceof E ? (E) obj : null;
        this.e = obj instanceof v ? (v) obj : null;
        boolean z2 = (this.d == null && this.e == null) ? false : true;
        C0970a.a(z2);
        this.a = aVar;
        this.b = z;
        this.c = cls;
    }

    public <T> N<T> a(C0993k c0993k, a<T> aVar) {
        boolean isAssignableFrom = this.a != null ? this.a.equals(aVar) || (this.b && this.a.getType() == aVar.getRawType()) : this.c.isAssignableFrom(aVar.getRawType());
        return isAssignableFrom ? new K(this.d, this.e, c0993k, aVar, this) : null;
    }
}
