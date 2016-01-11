package com.c.b;

import com.c.b.c.a;
import com.c.b.c.b;

public final class c {
    private final b a;
    private b b;

    public c(b bVar) {
        if (bVar == null) {
            throw new IllegalArgumentException("Binarizer must be non-null.");
        }
        this.a = bVar;
    }

    public int a() {
        return this.a.c();
    }

    public a a(int i, a aVar) {
        return this.a.a(i, aVar);
    }

    public c a(int i, int i2, int i3, int i4) {
        return new c(this.a.a(this.a.a().a(i, i2, i3, i4)));
    }

    public int b() {
        return this.a.d();
    }

    public b c() {
        if (this.b == null) {
            this.b = this.a.b();
        }
        return this.b;
    }

    public boolean d() {
        return this.a.a().b();
    }

    public boolean e() {
        return this.a.a().c();
    }

    public c f() {
        return new c(this.a.a(this.a.a().e()));
    }

    public c g() {
        return new c(this.a.a(this.a.a().f()));
    }

    public String toString() {
        try {
            return c().toString();
        } catch (n e) {
            return com.xiaomi.e.a.f;
        }
    }
}
