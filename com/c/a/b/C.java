package com.c.a.b;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

abstract class C<T> implements Iterator<T> {
    D<K, V> b;
    D<K, V> c;
    int d;
    final /* synthetic */ w e;

    private C(w wVar) {
        this.e = wVar;
        this.b = this.e.e.d;
        this.c = null;
        this.d = this.e.d;
    }

    final D<K, V> b() {
        D<K, V> d = this.b;
        if (d == this.e.e) {
            throw new NoSuchElementException();
        } else if (this.e.d != this.d) {
            throw new ConcurrentModificationException();
        } else {
            this.b = d.d;
            this.c = d;
            return d;
        }
    }

    public final boolean hasNext() {
        return this.b != this.e.e;
    }

    public final void remove() {
        if (this.c == null) {
            throw new IllegalStateException();
        }
        this.e.a(this.c, true);
        this.c = null;
        this.d = this.e.d;
    }
}
