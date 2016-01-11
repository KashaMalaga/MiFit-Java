package com.xiaomi.hm.health.bt.a;

public class C1114a extends C {
    private short a;
    private short b;
    private byte c;

    public C1114a(short s, short s2, byte b, d dVar) {
        super(dVar);
        this.a = s;
        this.b = s2;
        this.c = b;
    }

    public void a(d dVar) {
        if (dVar != null) {
            dVar.c();
        }
        boolean a = this.q.a(this.a, this.b, this.c);
        if (dVar != null) {
            dVar.c(Boolean.valueOf(a));
        }
    }
}
