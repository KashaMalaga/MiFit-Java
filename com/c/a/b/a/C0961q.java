package com.c.a.b.a;

import com.c.a.C0993k;
import com.c.a.N;
import com.c.a.c.a;
import com.c.a.d.e;
import java.lang.reflect.Field;

class C0961q extends C0960s {
    final N<?> a = this.b.a(this.c);
    final /* synthetic */ C0993k b;
    final /* synthetic */ a c;
    final /* synthetic */ Field d;
    final /* synthetic */ boolean e;
    final /* synthetic */ C0959p f;

    C0961q(C0959p c0959p, String str, boolean z, boolean z2, C0993k c0993k, a aVar, Field field, boolean z3) {
        this.f = c0959p;
        this.b = c0993k;
        this.c = aVar;
        this.d = field;
        this.e = z3;
        super(str, z, z2);
    }

    void a(com.c.a.d.a aVar, Object obj) {
        Object b = this.a.b(aVar);
        if (b != null || !this.e) {
            this.d.set(obj, b);
        }
    }

    void a(e eVar, Object obj) {
        new C0967x(this.b, this.a, this.c.getType()).a(eVar, this.d.get(obj));
    }
}
