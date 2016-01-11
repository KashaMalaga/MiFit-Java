package com.xiaomi.hm.health.bt.a;

public class v extends C {
    public static final byte a = (byte) 0;
    private byte b = (byte) 0;

    public v(d dVar, byte b) {
        super(dVar);
        this.b = b;
    }

    public void a(d dVar) {
        if (dVar != null) {
            dVar.c();
        }
        boolean d = this.q.d(this.b);
        if (dVar != null) {
            dVar.c(Boolean.valueOf(d));
        }
    }
}
