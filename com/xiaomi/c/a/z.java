package com.xiaomi.c.a;

final class z extends a<String> {
    private z(String str) {
        super(str);
    }

    static z a(String str) {
        return str == null ? null : new z(str);
    }
}
