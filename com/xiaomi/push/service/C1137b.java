package com.xiaomi.push.service;

import android.text.TextUtils;

class C1137b extends e {
    private final Z a;

    public C1137b(Z z) {
        super(12);
        this.a = z;
    }

    public void a() {
        this.a.a(ab.unbind, 1, 21, null, null);
    }

    public String b() {
        return "bind time out. chid=" + this.a.h;
    }

    public boolean equals(Object obj) {
        return !(obj instanceof C1137b) ? false : TextUtils.equals(((C1137b) obj).a.h, this.a.h);
    }

    public int hashCode() {
        return this.a.h.hashCode();
    }
}
