package com.activeandroid.c;

import java.util.Date;

public final class g extends e {
    public Class<?> a() {
        return Date.class;
    }

    public Long a(Object obj) {
        return obj == null ? null : Long.valueOf(((Date) obj).getTime());
    }

    public Class<?> b() {
        return Long.TYPE;
    }

    public Date b(Object obj) {
        return obj == null ? null : new Date(((Long) obj).longValue());
    }

    public /* synthetic */ Object c(Object obj) {
        return b(obj);
    }

    public /* synthetic */ Object d(Object obj) {
        return a(obj);
    }
}
