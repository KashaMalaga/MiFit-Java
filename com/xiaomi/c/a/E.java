package com.xiaomi.c.a;

import java.util.concurrent.TimeUnit;

final class E extends v {
    private E(String str) {
        super(str);
        a(1);
    }

    static E a(String str) {
        return str == null ? null : new E(str);
    }

    public int c() {
        return (int) TimeUnit.MILLISECONDS.convert((long) b(), TimeUnit.SECONDS);
    }
}
