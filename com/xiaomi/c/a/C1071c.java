package com.xiaomi.c.a;

import java.util.EventObject;

public final class C1071c extends EventObject {
    private final C1078u a;

    private C1071c(Object obj, C1078u c1078u) {
        super(obj);
        if (c1078u == null) {
            throw new IllegalArgumentException("message body may not be null");
        }
        this.a = c1078u;
    }

    static C1071c a(L l, C1078u c1078u) {
        return new C1071c(l, c1078u);
    }

    static C1071c b(L l, C1078u c1078u) {
        return new C1071c(l, c1078u);
    }

    public C1078u a() {
        return this.a;
    }
}
