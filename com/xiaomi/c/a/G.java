package com.xiaomi.c.a;

final class G extends v {
    private G(String str) {
        super(str);
        a(1);
    }

    static G a(String str) {
        return str == null ? null : new G(str);
    }
}
