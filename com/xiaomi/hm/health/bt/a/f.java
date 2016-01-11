package com.xiaomi.hm.health.bt.a;

public class f extends C {
    public static final byte a = (byte) 0;
    public static final byte b = (byte) 1;
    private byte c = a;

    public f(d dVar, byte b) {
        super(dVar);
        this.c = b;
    }

    public void a(d dVar) {
        if (dVar != null) {
            dVar.c();
        }
        boolean e = this.q.e(this.c);
        if (dVar != null) {
            dVar.c(Boolean.valueOf(e));
        }
    }
}
