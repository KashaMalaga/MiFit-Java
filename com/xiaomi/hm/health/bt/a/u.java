package com.xiaomi.hm.health.bt.a;

import kankan.wheel.widget.a;

public class u extends C {
    private int a = a.bS;

    public u(int i, d dVar) {
        super(dVar);
        this.a = i;
    }

    public void a(d dVar) {
        if (this.o != null) {
            this.o.c();
        }
        boolean a = this.q.a((byte) 0, this.a);
        if (this.o != null) {
            this.o.c(Boolean.valueOf(a));
        }
    }
}
