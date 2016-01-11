package com.xiaomi.c.a;

final class C1069A extends a<String> {
    private final String[] a;

    private C1069A(String str) {
        super(str);
        this.a = str.split("\\ +");
    }

    static C1069A a(String str) {
        return str == null ? null : new C1069A(str);
    }
}
