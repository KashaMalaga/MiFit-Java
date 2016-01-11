package com.e.b;

public abstract class d<T, V> {
    private final String a;
    private final Class<V> b;

    public d(Class<V> cls, String str) {
        this.a = str;
        this.b = cls;
    }

    public static <T, V> d<T, V> a(Class<T> cls, Class<V> cls2, String str) {
        return new e(cls, cls2, str);
    }

    public abstract V a(T t);

    public void a(T t, V v) {
        throw new UnsupportedOperationException("Property " + b() + " is read-only");
    }

    public boolean a() {
        return false;
    }

    public String b() {
        return this.a;
    }

    public Class<V> c() {
        return this.b;
    }
}
