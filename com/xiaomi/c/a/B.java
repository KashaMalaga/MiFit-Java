package com.xiaomi.c.a;

final class B extends v {
    private B(String str) {
        super(str);
        a(0);
    }

    static B a(String str) {
        return str == null ? null : new B(str);
    }
}
