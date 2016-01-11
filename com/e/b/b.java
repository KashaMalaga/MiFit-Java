package com.e.b;

public abstract class b<T> extends d<T, Integer> {
    public b(String str) {
        super(Integer.class, str);
    }

    public abstract void a(T t, int i);

    public final void a(T t, Integer num) {
        a((Object) t, Integer.valueOf(num.intValue()));
    }
}
