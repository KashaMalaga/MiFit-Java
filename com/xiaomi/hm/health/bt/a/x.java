package com.xiaomi.hm.health.bt.a;

import cn.com.smartdevices.bracelet.C0596r;

public class x extends C {
    public static final byte a = (byte) 0;
    public static final byte b = (byte) 1;
    public static final byte c = (byte) 2;
    private byte d = a;

    public x(d dVar, byte b) {
        super(dVar);
        this.d = b;
    }

    public void a(d dVar) {
        if (dVar != null) {
            dVar.c();
        }
        C0596r.e(p, "location:" + this.d);
        boolean c = this.q.c(this.d);
        if (dVar != null) {
            dVar.c(Boolean.valueOf(c));
        }
    }
}
