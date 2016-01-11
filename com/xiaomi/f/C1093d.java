package com.xiaomi.f;

import com.xiaomi.f.c.e;

class C1093d implements Runnable {
    final /* synthetic */ C1091b a;
    private e b;

    public C1093d(C1091b c1091b, e eVar) {
        this.a = c1091b;
        this.b = eVar;
    }

    public void run() {
        for (m a : this.a.f.values()) {
            a.a(this.b);
        }
    }
}
