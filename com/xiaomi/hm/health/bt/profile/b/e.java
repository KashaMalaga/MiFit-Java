package com.xiaomi.hm.health.bt.profile.b;

import com.xiaomi.hm.health.bt.a.d;

class e extends b {
    private f b = null;
    private d c = null;

    public e(f fVar, d dVar) {
        this.b = fVar;
        this.c = dVar;
    }

    protected void d() {
        if (this.c != null) {
            this.c.c();
        }
        int i = -1;
        if (this.b != null && this.b.u()) {
            i = this.b.A();
        }
        if (this.c != null) {
            this.c.c(Integer.valueOf(i));
        }
    }
}
