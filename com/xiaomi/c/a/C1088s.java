package com.xiaomi.c.a;

import java.util.Collections;
import java.util.Map;

final class C1088s extends C1078u {
    private static final C1072d a = new C1074f();
    private final Map<C1076h, String> b;
    private final String c;

    private C1088s(Map<C1076h, String> map, String str) {
        this.b = map;
        this.c = str;
    }

    public static C1088s a(String str) {
        return new C1088s(a.a(str).a(), str);
    }

    public Map<C1076h, String> c() {
        return Collections.unmodifiableMap(this.b);
    }

    public String d() {
        return this.c;
    }
}
