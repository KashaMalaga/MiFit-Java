package com.xiaomi.c.a;

final class H extends a<String> {
    private H(String str) {
        super(str);
    }

    static H a(String str) {
        return new H(str);
    }
}
