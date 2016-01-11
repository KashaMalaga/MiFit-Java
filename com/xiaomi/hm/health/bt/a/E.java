package com.xiaomi.hm.health.bt.a;

public class E extends C {
    private int a = 0;

    public E(int i, d dVar) {
        super(dVar);
        this.a = i;
    }

    public void a(d dVar) {
        if (dVar != null) {
            dVar.c();
        }
        boolean c = this.q.c(this.a);
        if (dVar != null) {
            dVar.c(Boolean.valueOf(c));
        }
    }
}
