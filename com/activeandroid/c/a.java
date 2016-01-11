package com.activeandroid.c;

import java.math.BigDecimal;

public final class a extends e {
    public Class<?> a() {
        return BigDecimal.class;
    }

    public String a(Object obj) {
        return obj == null ? null : ((BigDecimal) obj).toString();
    }

    public Class<?> b() {
        return String.class;
    }

    public BigDecimal b(Object obj) {
        return obj == null ? null : new BigDecimal((String) obj);
    }

    public /* synthetic */ Object c(Object obj) {
        return b(obj);
    }

    public /* synthetic */ Object d(Object obj) {
        return a(obj);
    }
}
