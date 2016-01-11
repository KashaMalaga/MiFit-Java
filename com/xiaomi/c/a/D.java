package com.xiaomi.c.a;

final class D extends v {
    private D(String str) {
        super(str);
        a(1);
    }

    static D a(String str) {
        return str == null ? null : new D(str);
    }
}
