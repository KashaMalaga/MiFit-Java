package com.xiaomi.hm.health.bt.e;

import java.util.UUID;

public class f {
    public static final int a = -1;
    private int b = a;
    private UUID c = null;
    private String d = null;
    private h e = null;
    private boolean f = false;

    public f(g gVar) {
        this.b = gVar.a;
        this.c = gVar.b;
        this.d = gVar.c;
        this.e = gVar.d;
        this.f = gVar.e;
    }

    public int a() {
        return this.b;
    }

    public UUID b() {
        return this.c;
    }

    public String c() {
        return this.d;
    }

    public h d() {
        return this.e;
    }

    public boolean e() {
        return this.f;
    }

    public String toString() {
        return "timeout:" + this.b + ",filterUuid:" + this.c + ",filterAddress:" + this.d + ",needConnectedDevice:" + this.f;
    }
}
