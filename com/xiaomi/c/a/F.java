package com.xiaomi.c.a;

import java.util.concurrent.TimeUnit;

final class F extends v {
    private F(String str) {
        super(str);
        a(0);
    }

    static F a(String str) {
        return str == null ? null : new F(str);
    }

    public int c() {
        return (int) TimeUnit.MILLISECONDS.convert((long) b(), TimeUnit.SECONDS);
    }
}
