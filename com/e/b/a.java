package com.e.b;

public abstract class a<T> extends d<T, Float> {
    public a(String str) {
        super(Float.class, str);
    }

    public abstract void a(T t, float f);

    public final void a(T t, Float f) {
        a((Object) t, f.floatValue());
    }
}
