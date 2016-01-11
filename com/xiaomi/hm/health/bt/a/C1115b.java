package com.xiaomi.hm.health.bt.a;

public class C1115b extends C {
    public static final byte a = (byte) 0;
    public static final byte b = (byte) 1;
    public static final byte c = (byte) 2;
    public static final byte d = (byte) 3;
    public static final byte e = (byte) 4;
    private byte f = d;

    public C1115b(byte b, d dVar) {
        super(dVar);
        this.f = b;
    }

    public void a(d dVar) {
        if (dVar != null) {
            dVar.c();
        }
        boolean b = this.q.b(this.f);
        if (dVar != null) {
            dVar.c(Boolean.valueOf(b));
        }
    }
}
