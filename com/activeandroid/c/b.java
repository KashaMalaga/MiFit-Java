package com.activeandroid.c;

import java.util.Calendar;

public final class b extends e {
    public Class<?> a() {
        return Calendar.class;
    }

    public Long a(Object obj) {
        return Long.valueOf(((Calendar) obj).getTimeInMillis());
    }

    public Class<?> b() {
        return Long.TYPE;
    }

    public Calendar b(Object obj) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(((Long) obj).longValue());
        return instance;
    }

    public /* synthetic */ Object c(Object obj) {
        return b(obj);
    }

    public /* synthetic */ Object d(Object obj) {
        return a(obj);
    }
}
