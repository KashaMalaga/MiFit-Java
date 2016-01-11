package com.g.a.a;

import java.io.Serializable;

class d implements Serializable {
    private static final long a = 20140327;
    private String b;
    private long c;
    private long d;

    public d(String str) {
        this.b = str;
    }

    public void a() {
        this.d = System.currentTimeMillis();
    }

    public boolean a(String str) {
        return this.b.equals(str);
    }

    public void b() {
        this.c += System.currentTimeMillis() - this.d;
        this.d = 0;
    }

    public void c() {
        a();
    }

    public void d() {
        b();
    }

    public long e() {
        return this.c;
    }

    public String f() {
        return this.b;
    }
}
