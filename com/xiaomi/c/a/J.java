package com.xiaomi.c.a;

final class J extends v {
    private J(String str) {
        super(str);
        a(1);
    }

    static J a(String str) {
        return str == null ? null : new J(str);
    }
}
