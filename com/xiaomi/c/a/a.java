package com.xiaomi.c.a;

abstract class a<T extends Comparable> implements Comparable {
    private final T a;

    protected a(T t) {
        this.a = t;
    }

    public final T a() {
        return this.a;
    }

    public int compareTo(Object obj) {
        return obj == null ? 1 : this.a.compareTo(obj);
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof a)) {
            return false;
        }
        return this.a.equals(((a) obj).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return this.a.toString();
    }
}
