package com.c.b.h.a;

import com.c.b.c.b;
import com.c.b.n;
import com.c.b.u;

final class c {
    private b a;
    private u b;
    private u c;
    private u d;
    private u e;
    private int f;
    private int g;
    private int h;
    private int i;

    c(b bVar, u uVar, u uVar2, u uVar3, u uVar4) {
        if (!(uVar == null && uVar3 == null) && (!(uVar2 == null && uVar4 == null) && ((uVar == null || uVar2 != null) && (uVar3 == null || uVar4 != null)))) {
            a(bVar, uVar, uVar2, uVar3, uVar4);
            return;
        }
        throw n.a();
    }

    c(c cVar) {
        a(cVar.a, cVar.b, cVar.c, cVar.d, cVar.e);
    }

    static c a(c cVar, c cVar2) {
        return cVar == null ? cVar2 : cVar2 == null ? cVar : new c(cVar.a, cVar.b, cVar.c, cVar2.d, cVar2.e);
    }

    private void a(b bVar, u uVar, u uVar2, u uVar3, u uVar4) {
        this.a = bVar;
        this.b = uVar;
        this.c = uVar2;
        this.d = uVar3;
        this.e = uVar4;
        i();
    }

    private void i() {
        if (this.b == null) {
            this.b = new u(0.0f, this.d.b());
            this.c = new u(0.0f, this.e.b());
        } else if (this.d == null) {
            this.d = new u((float) (this.a.f() - 1), this.b.b());
            this.e = new u((float) (this.a.f() - 1), this.c.b());
        }
        this.f = (int) Math.min(this.b.a(), this.c.a());
        this.g = (int) Math.max(this.d.a(), this.e.a());
        this.h = (int) Math.min(this.b.b(), this.d.b());
        this.i = (int) Math.max(this.c.b(), this.e.b());
    }

    int a() {
        return this.f;
    }

    c a(int i, int i2, boolean z) {
        int b;
        u uVar;
        u uVar2 = this.b;
        u uVar3 = this.c;
        u uVar4 = this.d;
        u uVar5 = this.e;
        if (i > 0) {
            u uVar6 = z ? this.b : this.d;
            b = ((int) uVar6.b()) - i;
            if (b < 0) {
                b = 0;
            }
            uVar = new u(uVar6.a(), (float) b);
            if (!z) {
                uVar4 = uVar;
                uVar = uVar2;
            }
        } else {
            uVar = uVar2;
        }
        if (i2 > 0) {
            uVar6 = z ? this.c : this.e;
            b = ((int) uVar6.b()) + i2;
            if (b >= this.a.g()) {
                b = this.a.g() - 1;
            }
            uVar2 = new u(uVar6.a(), (float) b);
            if (!z) {
                uVar5 = uVar2;
                uVar2 = uVar3;
            }
        } else {
            uVar2 = uVar3;
        }
        i();
        return new c(this.a, uVar, uVar2, uVar4, uVar5);
    }

    int b() {
        return this.g;
    }

    int c() {
        return this.h;
    }

    int d() {
        return this.i;
    }

    u e() {
        return this.b;
    }

    u f() {
        return this.d;
    }

    u g() {
        return this.c;
    }

    u h() {
        return this.e;
    }
}
