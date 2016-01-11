package com.activeandroid.c;

import java.util.UUID;

public final class f extends e {
    public Class<?> a() {
        return UUID.class;
    }

    public String a(Object obj) {
        return obj == null ? null : ((UUID) obj).toString();
    }

    public Class<?> b() {
        return String.class;
    }

    public UUID b(Object obj) {
        return obj == null ? null : UUID.fromString((String) obj);
    }

    public /* synthetic */ Object c(Object obj) {
        return b(obj);
    }

    public /* synthetic */ Object d(Object obj) {
        return a(obj);
    }
}
