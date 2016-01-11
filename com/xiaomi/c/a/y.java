package com.xiaomi.c.a;

final class y extends a<String> {
    private final String[] a;

    private y(String str) {
        super(str);
        this.a = str.split("[\\s,]+");
    }

    static y a(String str) {
        return str == null ? null : new y(str);
    }
}
