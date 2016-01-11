package com.c.a.b;

import com.c.a.C0993k;
import com.c.a.N;
import com.c.a.c.a;
import com.c.a.d.e;

class t extends N<T> {
    final /* synthetic */ boolean a;
    final /* synthetic */ boolean b;
    final /* synthetic */ C0993k c;
    final /* synthetic */ a d;
    final /* synthetic */ s e;
    private N<T> f;

    t(s sVar, boolean z, boolean z2, C0993k c0993k, a aVar) {
        this.e = sVar;
        this.a = z;
        this.b = z2;
        this.c = c0993k;
        this.d = aVar;
    }

    private N<T> b() {
        N<T> n = this.f;
        if (n != null) {
            return n;
        }
        n = this.c.a(this.e, this.d);
        this.f = n;
        return n;
    }

    public void a(e eVar, T t) {
        if (this.b) {
            eVar.f();
        } else {
            b().a(eVar, (Object) t);
        }
    }

    public T b(com.c.a.d.a aVar) {
        if (!this.a) {
            return b().b(aVar);
        }
        aVar.n();
        return null;
    }
}
