package com.xiaomi.c.a;

final class C extends v {
    private C(String str) {
        super(str);
        a(0);
    }

    static C a(String str) {
        return str == null ? null : new C(str);
    }
}
