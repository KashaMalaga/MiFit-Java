package com.xiaomi.f;

import com.xiaomi.c.a.R;
import com.xiaomi.c.a.S;

class C1092c implements S {
    final /* synthetic */ C1091b a;

    private C1092c(C1091b c1091b) {
        this.a = c1091b;
    }

    public void a(R r) {
        if (!r.a()) {
            this.a.a(2, 0, null);
            this.a.a((Exception) r.b());
        }
        synchronized (this.a.A) {
            this.a.A.notifyAll();
        }
    }
}
