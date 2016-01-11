package com.xiaomi.hm.health.bt.a;

public class g extends C {
    private byte a = (byte) 0;
    private byte b = (byte) 0;

    public g(byte b, byte b2, d dVar) {
        super(dVar);
        this.a = b;
        this.b = b2;
    }

    public void a(d dVar) {
        if (dVar != null) {
            dVar.c();
        }
        boolean a = this.q.a(this.a, this.b);
        if (dVar != null) {
            dVar.c(Boolean.valueOf(a));
        }
    }
}
