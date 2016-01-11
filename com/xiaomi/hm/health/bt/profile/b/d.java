package com.xiaomi.hm.health.bt.profile.b;

import com.xiaomi.hm.health.bt.d.b;
import kankan.wheel.widget.a;

public class d extends b {
    private f b = null;
    private String c = null;
    private b d = null;

    public d(f fVar, String str, b bVar) {
        this.b = fVar;
        this.c = str;
        this.d = bVar;
    }

    protected void d() {
        this.d.onStart(0);
        if (this.b == null || !this.b.u()) {
            this.d.onStop(1);
            return;
        }
        this.b.a(39, 39, 0, a.aB, 0);
        this.d.onStop(this.b.a(this.c, this.d));
    }
}
