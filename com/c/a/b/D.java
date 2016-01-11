package com.c.a.b;

import java.util.Map.Entry;

final class D<K, V> implements Entry<K, V> {
    D<K, V> a;
    D<K, V> b;
    D<K, V> c;
    D<K, V> d;
    D<K, V> e;
    final K f;
    V g;
    int h;

    D() {
        this.f = null;
        this.e = this;
        this.d = this;
    }

    D(D<K, V> d, K k, D<K, V> d2, D<K, V> d3) {
        this.a = d;
        this.f = k;
        this.h = 1;
        this.d = d2;
        this.e = d3;
        d3.d = this;
        d2.e = this;
    }

    public D<K, V> a() {
        D<K, V> d;
        for (D<K, V> d2 = this.b; d2 != null; d2 = d2.b) {
            d = d2;
        }
        return d;
    }

    public D<K, V> b() {
        D<K, V> d;
        for (D<K, V> d2 = this.c; d2 != null; d2 = d2.c) {
            d = d2;
        }
        return d;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Entry)) {
            return false;
        }
        Entry entry = (Entry) obj;
        if (this.f == null) {
            if (entry.getKey() != null) {
                return false;
            }
        } else if (!this.f.equals(entry.getKey())) {
            return false;
        }
        if (this.g == null) {
            if (entry.getValue() != null) {
                return false;
            }
        } else if (!this.g.equals(entry.getValue())) {
            return false;
        }
        return true;
    }

    public K getKey() {
        return this.f;
    }

    public V getValue() {
        return this.g;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = this.f == null ? 0 : this.f.hashCode();
        if (this.g != null) {
            i = this.g.hashCode();
        }
        return hashCode ^ i;
    }

    public V setValue(V v) {
        V v2 = this.g;
        this.g = v;
        return v2;
    }

    public String toString() {
        return this.f + "=" + this.g;
    }
}
