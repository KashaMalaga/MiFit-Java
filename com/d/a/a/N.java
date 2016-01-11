package com.d.a.a;

import java.lang.ref.WeakReference;

public class N {
    private final WeakReference<C1018g> a;

    public N(C1018g c1018g) {
        this.a = new WeakReference(c1018g);
    }

    public boolean a() {
        C1018g c1018g = (C1018g) this.a.get();
        return c1018g == null || c1018g.b();
    }

    public boolean a(boolean z) {
        C1018g c1018g = (C1018g) this.a.get();
        return c1018g == null || c1018g.a(z);
    }

    public boolean b() {
        C1018g c1018g = (C1018g) this.a.get();
        return c1018g == null || c1018g.a();
    }

    public boolean c() {
        boolean z = b() || a();
        if (z) {
            this.a.clear();
        }
        return z;
    }
}
